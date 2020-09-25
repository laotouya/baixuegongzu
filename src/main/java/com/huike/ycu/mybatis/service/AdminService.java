package com.huike.ycu.mybatis.service;

import com.huike.ycu.mybatis.model.UmsAdmin;
import com.huike.ycu.mybatis.result.Result;

public interface AdminService {

    /** 使用用户名和密码进行登录 */
    Result<UmsAdmin> login(UmsAdmin umsAdmin) ;


    int delete(long id);

    int zhuce(UmsAdmin umsAdmin);
}
