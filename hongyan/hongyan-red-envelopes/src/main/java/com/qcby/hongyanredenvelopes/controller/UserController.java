package com.qcby.hongyanredenvelopes.controller;

import com.qcby.hongyanredenvelopes.entity.User;
import com.qcby.hongyanredenvelopes.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("listAll")
    public List<User> listAll(){
        return userService.select();
    }

    @RequestMapping("redisTest")
    public String redisTest(String name){
        redisTemplate.opsForValue().set("name",name);
        String name1 = (String) redisTemplate.opsForValue().get("name");
        log.info("redis测试输入的姓名为：{}",name1);
        return name1;
    }


//    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            System.out.println("第" + i + "次");
//            List<User> users = userService.select();
//            System.out.println(users);
//        }
//    }





}
