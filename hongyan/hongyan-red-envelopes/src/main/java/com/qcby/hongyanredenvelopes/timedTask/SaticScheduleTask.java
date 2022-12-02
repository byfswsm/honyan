package com.qcby.hongyanredenvelopes.timedTask;

import com.qcby.hongyanredenvelopes.entity.Envelope;
import com.qcby.hongyanredenvelopes.entity.User;
import com.qcby.hongyanredenvelopes.util.RedisUtil;
import com.qcby.hongyanredenvelopes.service.EnvelopeService;
import com.qcby.hongyanredenvelopes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    @Autowired
    private EnvelopeService envelopeService;
    @Autowired
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;


    //3.添加定时任务
    //@Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate=1000*60*60)
    private void configureTasks() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.err.println("判断红包是否过期: " + dateTime);
        List<Envelope> envelopeList = envelopeService.list();
        List<Long> idList = new ArrayList<>();
        User user = new User();
        for (Envelope envelope : envelopeList){
            //判断红包是否过期
            if (envelope.getDeadline().isBefore(LocalDateTime.now())){
                String envelopeId = envelope.getId()+"";
                if (envelope.getStatus()==0){
                    //清理数据库中抢完的红包的信息
                    idList.add(envelope.getId());
                    //清理redis中的过期信息
                    redisUtil.del(envelopeId);
                }else {
                    //退还红包剩余金额
                    int money = envelope.getAmount();
                    user.setUsername(envelope.getOrganizer());
                    user = userService.getOneByName(user);
                    user.setMoney(user.getMoney()+money);
                    userService.updateUserAmount(user);
                    //将红包id加入过期红包idlist
                    idList.add(envelope.getId());
                    //清理redis中的过期信息
                    redisUtil.del(envelopeId);
                }
            }
        }
        if (idList.size()!=0){
            envelopeService.removeByIds(idList);
        }
    }
}
