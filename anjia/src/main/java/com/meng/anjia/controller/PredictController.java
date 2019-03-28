package com.meng.anjia.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.model.Prediction;
import com.meng.anjia.model.Probability;
import com.meng.anjia.model.Rank;
import com.meng.anjia.service.PredictService;
import com.meng.anjia.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/3/24 16:38
 */
@Controller
public class PredictController {
    public static final String PREDICT= "Predict";

    @Autowired
    RankService rankService;

    @Autowired
    PredictService predictService;


    @RequestMapping("/predict")
    public String getPredictPath()
    {
        return PREDICT;
    }

    /**
     * 得到全部的Rank信息
     * @return
     */
    @RequestMapping(value = "/predict/getAllRank")
    @ResponseBody
    public String getAllRank()
    {
        List<Rank> list = rankService.getAllRank();
        JSONObject result = new JSONObject();
        JSONArray cityList = new JSONArray();
        JSONArray cityLocation = new JSONArray();
        for(Rank rank : list)
        {
            JSONObject item = new JSONObject();
            item.put("name",rank.getCity());
            item.put("value",rank.getIncreasement());
            cityList.add(item);
            JSONObject location = new JSONObject();
            double[] lngAlat = new double[3];
            lngAlat[0] =  rank.getLng();
            lngAlat[1] = rank.getLat();
            lngAlat[2] = rank.getIncreasement();
            location.put("name",rank.getCity());
            location.put("value",lngAlat);
            cityLocation.add(location);
        }
        result.put("CityList",cityList);
        result.put("Location", cityLocation);
        return result.toJSONString();
    }


    @GetMapping(value = "/predict/getPredictionByName/{City}")
    @ResponseBody
    public String getPredictionByName(@PathVariable("City")String  city)
    {
        Prediction prediction = predictService.getPredictionByName(city);
        JSONObject result = new JSONObject();
        result.put("September",prediction.getSeptember());
        result.put("August",prediction.getAugust());
        result.put("July",prediction.getJuly());
        result.put("June",prediction.getJune());
        result.put("May",prediction.getMay());
        result.put("April",prediction.getApril());
        return result.toJSONString();
    }

    @GetMapping(value = "/predict/getCityList")
    @ResponseBody
    public String getCityList()
    {
        List<String> cityList = predictService.getCityList();
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        for(String city:cityList)
        {
            JSONObject item = new JSONObject();
            item.put("CityName", city);
            array.add(item);
        }
        result.put("cityList",array);
        return result.toJSONString();
    }

    @GetMapping(value = "/predict/getProbabilityByCity/{city}")
    @ResponseBody
    public String getProbabilityByCity(@PathVariable("city") String city)
    {
        Probability ratio = predictService.getProbabilityByCity(city);
        Rank info = rankService.getRankByCity(city);
        JSONObject result = new JSONObject();
        result.put("Name",ratio.getName());
        result.put("attractionRatio",ratio.getAttraction());
        result.put("gdpRatio",ratio.getGdp());
        result.put("ratioRatio",ratio.getRatio());
        result.put("suggestion",ratio.getSuggestion());
        result.put("population",info.getPopulation());
        result.put("avgGdp",info.getAvgGdp());
        result.put("ratio",info.getRatio());
        result.put("March",info.getMarch());
        result.put("increasement",info.getIncreasement());
        return result.toJSONString();
    }
}
