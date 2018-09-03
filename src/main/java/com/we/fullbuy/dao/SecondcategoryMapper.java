package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Secondcategory;

public interface SecondcategoryMapper {
    int deleteByPrimaryKey(Integer secondcategoryid);

    int insert(Secondcategory record);

    int insertSelective(Secondcategory record);

    Secondcategory selectByPrimaryKey(Integer secondcategoryid);

    int updateByPrimaryKeySelective(Secondcategory record);

    int updateByPrimaryKey(Secondcategory record);
}