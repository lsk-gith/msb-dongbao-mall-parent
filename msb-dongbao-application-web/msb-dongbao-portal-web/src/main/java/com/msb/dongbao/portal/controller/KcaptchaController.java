package com.msb.dongbao.portal.controller;

import com.baomidou.kaptcha.Kaptcha;
import com.msb.dongbao.common.base.annotations.TokenCheck;
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
import java.util.Map;
import java.util.UUID;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 18:43
 * @Description: com.msb.dongbao.portal.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/kaptcha")
public class KcaptchaController {
    String attrName = "verifyCode";
    @Autowired
    private Kaptcha kaptcha;
    @GetMapping("/generator")
    @TokenCheck(required = false)
    public void generatorCode(HttpServletRequest request, HttpServletResponse response){
        kaptcha.render();
    }
    @GetMapping("/verify")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request){
        Boolean verify = kaptcha.validate(verifyCode);
        //保证验证码的时效性
        if(verify){
            CaptchaUtil.clear(request);
        }
        return verify ? "验证码正确":"验证码错误";
    }
}
