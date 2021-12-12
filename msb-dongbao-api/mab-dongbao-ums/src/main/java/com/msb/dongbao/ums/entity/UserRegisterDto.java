package com.msb.dongbao.ums.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @Author: lsk
 * @Date: 2021/12/10 - 12 - 10 - 14:09
 * @Description: com.msb.dongbao.api.entity
 * @Version: 1.0
 */
@Data
@ToString
public class UserRegisterDto {
    //    用户名
    @NotEmpty(message = "用户名不能为空")
    private String username;
    //  密码
    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 昵称
     */
    @Size(min = 1, max = 8, message = "用户昵称长度在1-8之间")
    private String nickName;

}
