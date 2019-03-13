package com.meng.anjia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {
	
	@RequestMapping("/calculator")
	public String showCalculatorPath()
	{
		return "calculator";
	}
}
