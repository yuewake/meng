package com.meng.anjia.controller;

import com.alibaba.fastjson.*;
import com.meng.anjia.model.City;
import com.meng.anjia.model.CityPrice;
import com.meng.anjia.service.CityPriceService;
import com.meng.anjia.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

/**
 *  create by shine10076
 */
@Controller
public class Statics_cityController {

    @Autowired
    CityService cityService;

    @Autowired
    CityPriceService cityPriceService;

    private static final Logger logger = LoggerFactory.getLogger(Statics_cityController.class);

    @RequestMapping("/city")
    public String getCityPath()
    {
        return "statics_city.html";
    }

    /**
     * 返回某市的区域json数据
     */
    @RequestMapping(value="/city/{cityname}", method = RequestMethod.GET)
    @ResponseBody
    public String  uid(@PathVariable("cityname") String cityname)
    {
        int uid  = cityService.getCityIDbyName(cityname);
        List<City> list = cityService.CityList(uid);
        JSONObject citylist = new JSONObject();
        JSONArray  arealist = new JSONArray();
        for(int i=0;i<list.size();i++)
        {
            JSONObject area = new JSONObject();
            area.put("name", list.get(i).getName());
            area.put("ID", list.get(i).getId());
            arealist.add(area);
        }
        citylist.put("CityName",cityname);
        citylist.put("area",arealist);
        System.out.println(citylist.toJSONString());
        return citylist.toJSONString();
    }


    /**
     * 返回某区域的历史房价json数据
     */
    @RequestMapping(value = "/city/price/{name}" , method = RequestMethod.GET)
    @ResponseBody
    public String CityPrice(@PathVariable("name")String name)
    {
        List<CityPrice> list = cityPriceService.getAllCityPrice(name);
        JSONObject cityPricelist = new JSONObject();
        JSONArray  pricelist = new JSONArray();
        for(int i = 0; i<list.size();i++)
        {
            JSONObject price = new JSONObject();
            price.put("price",list.get(i).getPrice());
            String year = Integer.toString(list.get(i).getYear());
            String month = Integer.toString(list.get(i).getMonth());
            price.put("Time",year + '/' + month);
            pricelist.add(price);
        }
        cityPricelist.put("CityName", name);
        cityPricelist.put("priceList", pricelist);

        return cityPricelist.toJSONString();
    }


    /**
     * 返回某区域的历史房价json数据
     */
    @RequestMapping(value = "/city/priceByID/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public String CityPrice(@PathVariable("id")int id)
    {
        List<CityPrice> list = cityPriceService.getAllCityPriceByID(id);
        JSONObject cityPricelist = new JSONObject();
        JSONArray  pricelist = new JSONArray();
        for(int i = 0; i<list.size();i++)
        {
            JSONObject price = new JSONObject();
            price.put("price",list.get(i).getPrice());
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
     * 返回当前城市的最新房价
     */
    @RequestMapping(value = "/city/firstPrice/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String FirstCityPrice(@PathVariable("name")String name)
    {
        CityPrice firstPrice = cityPriceService.getFirstCityPrice(name);
        JSONObject price = new JSONObject();
        price.put("CityName", name);
        String strpirce = Integer.toString(firstPrice.getPrice());
        price.put("price", strpirce);
        return price.toJSONString();
    }


    /**
     * 返回当前城市子区域的最新房价
     */
    @RequestMapping(value = "/city/FirstPriceList/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String FirstPriceList(@PathVariable("name") String name)
    {
        int uid  = cityService.getCityIDbyName(name);
        List<City> list = cityService.CityList(uid);
        List<CityPrice> priceList = new ArrayList<CityPrice>();
        for(int i=0;i<list.size();i++)
        {
            priceList.add(cityPriceService.getFirstCityPrice(list.get(i).getName()));
        }
        JSONArray priceArray = new JSONArray();
        System.out.println(priceList.size());
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
