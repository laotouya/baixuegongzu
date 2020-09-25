package com.huike.ycu.mybatis.mapper;

import com.huike.ycu.mybatis.model.UmsAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
    @Autowired
    private UmsAdminDao adminDao;

    @Test
    public void insertAdminTest() {
        UmsAdmin admin = new UmsAdmin();
        admin.setNickName("得得");
        admin.setCreateTime(new Date());
        admin.setPassword("123456");
        admin.setUsername("李四");

        this.adminDao.insertSelective(admin);
    }

    @Test
    public void deleteAdminTest(){
        this.adminDao.deleteByPrimaryKey(9L);
    }

    @Test
    public void selectByPrimaryKey(){
        this.adminDao.selectByPrimaryKey(12L);
    }

    @Test
    public void selectAll(){
        this.adminDao.selectAll();
    }

    @Test
    public void updateByPrimaryKeySelective(){
        UmsAdmin admin = new UmsAdmin();
        admin.setId(12L);
        admin.setNickName("嘻嘻");
        admin.setUsername("黄蛋蛋");

        this.adminDao.updateByPrimaryKeySelective(admin);
    }


}
