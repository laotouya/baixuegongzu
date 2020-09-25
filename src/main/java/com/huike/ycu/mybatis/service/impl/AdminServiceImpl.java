package com.huike.ycu.mybatis.service.impl;

import com.huike.ycu.mybatis.mapper.UmsAdminDao;
import com.huike.ycu.mybatis.model.UmsAdmin;
import com.huike.ycu.mybatis.result.CodeMsg;
import com.huike.ycu.mybatis.result.Result;
import com.huike.ycu.mybatis.service.AdminService;
import com.huike.ycu.mybatis.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UmsAdminDao adminDao;



    @Override
    public Result<UmsAdmin> login(UmsAdmin umsAdmin) {
        UmsAdmin admin = this.adminDao.selectByUsername(umsAdmin);
        if(ObjectUtils.isEmpty(admin)) {
            return Result.error(CodeMsg.USERNAME_NOT_EXISTS);
        }
        // 数据库中保存的密码
        String dbPwd = admin.getPassword();
        String saltDB = admin.getSalt();
        // 用户输入的密码进行了加密
        String calaPass = MD5Util.inputPassToDbPass(umsAdmin.getPassword(), saltDB);
        if(!StringUtils.equals(dbPwd, calaPass)) { // 密码不一致
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        // 返回的admin信息中不能有密码的信息，所以要将密码置空
        admin.setPassword(StringUtils.EMPTY);
        admin.setSalt(StringUtils.EMPTY);

        return Result.success(admin);
    }




    @Override
    public int delete(long id) {
        return this.adminDao.deleteByPrimaryKey(id);
    }


    @Override
    public int zhuce(UmsAdmin umsAdmin) {
        return this.adminDao.insertSelective(umsAdmin);
    }
}
