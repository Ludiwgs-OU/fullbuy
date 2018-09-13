package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Favor;

import java.util.List;

public interface FavorMapper {
    int deleteByPrimaryKey(Integer favorid);

    int insert(Favor record);

    int insertSelective(Favor record);

    Favor selectByPrimaryKey(Integer favorid);

    int updateByPrimaryKeySelective(Favor record);

    int updateByPrimaryKey(Favor record);

    /*new*/
    /*删除收藏夹*/
    int deleteFavors(List<Integer> favorid);
    /*显示用户收藏夹*/
    List<Favor> selectByUserId(Integer userid);
}