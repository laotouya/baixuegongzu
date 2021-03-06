package com.huike.ycu.mybatis.mapper;

import com.huike.ycu.mybatis.model.PmsBrand;

public interface PmsBrandDao {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);
}