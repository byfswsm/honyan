package com.qcby.hongyanchat.controller;

import com.qcby.hongyanchat.common.web.ResultJson;
import com.qcby.hongyanchat.model.Friend;
import com.qcby.hongyanchat.model.Request;
import com.qcby.hongyanchat.model.Shield;
import com.qcby.hongyanchat.service.FriendService;
import com.qcby.hongyanchat.service.RequestService;
import com.qcby.hongyanchat.service.ShieldService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController //controller和resposebody的复合注解
@RequestMapping("friend") //请求映射 路径
public class FriendController {

    @Resource
    private FriendService friendService;

    @Resource
    private ShieldService shieldService;

    @Resource
    private RequestService requestService;

    @RequestMapping("addFriend")
    public ResultJson addFriend(@RequestBody Request request){
        requestService.save(request);
        return ResultJson.ok();
    }

    @RequestMapping("deleteFriend")
    public ResultJson deleteFriend(Friend friend){
        friendService.removeById(friend.getId());
        return ResultJson.ok();
    }

    @RequestMapping("listAll")
    public ResultJson listAll(int id){
        List<Friend> data = friendService.list();
        return ResultJson.ok(data);
    }

    @RequestMapping("shield")
    public ResultJson shield(Shield shield){
        shieldService.save(shield);
        return ResultJson.ok();
    }

    @RequestMapping("request")
    public ResultJson request(){
        List<Request> data = requestService.list();
        return ResultJson.ok(data);
    }

    @RequestMapping("accept")
    public ResultJson Accept(Request request){
        int data = requestService.accept(request);
        return ResultJson.ok(data);
    }

    @RequestMapping("reject")
    public ResultJson Reject(Request request){
        int data = requestService.reject(request);
        return ResultJson.ok();
    }
}
