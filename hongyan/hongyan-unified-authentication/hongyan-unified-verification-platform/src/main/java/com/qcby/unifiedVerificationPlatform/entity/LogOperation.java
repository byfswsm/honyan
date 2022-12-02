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
 * 操作日志
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LogOperation{
    /**
     * 操作id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 访问方法名
     */
    private String method;

    /**
     * 入参
     */
    private String inputParameter;
    /**
     * 创建时间

     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 出参
     */
    private String outputParameter;


}