package com.qcby.hongyanredenvelopes.interceptor;


import com.qcby.hongyanredenvelopes.common.JiucaiConstant;
import com.qcby.hongyanredenvelopes.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * 这是拦截器
 *
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    @Autowired
    private HttpSession httpSession;

    //Controller逻辑执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle....");
        String uri = request.getRequestURI();
        String token = request.getHeader(JiucaiConstant.TOKEN);
        log.info("uri："+ uri);
        log.info("token: "+ token);
//        httpSession.getAttribute(JiucaiConstant.SESSION_USER) == null
        if (!TokenUtil.existToken(token)){
            throw  new RuntimeException("no login!");
            // 未登录跳转到登录界面
//            response.sendRedirect("/login/toLogin");
//            return false;
        } else {
            return true;
        }
    }

}
