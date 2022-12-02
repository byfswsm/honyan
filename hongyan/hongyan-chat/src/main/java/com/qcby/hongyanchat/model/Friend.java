package com.qcby.hongyanchat.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor//无参构造器
@AllArgsConstructor//有参构造器
@Builder
@Data //不用加set/get
@TableName(value="friend")
public class Friend {
    private Long id;

    @TableField(value="user_id")
    private Long userId;

    @TableField(value="friend_id")
    private Long friendId;

    @TableField(exist = false)
    private long sss;

    public Friend(Long userId, Long friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }
}
