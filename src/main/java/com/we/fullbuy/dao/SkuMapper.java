package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Sku;

import java.util.List;

public interface SkuMapper {
    int deleteByPrimaryKey(Integer skuId);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Integer skuId);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);

    /*new*/
    /*获取价格*/
    Sku getPrice(Integer productId, Integer itemId, Integer secondItemId);
    /*根据商品ID获取sku*/
    List<Sku> displaySku(Integer productId);
}