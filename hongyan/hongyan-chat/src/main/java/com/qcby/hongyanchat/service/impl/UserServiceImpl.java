package com.qcby.hongyanchat.service.impl;

import com.qcby.hongyanchat.dao.UserMapper;
import com.qcby.hongyanchat.model.User;
import com.qcby.hongyanchat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        User user = userMapper.findByUsernameAndPasswd(username, password);
        return user != null;
    }

    @Override
    public boolean register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPasswd(password);
        int cnt = userMapper.insertSelective(user);
        return cnt > 0;
    }

    @Override
    @Transactional
    public void batchAdd(String username, String passwd) {
        User user = new User();
        user.setUsername(username);
        user.setPasswd(passwd);
        userMapper.insertSelective(user);
        user = new User();
        user.setUsername(username + "2");
        user.setPasswd(passwd);
        userMapper.insertSelective(user);
    }

    @Override
    public List<User> getUserList(String username) {
        return userMapper.getUserList(username);
    }
}
