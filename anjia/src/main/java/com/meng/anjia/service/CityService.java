package com.meng.anjia.service;

import com.meng.anjia.model.City;
import com.meng.anjia.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService {

    @Autowired
    CityDao cityDao;

    public List<City> CityList(int uid)
    {
        return cityDao.getAllCity(uid);
    }

    public int getCityIDbyName (String name)
    {
        return cityDao.getCity(name);
    }
}
