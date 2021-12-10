package com.msb.dongbao.api.entity;

import lombok.Data;
import lombok.ToString;

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
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
}
