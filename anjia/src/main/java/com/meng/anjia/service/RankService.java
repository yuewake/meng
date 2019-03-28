package com.meng.anjia.service;

import com.meng.anjia.dao.RankDao;
import com.meng.anjia.model.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/24 19:53
 */
@Service
public class RankService {

    @Autowired
    RankDao rankDao;

    /**
     * 返回所有城市预测数据
     * @return
     */
    public List<Rank> getAllRank()
    {
        return rankDao.getAllRank();
    }

    /**
     * 根据城市名得到预测信息
     * @param city
     * @return
     */
    public Rank getRankByCity(String city)
    {
        return rankDao.getRankByCity(city);
    }
}
