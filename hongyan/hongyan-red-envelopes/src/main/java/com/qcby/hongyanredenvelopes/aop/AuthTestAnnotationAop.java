package com.qcby.hongyanredenvelopes.aop;

import com.qcby.hongyanredenvelopes.common.JiucaiConstant;
import com.qcby.hongyanredenvelopes.entity.User;
import com.qcby.hongyanredenvelopes.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @className: AnnotationAop
 * @description:
 * @author: lxt
 * @create: 2021-05-12 17:37
 **/
@Slf4j
// 切面注解
@Aspect
// spring 组件
@Component
public class AuthTestAnnotationAop {
    @Resource
    private HttpServletRequest request;


    //定义切点，注解作为切入点
    @Pointcut("@annotation(com.qcby.hongyanredenvelopes.aop.AuthTestViewRecords)")
    public void viewRecordsPoinCut() {

    }
    /**
     * before 目标方法执行前执行，前置通知
     * after 目标方法执行后执行，后置通知
     * after returning 目标方法返回时执行 ，后置返回通知
     * after throwing 目标方法抛出异常时执行 异常通知
     * around 在目标函数执行中执行，可控制目标函数是否执行，环绕通知
     */

    @Before("viewRecordsPoinCut()")
    public void before(JoinPoint joinPoint) throws Throwable {

//        log.info("注解方法进入Before通知....");
    }

    @After("viewRecordsPoinCut()")
    public void after(JoinPoint joinPoint) throws Throwable {
//        log.info("注解方法进入After通知....");
    }

    @AfterReturning("viewRecordsPoinCut()")
    public void afterReturning(JoinPoint joinPoint) throws Throwable {
//        log.info("注解方法进入AfterReturning通知....");
    }

    @AfterThrowing("viewRecordsPoinCut()")
    public void afterThrowing(JoinPoint joinPoint) throws Throwable {
//        log.info("注解方法进入AfterThrowing通知....");
    }



    @Around("viewRecordsPoinCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //log.info("注解方法进入Around通知....前");
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取注解信息
        AuthTestViewRecords authTestViewRecords = method.getAnnotation(AuthTestViewRecords.class);
        String auth = authTestViewRecords.auth();
        boolean enable = authTestViewRecords.enable();

        //获取登录用户的信息
        String token = request.getHeader(JiucaiConstant.TOKEN);
        log.info("权限获取token："+token);
        User user = TokenUtil.getUser(token);
//        Set<String> set = user.getSet();

//        if (enable==true && !set.contains(auth) ){
//            throw  new RuntimeException("no Authority!!!");
//        }else {
//            /**
//             * 进行业务操作
//             */
//            // 执行目标方法
            Object r  = joinPoint.proceed();
            /**
             * 目标方法执行完毕之后，执行的业务增强操作
             */
            log.info("出参:{}",r);
            return r;
//        }
    }


    public static void main(String[] args) {

    }



}
