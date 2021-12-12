package com.msb.dongbao.common.base.Result;

import com.msb.dongbao.common.base.enums.StateCodeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: lsk
 * @Date: 2021/12/12 - 12 - 12 - 18:42
 * @Description: com.msb.dongbao.common.base.Result
 * @Version: 1.0
 */
@Data
@Builder
public class ResultWrapper<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    public static ResultWrapper.ResultWrapperBuilder getSuccessBuilder(){
        return ResultWrapper.builder().code(StateCodeEnum.SUCCESS.getCode()).msg(StateCodeEnum.SUCCESS.getMsg());
    }
    public static ResultWrapper.ResultWrapperBuilder getFailBuilder(){
        return ResultWrapper.builder().code(StateCodeEnum.FAIL.getCode()).msg(StateCodeEnum.FAIL.getMsg());
    }
    public static ResultWrapper.ResultWrapperBuilder getRuplicateUserName(){
        return ResultWrapper.builder().code(StateCodeEnum.USER_EXIST.getCode()).msg(StateCodeEnum.USER_EXIST.getMsg());
    }
    public static ResultWrapper.ResultWrapperBuilder getPassWordError(){
        return ResultWrapper.builder().code(StateCodeEnum.PASSWORD_ERROR.getCode()).msg(StateCodeEnum.PASSWORD_ERROR.getMsg());
    }
    public static ResultWrapper.ResultWrapperBuilder getUserEmpty(){
        return ResultWrapper.builder().code(StateCodeEnum.USER_EMPTY.getCode()).msg(StateCodeEnum.USER_EMPTY.getMsg());
    }
}
