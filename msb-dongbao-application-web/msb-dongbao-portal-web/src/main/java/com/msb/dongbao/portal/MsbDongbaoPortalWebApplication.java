package com.msb.dongbao.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.msb.dongbao"})
@MapperScan("com.msb.dongbao.ums")
public class MsbDongbaoPortalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsbDongbaoPortalWebApplication.class, args);
    }

}
