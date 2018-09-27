package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Groudbuy;

import java.util.List;

public interface GroudbuyMapper {
    int deleteByPrimaryKey(Integer gbId);

    int insert(Groudbuy record);

    int insertSelective(Groudbuy record);

    Groudbuy selectByPrimaryKey(Integer gbId);

    int updateByPrimaryKeySelective(Groudbuy record);

    int updateByPrimaryKey(Groudbuy record);

    /*new*/
    /*商家查看团购*/
    List<Groudbuy> selectBySalesId(Integer salesId);
    /*根据关键字搜索团购活动*/
    List<Groudbuy> searchGroudbuy(String keyword);
    /*显示所有团购*/
    List<Groudbuy> showAllGroudbuy();
    /*商品团购详情*/
    Groudbuy showGroudbuyDetail(Integer productId);
}