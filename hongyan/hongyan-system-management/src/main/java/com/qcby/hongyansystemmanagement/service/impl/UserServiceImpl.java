package com.qcby.hongyansystemmanagement.service.impl;

import com.qcby.hongyansystemmanagement.mapper.UserMapper;
import com.qcby.hongyansystemmanagement.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mi
 * @version 1.0
 * @description: TODO
 * @date 2021/12/29 10:35
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
}
