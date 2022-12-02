package com.qcby.hongyansystemmanagement;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
@MapperScan("com.qcby.hongyansystemmanagement.mapper")
public class HongyanSystemManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HongyanSystemManagementApplication.class, args);
    }

}
