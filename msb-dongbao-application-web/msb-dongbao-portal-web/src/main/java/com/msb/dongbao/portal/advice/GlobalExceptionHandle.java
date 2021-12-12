package com.msb.dongbao.portal.advice;

import com.msb.dongbao.common.base.Result.ResultWrapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
