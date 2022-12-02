package com.qcby.hongyanfriendcircle.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertMomentsVo {
    private Long id;

    private Long userId;

    private String content;

    private Integer state;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer visibleTime;

    private Integer pingstate;

}
