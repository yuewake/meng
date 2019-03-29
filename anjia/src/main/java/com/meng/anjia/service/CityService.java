package com.meng.anjia.service;

import com.meng.anjia.model.City;
import com.meng.anjia.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author shine10076
 * @date 2019/3/19 15:19
 */
@Service
public class CityService {

    @Autowired
    CityDao cityDao;

    public List<City> cityList(int uid)
    {
        return cityDao.getAllCity(uid);
    }

    public int getCityIDbyName (String name)
    {
        return cityDao.getCity(name);
    }
}
