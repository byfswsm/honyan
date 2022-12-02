package com.qcby.hongyanredenvelopes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanredenvelopes.entity.User;
import com.qcby.hongyanredenvelopes.mapper.UserMapper;
import com.qcby.hongyanredenvelopes.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> select() {
        List<User> users = userMapper.select();
        for (User user:users){
            System.out.println(user.toString());
        }
        return users;
    }

    @Override
    public boolean updateUserAmount(User user) {
        return userMapper.updateUserAmount(user);
    }

    @Override
    public User getOneByName(User user) {
        return userMapper.getOneByName(user);
    }
}
