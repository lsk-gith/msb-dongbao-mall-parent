package com.msb.dongbao.ums.md5;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @Author: lsk
 * @Date: 2021/12/10 - 12 - 10 - 20:13
 * @Description: com.msb.dongbao.ums.md5
 * @Version: 1.0
 */
public class encoderOrDecoderTest {
    @Test
    public void encoderOrDecode(){
        String sourceString = "123456";
        String md5DigestAsHex1 = DigestUtils.md5DigestAsHex(sourceString.getBytes());
        System.out.println("第一次加密值："+md5DigestAsHex1);
        String md5DigestAsHex2 = DigestUtils.md5DigestAsHex(sourceString.getBytes());
        System.out.println("第一次加密值："+md5DigestAsHex2);
    }

    @Test
    public void bcrypt(){
        String sourceString = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode(sourceString);
        System.out.println("第一次加密值："+encode1);
        String encode2 = bCryptPasswordEncoder.encode(sourceString);
        System.out.println("第一次加密值："+encode2);
        //验证
        boolean matches1 = bCryptPasswordEncoder.matches(sourceString,encode1);
        System.out.println(matches1);
        boolean matches2 = bCryptPasswordEncoder.matches(sourceString,encode2);
        System.out.println(matches2);
    }


}
