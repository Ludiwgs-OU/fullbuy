package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Favor;

import java.util.List;

public interface FavorService {
    /*添加商品到收藏夹*/
    int addFavor(Favor favor);
    /*删除单个收藏夹的商品*/
    int deleteSingleFavor(int favorId);
    /*批量删除收藏夹的商品*/
    int deleteFavors(List<Integer> favorId);
    /*查看收藏夹*/
    List<Favor> displayFavor(int userId);
}
