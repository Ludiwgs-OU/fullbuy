package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.GroudbuyMapper;
import com.we.fullbuy.pojo.Groudbuy;
import com.we.fullbuy.service.GroudbuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("GroudbuyService")
public class GroudbuyServiceImpl implements GroudbuyService {
    @Autowired
    private GroudbuyMapper groudbuyMapper;

    @Override
    @Transactional
    public int addGroudbuy(Groudbuy groudbuy) {
        return groudbuyMapper.insert(groudbuy);
    }

    @Override
    @Transactional
    public int modifyGroudbuy(Groudbuy groudbuy) {
        return groudbuyMapper.updateByPrimaryKeySelective(groudbuy);
    }

    @Override
    public List<Groudbuy> showGroudbuyBySalesId(int salesId) {
        return groudbuyMapper.selectBySalesId(salesId);
    }

    @Override
    public List<Groudbuy> showAllGroudbuy() {
        return groudbuyMapper.showAllGroudbuy();
    }

    @Override
    public List<Groudbuy> searchGroudbuy(String keyword) {
        return groudbuyMapper.searchGroudbuy(keyword);
    }

    @Override
    @Transactional
    public int deleteGroudbuy(int groudbuyId) {
        return groudbuyMapper.deleteByPrimaryKey(groudbuyId);
    }

    @Override
    public Groudbuy showGroudbuyDetail(int productId) {
        return groudbuyMapper.showGroudbuyDetail(productId);
    }
}
