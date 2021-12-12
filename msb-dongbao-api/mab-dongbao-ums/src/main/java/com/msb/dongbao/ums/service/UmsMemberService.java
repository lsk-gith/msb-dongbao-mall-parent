package com.msb.dongbao.ums.service;
import com.msb.dongbao.common.base.Result.ResultWrapper;
import com.msb.dongbao.ums.entity.UserLoadDto;
import com.msb.dongbao.ums.entity.UserRegisterDto;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author lsk
 * @since 2021-12-09
 */
public interface UmsMemberService {
    public abstract ResultWrapper register(UserRegisterDto userRegisterDto);
    public abstract ResultWrapper load(UserLoadDto userLoadDto);
}
