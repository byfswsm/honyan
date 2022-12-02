package com.qcby.unifiedVerificationPlatform.util;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


/**
 * 检测是否为学生或老师
 */
@Slf4j
public class IsStudentTeacherUtil {

    private static volatile Map<Long, Integer> isStudentTeacherMap;

    //单例模式,懒汉式,同步锁===========>多线程访问的话,会锁住,只允许一个进程访问
    public static Map<Long, Integer> getIsStudentTeacherMap() {
        if (isStudentTeacherMap == null) {
            synchronized (IsStudentTeacherUtil.class) {
                if (isStudentTeacherMap == null) {
                    isStudentTeacherMap = new HashMap<>();
                }
            }
        }
        return isStudentTeacherMap;
    }

    //不能创建对象
    private IsStudentTeacherUtil() {

    }

}
