package com.msb.dongbao.portal.advice;

import com.msb.dongbao.common.base.Result.ResultWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author: lsk
 * @Date: 2021/12/12 - 12 - 12 - 19:48
 * @Description: com.msb.dongbao.portal.advice
 * @Version: 1.0
 */
//
@ControllerAdvice
public class ValidateHandler extends ResponseEntityExceptionHandler{
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder sb = new StringBuilder();
        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            String defaultMessage = fieldError.getDefaultMessage();
            sb.append("    " + defaultMessage);
            //这里还可以添加其他的信息
//            sb.append("    " + );
            break;
        }
        return new ResponseEntity<>(ResultWrapper.builder().code(102).msg(sb.toString()).build(),HttpStatus.OK);
    }
}
