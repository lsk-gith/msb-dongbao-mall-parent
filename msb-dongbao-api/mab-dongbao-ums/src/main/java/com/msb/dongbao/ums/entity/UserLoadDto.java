package com.msb.dongbao.ums.entity;

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
public class UserLoadDto {
    //    用户名
    private String username;
    //  密码
    private String password;
}
