package com.qcby.unifiedVerificationPlatform.config;

import com.xxl.sso.core.store.SsoLoginStore;
import com.xxl.sso.core.util.JedisUtil;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuxueli 2018-04-03 20:41:07
 */
@Configuration
@ConfigurationProperties(prefix="redis-wangyi")
@Data
public class XxlSsoConfig implements InitializingBean, DisposableBean {

    private String redisAddress;

    private int redisExpireMinute;

    @Override
    public void afterPropertiesSet() throws Exception {
        SsoLoginStore.setRedisExpireMinite(redisExpireMinute);
        JedisUtil.init(redisAddress);
    }

    @Override
    public void destroy() throws Exception {
        JedisUtil.close();
    }

}
