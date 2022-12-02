package com.qcby.hongyansystemmanagement.controller;

import com.qcby.hongyansystemmanagement.common.web.ResultJson;
import com.qcby.hongyansystemmanagement.entity.User ;
import com.qcby.hongyansystemmanagement.service.LoginSeivice ;
import com.qcby.hongyansystemmanagement.service.PowerService ;
import com.qcby.hongyansystemmanagement.util.JwtUtil ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/** 登录管理接口
 * @author Mi
 * @version 1.0
 * @description: TODO
 * @date 2021/12/29 10:29
 */

@RestController
@RequestMapping("loginModule")
public class LoginController {
    @Autowired
    private HttpSession session;

    @Autowired
    private LoginSeivice loginSeivice;

    @Autowired
    private PowerService powerService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 登录接口
     * @param user
     * @return
     */
    @RequestMapping("login")
    public ResultJson login(User user){
        User user1 = loginSeivice.isLogin(user);
        if(user1 != null){
            String token = jwtUtil.createToken(user1);
            user1.setToken(token);
            return ResultJson.ok(user1);
        }
        return ResultJson.error("用户名或密码错误！");
    }

    /**
     * 登出接口
     * @return
     */
    @RequestMapping("quit")
    public String logout(){
        if(session.getAttribute("username") != null){
            session.removeAttribute("username");
            return "退出登录成功！";
        }
        return "退出登录失败！";
    }
}
