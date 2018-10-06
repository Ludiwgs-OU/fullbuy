package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Item;

import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    /*new*/
    List<Item> displayItem();
}