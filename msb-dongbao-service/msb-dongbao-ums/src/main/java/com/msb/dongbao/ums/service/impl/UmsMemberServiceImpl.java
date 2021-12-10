package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.api.entity.UmsMember;
import com.msb.dongbao.api.entity.UserRegisterDto;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.msb.dongbao.api.service.UmsMemberService;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@ToString
public class UmsMemberServiceImpl implements UmsMemberService {
    @Resource
    UmsMemberMapper umsMemberMapper;
    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public String register(UserRegisterDto userRegisterDto){
        UmsMember user = new UmsMember();
        BeanUtils.copyProperties(userRegisterDto,user);
        try {
            String encode1 = bCryptPasswordEncoder.encode(user.getPassword());
            System.out.println(encode1);
            user.setPassword(encode1);
            umsMemberMapper.insert(user);
            return "success";
        }catch (Exception e){
            return "replicate userName! try other userName!!!";
        }
    }

}
