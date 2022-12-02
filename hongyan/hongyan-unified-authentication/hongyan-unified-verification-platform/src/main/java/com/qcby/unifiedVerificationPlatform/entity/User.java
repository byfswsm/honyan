package com.qcby.unifiedVerificationPlatform.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.qcby.unifiedVerificationPlatform.util.BloomFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 用户表
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户表id
     */
    private Long id;

    /**
     * 对应教职工号或者学号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * -1开除,0在校,1出校
     */
    private Integer state;

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
    private Set<String> menuUrlNameList;

    @TableField(exist = false)
    private String token;

    @TableField(exist = false)
    private String email;//以后修改邮箱的时候,更加方便,不用联表操作之类的

    @TableField(exist = false)
    private String phone;

    @TableField(exist = false)
    private List<Long> dutiesId;

    @TableField(exist = false)
    private List<String> dutiesName;

    @TableField(exist = false)
    private BloomFilter bloomFileter;

//    SSO相关操作
    @TableField(exist = false)
    private Map<String, String> plugininfo;
    @TableField(exist = false)
    private String version;
    @TableField(exist = false)
    private int expireMinute;
    @TableField(exist = false)
    private long expireFreshTime;
}