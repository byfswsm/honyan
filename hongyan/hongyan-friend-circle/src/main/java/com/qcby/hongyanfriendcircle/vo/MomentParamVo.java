package com.qcby.hongyanfriendcircle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MomentParamVo {
    private Long userId;
    private LocalDateTime nowTime;
    private Long id;
}
