package com.msb.dongbao.portal.controller;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.msb.dongbao.common.base.code.util.JCaptchaUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 18:43
 * @Description: com.msb.dongbao.portal.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/jcaptcha")
public class JCaptchaController {
    String attrName = "verifyCode";
    @GetMapping("/generator")
    @TokenCheck(required = false)
    public void generatorCode(HttpServletRequest request, HttpServletResponse response){
        try {
            String id = request.getSession().getId();
            BufferedImage image = JCaptchaUtil.getService().getImageChallengeForID(id);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(byteArrayOutputStream);
            jpegEncoder.encode(image);
            response.setHeader("Cache-Cotrol","no-store");
            response.setContentType("image/jpeg");
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ServletOutputStream servletOutputStream = response.getOutputStream();
            servletOutputStream.write(bytes);
            servletOutputStream.flush();
            servletOutputStream.close();
        }catch (Exception e){
            System.out.println("codeImage generate error");
        }
    }
    @GetMapping("/verify")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request){
        Boolean verify = JCaptchaUtil.getService().validateResponseForID(request.getSession().getId(), verifyCode);
        return verify ? "验证码正确":"验证码错误";
    }
}
