//package com.clusterProject.unifiedVerificationPlatform.aop;
//
//import com.theSecondCentralizedProject.DistributedProject.common.constant.WebConstant;
//import com.theSecondCentralizedProject.DistributedProject.entity.LogOperation;
//import com.theSecondCentralizedProject.DistributedProject.util.JwtUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//
//@Slf4j
//@Aspect
//@Component
//@Order(0)
//public class LoginAop {
//
//    @Autowired
//    private HttpServletRequest httpServletRequest;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private HttpServletResponse response;
////    @Resource
////    private LogOperationService logOperationService;
//
//    //定义切点,注解为切入点
//    @Pointcut("within(com.theSecondCentralizedProject.DistributedProject.controller..*)&& !within(com.theSecondCentralizedProject.DistributedProject.controller.LoginController)")
//    public void viewRecordsPointCut() {
//
//    }
//
//    /**
//     * before 目标方法执行前执行，前置通知
//     * after 目标方法执行后执行，后置通知
//     * after returning 目标方法返回时执行 ，后置返回通知
//     * after throwing 目标方法抛出异常时执行 异常通知
//     * around 在目标函数执行中执行，可控制目标函数是否执行，环绕通知
//     */
//
//    @Before("viewRecordsPointCut()")
//    public void before(JoinPoint joinPoint) throws Throwable {
//        log.info("进入Before通知...");
//    }
//
//    @After("viewRecordsPointCut()")
//    public void after(JoinPoint joinPoint) throws Throwable {
//        log.info("进入After通知....");
//    }
//
//    @AfterReturning("viewRecordsPointCut()")
//    public void afterReturning(JoinPoint joinPoint) throws Throwable {
//        log.info("进入AfterReturning通知....");
//    }
//
//    @AfterThrowing("viewRecordsPointCut()")
//    public void afterThrowing(JoinPoint joinPoint) throws Throwable {
//        log.info("进入AfterThrowing通知....");
//    }
//
//
//    @Around("viewRecordsPointCut()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("进入controller==>Around通知....");
//        /**
//         * 进行业务操作
//         */
//        String token = httpServletRequest.getHeader(WebConstant.HEADER_TOKEN);
//        String userId = jwtUtil.getAudience(token);
//        if (!jwtUtil.verifyToken(token, userId) || JwtUtil.getBlackListSet().contains(Long.parseLong(userId))) {
//            response.sendRedirect("/thirdPartyLogin.html");
//            return null;
//        }
//
//
//        //从切面织入点处通过反射机制获取织入点处的方法
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//
//        //获取切入点所在的方法
//        Method method = signature.getMethod();        //方法名
//        Object[] inputParameters = joinPoint.getArgs();        //入参
//        /*for (Object inputParameter : inputParameters) {
//            log.info("inputParameter:{}", inputParameter);
//        }*/
//        Object outputParameter = joinPoint.proceed();        //返回参数
//        LocalDateTime localDateTime = LocalDateTime.now();        //时间
//
//        LogOperation logOperation = LogOperation.builder()
//                .userId(Long.parseLong(userId))
//                .method(method.getName())
//                .createTime(localDateTime).build();
//
//        if (outputParameter != null) {
//            logOperation.setOutputParameter(outputParameter.toString());
//        } else {
//            logOperation.setOutputParameter("null");
//        }
//
//        if (inputParameters != null && inputParameters.length != 0) {
//            logOperation.setInputParameter(Arrays.toString(inputParameters));
//        } else {
//            logOperation.setInputParameter("null");
//        }
//
//        log.info("入参:  " + Arrays.toString(inputParameters) + "    时间: " + LocalDateTime.now());
//        log.info("出参: " + outputParameter.toString() + "    时间: " + LocalDateTime.now());
//
////        logOperationService.save(logOperation);
//
//        return outputParameter;
//    }
//
//}
