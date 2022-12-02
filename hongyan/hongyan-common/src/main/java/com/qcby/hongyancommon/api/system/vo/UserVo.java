package com.qcby.hongyancommon.api.system.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {
    private String username;
    private String token;
}
