package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Favor;

public interface FavorMapper {
    int deleteByPrimaryKey(Integer favorid);

    int insert(Favor record);

    int insertSelective(Favor record);

    Favor selectByPrimaryKey(Integer favorid);

    int updateByPrimaryKeySelective(Favor record);

    int updateByPrimaryKey(Favor record);
}