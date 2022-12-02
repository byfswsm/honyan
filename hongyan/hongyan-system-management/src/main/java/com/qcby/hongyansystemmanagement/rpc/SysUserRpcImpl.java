//package com.qcby.hongyansystemmanagement.rpc;
//
//import com.qcby.hongyancommon.api.system.rpc.SysUserRpc;
//import com.qcby.hongyancommon.api.system.vo.UserVo;
//import org.apache.dubbo.config.annotation.DubboService;
//
//import java.util.UUID;
//
//@DubboService(version = "${dubbo.provider.SysUserRpc.version}")
//public class SysUserRpcImpl implements SysUserRpc {
//
//    @Override
//    public UserVo login(String username, String password) {
//        if("admin".equals(username) && "123".equals(password)){
//            UserVo userVo  = new UserVo();
//            userVo.setUsername(username);
//            userVo.setToken(UUID.randomUUID().toString());
//            return userVo;
//        }
//        return null;
//    }
//
//
//}
