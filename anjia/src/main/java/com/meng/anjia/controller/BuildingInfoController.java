package com.meng.anjia.controller;

import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.model.Building;
import com.meng.anjia.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shine10076
 * @date 2019/3/20 21:24
 */
@Controller
public class BuildingInfoController {

    @Autowired
    BuildingService buildingService;

    @RequestMapping("/buildingInfo/{id}")
    public String getBuildingInfoPath(@PathVariable("id")int id, Model model)
    {
        model.addAttribute("id",id);
        return "buildingInfo";
    }

    /**
     * 返回一个楼盘信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/buildingInformation/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getBuildingInfo(@PathVariable("id")int id)
    {
        Building building = buildingService.getBuildingInfo(id);
        JSONObject result = new JSONObject();
        result.put("Name", building.getName());
        result.put("Type", building.getType());
        result.put("Status",building.getStatus());
        result.put("Area", building.getArea());
        result.put("Unit",building.getUnit());
        result.put("SubArea", building.getSubarea());
        result.put("Location", building.getLocation());
        result.put("Rooms", building.getRooms());
        result.put("ImgUrl", building.getImg_url());
        result.put("MinArea",building.getMin_area());
        result.put("MaxArea",building.getMax_area());
        result.put("Tags", building.getTags());
        result.put("AvgPrice",building.getAvg_price());
        return result.toJSONString();
    }
}
