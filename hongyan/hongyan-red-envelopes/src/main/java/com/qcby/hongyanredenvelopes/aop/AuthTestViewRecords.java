package com.qcby.hongyanredenvelopes.aop;


import java.lang.annotation.*;

/**
 * 浏览记录
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)  //运行时生效
@Target(ElementType.METHOD) // 只可以在方法上使用 可以，隔开继续ElementType.***加其他的
public @interface AuthTestViewRecords {
    String auth() default  "";
    boolean enable() default true;
}
