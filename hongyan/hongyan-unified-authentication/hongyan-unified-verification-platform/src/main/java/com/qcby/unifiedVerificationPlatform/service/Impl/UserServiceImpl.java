package com.qcby.unifiedVerificationPlatform.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.unifiedVerificationPlatform.entity.User;
import com.qcby.unifiedVerificationPlatform.mapper.UserDAO;
import com.qcby.unifiedVerificationPlatform.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {
}
