package com.qcby.hongyansystemmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 用户表id
     */
    private int uid;

    /**
     * 对应教职工号或者学号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 详细描述
     */
    private String details;

    @TableField(exist = false)
    private String token;
}
