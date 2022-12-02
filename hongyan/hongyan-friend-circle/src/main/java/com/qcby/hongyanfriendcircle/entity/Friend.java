package com.qcby.hongyanfriendcircle.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.entity
 * @ClassName: Friend
 * @Author: zxh
 * @Description: 好友表
 * @Date: 2021/12/29 17:16
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friend {

    private Long userId;

    private Long otherId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
