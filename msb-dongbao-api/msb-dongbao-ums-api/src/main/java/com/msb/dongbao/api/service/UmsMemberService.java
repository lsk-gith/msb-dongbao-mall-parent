package com.msb.dongbao.api.service;

import com.msb.dongbao.api.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author lsk
 * @since 2021-12-09
 */
public interface UmsMemberService extends IService<UmsMember> {
    public String register();
}
