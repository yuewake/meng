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

    public List<CityPrice> getAllCityPriceByID(int id)
    {
        return cityPrice.getAllCityPriceByID(id);
    }
    /**
     * 查询某区域的最新房价
     */
    public CityPrice getFirstCityPrice(String name)
    {
        return cityPrice.getFirstCityPrice(name);
    }

    public CityPrice getFirstCityPriceByID(int id)
    {
        return cityPrice.getFirstCityPriceByID(id);
    }

    /**
     * 查询某城市最近半年的房价
     */
    public List<CityPrice> getCityPriceHalfYear(String name)
    {
        return cityPrice.getCityPriceHalfYear(name);
    }

    /**
     * 分页测试
     */
    public List<CityPrice> getCityPricePage(String name, int number)
    {
        return cityPrice.getAllCityPricePage(name, number);
    }

}
