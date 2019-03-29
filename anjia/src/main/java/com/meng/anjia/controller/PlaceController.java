package com.meng.anjia.controller;

import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.model.Building;
import com.meng.anjia.pojo.AvgPrice;
import com.meng.anjia.pojo.Place;
import com.meng.anjia.service.BuildingService;
import com.meng.anjia.service.MapPointService;
import com.meng.anjia.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceController {
    @Autowired
    PlaceService placeService;

    @Autowired
    MapPointService mapPointService;

    @Autowired
    BuildingService buildingService;

    @GetMapping("/places")
    public List<Place> list(){
        return placeService.list();
    }

    @GetMapping("/findAllMap/{name}")
    @ResponseBody
    public String findAllMap(@PathVariable("name")String name)
    {
        List<AvgPrice> allPrice = mapPointService.findAllPriceByName(name);
        JSONObject result = new JSONObject();
        result.put("AllPrice",allPrice);
        List<Building> buildingList = buildingService.getAllBuildingByCity(name);
        result.put("AllBuilding",buildingList);
        return result.toJSONString();
    }
}
