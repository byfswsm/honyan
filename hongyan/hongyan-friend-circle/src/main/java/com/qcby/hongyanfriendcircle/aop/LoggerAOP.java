package com.qcby.hongyanfriendcircle.aop;

import com.alibaba.fastjson.JSON;
import com.qcby.hongyanfriendcircle.util.JwtUtil;
import com.qcby.hongyanfriendcircle.entity.LogOperation;
import com.qcby.hongyanfriendcircle.service.LogOperationService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @ProjectName: xmfs-3_project
 * @Package: com.qcby.xmfs3_project.aop
 * @ClassName: LoggerAOP
 * @Author: zxh
 * @Description: 用于记录操作日志
 * @Date: 2021/12/7 15:23
 * @Version: 1.0
 */

@Component
@Aspect
@Slf4j
public class LoggerAOP {
    private LogOperationService logOperationService;

    @Autowired
    public void setLogOperationService(LogOperationService logOperationService) {
        this.logOperationService = logOperationService;
    }

    //定义切点，注解作为切入点
    @Pointcut("execution(* com.qcby.hongyanfriendcircle.controller.*.*(..)) " +
            "&& (!execution(* com.qcby.hongyanfriendcircle.controller.LoginController.tologin(..)))")
    public void LoggerPointCut() {

    }

    @Around("LoggerPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        LogOperation logOperation = new LogOperation();
        String token = request.getHeader("token");
        Long id = Long.parseLong(JwtUtil.getAudience(token));
        logOperation.setUserId(id);
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        log.info("执行的方法为:"+method.getName());
        logOperation.setMethod(method.getName());
        Object[] objects = joinPoint.getArgs();
        String[] paramNames = signature.getParameterNames();
        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < objects.length; i++) {
            map.put(paramNames[i], objects[i]);
        }
        String InputParameter = JSON.toJSONString(map);
        logOperation.setInputParameter(InputParameter);
        log.info("入参 = " + InputParameter);
        Object proceed = joinPoint.proceed();
        String OutputParameter = JSON.toJSONString(proceed);
        log.info("出参=" + OutputParameter);
        logOperation.setOutputParameter(OutputParameter);
        logOperation.setCreateTime(LocalDateTime.now());
        try {
            logOperationService.save(logOperation);
        } catch (Exception e) {
            log.error("操作日志存储失败:" + e.getMessage());
        }
        return proceed;
    }
}
