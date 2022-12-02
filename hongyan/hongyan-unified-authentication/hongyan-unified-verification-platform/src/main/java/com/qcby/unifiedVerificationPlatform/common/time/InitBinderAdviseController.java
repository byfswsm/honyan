package com.qcby.unifiedVerificationPlatform.common.time;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class InitBinderAdviseController {
    
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为时间类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // LocalDateTime 类型转换
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (!StringUtils.isEmpty(text)) {
                    setValue(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }
            }
        });
    }
}