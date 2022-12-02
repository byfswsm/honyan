package com.qcby.hongyanredenvelopes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qcby.hongyanredenvelopes.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    public List<User> select();

    public boolean updateUserAmount(@Param("user") User user);

    public User getOneByName(@Param("user") User user);
}
