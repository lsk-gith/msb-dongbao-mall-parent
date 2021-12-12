package com.msb.dongbao.common.base.enums;
/**
 * @Author: lsk
 * @Date: 2021/12/12 - 12 - 12 - 18:38
 * @Description: com.msb.dongbao.common.base.enums
 * @Version: 1.0
 */
public enum StateCodeEnum {
    //用户名密码不正确
    PASSWORD_ERROR(1001,"用户名密码不正确"),
    //用户不存在
    USER_EMPTY(1002,"用户不存在"),
    //用户名重复
    USER_EXIST(1003,"用户名重复"),
    //请求失败,
    FAIL(500,"请求失败"),
    //请求成功
    SUCCESS(200,"请求成功");
    private  int code;
    private String msg;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    StateCodeEnum(int code , String msg){
        this.code = code;
        this.msg = msg;
    }
}
