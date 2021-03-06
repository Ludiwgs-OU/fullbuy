package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    /*new*/
    /*显示用户收藏夹*/
    List<Address> selectByUserId(Integer userId);
}