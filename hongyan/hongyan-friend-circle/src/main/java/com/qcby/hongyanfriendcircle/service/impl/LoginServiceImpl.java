package com.qcby.hongyanfriendcircle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanfriendcircle.entity.User;
import com.qcby.hongyanfriendcircle.mapper.LoginMapper;
import com.qcby.hongyanfriendcircle.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.service.impl
 * @ClassName: LoginServiceImpl
 * @Author: zxh
 * @Description: 登录实现类
 * @Date: 2021/12/28 22:45
 * @Version: 1.0
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {
}
