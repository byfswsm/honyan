package com.qcby.unifiedVerificationPlatform.common.exception;

public class BusinessException extends Exception {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String meassage, Throwable cause) {
        super(meassage, cause);
    }
}
