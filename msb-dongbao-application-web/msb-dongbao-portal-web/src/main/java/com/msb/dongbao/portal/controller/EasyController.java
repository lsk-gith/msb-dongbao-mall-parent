package com.msb.dongbao.portal.controller;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 18:43
 * @Description: com.msb.dongbao.portal.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/easycpatcha")
public class EasyController {
    String attrName = "verifyCode";
    @GetMapping("/generator")
    @TokenCheck(required = false)
    public void generatorCode(HttpServletRequest request, HttpServletResponse response){
        try {
            CaptchaUtil.out(request,response);
        }catch (Exception e){
            System.out.println("codeImage generate error");
        }
    }
    @GetMapping("/verify")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request){
        Boolean verify = CaptchaUtil.ver(verifyCode,request);
        //保证验证码的时效性
        if(verify){
            CaptchaUtil.clear(request);
        }
        return verify ? "验证码正确":"验证码错误";
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("/generator-redis")
    @TokenCheck(required = false)
    public Map<String, String> generatorCodeRedis(HttpServletRequest request, HttpServletResponse response){
        SpecCaptcha specCaptcha = new SpecCaptcha(500, 100);
        String text = specCaptcha.text();
        String s = UUID.randomUUID().toString();
        String sessionId = request.getSession().getId();
        stringRedisTemplate.opsForValue().set(s,text);
        String specCaptchaBase64 = specCaptcha.toBase64();
        Map<String,String> map = new HashMap<>();
        map.put("uuid",s);
        map.put("specCaptchaBase64",specCaptchaBase64);
        return map;
    }
    @GetMapping("/verify-redis")
    @TokenCheck(required = false)
    public String verifyRedis(String verifyCode, HttpServletRequest request){
        String sessionId = request.getSession().getId();
        String c = stringRedisTemplate.opsForValue().get(verifyCode);
        Boolean verify = c.equals(verifyCode);
        System.out.println(c);
        System.out.println(verifyCode);
        //保证验证码的时效性
        if(verify){
            CaptchaUtil.clear(request);
        }
        return verify ? "验证码正确":"验证码错误";
    }

}
