package com.qcby.unifiedVerificationPlatform;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDubbo
@SpringBootApplication
@MapperScan("com.qcby.unifiedVerificationPlatform.mapper")
@EnableAsync
public class UnifiedVerificationPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnifiedVerificationPlatformApplication.class, args);
    }
}
