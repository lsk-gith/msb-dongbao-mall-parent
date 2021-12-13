package com.msb.dongbao.common.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 13:57
 * @Description: com.msb.dongbao.common.base.annotations
 * @Version: 1.0
 */
@Target(ElementType.METHOD)//表示作用的方法上
@Retention(RetentionPolicy.RUNTIME)//保留在什么地方
public @interface TokenCheck {
    //是否校验token
    boolean required() default true;//默认检测token
}
