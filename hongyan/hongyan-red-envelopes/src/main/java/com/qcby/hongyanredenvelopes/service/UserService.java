package com.qcby.hongyanredenvelopes.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qcby.hongyanredenvelopes.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    public List<User> select();
    public boolean updateUserAmount(User user);

    public User getOneByName(User user);
}
