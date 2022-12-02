package com.qcby.unifiedVerificationPlatform.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qcby.unifiedVerificationPlatform.common.constant.UserConstant;
import com.qcby.unifiedVerificationPlatform.common.constant.WebConstant;
import com.qcby.unifiedVerificationPlatform.common.web.ResultJson;
import com.qcby.unifiedVerificationPlatform.entity.Student;
import com.qcby.unifiedVerificationPlatform.entity.Teacher;
import com.qcby.unifiedVerificationPlatform.entity.User;
import com.qcby.unifiedVerificationPlatform.service.LoginService;
import com.qcby.unifiedVerificationPlatform.service.StudentService;
import com.qcby.unifiedVerificationPlatform.service.TeacherService;
import com.qcby.unifiedVerificationPlatform.util.CodeUtil;
import com.qcby.unifiedVerificationPlatform.util.IsStudentTeacherUtil;
import com.qcby.unifiedVerificationPlatform.util.JwtUtil;
import com.qcby.unifiedVerificationPlatform.util.RegexUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestController
@RequestMapping("self")
public class SelfController {

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private JwtUtil jwtUtil;

    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private LoginService loginService;

    /**
     * 修改密码验证接口
     *
     * @param phoneEmailCode
     * @return
     */
    @PostMapping("updatePasswordCheckEmail")
    public ResultJson updatePasswordCheckEmail(@RequestParam(value = "phoneEmailCode") String phoneEmailCode) {
        String token = httpServletRequest.getHeader(WebConstant.HEADER_TOKEN);
        User user = jwtUtil.getUser(token);

        String email = user.getEmail();
        String phone = user.getPhone();
        if (CodeUtil.checkCode(email, phoneEmailCode) || CodeUtil.checkCode(phone, phoneEmailCode)) {
            return ResultJson.ok();
        }

        return ResultJson.error();
    }

    /**
     * 解绑邮箱接口
     *
     * @param code
     * @return
     */
    @PostMapping("deleteEmail")
    public ResultJson deleteEmail(@RequestParam(value = "code") String code) {
        //发送验证码之后
        String token = httpServletRequest.getHeader(WebConstant.HEADER_TOKEN);
        User user = jwtUtil.getUser(token);

        String email = user.getEmail();
        if (!RegexUtil.isSixNumber(code) || !CodeUtil.checkCode(email, code)) {
            return ResultJson.error();
        }
        return ResultJson.ok();
    }

    /**
     * 绑定邮箱接口
     *
     * @param email
     * @param code
     * @return
     */
    @PostMapping("insertEmail")
    public ResultJson insertEmail(@RequestParam(value = "email") String email, @RequestParam(value = "code") String code) {
        //发送验证码之后
        if (!RegexUtil.isSixNumber(code) || !CodeUtil.checkCode(email, code)) {
            return ResultJson.error();
        }

        String token = httpServletRequest.getHeader(WebConstant.HEADER_TOKEN);
        String userId = jwtUtil.getAudience(token);
        User user = jwtUtil.getUser(token);

        //从内存里面获取,不进行硬盘IO操作===========>redis
        Integer isStudentTeacher = IsStudentTeacherUtil.getIsStudentTeacherMap().get(Long.parseLong(userId));
        if (isStudentTeacher == UserConstant.USER_STUDENT) {
            //更新信息
            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId);
            Student student = new Student();
            student.setEmail(email);
            boolean f = studentService.update(student, queryWrapper);

            if (f) {
                //更新jwt用户信息
                User user1 = loginService.usernameLogin(user);
                String token1 = jwtUtil.createToken(user1);
                user1.setToken(token1);

                //把之前的token放入黑名单
                jwtUtil.getBlackListSet().add(token);
                //延迟删除
                jwtUtil.delayDeleteBlackListSet(token);
                return ResultJson.ok();
            } else {
                return ResultJson.error();
            }

        }
        if (isStudentTeacher == UserConstant.USER_TEACHER) {
            QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId);
            Teacher teacher = new Teacher();
            teacher.setEmail(email);
            boolean f = teacherService.update(teacher, queryWrapper);

            if (f) {
                //更新jwt用户信息
                User user1 = loginService.usernameLogin(user);
                String token1 = jwtUtil.createToken(user1);
                user1.setToken(token1);

                //把之前的token放入黑名单
                jwtUtil.getBlackListSet().add(token);
                //延迟删除
                jwtUtil.delayDeleteBlackListSet(token);
                return ResultJson.ok();
            } else {
                return ResultJson.error();
            }
        }

        return ResultJson.ok();
    }

    /**
     * 解绑手机接口
     *
     * @param code
     * @return
     */
    @PostMapping("deletePhone")
    public ResultJson deletePhone(@RequestParam(value = "code") String code) {
        //发送验证码之后
        String token = httpServletRequest.getHeader(WebConstant.HEADER_TOKEN);
        User user = jwtUtil.getUser(token);

        String email = user.getEmail();
        if (!RegexUtil.isSixNumber(code) || !CodeUtil.checkCode(email, code)) {
            return ResultJson.error();
        }
        return ResultJson.ok();
    }

    /**
     * 绑定手机接口
     *
     * @param phone
     * @param code
     * @return
     */
    @PostMapping("insertPhone")
    public ResultJson insertPhone(@RequestParam(value = "phone") String phone, @RequestParam(value = "code") String code) {
        //发送验证码之后
        if (!RegexUtil.isSixNumber(code) || !CodeUtil.checkCode(phone, code)) {
            return ResultJson.error();
        }

        String token = httpServletRequest.getHeader(WebConstant.HEADER_TOKEN);
        String userId = jwtUtil.getAudience(token);
        User user = jwtUtil.getUser(token);

        //从内存里面获取,不进行硬盘IO操作===========>redis
        Integer isStudentTeacher = IsStudentTeacherUtil.getIsStudentTeacherMap().get(Long.parseLong(userId));
        if (isStudentTeacher == UserConstant.USER_STUDENT) {
            //更新信息
            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId);
            Student student = new Student();
            student.setPhone(phone);
            boolean f = studentService.update(student, queryWrapper);

            if (f) {
                //更新jwt用户信息
                User user1 = loginService.usernameLogin(user);
                String token1 = jwtUtil.createToken(user1);
                user1.setToken(token1);

                //把之前的token放入黑名单
                jwtUtil.getBlackListSet().add(token);
                //延迟删除
                jwtUtil.delayDeleteBlackListSet(token);
                return ResultJson.ok();
            } else {
                return ResultJson.error();
            }

        }
        if (isStudentTeacher == UserConstant.USER_TEACHER) {
            QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId);
            Teacher teacher = new Teacher();
            teacher.setPhone(phone);
            boolean f = teacherService.update(teacher, queryWrapper);

            if (f) {
                //更新jwt用户信息
                User user1 = loginService.usernameLogin(user);
                String token1 = jwtUtil.createToken(user1);
                user1.setToken(token1);

                //把之前的token放入黑名单
                jwtUtil.getBlackListSet().add(token);
                //延迟删除
                jwtUtil.delayDeleteBlackListSet(token);
                return ResultJson.ok();
            } else {
                return ResultJson.error();
            }
        }

        return ResultJson.ok();
    }

}
