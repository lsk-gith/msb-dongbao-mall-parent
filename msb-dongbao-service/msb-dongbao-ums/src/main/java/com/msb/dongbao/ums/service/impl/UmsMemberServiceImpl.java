package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.api.entity.UmsMember;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.msb.dongbao.api.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author lsk
 * @since 2021-12-09
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {
    @Resource
    UmsMemberMapper umsMemberMapper;
    public String register(){
        UmsMember user = new UmsMember();
        user.setUsername("haha");
        user.setPassword("123456");
        umsMemberMapper.insert(user);
        return "success";
    }

}
