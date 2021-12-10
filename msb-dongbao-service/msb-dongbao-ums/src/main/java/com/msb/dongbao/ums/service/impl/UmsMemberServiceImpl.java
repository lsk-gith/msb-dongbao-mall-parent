package com.msb.dongbao.ums.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.msb.dongbao.api.entity.UmsMember;
import com.msb.dongbao.api.entity.UserRegisterDto;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.msb.dongbao.api.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
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
    public String register(UserRegisterDto userRegisterDto){
        UmsMember user = new UmsMember();
        BeanUtils.copyProperties(userRegisterDto,user);
        try {
            umsMemberMapper.insert(user);
            return "success";
        }catch (Exception e){
            System.out.println("111111111111111111111111111111111");
            return "replicate userName! try other userName!!!";
        }
    }

}
