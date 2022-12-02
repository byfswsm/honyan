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
 * 评论表
 * </p>
 *
 * @author xmfs_bwfw
 * @since 2021-12-28
 */
@TableName("comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户主键
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 回复谁
     */
    @TableField("to_id")
    private Long toId;

    /**
     * 评论内容
     */
    @TableField("content")
    private String content;

    /**
     * 动态主键
     */
    @TableField("moments_id")
    private Long momentsId;

    /**
     * 评论时间
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
    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Long getMomentsId() {
        return momentsId;
    }

    public void setMomentsId(Long momentsId) {
        this.momentsId = momentsId;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
            "id=" + id +
            ", userId=" + userId +
            ", toId=" + toId +
            ", content=" + content +
            ", momentsId=" + momentsId +
            ", createTime=" + createTime +
        "}";
    }
}
