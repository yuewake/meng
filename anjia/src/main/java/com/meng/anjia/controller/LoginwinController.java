package com.meng.anjia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginwinController {
	
	@RequestMapping("/loginwin")
	public String getLoginwinPath()
	{
		return "loginwin";
	}
}
