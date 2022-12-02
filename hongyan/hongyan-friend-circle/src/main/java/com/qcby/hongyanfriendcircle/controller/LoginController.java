package com.qcby.hongyanfriendcircle.controller;

import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import com.qcby.hongyanfriendcircle.service.LoginService;
import com.qcby.hongyanfriendcircle.util.JwtUtil;
import com.qcby.hongyanfriendcircle.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.controller
 * @ClassName: LoginController
 * @Author: zxh
 * @Description: 登录
 * @Date: 2021/12/28 22:40
 * @Version: 1.0
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("tologin")
    @ResponseBody
    public ResultJson tologin(Long id){
        User UserDB = loginService.getById(id);
        String token = JwtUtil.createToken(UserDB);
        UserDB.setToken(token);
        return ResultJson.ok(UserDB);
    }
}
