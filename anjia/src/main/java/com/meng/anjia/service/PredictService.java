package com.meng.anjia.service;

import com.meng.anjia.dao.PredictionDao;
import com.meng.anjia.dao.ProbabilityDao;
import com.meng.anjia.model.Prediction;
import com.meng.anjia.model.Probability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/25 11:21
 */
@Service
public class PredictService {


    @Autowired
    PredictionDao predictionDao;

    @Autowired
    ProbabilityDao probabilityDao;
    /**
     * 根据城市名称查询预测房价
     * @param city
     * @return
     */
    public Prediction getPredictionByName(String city)
    {
        return predictionDao.getPredictionByName(city);
    }

    public List<String> getCityList()
    {
        return predictionDao.getCityList();
    }

    /**
     * 根据城市名称查询预测信息
     * @param city
     * @return
     */
    public Probability getProbabilityByCity(String city)
    {
        return probabilityDao.getProbabilityByCity(city);
    }

}
