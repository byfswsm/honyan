package com.qcby.hongyanredenvelopes.controller;

import com.qcby.hongyanredenvelopes.common.JiucaiConstant;
import com.qcby.hongyanredenvelopes.common.ResultJson;
import com.qcby.hongyanredenvelopes.entity.Envelope;
import com.qcby.hongyanredenvelopes.entity.Record;
import com.qcby.hongyanredenvelopes.entity.User;
import com.qcby.hongyanredenvelopes.util.CommonUtil;
import com.qcby.hongyanredenvelopes.util.RedisUtil;
import com.qcby.hongyanredenvelopes.service.EnvelopeService;
import com.qcby.hongyanredenvelopes.service.RecordService;
import com.qcby.hongyanredenvelopes.service.UserService;
import com.qcby.hongyanredenvelopes.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RequestMapping("envelope")
@RestController
public class EnvelopeController {
    @Autowired
    private EnvelopeService envelopeService;
    @Autowired
    private UserService userService;

    @Resource
    private RecordService recordService;
    @Autowired
    HttpServletRequest request;
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //抢红包记录
    private List<Record> grabRecords = new ArrayList<>();
    //拆红包记录
    private Map<String,Object> openRecords = new HashMap<>();
    private List<Record> openRecordsList = new ArrayList<>();


    @RequestMapping("listAll")
    public ResultJson listAll(){
        String str = "测试";
        rabbitTemplate.convertAndSend("order-event-exchange","order.create.order",str);
        return ResultJson.ok(envelopeService.list());
    }

    @RequestMapping("handOut")
    public ResultJson handOut(Envelope envelope){
        if (allowableEnvelope(envelope)){
            LocalDateTime date = LocalDateTime.now().plusDays(1);
            envelope.setDeadline(date);

            String token = request.getHeader(JiucaiConstant.TOKEN);
            User user = TokenUtil.getUser(token);
            envelope.setOrganizer(user.getUsername());//设定红包发起人
            envelope.setStatus(envelope.getNumber());//设定红包总数量(剩余数量)
            if (user.getMoney()<envelope.getAmount()){
                return ResultJson.error("您账户中的余额不足");
            }
            envelopeService.save(envelope);
            String envelopeId = envelope.getId()+"";
//            envelope.setDeadline(null);
            redisUtil.set(envelopeId,envelope);
            rabbitTemplate.convertAndSend("order-event-exchange","order.create.order",envelopeId);
            Long money = user.getMoney();
            money -= envelope.getAmount();
            user.setMoney(money);
            if (userService.updateById(user)){
                return ResultJson.ok("红包发送成功",envelope);
            }else {
                return ResultJson.ok("红包发送失败",envelope);
            }
        }
        return ResultJson.error("您输入的红包信息有误");
    }
    public static boolean allowableEnvelope(Envelope envelope){
        Integer amount = envelope.getAmount();
        Integer number = envelope.getNumber();
        if (envelope!=null && amount!=null && amount!=0 && number!=null &&number!=0 && amount>=number){
            return true;
        }else {
            return false;
        }

    }

    //抢红包  入参是红包id
    @RequestMapping("grab")
    public ResultJson grab(Envelope envelope){
        //获取登陆用户信息
        String token = request.getHeader(JiucaiConstant.TOKEN);
        User user = TokenUtil.getUser(token);
        //获取要抢的红包的信息
        String envelopeId = envelope.getId()+"";
        Envelope envelope1 = (Envelope) redisUtil.get(envelopeId);
        //判断红包是否还哟有剩余
        if (envelope1.getStatus()>0){
            Record record = new Record();
            record.setUserId(user.getId());
            record.setEId(envelope1.getId());
            //判断当前用户是不是抢过这个红包  返回-1说明list中没有这个值
            if (grabRecords.indexOf(record)==-1){
                grabRecords.add(record);
                return ResultJson.ok("抢到红包");
            }else {
                return ResultJson.ok("您已经抢过这个红包了");
            }
        }else {
            //红包抢完，对数据库进行修改
            List<Record> openRecordsList1 = (List<Record>) openRecords.get(envelopeId);
            recordService.saveBatch(openRecordsList1);
            //红包被抢完，删除map中该红包的信息
            openRecords.remove(envelopeId);
            return ResultJson.ok("红包已经被抢完了");
        }
    }

    //拆红包 入参是红包id
    @RequestMapping("open")
    public ResultJson open(Envelope envelope){
        //获取登陆用户信息
        String token = request.getHeader(JiucaiConstant.TOKEN);
        User user = TokenUtil.getUser(token);
        //获取要抢的红包的信息
        String envelopeId = envelope.getId()+"";
        Envelope envelope1 = (Envelope) redisUtil.get(envelopeId);
        //判断这个用户是不是抢到了这个红包
        Record record = new Record();
        record.setUserId(user.getId());
        record.setEId(envelope1.getId());
        if (grabRecords.indexOf(record)!=-1){
            //判断红包是否还有剩余
            int status = envelope1.getStatus();
            int amount = envelope1.getAmount();
            String id = envelope1.getId()+"";
            //判断红包是不是还有金额
            if (status>0 && amount>=status){
                //判断用户抢到了红包，从抢的list中删除这条记录(不论用户是否能成功拆到红包)
                grabRecords.remove(record);
                //这里是拆的逻辑；参数是抢红包的金额和剩余数量
                int openMoney = CommonUtil.openPack(status,amount);

                //拆到红包以后对redis中该红包信息进行修改
                status--;
                envelope1.setStatus(status);
                envelope1.setAmount(amount-openMoney);
                redisUtil.set(envelopeId,envelope1);
                //修改record中的金额
                record.setMoney(openMoney);
                //记录拆到红包的信息
                openRecordsList.add(record);
                if (status==0){
                    openRecords.put(id,openRecordsList);
                }
                //更新数据库中用户金额
                user.setMoney(user.getMoney()+openMoney);
                userService.updateUserAmount(user);
                return ResultJson.ok("恭喜您抢到红包,您抢到的金额为：",openMoney);
            }else {
                //红包抢完，对数据库进行修改
                List<Record> openRecordsList1 = (List<Record>) openRecords.get(id);
                recordService.saveBatch(openRecordsList1);
                //红包被抢完，删除map中该红包的信息
                openRecordsList.remove(id);
                return ResultJson.ok("您手速慢了，红包已经被抢完了");
            }
        }else {
            return ResultJson.error("你的操作不合法");
        }
    }


}
