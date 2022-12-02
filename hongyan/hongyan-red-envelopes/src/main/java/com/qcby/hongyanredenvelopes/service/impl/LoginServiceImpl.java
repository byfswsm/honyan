package com.qcby.hongyanredenvelopes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanredenvelopes.entity.User;
import com.qcby.hongyanredenvelopes.mapper.LoginMapper;
import com.qcby.hongyanredenvelopes.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Override
    public List<User> login(User user) {
        return loginMapper.login(user);
    }
}
