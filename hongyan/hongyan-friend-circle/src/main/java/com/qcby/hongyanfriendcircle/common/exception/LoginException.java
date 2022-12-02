package com.qcby.hongyanfriendcircle.common.exception;

/**
 * @ProjectName: xmfs-3_project
 * @Package: com.qcby.xmfs3_project.Exception
 * @ClassName: LoginException
 * @Author: zxh
 * @Description: 登陆异常
 * @Date: 2021/11/29 15:53
 * @Version: 1.0
 */
public class LoginException extends Exception {
    /*无参构造函数*/
    public LoginException(){
        super();
    }

    //用详细信息指定一个异常
    public LoginException(String message){
        super(message);
    }

    //用指定的详细信息和原因构造一个新的异常
    public LoginException(String message, Throwable cause){
        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public LoginException(Throwable cause) {
        super(cause);
    }
}
