package com.qcby.unifiedVerificationPlatform.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.unifiedVerificationPlatform.entity.Teacher;
import com.qcby.unifiedVerificationPlatform.mapper.TeacherDAO;
import com.qcby.unifiedVerificationPlatform.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherDAO, Teacher> implements TeacherService {
}
