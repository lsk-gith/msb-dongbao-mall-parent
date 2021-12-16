package com.msb.dongbao.portal.controller;

import com.msb.dongbao.portal.util.SliderUtil;
import com.msb.dongbao.portal.util.VerificationVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lsk
 * @Date: 2021/12/16 - 12 - 16 - 19:47
 * @Description: com.msb.dongbao.portal.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/my-slider")
public class MySlidController {
    @GetMapping("/generator")
    public VerificationVO genreteCode(HttpServletRequest request, HttpServletResponse response){
        return SliderUtil.cut();
    }
    @GetMapping("/verify")
    public String verify(String verifyCode, HttpServletRequest request) {
//		Boolean aBoolean = kaptcha.validate(verifyCode, 10);
//		if (aBoolean) {
//			return "通过";
//		}
        return "不通过";
    }
}
