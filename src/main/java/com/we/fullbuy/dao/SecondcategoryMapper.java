package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Secondcategory;

public interface SecondcategoryMapper {
    int deleteByPrimaryKey(Integer secondCategoryId);

    int insert(Secondcategory record);

    int insertSelective(Secondcategory record);

    Secondcategory selectByPrimaryKey(Integer secondCategoryId);

    int updateByPrimaryKeySelective(Secondcategory record);

    int updateByPrimaryKey(Secondcategory record);
}