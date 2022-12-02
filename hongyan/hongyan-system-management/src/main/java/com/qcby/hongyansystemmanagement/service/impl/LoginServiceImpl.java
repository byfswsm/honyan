package com.qcby.hongyansystemmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qcby.hongyansystemmanagement.entity.User;
import com.qcby.hongyansystemmanagement.mapper.UserMapper;
import com.qcby.hongyansystemmanagement.service.LoginSeivice;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author Mi
 * @version 1.0
 * @description: TODO
 * @date 2022/1/3 20:45
 */
@Service
public class LoginServiceImpl implements LoginSeivice {


    @Resource
    private UserMapper userMapper;
    /**
     *
     * @param user
     * @return
     */
    @Override
    public User isLogin(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();


//        if (!StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getPassword()))
        if (StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword())) {
            queryWrapper.eq("username",user.getUsername());
            queryWrapper.eq("password",user.getPassword());
        }
//        User user1 = userDao.selectOne(queryWrapper);
        User user1 = userMapper.selectOne(queryWrapper);
        if(user1 != null){
            return user1;
        }

        return null;
    }


}
