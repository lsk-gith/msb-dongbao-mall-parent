package com.msb.dongbao.portal.Interceptor;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.msb.dongbao.common.util.JwtUtil.JwtUtil;
import com.mysql.cj.protocol.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 15:43
 * @Description: com.msb.dongbao.portal.AuthInterceptor
 * @Version: 1.0
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器进入！");
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            throw new LoginException("token 为空");
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查调用的接口处是否有annotation的注解，如果有注解就进如if内部进行Jwt的token校验
        //如果没有就直接return true
        if(method.isAnnotationPresent(TokenCheck.class)){
            TokenCheck annotation  = method.getAnnotation(TokenCheck.class);
            if(annotation.required()){
                //校验token
                try {
                    String parseToken = JwtUtil.parseToken(token);
                    return true;
                }catch (Exception e){
                    throw new LoginException("token 异常");
                }
            }
            return true;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器处理中！");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器处理后");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
