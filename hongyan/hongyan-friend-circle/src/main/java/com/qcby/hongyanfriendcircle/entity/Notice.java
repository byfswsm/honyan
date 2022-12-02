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
 * 通知表
 * </p>
 *
 * @author xmfs_bwfw
 * @since 2021-12-28
 */
@TableName("notice")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通知主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 操作者
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 被操作者
     */
    @TableField("user_to_id")
    private Long userToId;

    /**
     * 通知性质
     */
    @TableField("content")
    private Integer content;

    /**
     * 动态主键
     */
    @TableField("moments_id")
    private Long momentsId;

    /**
     * 通知给谁
     */
    @TableField("to_id")
    private Long toId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 查看状态
     */
    @TableField("state")
    private Integer state;

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
    public Long getUserToId() {
        return userToId;
    }

    public void setUserToId(Long userToId) {
        this.userToId = userToId;
    }
    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }
    public Long getMomentsId() {
        return momentsId;
    }

    public void setMomentsId(Long momentsId) {
        this.momentsId = momentsId;
    }
    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Notice{" +
            "id=" + id +
            ", userId=" + userId +
            ", userToId=" + userToId +
            ", content=" + content +
            ", momentsId=" + momentsId +
            ", toId=" + toId +
            ", createTime=" + createTime +
            ", state=" + state +
        "}";
    }
}
