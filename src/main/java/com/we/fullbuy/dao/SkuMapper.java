package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Sku;

import java.util.List;

public interface SkuMapper {
    int deleteByPrimaryKey(Integer skuid);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Integer skuid);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);

}