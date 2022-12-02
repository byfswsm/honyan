package com.qcby.hongyanredenvelopes.controller;

import com.qcby.hongyanredenvelopes.common.ResultJson;
import com.qcby.hongyanredenvelopes.entity.User;
import com.qcby.hongyanredenvelopes.service.LoginService;
import com.qcby.hongyanredenvelopes.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RequestMapping("login")
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;



    @RequestMapping("login")
    public ResultJson login(User user){
        log.info("{}",user.toString());
        List<User> users = loginService.login(user);
        if (users.size()==1){
            User user1 = users.get(0);
            String token = TokenUtil.genToken(user1);
            user1.setToken(token);
            return ResultJson.ok("登录成功",user1);

        }else {
            return ResultJson.error("登录失败");
        }

    }
}
