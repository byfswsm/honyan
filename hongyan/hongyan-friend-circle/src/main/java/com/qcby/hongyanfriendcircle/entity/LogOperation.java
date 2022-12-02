package com.qcby.hongyanfriendcircle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author xmfs_group3
 * @since 2021-11-28
 */
@TableName("log_operation")
public class LogOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 访问方法名
     */
    @TableField("method")
    private String method;

    /**
     * 入参
     */
    @TableField("input_parameter")
    private String inputParameter;

    /**
     * 出参
     */
    @TableField("output_parameter")
    private String outputParameter;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getInputParameter() {
        return inputParameter;
    }

    public void setInputParameter(String inputParameter) {
        this.inputParameter = inputParameter;
    }
    public String getOutputParameter() {
        return outputParameter;
    }

    public void setOutputParameter(String outputParameter) {
        this.outputParameter = outputParameter;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LogOperation{" +
            "id=" + id +
            ", userId=" + userId +
            ", method=" + method +
            ", inputParameter=" + inputParameter +
            ", outputParameter=" + outputParameter +
            ", createTime=" + createTime +
        "}";
    }
}
