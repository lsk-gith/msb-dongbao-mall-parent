package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.UserLoadDto;
import com.msb.dongbao.ums.entity.UserRegisterDto;
import com.msb.dongbao.ums.service.UmsMemberService;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author lsk
 * @since 2021-12-10
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    UmsMemberMapper umsMemberMapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public String register(UserRegisterDto userRegisterDto) {
        UmsMember user = new UmsMember();
        BeanUtils.copyProperties(userRegisterDto,user);
        try {
            String encode = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encode);
            umsMemberMapper.insert(user);
            return "success!";
        }catch (Exception e){
            return "userName replicate, try other userName!!!";
        }
    }

    @Override
    public String load(UserLoadDto userLoadDto) {
        System.out.println(userLoadDto.getUsername() + userLoadDto.getPassword());
        UmsMember umsMember = umsMemberMapper.selectByName(userLoadDto.getUsername());
        if(null != umsMember){
            String passWord = umsMember.getPassword();
            if(bCryptPasswordEncoder.matches(userLoadDto.getPassword(),passWord)){
                return "登陆成功";
            }else{
                return "密码错误";
            }
        }else{
            return "用户不存在，登陆失败";
        }
    }
}
