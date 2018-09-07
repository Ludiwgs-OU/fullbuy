package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.SalesMapper;
import com.we.fullbuy.pojo.Sales;
import com.we.fullbuy.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SalesService")
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesMapper salesMapper;

    @Override
    public Sales displaySalesDetail(int salesId) {
        return salesMapper.selectByPrimaryKey(salesId);
    }

    @Override
    public int modifySales(Sales sales) {
        return salesMapper.updateByPrimaryKeySelective(sales);
    }

    @Override
    public int registerSales(Sales sales) {
        return salesMapper.insert(sales);
    }

    @Override
    public Sales login(String phone) {
        return salesMapper.selectByPhone(phone);
    }
}
