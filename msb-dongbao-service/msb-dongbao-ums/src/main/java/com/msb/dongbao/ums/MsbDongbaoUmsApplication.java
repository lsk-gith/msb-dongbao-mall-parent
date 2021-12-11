package com.msb.dongbao.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@MapperScan({"com.msb.dongbao.ums.mapper"})
public class MsbDongbaoUmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsbDongbaoUmsApplication.class, args);
    }

//    @Bean
//    public BCryptPasswordEncoder PasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

}
