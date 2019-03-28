package com.meng.anjia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomePageController {

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
}
