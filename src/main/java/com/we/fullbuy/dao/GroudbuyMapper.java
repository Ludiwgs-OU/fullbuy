package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Groudbuy;

public interface GroudbuyMapper {
    int deleteByPrimaryKey(Integer gbid);

    int insert(Groudbuy record);

    int insertSelective(Groudbuy record);

    Groudbuy selectByPrimaryKey(Integer gbid);

    int updateByPrimaryKeySelective(Groudbuy record);

    int updateByPrimaryKey(Groudbuy record);
}