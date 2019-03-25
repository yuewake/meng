package com.meng.anjia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {

	public static final  String  CALCULATOR = "calculator";
	@RequestMapping("/calculator")
	public String showCalculatorPath()
	{
		return CALCULATOR;
	}
}
