package com.qcby.unifiedVerificationPlatform.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qcby.unifiedVerificationPlatform.common.constant.UserConstant;
import com.qcby.unifiedVerificationPlatform.entity.Student;
import com.qcby.unifiedVerificationPlatform.entity.Teacher;
import com.qcby.unifiedVerificationPlatform.entity.User;
import com.qcby.unifiedVerificationPlatform.mapper.*;
import com.qcby.unifiedVerificationPlatform.service.LoginService;
import com.qcby.unifiedVerificationPlatform.util.IsStudentTeacherUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private TeacherDAO teacherDAO;
    @Override
    @Transactional
    public User usernameLogin(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getPassword())) {
            queryWrapper.eq("username", user.getUsername());
            queryWrapper.eq("password", user.getPassword());
        }
        //看user表是否有该用户
        User user1 = userDAO.selectOne(queryWrapper);
        if (user1 != null) {//如果有
            QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
            studentQueryWrapper.eq("user_id", user1.getId());
            Student student = studentDAO.selectOne(studentQueryWrapper);
            if (student != null) {
                user1.setEmail(student.getEmail());
                user1.setPhone(student.getPhone());
                IsStudentTeacherUtil.getIsStudentTeacherMap().put(student.getUserId(), UserConstant.USER_STUDENT);
            }

            QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
            teacherQueryWrapper.eq("user_id", user1.getId());
            Teacher teacher = teacherDAO.selectOne(teacherQueryWrapper);
            if (teacher != null) {
                user1.setEmail(teacher.getEmail());
                user1.setPhone(teacher.getPhone());
                IsStudentTeacherUtil.getIsStudentTeacherMap().put(teacher.getUserId(), UserConstant.USER_TEACHER);
            }
            return user1;
        }
        return null;
    }

    @Override
    public User phoneEmailLogin(User user) {
        String password = user.getPassword();
        if (StringUtils.isEmpty(password)) {
            return null;
        }

        String email = user.getEmail();
        if (!StringUtils.isEmpty(email)) {
            QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
            studentQueryWrapper.eq("email", email);
            studentQueryWrapper.eq("password", password);
            User user1 = loginDAO.isStudent(studentQueryWrapper);
            if (user1 != null) {
                return user1;
            }

            QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
            teacherQueryWrapper.eq("email", email);
            teacherQueryWrapper.eq("password", password);
            user1 = loginDAO.isTeacher(teacherQueryWrapper);
            if (user1 != null) {
                return user1;
            }
        }

        String phone = user.getPhone();
        if (!StringUtils.isEmpty(phone)) {

            QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
            studentQueryWrapper.eq("phone", phone);
            studentQueryWrapper.eq("password", password);
            User user3 = loginDAO.isStudent(studentQueryWrapper);
            if (user3 != null) {
                return user3;
            }

            QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
            teacherQueryWrapper.eq("phone", phone);
            teacherQueryWrapper.eq("password", password);
            User user4 = loginDAO.isTeacher(teacherQueryWrapper);
            if (user4 != null) {
                return user4;
            }
        }

        return null;
    }

}
