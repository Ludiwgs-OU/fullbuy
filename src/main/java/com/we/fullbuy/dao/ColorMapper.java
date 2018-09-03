package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Color;

public interface ColorMapper {
    int deleteByPrimaryKey(Integer colorid);

    int insert(Color record);

    int insertSelective(Color record);

    Color selectByPrimaryKey(Integer colorid);

    int updateByPrimaryKeySelective(Color record);

    int updateByPrimaryKey(Color record);
}