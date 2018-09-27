package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Sales;

import java.util.List;

public interface SalesMapper {
    int deleteByPrimaryKey(Integer salesId);

    int insert(Sales record);

    int insertSelective(Sales record);

    Sales selectByPrimaryKey(Integer salesId);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);

    /*new*/
    /*根据商家注册电话搜索*/
    Sales selectByPhone(String phone);
    /*推荐商家*/
    List<Sales> displayRecommend();
}