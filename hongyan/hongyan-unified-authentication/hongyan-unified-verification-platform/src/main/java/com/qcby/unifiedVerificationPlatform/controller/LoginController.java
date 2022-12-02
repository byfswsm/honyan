package com.qcby.unifiedVerificationPlatform.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qcby.unifiedVerificationPlatform.common.constant.UserConstant;
import com.qcby.unifiedVerificationPlatform.common.constant.WebConstant;
import com.qcby.unifiedVerificationPlatform.common.web.ResultJson;
import com.qcby.unifiedVerificationPlatform.entity.Student;
import com.qcby.unifiedVerificationPlatform.entity.Teacher;
import com.qcby.unifiedVerificationPlatform.entity.User;
import com.qcby.unifiedVerificationPlatform.service.*;
import com.qcby.unifiedVerificationPlatform.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private JwtUtil jwtUtil;
    @Resource
    private UserService userService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private LoginService loginService;
    @Resource
    private AsyncService asyncService;

    /**
     * 用户名登录
     *
     * @param user
     * @return
     */
    @PostMapping("usernameLogin")
    public ResultJson usernameLogin(User user) {
        User user1 = loginService.usernameLogin(user);
        if (user1 != null) {
            //加权限字符串

            //token设置
            String token = jwtUtil.createToken(user1);
            user1.setToken(token);

            //存入登录数据

            //验证是否为学生老师,放入IsStudentTeacherUtil的isStudentTeacherMap表中
            String userId = jwtUtil.getAudience(token);
            QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
            studentQueryWrapper.eq("user_id", userId);
            Student student = studentService.getOne(studentQueryWrapper);
            if (student != null) {
                IsStudentTeacherUtil.getIsStudentTeacherMap().put(Long.parseLong(userId), UserConstant.USER_STUDENT);
                log.info("IsStudentTeacherUtil.getIsStudentTeacherMap(): " + IsStudentTeacherUtil.getIsStudentTeacherMap());
            }

            QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
            teacherQueryWrapper.eq("user_id", userId);
            Teacher teacher = teacherService.getOne(teacherQueryWrapper);
            if (teacher != null) {
                IsStudentTeacherUtil.getIsStudentTeacherMap().put(Long.parseLong(userId), UserConstant.USER_TEACHER);
                log.info("IsStudentTeacherUtil.getIsStudentTeacherMap(): " + IsStudentTeacherUtil.getIsStudentTeacherMap());
            }

            //移除黑名单
            if (JwtUtil.getBlackListSet().contains(user1.getId())) {
                JwtUtil.getBlackListSet().remove(user1.getId());
            }

            return ResultJson.ok(user1);
        }

        return ResultJson.error();
    }

    /**
     * 手机或者邮箱登录接口
     *
     * @param user
     * @return
     */
    @PostMapping("phoneEmailLogin")
    public ResultJson phoneEmailLogin(User user) {

        User user1 = loginService.phoneEmailLogin(user);
        if (user1 != null) {
            //加权限字符串

            //token设置
            String token = jwtUtil.createToken(user1);
            user1.setToken(token);

            //存入登录数据

            //验证是否为学生老师,放入IsStudentTeacherUtil的isStudentTeacherMap表中
            String userId = jwtUtil.getAudience(token);

            QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
            studentQueryWrapper.eq("user_id", userId);
            Student student = studentService.getOne(studentQueryWrapper);
            if (student != null) {
                IsStudentTeacherUtil.getIsStudentTeacherMap().put(Long.parseLong(userId), UserConstant.USER_STUDENT);
                log.info("IsStudentTeacherUtil.getIsStudentTeacherMap(): " + IsStudentTeacherUtil.getIsStudentTeacherMap());
            }

            QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
            teacherQueryWrapper.eq("user_id", userId);
            Teacher teacher = teacherService.getOne(teacherQueryWrapper);
            if (teacher != null) {
                IsStudentTeacherUtil.getIsStudentTeacherMap().put(Long.parseLong(userId), UserConstant.USER_TEACHER);
                log.info("IsStudentTeacherUtil.getIsStudentTeacherMap(): " + IsStudentTeacherUtil.getIsStudentTeacherMap());

            }

            //移除黑名单
            if (JwtUtil.getBlackListSet().contains(user1.getId())) {
                JwtUtil.getBlackListSet().remove(user1.getId());
            }

            return ResultJson.ok(user1);
        }

        return ResultJson.error();
    }

    /**
     * 获取前端输入手机号或者邮箱号,发送信息
     *
     * @param getPhoneEmail
     * @return
     */
    @PostMapping("sendPhoneEmailCode")
    public ResultJson sendPhoneEmailCode(@RequestParam("getPhoneEmail") String getPhoneEmail) {

        //验证格式
        if (RegexUtil.isEmail(getPhoneEmail)) {
            //发送邮箱
            String email = getPhoneEmail;
            MailSendUtil.sendMsg(email);
            //注解异步删除emailCode
            asyncService.delayDeleteUserCode(email);
            return ResultJson.ok();
        }
        if (RegexUtil.isMobile(getPhoneEmail)) {
            //发送手机号
            String phone = getPhoneEmail;
            PhoneSendUtil.sendMsg(phone);
            //注解异步删除phoneCode
            asyncService.delayDeleteUserCode(phone);
            return ResultJson.ok();
        }

        return ResultJson.error();
    }

    /**
     * 自动获取手机号,发送信息
     *
     * @return
     */
    @PostMapping("sendPhoneCode")
    public ResultJson sendPhoneCode() {
        String token = httpServletRequest.getHeader(WebConstant.HEADER_TOKEN);
        User user = jwtUtil.getUser(token);
        String phone = user.getPhone();
        //验证格式
        if (RegexUtil.isMobile(phone)) {
            //注解异步删除emailCode
            PhoneSendUtil.sendMsg(phone);
            //注解异步删除phoneCode
            asyncService.delayDeleteUserCode(phone);
            return ResultJson.ok();
        }

        return ResultJson.error();
    }

    /**
     * 自动获取邮箱号,发送信息
     *
     * @return
     */
    @PostMapping("sendEmailCode")
    public ResultJson sendEmailCode() {
        String token = httpServletRequest.getHeader(WebConstant.HEADER_TOKEN);
        User user = jwtUtil.getUser(token);
        String email = user.getEmail();

        //验证格式
        if (RegexUtil.isEmail(email)) {
            //发送邮箱
            MailSendUtil.sendMsg(email);
            //注解异步删除email
            asyncService.delayDeleteUserCode(email);
            return ResultJson.ok();
        }

        return ResultJson.error();
    }

    /**
     * 忘记密码验证接口
     *
     * @param getPhoneEmail
     * @param phoneEmailCode
     * @return
     */
    @PostMapping("forgetPasswordCheck")
    public ResultJson forgetPasswordCheck(
            @RequestParam(value = "getPhoneEmail") String getPhoneEmail,
            @RequestParam(value = "phoneEmailCode") String phoneEmailCode) {


        if (RegexUtil.isEmail(getPhoneEmail) && CodeUtil.checkCode(getPhoneEmail, phoneEmailCode)) {

            return ResultJson.ok();
        }
        if (RegexUtil.isMobile(getPhoneEmail) && CodeUtil.checkCode(getPhoneEmail, phoneEmailCode)) {

            return ResultJson.ok();
        }

        return ResultJson.error();
    }

    /**
     * 修改密码接口
     *
     * @param newPassword
     * @param againPassword
     * @param getPhoneEmail
     * @return
     */
    @PostMapping("updatePassword")
    public ResultJson updatePassword(
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "againPassword") String againPassword,
            @RequestParam(value = "getPhoneEmail") String getPhoneEmail) {

        String token = httpServletRequest.getHeader(WebConstant.HEADER_TOKEN);
        User user = jwtUtil.getUser(token);

        //用户既没有输入手机号或邮箱,又没有登录
        if (StringUtils.isEmpty(getPhoneEmail) || user == null) {
            return ResultJson.error();
        }


        //如果用户输入的邮箱或者手机号正确
        if (user.getEmail().equals(getPhoneEmail) || user.getPhone().equals(getPhoneEmail)) {

            if (StringUtils.isEmpty(newPassword)
                    || StringUtils.isEmpty(againPassword)
                    || !newPassword.equals(againPassword)) {
                return ResultJson.error();
            }

            //更新用户信息
            User user1 = new User();
            user1.setPassword(newPassword);
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("id", user.getId());
            boolean f = userService.update(user1, userQueryWrapper);
            if (f) {
                //更新jwt用户信息
                user.setPassword(newPassword);//只需要改之前用户的password就行
                String token1 = jwtUtil.createToken(user);
                user.setToken(token1);

                //把之前的token放入黑名单
                jwtUtil.getBlackListSet().add(token);
                //延迟删除
                jwtUtil.delayDeleteBlackListSet(token);
                return ResultJson.ok();
            }
        }

        return ResultJson.ok();

    }

    /**
     * 生成普通验证码
     *
     * @return
     */
    @RequestMapping("doCode")
    public String doCode() {

        return CodeUtil.doCode(httpServletRequest);
    }

    /**
     * 检验普通验证码
     *
     * @param code
     * @return
     */
    @RequestMapping("checkCode")
    public boolean checkCode(String code) {
        if (StringUtils.isEmpty(code) || code == null) {
            return false;
        }

        return CodeUtil.checkCode(code, httpServletRequest);
    }


    /**
     * 验证手机或邮箱验证码
     *
     * @param phoneEmailCode
     * @param getPhoneEmail
     * @return
     */
    @RequestMapping("checkPhoneEmailCode")
    public boolean checkPhoneEmailCode(@RequestParam(value = "phoneEmailCode") String phoneEmailCode,
                                       @RequestParam(value = "getPhoneEmail") String getPhoneEmail) {

        return CodeUtil.checkCode(getPhoneEmail, phoneEmailCode);
    }




}
