package com.qcby.hongyanredenvelopes.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qcby.hongyanredenvelopes.entity.User;

import java.util.List;

public interface LoginService extends IService<User> {
    List<User> login(User user);
}
