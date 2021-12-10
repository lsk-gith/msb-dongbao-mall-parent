package com.msb.dongbao.ums;

import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: lsk
 * @Date: 2021/12/9 - 12 - 09 - 22:27
 * @Description: com.msb.dongbao.ums
 * @Version: 1.0
 */
@SpringBootTest(classes = com.msb.dongbao.ums.MsbDongbaoUmsApplication.class)
public class UserMemberTest {
    @Resource
     UmsMemberMapper umsMemberMapper;
    @Test
    void insertTest(){
        UmsMember t = new UmsMember();
        t.setUsername("lsk3");
        t.setStatus(0);
        t.setPassword("lsk@285975");
        t.setNote("note");
        t.setNickName("nick");
        t.setEmail("email");


        umsMemberMapper.insert(t);
    }

    @Test
    void testUpdate(){
        UmsMember t = new UmsMember();
        t.setNickName("尴尬");
        t.setId(16L);

        umsMemberMapper.updateById(t);
    }

}
