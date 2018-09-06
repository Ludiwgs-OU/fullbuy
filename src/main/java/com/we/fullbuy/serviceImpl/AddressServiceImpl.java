package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.AddressMapper;
import com.we.fullbuy.pojo.Address;
import com.we.fullbuy.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    @Transactional
    public int addAddress(Address address) {
        return addressMapper.insert(address);
    }

    @Override
    @Transactional
    public int modifyAddress(Address address) {
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    @Transactional
    public int deleteAddress(int addressId) {
        return addressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    @Transactional
    public List<Address> displayAddress(int userId) {
        return addressMapper.selectByUserId(userId);
    }

    @Override
    @Transactional
    public Address displayAddressDetail(int addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }
}
