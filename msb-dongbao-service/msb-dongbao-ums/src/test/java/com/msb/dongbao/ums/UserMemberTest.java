package com.msb.dongbao.ums;

import com.msb.dongbao.ums.entity.UmsMember;
//import com.msb.dongbao.ums.entity.UserLoadDto;
import com.msb.dongbao.ums.entity.UserLoadDto;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @Author: lsk
 * @Date: 2021/12/9 - 12 - 09 - 22:27
 * @Description: com.msb.dongbao.ums
 * @Version: 1.0
 */
@SpringBootTest(classes = MsbDongbaoUmsApplication.class)
public class UserMemberTest {
    @Resource
     UmsMemberMapper umsMemberMapper;
    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Test
    void insertTest(){
        UmsMember t = new UmsMember();
        t.setUsername("lsk3");
        t.setStatus(0);
        t.setPassword("lsk@285975");
        t.setNote("note");
        t.setNickName("nick");
        t.setEmail("email");
        String encode = bCryptPasswordEncoder.encode(t.getPassword());
        try {
            t.setPassword(encode);
            umsMemberMapper.insert(t);
            System.out.println("注册成功！");
        }catch (Exception e){
            System.out.println("username duplicate! try other again!!!");
        }


    }

    @Test
    void testUpdate(){
        UmsMember t = new UmsMember();
        t.setNickName("乐呵呵");
        t.setId(52L);

        umsMemberMapper.updateById(t);
    }
//这里的loadtest中需要把改子项目的@Bean接触注释
    @Test
    void loadTest(){
        UserLoadDto userLoadDto = new UserLoadDto();
        userLoadDto.setUsername("lsk0");
        userLoadDto.setPassword("lsk@285975");
        UmsMember umsMember = umsMemberMapper.selectByName(userLoadDto.getUsername());
        if(null != umsMember){
            String passWordEncoded = umsMember.getPassword();
            if(bCryptPasswordEncoder.matches(userLoadDto.getPassword(),passWordEncoded)){
                System.out.println("登陆成功");
            }else{
                System.out.println("密码错误");
            }
        }else{
            System.out.println("用户不存在，登陆失败");
        }
    }

}
