package com.meng.anjia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
