package com.qcby.hongyancommon.api.system.rpc;

import com.qcby.hongyancommon.api.system.vo.UserVo;

public interface SysUserRpc {

    /**
     *  登陆rpc接口
     *      返回用户信息，如果失败返回null
     * @param username
     * @param password
     * @return
     */
    UserVo login(String username,String password);
}
