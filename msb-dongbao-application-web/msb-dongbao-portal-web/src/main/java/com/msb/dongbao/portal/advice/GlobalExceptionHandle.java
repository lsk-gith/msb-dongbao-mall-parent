package com.msb.dongbao.portal.advice;

import com.baomidou.kaptcha.exception.KaptchaException;
import com.baomidou.kaptcha.exception.KaptchaIncorrectException;
import com.baomidou.kaptcha.exception.KaptchaTimeoutException;
import com.msb.dongbao.common.base.Result.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.LoginException;

/**
 * @Author: lsk
 * @Date: 2021/12/12 - 12 - 12 - 20:12
 * @Description: com.msb.dongbao.portal.advice
 * @Version: 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper customException(){
        return ResultWrapper.builder().code(301).msg("除数为零异常").build();
    }

    @ExceptionHandler(LoginException.class)
    public ResultWrapper loginException(Exception e){
        return ResultWrapper.getFailBuilder().msg(e.getMessage()).build();
    }
    @ExceptionHandler(KaptchaException.class)
    public String kacptchaExceptionHandle(KaptchaException e){
        if(e instanceof KaptchaIncorrectException){
            return "不正确！";
        }else if(e instanceof KaptchaTimeoutException){
            return "超时！";
        }else {
            return "没有找到！";
        }
    }
}
