package com.msb.dongbao.portal.controller;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.msb.dongbao.common.base.code.ImageCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 18:43
 * @Description: com.msb.dongbao.portal.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/code")
public class VerifyCodeController {
    String attrName = "verifyCode";
    @GetMapping("/generator")
    @TokenCheck(required = false)
    public void generatorCode(HttpServletRequest request, HttpServletResponse response){
        try {
            ImageCode imageCode = ImageCode.getInstance();
            String code = imageCode.getCode();
            System.out.println(code);
            request.getSession().setAttribute(attrName,code);
            ByteArrayInputStream image = imageCode.getImage();
            //使用字节流直接输出到前端
            response.setContentType("image/jpeg");
            byte[] bytes = new byte[1024];
            try (ServletOutputStream out = response.getOutputStream()){
                while(image.read(bytes) != -1){
                    out.write(bytes);
                }
            }
            //使用base64转成字节输出到前端
//            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
//            byte[] buff = new byte[1024];
//            int r = 0;
//            while((r = image.read(buff,0,1024)) > 0){
//                swapStream.write(buff,0,r);
//            }
//            byte[] data = swapStream.toByteArray();
//            return Base64.getEncoder().encodeToString(data);

        }catch (Exception e){
            System.out.println("codeImage generate error");
//            return "";
        }
    }
    @GetMapping("/verify")
    @TokenCheck(required = false)
    public String verify(String verifyCode, HttpServletRequest request){
        String s = request.getSession().getAttribute(attrName).toString();
        if(s == null){
            return "验证为空";
        }
        if(verifyCode.equals(s)){
            return "验证码校验通过";
        }
        return "验证码错误";
    }




}
