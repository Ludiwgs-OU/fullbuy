package com.we.fullbuy.serviceImpl;

import com.we.fullbuy.dao.FavorMapper;
import com.we.fullbuy.pojo.Favor;
import com.we.fullbuy.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("FavorService")
public class FavorServiceImpl implements FavorService {
    @Autowired
    FavorMapper favorMapper;

    @Override
    @Transactional
    public int addFavor(Favor favor) {
        return favorMapper.insert(favor);
    }

    @Override
    @Transactional
    public int deleteSingleFavor(int favorId) {
        return favorMapper.deleteByPrimaryKey(favorId);
    }

    @Override
    @Transactional
    public int deleteFavors(List<Integer> favorId) {
        return favorMapper.deleteFavors(favorId);
    }

    @Override
    public List<Favor> displayFavor(int userId) {
        return favorMapper.selectByUserId(userId);
    }

/*    @Override
    public List<Favor> searchFavor(String keyword, int userId) {
        return null;
    }*/
}
