package com.msb.dongbao.portal.controller;


import com.msb.dongbao.common.base.Result.ResultWrapper;
import com.msb.dongbao.ums.entity.UserLoadDto;
import com.msb.dongbao.ums.entity.UserRegisterDto;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    @Autowired
    UmsMemberService umsMemberService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/register")
    public ResultWrapper registerController(@RequestBody @Valid UserRegisterDto userRegisterDto){
      return umsMemberService.register(userRegisterDto);
    }
    @GetMapping("/load")
    public ResultWrapper loadController(@RequestBody UserLoadDto userLoadDto){
        return umsMemberService.load(userLoadDto);
    }

}

