package com.meng.anjia.controller;

import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.model.MapPoint;
import com.meng.anjia.pojo.AvgPrice;
import com.meng.anjia.pojo.Place;
import com.meng.anjia.service.MapPointService;
import com.meng.anjia.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaceController {
    @Autowired
    PlaceService placeService;

    @Autowired
    MapPointService mapPointService;

    @GetMapping("/places")
    public List<Place> list(){
        return placeService.list();
    }

    @GetMapping("/findAllMap/{name}")
    @ResponseBody
    public String findAllMap(@PathVariable("name")String name)
    {
        /*得到城市（苏州）的实体类*/
        List<Place>  id = mapPointService.getIDByName(name);
        /*得到苏州的所有子区域的实体类*/
        List<Place> areaIdList = mapPointService.getIDByUid(id.get(0).getId());
        /*苏州及其子区域的实体类*/
        areaIdList.addAll(id);
        List<Place> allAreaList = new ArrayList<>();
        for(Place place:areaIdList)
            allAreaList.addAll(mapPointService.getIDByUid(place.getId()));
        List<AvgPrice> allPrice = new ArrayList<>();
        for(Place place:allAreaList)
            allPrice.addAll(mapPointService.getAvgPriceByPid(place.getId()));

        JSONObject result = new JSONObject();
        result.put("AllPrice",allPrice);
        return result.toJSONString();
    }
}
