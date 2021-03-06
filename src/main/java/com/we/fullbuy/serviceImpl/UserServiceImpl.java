package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.UserMapper;
import com.we.fullbuy.pojo.User;
import com.we.fullbuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User displayUserDetail(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional
    public int modifyUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional
    public int registerUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User login(String phone) {
        return userMapper.selectByPhone(phone);
    }

}
