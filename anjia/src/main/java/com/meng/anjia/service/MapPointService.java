package com.meng.anjia.service;

import com.meng.anjia.dao.MapPointDao;
import com.meng.anjia.model.MapPoint;
import com.meng.anjia.pojo.AvgPrice;
import com.meng.anjia.pojo.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/28 16:21
 */
@Service
public class MapPointService {
    @Autowired
    MapPointDao mapPointDao;

    public List<Place> getIDByName(String name){return mapPointDao.getIDByName(name);}

    public List<Place> getIDByUid(int id){ return mapPointDao.getIDByUid(id);}

    public List<AvgPrice> getAvgPriceByPid(int pid ){
        return mapPointDao.getAvgPriceByPid(pid);
    }

    public List<MapPoint> findAllPriceByName(String name )
    {
        return mapPointDao.findAllPriceByName(name);
    }
}
