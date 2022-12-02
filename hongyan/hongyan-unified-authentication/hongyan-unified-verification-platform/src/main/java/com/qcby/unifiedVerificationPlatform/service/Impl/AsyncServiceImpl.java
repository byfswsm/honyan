package com.qcby.unifiedVerificationPlatform.service.Impl;

import com.qcby.unifiedVerificationPlatform.service.AsyncService;
import com.qcby.unifiedVerificationPlatform.util.CodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async("asyncServiceExecutor")
    public void testExecuteAsync() {
        log.info("开始异步");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("结束异步");
    }

    @Override
    @Async("asyncServiceExecutor")
    public void delayDeleteUserCode(String getPhoneEmail) {
        log.info("2分钟后删除该用户  " + getPhoneEmail + "  的验证码");

        try {
            Thread.sleep(120 * 1000);
            CodeUtil.getLoginCodeMap().remove(getPhoneEmail);
            log.info("已删除该用户  " + getPhoneEmail + "  的验证码");
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
