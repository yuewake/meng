package com.meng.anjia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomePageController {
	
	@RequestMapping("/")
	public String getHomePagePath()
	{
		return"HomePage";
	}

	@GetMapping(value = "/map")
	public String map(){
		return "map";
	}

	@RequestMapping(value = "/location/{cityName}", method = RequestMethod.GET)
	public String location(Model model, HttpServletRequest request, @PathVariable("cityName")String cityName)
	{
		System.out.println(cityName);
		request.getSession().setAttribute("CityName",cityName);
		return "redirect:/";
	}
}
