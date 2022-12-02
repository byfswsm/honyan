package com.qcby.unifiedVerificationPlatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qcby.unifiedVerificationPlatform.entity.User;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends BaseMapper<User> {

}