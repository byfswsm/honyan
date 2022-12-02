package com.qcby.hongyanfriendcircle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qcby.hongyanfriendcircle.mapper")
public class HongyanFriendCircleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HongyanFriendCircleApplication.class, args);
    }

}
