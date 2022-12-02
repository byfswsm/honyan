package com.qcby.hongyansystemmanagement.util;//package com.example.chatsystem.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTDecodeException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.example.chatsystem.entity.User;
//import com.example.chatsystem.service.UserService;
//import com.example.chatsystem.customizeAnnotation.PassToken;
//import com.example.chatsystem.customizeAnnotation.UserLoginToken;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//
///**
// * @author Mi
// * @version 1.0
// * @description: TODO
// * @date 2022/1/7 16:32
// */
//
//public class AuthenticationInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    UserService userService;
//
//
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //进入方法之前进行的操作
//        //获取token
//        String token  =  request.getHeader("token");
//        //如果不是映射到方法直接通过
//        if(!(handler instanceof HandlerMethod)){
//            return true;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//        if(method.isAnnotationPresent(PassToken.class))
//        {
//            PassToken passToken = method.getAnnotation(PassToken.class);
//            if(passToken.required()){
//                return true;
//            }
//        }
//        String userId = null;
//        if(method.isAnnotationPresent(UserLoginToken.class))
//        {
//            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
//            if(userLoginToken.required()){
//                if(token == null){
//                    throw new RuntimeException("无token，请重新登录");
//                }
//                //获取token的userid
//                try{
//                    userId = JWT.decode(token).getAudience().get(0);
//                }
//                catch (JWTDecodeException e){
//                    throw new RuntimeException("401");
//                }
////                int userId1 = Integer.parseInt(userId);
//                User user = userService.getUser(userId1); //int 类型的User
////                User user = userService.getUser(userId);
//                if(user==null){
//                    throw new RuntimeException("用户不存在");
//                }
//                //验证token
//                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
//                try{
//                    jwtVerifier.verify(token);
//                }catch (JWTVerificationException e){
//                    throw new RuntimeException("401");
//                }
//
//                return true;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        //方法处理之后但是并未渲染视图的时候进行的操作
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        //渲染视图之后进行的操作
//    }
//}