package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Favor;

import java.util.List;

public interface FavorMapper {
    int deleteByPrimaryKey(Integer favorId);

    int insert(Favor record);

    int insertSelective(Favor record);

    Favor selectByPrimaryKey(Integer favorId);

    int updateByPrimaryKeySelective(Favor record);

    int updateByPrimaryKey(Favor record);

    /*new*/
    /*删除收藏夹*/
    int deleteFavors(List<Integer> favorId);
    /*显示用户收藏夹*/
    List<Favor> selectByUserId(Integer userId);
}