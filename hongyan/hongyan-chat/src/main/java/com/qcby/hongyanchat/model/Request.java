package com.qcby.hongyanchat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor//无参构造器
@AllArgsConstructor//有参构造器
@Builder
@Data //不用加set/get
public class Request {
    Long id;
    Long userId;
    Long requestId;
}
