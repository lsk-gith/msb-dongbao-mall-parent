package com.msb.dongbao.portal.controller;


import com.msb.dongbao.api.entity.UserRegisterDto;
import com.msb.dongbao.api.service.UmsMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author lsk
 * @since 2021-12-09
 */
@RestController
@RequestMapping("/ums-member")
public class UmsMemberController {
    @Resource
    UmsMemberService umsMemberService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/register")
    public String register(@RequestBody UserRegisterDto userRegisterDto){
      return umsMemberService.register(userRegisterDto);
//        return "register";
    }
}

