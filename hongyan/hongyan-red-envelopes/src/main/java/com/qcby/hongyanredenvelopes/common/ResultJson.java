package com.qcby.hongyanredenvelopes.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.qcby.hongyanredenvelopes.common.JiucaiConstant.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultJson {
    private int code;
    private String msg;
    private Object data;

    public static ResultJson build(int code, String msg, Object data){
        return new ResultJson(code,msg,data);
    }
    public static ResultJson build(boolean r){
        if(r){
            return ResultJson.ok();
        }else{
            return ResultJson.error();
        }
//        return r ? ok() : error();
    }
    public static ResultJson ok(String msg, Object data){
        return build(CODE_OK,msg,data);
//        return new ResultJson(CODE_OK,msg,data);
    }
    public static ResultJson ok(Object data){
        return build(CODE_OK,CODE_OK_MSG,data);
    }
    public static ResultJson ok(String msg){
        return build(CODE_OK,msg,null);
//        return new ResultJson(CODE_OK,msg,null);
    }
    public static ResultJson ok(){
        return build(CODE_OK,CODE_OK_MSG,null);
    }
    public static ResultJson error(String msg, Object data){
        return build(CODE_ERROR,msg,data);
    }
    public static ResultJson error(Object data){
        return build(CODE_ERROR,CODE_ERROR_MSG,data);
    }
    public static ResultJson error(String msg){
        return build(CODE_ERROR,msg,null);
    }
    public static ResultJson error(){
        return build(CODE_ERROR,CODE_ERROR_MSG,null);
    }


}
