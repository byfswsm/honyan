package com.qcby.unifiedVerificationPlatform.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

/**
 * @author 老师表
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 老师的id
     */
    private Long id;

    /**
     * 对应用户id
     */
    private Long userId;

    /**
     * 老师的姓名
     */
    private String name;

    /**
     * 老师的教师号，也是他的登录名
     */
    private String username;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生年月
     */
    private String birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 入职时间
     */
    private Date startDate;

    /**
     * 离职时间 未离职9999-01-01
     */
    private Date overDate;

    /**
     * 存的是照片粗放的地址
     */
    private String photo;

    /**
     * 学位,教师学位表主键id
     */
    private Long degreeId;

    @TableField(exist = false)
    private String degreeName;
    /**
     * 身份证号
     */
    private String idCard;


    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 权限字符串
     */
    @TableField(exist = false)
    private Set<String> menuUrlPathList;

    @TableField(exist = false)
    private String token;

    @TableField(exist = false)
    private String password;
}