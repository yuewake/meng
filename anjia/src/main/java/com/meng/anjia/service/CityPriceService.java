package com.meng.anjia.service;

import com.meng.anjia.dao.CityPriceDao;
import com.meng.anjia.model.CityPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/13 14:25
 */
@Service
public class CityPriceService {


    @Autowired
    CityPriceDao cityPrice;
    /**
     * 查询指定区域月份排序的历史房价
     */
    public List<CityPrice> getAllCityPrice(String name)
    {
        return cityPrice.getAllCityPrice(name);
    }

    /**
     * 查询某区域的最新房价
     */
    public CityPrice getFirstCityPrice(String name)
    {
        return cityPrice.getFirstCityPrice(name);
    }

}
