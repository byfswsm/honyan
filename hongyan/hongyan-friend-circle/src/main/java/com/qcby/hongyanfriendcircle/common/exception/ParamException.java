package com.qcby.hongyanfriendcircle.common.exception;

/**
 * @ProjectName: xmfs-3_project
 * @Package: com.qcby.xmfs3_project.Exception
 * @ClassName: ParamException
 * @Author: zxh
 * @Description: 参数错误
 * @Date: 2021/12/1 10:04
 * @Version: 1.0
 */
public class ParamException extends Exception {
    /*无参构造函数*/
    public ParamException(){
        super();
    }

    //用详细信息指定一个异常
    public ParamException(String message){
        super(message);
    }

    //用指定的详细信息和原因构造一个新的异常
    public ParamException(String message, Throwable cause){
        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public ParamException(Throwable cause) {
        super(cause);
    }
}
