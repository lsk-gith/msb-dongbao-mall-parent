package com.msb.dongbao.common.util.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 11:52
 * @Description: com.msb.dongbao.common.util
 * @Version: 1.0
 */
public class JwtUtil {
    //所谓的盐，随便设置，但是只是开发人员知道。
    private static final String secret = "asdfasdf";
    public static String createToken(String subject){
        String token = Jwts.builder().setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))//设置过期时间
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return token;
    }
    public static String parseToken(String token){
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        String subject = body.getSubject();
        return subject;
    }
}
