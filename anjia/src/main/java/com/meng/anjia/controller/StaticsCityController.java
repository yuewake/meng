package com.meng.anjia.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.model.City;
import com.meng.anjia.model.CityPrice;
import com.meng.anjia.service.CityPriceService;
import com.meng.anjia.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * @author shine10076
 * @date 2019/3/19 15:19
 */
@Controller
public class StaticsCityController {

    @Autowired
    CityService cityService;

    @Autowired
    CityPriceService cityPriceService;

    public static final String CITY = "statics_city";
    @RequestMapping("/city")
    public String getCityPath()
    {
        return CITY;
    }

    public void putCityName(JSONObject json,String cityName)
    {
        json.put("CityName",cityName);
    }

    public void putPrice(JSONObject json, int price)
    {
        json.put("price",price);
    }

    public void putStrPrice(JSONObject json, String price)
    {
        json.put("strPrice",price);
    }
    /**
     * 返回某市的区域json数据
     */
    @GetMapping(value="/city/{cityName}")
    @ResponseBody
    public String  uid(@PathVariable("cityName") String cityName)
    {
        int uid  = cityService.getCityIDbyName(cityName);
        List<City> list = cityService.cityList(uid);
        JSONObject cityList = new JSONObject();
        JSONArray  areaList = new JSONArray();
        for(int i=0;i<list.size();i++)
        {
            JSONObject area = new JSONObject();
            area.put("name", list.get(i).getName());
            area.put("ID", list.get(i).getId());
            areaList.add(area);
        }
        putCityName(cityList,cityName);
        cityList.put("area",areaList);
        return cityList.toJSONString();
    }


    /**
     * 返回某区域的历史房价json数据
     */
    @GetMapping(value = "/city/price/{name}" )
    @ResponseBody
    public String cityPrice(@PathVariable("name")String name)
    {
        List<CityPrice> list = cityPriceService.getAllCityPrice(name);
        JSONObject cityPriceList = new JSONObject();
        JSONArray  priceList = new JSONArray();
        for(int i = 0; i<list.size();i++)
        {
            JSONObject priceArea = new JSONObject();
            putPrice(priceArea,list.get(i).getPrice());
            String year = Integer.toString(list.get(i).getYear());
            String month = Integer.toString(list.get(i).getMonth());
            priceArea.put("Time",year + '/' + month);
            priceList.add(priceArea);
        }
        putCityName(cityPriceList,name);
        cityPriceList.put("priceList", priceList);

        return cityPriceList.toJSONString();
    }


    /**
     * 返回某区域的历史房价json数据
     */
    @GetMapping(value = "/city/priceByID/{id}")
    @ResponseBody
    public String cityPrice(@PathVariable("id")int id)
    {
        List<CityPrice> list = cityPriceService.getAllCityPriceByID(id);
        JSONObject cityPricelist = new JSONObject();
        JSONArray  pricelist = new JSONArray();
        for(int i = 0; i<list.size();i++)
        {
            JSONObject price = new JSONObject();
            putPrice(price,list.get(i).getPrice());
            String year = Integer.toString(list.get(i).getYear());
            String month = Integer.toString(list.get(i).getMonth());
            price.put("Time",year + '/' + month);
            pricelist.add(price);
        }
        cityPricelist.put("CityID", id);
        cityPricelist.put("priceList", pricelist);

        return cityPricelist.toJSONString();
    }



    /**
     * 返回当前城市的最新房价,还未用到
     */
    @GetMapping(value = "/city/firstPrice/{name}")
    @ResponseBody
    public String firstCityPrice(@PathVariable("name")String name)
    {
        JSONObject price = new JSONObject();
        putCityName(price,name);
        return price.toJSONString();
    }


    /**
     * 返回当前城市子区域的最新房价
     */
    @GetMapping(value = "/city/FirstPriceList/{name}")
    @ResponseBody
    public String firstPriceList(@PathVariable("name") String name)
    {
        int uid  = cityService.getCityIDbyName(name);
        List<City> list = cityService.cityList(uid);
        List<CityPrice> priceList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            priceList.add(cityPriceService.getFirstCityPrice(list.get(i).getName()));
        }
        JSONArray priceArray = new JSONArray();
        for(int i=0;i<priceList.size();i++)
        {
            JSONObject json = new JSONObject();
            json.put("name" ,  priceList.get(i).getName());
            String str = Integer.toString(priceList.get(i).getPrice());
            json.put("price", str);
            priceArray.add(json);
        }
        JSONObject result =new JSONObject();
        result.put("result", priceArray);
        return result.toJSONString();
    }
}
