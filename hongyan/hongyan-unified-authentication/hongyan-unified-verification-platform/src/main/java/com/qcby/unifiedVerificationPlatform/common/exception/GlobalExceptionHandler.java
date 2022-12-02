package com.qcby.unifiedVerificationPlatform.common.exception;


import com.qcby.unifiedVerificationPlatform.common.web.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultJson handle(Exception e) {
        if (e instanceof BusinessException) {
            log.info(e.getMessage(), e);
            return ResultJson.error(e.getMessage());
        }
        log.error("系统异常", e);
        return ResultJson.error("系统异常!");
    }

}
