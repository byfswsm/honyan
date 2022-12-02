package com.qcby.unifiedVerificationPlatform.controller;

import com.qcby.hongyancommon.api.system.rpc.SysUserRpc;
import com.qcby.hongyancommon.api.system.vo.UserVo;
import com.qcby.hongyancommon.web.ResultJson;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testRpc")
public class TestRpcController {

    /**
     *   王者  ： 版本更新：
     *      pk ->  100服务器
     *
     *      更新一个功能：可选更新 =》  同时  2个版本都可用
     *
     */
    @DubboReference(version = "${dubbo.consumer.SysUserRpc.version}")
    private SysUserRpc sysUserRpc;


    @RequestMapping("login")
    public ResultJson login(String username,String password){
        UserVo userVo = sysUserRpc.login(username,password);
        if(userVo == null){
            return ResultJson.fail("用户名或密码错误！");
        }
        return ResultJson.ok(userVo);
    }
}
