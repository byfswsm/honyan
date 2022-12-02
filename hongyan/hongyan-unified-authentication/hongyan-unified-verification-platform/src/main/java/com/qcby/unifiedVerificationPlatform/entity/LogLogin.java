package com.qcby.unifiedVerificationPlatform.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 
 * 登录日志
 */


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LogLogin {
    /**
     * 登录表的id
     */
    private Long id;

    /**
     * 用户的id
     */
    private String name;

    /**
     * 登录者ip
     */
    private String ip;

    /**
     * 创建时间

     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}