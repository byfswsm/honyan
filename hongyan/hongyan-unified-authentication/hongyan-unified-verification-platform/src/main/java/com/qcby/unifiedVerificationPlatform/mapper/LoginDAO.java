package com.qcby.unifiedVerificationPlatform.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.qcby.unifiedVerificationPlatform.entity.Student;
import com.qcby.unifiedVerificationPlatform.entity.Teacher;
import com.qcby.unifiedVerificationPlatform.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO {

    User isUsernameLogin(@Param("user") User user);

    User isPhoneEmailLogin(@Param("user") User user);

    User isStudent(@Param(Constants.WRAPPER) QueryWrapper<Student> queryWrapper);

    User isTeacher(@Param(Constants.WRAPPER) QueryWrapper<Teacher> queryWrapper);


}
