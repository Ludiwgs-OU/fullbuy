package com.we.fullbuy.serviceImpl;


import com.we.fullbuy.dao.ManagerMapper;
import com.we.fullbuy.pojo.Manager;
import com.we.fullbuy.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager login(int managerId) {
         return managerMapper.selectByPrimaryKey(managerId);
    }
}

