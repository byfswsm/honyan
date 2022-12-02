package com.qcby.hongyanfriendcircle.common.web;
import com.qcby.hongyanfriendcircle.common.constant.WebConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: ResultJson
 * @description: 统一返回格式
 * @author: lxt
 * @create: 2021-11-05
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultJson {

    private int code;
    private String msg;
    private Object data;



    public static ResultJson ok(String msg,Object data){
        return new ResultJson(WebConstant.CODE_OK,msg,data);
    }

    public static ResultJson ok(String msg){
        return ok(msg,null);
    }

    public static ResultJson ok(Object data){
        return ok(WebConstant.CODE_OK_MSG,data);
    }

    public static ResultJson ok(){
        return ok(WebConstant.CODE_OK_MSG,null);
    }



    public static ResultJson error(String msg,Object data){
        return new ResultJson(WebConstant.CODE_ERROR,msg,data);
    }

    public static ResultJson error(String msg){
        return error(msg,null);
    }

    public static ResultJson error(Object data){
        return error(WebConstant.CODE_ERROR_MSG,data);
    }

    public static ResultJson error(){
        return error(WebConstant.CODE_ERROR_MSG,null);
    }




    public static ResultJson r(boolean r){
        if(r){
            return ok();
        }
        return error();
    }


    public static ResultJson r(int count){
        if(count > 0){
            return ok();
        }
        return error();
    }




}
