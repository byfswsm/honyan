package com.qcby.hongyanfriendcircle.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 点赞表
 * </p>
 *
 * @author xmfs_bwfw
 * @since 2021-12-28
 */
@TableName("ref_fabulous")
public class RefFabulous implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 动态主键
     */
    @TableId("moments_id")
    private Long momentsId;

    /**
     * 点赞者
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 点赞时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private LocalDateTime createTime;

    public Long getMomentsId() {
        return momentsId;
    }

    public void setMomentsId(Long momentsId) {
        this.momentsId = momentsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RefFabulous{" +
            "momentsId=" + momentsId +
            ", userId=" + userId +
            ", createTime=" + createTime +
        "}";
    }
}
