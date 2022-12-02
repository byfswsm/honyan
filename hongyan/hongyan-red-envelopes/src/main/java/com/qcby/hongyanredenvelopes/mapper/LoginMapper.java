package com.qcby.hongyanredenvelopes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qcby.hongyanredenvelopes.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper extends BaseMapper<User> {

    public List<User> login(@Param("user") User user);
}
