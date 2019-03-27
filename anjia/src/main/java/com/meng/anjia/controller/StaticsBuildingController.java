package com.meng.anjia.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.model.Building;
import com.meng.anjia.model.CityPrice;
import com.meng.anjia.model.Question;
import com.meng.anjia.service.BuildingService;
import com.meng.anjia.service.CityPriceService;
import com.meng.anjia.service.CityService;
import com.meng.anjia.util.SolrAdapter;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shine10076
 * @date 2019/3/18 14:34
 */
@Controller
public class StaticsBuildingController {
    private static final Logger logger = LoggerFactory.getLogger(StaticsBuildingController.class);
    private static final int size = 10;

    @Autowired
    CityService cityService;

    @Autowired
    CityPriceService cityPriceService;

    @Autowired
    BuildingService buildingService;

    @Autowired
    SolrAdapter solrAdapter;
    /**
     *
     * @return 跳转到显示小区页面
     */

    public static final String BUILDING = "statics_building";
    @RequestMapping("/building")
    public String getBuildingPath()
    {
        return BUILDING;
    }

    /**
     * 返回某城市最近半年房价的json数据
     */
    @GetMapping(value = "/building/cityPrice/{name}")
    @ResponseBody
    public String cityPrice(@PathVariable("name")String name)
    {
        List<CityPrice> list = cityPriceService.getCityPriceHalfYear(name);
        JSONObject result = new JSONObject();
        JSONArray priceList = new JSONArray();
        for(int i = 0; i< list.size(); i++)
        {
            JSONObject item = new JSONObject();
            item.put("price", list.get(i).getPrice());
            String year = Integer.toString(list.get(i).getYear());
            String month = Integer.toString(list.get(i).getMonth());
            item.put("time", year+'/'+month);
            priceList.add(item);
        }
        result.put("CityName", name);
        result.put("priceList", priceList);
        return result.toJSONString();
    }

    /**
     * 返回Paginator参数
     * 分页数据测试
     */
    @GetMapping(value = "/building/PageParam/{cityName}")
    @ResponseBody
    public String pageParam(@PathVariable("cityName") String cityName)
    {
        int pageNumber = buildingService.getPageNumber(cityName);
        int page = pageNumber/10;
        JSONObject result = new JSONObject();
        result.put("curPage", 1);
        result.put("numberOfPage",8);
        result.put("totalPages",page);
        return result.toJSONString();
    }

    /**
     * 按页数返回小区信息
     */
    @GetMapping(value = "/building/Page/{page}&{cityname}")
    @ResponseBody
    public String pageData(@PathVariable("page")int page, @PathVariable("cityname")String cityname)
    {
        int number = (page-1)*10;
        List<Building> list = buildingService.getBuildingByNumber(number,cityname);
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size();++i)
        {
            JSONObject item  = new JSONObject();
            item.put("Name", list.get(i).getName());
            item.put("ID", list.get(i).getId());
            item.put("type",list.get(i).getType());
            item.put("location", list.get(i).getLocation());
            item.put("status", list.get(i).getStatus());
            item.put("area", list.get(i).getArea());
            item.put("subarea",list.get(i).getSubarea());
            item.put("Unit",list.get(i).getUnit());
            item.put("avgPrice",list.get(i).getAvgPrice());
            item.put("rooms", list.get(i).getRooms());
            item.put("minArea",list.get(i).getMinArea());
            item.put("tags",list.get(i).getTags());
            item.put("maxArea", list.get(i).getMaxArea());
            item.put("imgUrl",list.get(i).getUrl());
            array.add(item);
        }
            result.put("Page", page);
            result.put("BuildingList", array);
        return result.toJSONString();
    }

    /**
     * 按条件查询
     * @param area
     * @param minPrice
     * @param maxPrice
     * @return
     */
    @GetMapping(value = "/buildingFind/{area}&{minPrice}&{maxPrice}&{type}&{status}&{page}")
    @ResponseBody
    public String findBuildingByCondition(@PathVariable("area")String area, @PathVariable("minPrice")int minPrice, @PathVariable("maxPrice")int maxPrice,@PathVariable("type")String type,@PathVariable("status")String status,@PathVariable("page")int page)
    {
        Map<String, Object> map = new HashMap<>();
        if(!"".equals(area))
        {map.put("area", area);}
        if(minPrice != 0)
        {map.put("minPrice",minPrice);}
        if(maxPrice!=0)
        {map.put("maxPrice",maxPrice);}
        if(!"".equals(type))
        {map.put("type",type);}
        if(!"".equals(status))
        {map.put("status",status);}
        int number = (page-1)*10;
        map.put("number",number);

        //得到小区总数量
        int count  = buildingService.findBuildingByConditionCount(map);
        int totalPage = count%10 ==0 ? count/10 : count/10 + 1;
        List<Building> list = buildingService.findBuildingByCondition(map);
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size();++i)
        {
            JSONObject item  = new JSONObject();
            item.put("Name", list.get(i).getName());
            item.put("ID", list.get(i).getId());
            item.put("type",list.get(i).getType());
            item.put("location", list.get(i).getLocation());
            item.put("Status", list.get(i).getStatus());
            item.put("Unit",list.get(i).getUnit());
            item.put("area", list.get(i).getArea());
            item.put("subarea",list.get(i).getSubarea());
            item.put("avgPrice",list.get(i).getAvgPrice());
            item.put("rooms", list.get(i).getRooms());
            item.put("minArea",list.get(i).getMinArea());
            item.put("tags",list.get(i).getTags());
            item.put("maxArea", list.get(i).getMaxArea());
            item.put("imgUrl",list.get(i).getUrl());
            array.add(item);
        }
        result.put("BuildingList", array);
        result.put("totalPage", totalPage);
        result.put("curPage", 1);
        result.put("numberOfPage",4);
         return result.toJSONString();
    }

    @RequestMapping("selectBuild")
    @ResponseBody
    public String selectBuild(@RequestParam("name") String q, @RequestParam("page") Integer offset){
        offset--;
        JSONObject json = new JSONObject();
        try {
            QueryResponse queryResponse = solrAdapter.search("build",q,"name",offset * size, size);
            long total = queryResponse.getResults().getNumFound();
            List<Building> buildings = queryResponse.getBeans(Building.class);
            if(total % size == 0)
                total = total / size;
            else
                total = (total / size) + 1;
            json.put("curPage",offset);
            json.put("totalPage",total);
            json.put("BuildingList",buildings);
        }catch (Exception e){
            logger.error("发生错误：" + e.getMessage());
        }
        return json.toJSONString();
    }

}
