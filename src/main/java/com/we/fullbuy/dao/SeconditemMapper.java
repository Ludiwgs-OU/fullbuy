package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Seconditem;

import java.util.List;

public interface SeconditemMapper {
    int deleteByPrimaryKey(Integer secondItemId);

    int insert(Seconditem record);

    int insertSelective(Seconditem record);

    Seconditem selectByPrimaryKey(Integer secondItemId);

    int updateByPrimaryKeySelective(Seconditem record);

    int updateByPrimaryKey(Seconditem record);

    /*new*/
    List<Seconditem> displaySecondItem();
}