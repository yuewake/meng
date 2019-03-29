package com.meng.anjia.controller;

import com.alibaba.fastjson.JSONObject;
import com.meng.anjia.model.Building;
import com.meng.anjia.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * @author shine10076
 * @date 2019/3/19 15:19
 */
@Controller
public class HomePageController {

	@Autowired
	BuildingService buildingService;

	public static final  String  HOMEPAGE = "HomePage";
	public static final String MAP = "map";

	@RequestMapping("/")
	public String getHomePagePath()
	{
		return HOMEPAGE;
	}

	@GetMapping(value = "/map")
	public String getMapPath(){
		return MAP;
	}

	@GetMapping(value = "/location/{cityName}")
	public String location(Model model, HttpServletRequest request, @PathVariable("cityName")String cityName)
	{
		request.getSession().setAttribute("CityName",cityName);
		return "redirect:/";
	}

	@GetMapping(value = "/buildingContent/{content}")
	public String questionContent(Model model, @PathVariable("content")String content)
	{
		model.addAttribute("Content",content);
		return "result_building";
	}

	@GetMapping(value = "/buildingShow/{cityName}")
	@ResponseBody
	public String buildingShow(@PathVariable("cityName")String cityName)
	{
		List<Building> list = buildingService.getRandomBuilding(cityName);
		JSONObject result = new JSONObject();
		result.put("buildingList",list);
		return result.toJSONString();
	}
}
