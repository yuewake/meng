package com.meng.anjia.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.dao.MapPointDao;
import com.meng.anjia.dao.PlaceDAO;
import com.meng.anjia.pojo.AvgPrice;
import com.meng.anjia.pojo.Place;
import com.meng.anjia.util.JedisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/28 16:21
 */
@Service
public class MapPointService {
    @Autowired
    MapPointDao mapPointDao;

    @Autowired
    JedisAdapter jedisAdapter;

    @Autowired
    PlaceDAO placeDAO;

    public List<Place> getIDByName(String name){
        return mapPointDao.getIDByName(name);
    }

    public List<Place> getIDByUid(int id){ return mapPointDao.getIDByUid(id);}

    public List<AvgPrice> getAvgPriceByPid(int pid ){
        return mapPointDao.getAvgPriceByPid(pid);
    }

    public String findAllPriceByName(String name )
    {
        String value = jedisAdapter.hget("city",name);
        if(value != null){
            return value;
        }else {
            /*得到城市（苏州）的实体类*/
            List<Place>  id = mapPointDao.getIDByName(name);
            /*得到苏州的所有子区域的实体类*/
            List<Place> areaIdList = mapPointDao.getIDByUid(id.get(0).getId());
            /*苏州及其子区域的实体类*/
            areaIdList.addAll(id);
            List<Place> allAreaList = new ArrayList<>();
            for(Place place:areaIdList) {
                allAreaList.addAll(mapPointDao.getIDByUid(place.getId()));
            }
            JSONArray array = new JSONArray();
            for(Place place:allAreaList)
            {
                JSONObject item = new JSONObject();
                item.put("price",mapPointDao.getAvgPriceByPid(place.getId()));
                item.put("place",place);
                array.add(item);
            }
            JSONObject allPrice = new JSONObject();
            allPrice.put("AllPrice",array);
            jedisAdapter.hset("city",name,allPrice.toJSONString());
            return allPrice.toJSONString();
        }

    }
}
