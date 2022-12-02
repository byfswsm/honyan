package com.qcby.hongyanredenvelopes.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {
    private Long id;
    private Long money;
    private String username;
    private String password;

    @TableField(exist = false)
    private String token;
}
