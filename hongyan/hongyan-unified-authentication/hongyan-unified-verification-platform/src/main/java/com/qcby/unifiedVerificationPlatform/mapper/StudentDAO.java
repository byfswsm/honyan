package com.qcby.unifiedVerificationPlatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qcby.unifiedVerificationPlatform.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * StudentDAO继承基类
 */
@Repository
public interface StudentDAO extends BaseMapper<Student> {
}