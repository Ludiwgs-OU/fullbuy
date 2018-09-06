package com.we.fullbuy.service;

import com.we.fullbuy.pojo.Address;

import java.util.List;

public interface AddressService {
    /*增加地址*/
    int addAddress (Address address);
    /*修改地址*/
    int modifyAddress(Address address);
    /*删除地址*/
    int deleteAddress(int addressId);
    /*显示地址*/
    List<Address> displayAddress(int userId);
    /*地址详情*/
    Address displayAddressDetail(int addressId);
}
