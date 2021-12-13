package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.common.base.Result.ResultWrapper;
import com.msb.dongbao.common.util.JwtUtil.JwtUtil;
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
    public ResultWrapper register(UserRegisterDto userRegisterDto) {
        UmsMember user = new UmsMember();
        BeanUtils.copyProperties(userRegisterDto,user);
        try {
            String encode = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encode);
            umsMemberMapper.insert(user);
            return ResultWrapper.getSuccessBuilder().data(null).build();
        }catch (Exception e){
            return ResultWrapper.getRuplicateUserName().data(null).build();
        }
    }

    @Override
    public ResultWrapper load(UserLoadDto userLoadDto) {
        System.out.println(userLoadDto.getUsername() + userLoadDto.getPassword());
        UmsMember umsMember = umsMemberMapper.selectByName(userLoadDto.getUsername());
        if(null != umsMember){
            String passWord = umsMember.getPassword();
            if(bCryptPasswordEncoder.matches(userLoadDto.getPassword(),passWord)){
                String token = JwtUtil.createToken(umsMember.getUsername());
                return ResultWrapper.getSuccessBuilder().data(token).build();
            }else{
                return ResultWrapper.getPassWordError().data(null).build();
            }
        }else{
            return ResultWrapper.getUserEmpty().data(null).build();
        }
    }

    @Override
    public ResultWrapper edit(UmsMember umsMember) {
        //这里写的有点乱，正常情况下应该是先查找到老信息，然后跟新新信息
        String userName = umsMember.getUsername();
        UmsMember umsMember1 = umsMemberMapper.selectByName(userName);
        Long userId =umsMember1.getId();
        umsMember.setId(userId);
        String encodePassword = bCryptPasswordEncoder.encode(umsMember.getPassword());
        umsMember.setPassword(encodePassword);
        umsMemberMapper.updateById(umsMember);
        return ResultWrapper.getSuccessBuilder().build();
    }
}
