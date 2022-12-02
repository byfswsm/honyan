package com.qcby.unifiedVerificationPlatform.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.unifiedVerificationPlatform.entity.Student;
import com.qcby.unifiedVerificationPlatform.mapper.StudentDAO;
import com.qcby.unifiedVerificationPlatform.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDAO, Student> implements StudentService {
}
