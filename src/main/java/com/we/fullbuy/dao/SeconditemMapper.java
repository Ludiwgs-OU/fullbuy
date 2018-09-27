package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Seconditem;

public interface SeconditemMapper {
    int deleteByPrimaryKey(Integer secondItemId);

    int insert(Seconditem record);

    int insertSelective(Seconditem record);

    Seconditem selectByPrimaryKey(Integer secondItemId);

    int updateByPrimaryKeySelective(Seconditem record);

    int updateByPrimaryKey(Seconditem record);
}