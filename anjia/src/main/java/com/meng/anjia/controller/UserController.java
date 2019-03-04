package com.meng.anjia.controller;

import com.meng.anjia.model.HostHolder;
import com.meng.anjia.model.User;
import com.meng.anjia.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	HostHolder hostHolder;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 登陆
	 *
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user, Model model, HttpServletResponse response) {
		try {
			Map<String,Object> map = userService.login(user);
			if(map.containsKey("ticket")){
				Cookie c = new Cookie("ticket", map.get("ticket").toString());
				c.setPath("/");
				c.setMaxAge(3600*24*5);//过期时间设置为5天；
				response.addCookie(c);
				//TODO 如果next不为空， 就跳到next的页面。
				return "redirect:/";
			}else {
				model.addAttribute("msg", map.get("msg"));
				return "loginwin";//返回到登陆页面
			}
		}catch(Exception e){
			logger.error("登陆异常:" + e.getMessage());
			return "loginwin";
		}

	}

	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(@CookieValue("ticket") String ticket){
		userService.logout(ticket);
		return "redirect:/";
	}

	/**
	 * 注册
	 *
	 * @return
	 */
	@RequestMapping("/regist")
	public String regist(User user, Model model) {
		//TODO 修改成邮箱注册
		try {
			Map<String, Object> map = userService.regist(user);
			if(map.isEmpty()){
				return "redirect:/";
			}else{
				model.addAttribute("msg",map.get("msg"));
				return "loginwin";
			}
		}catch (Exception e){
			logger.error("注册异常" + e.getMessage());
			model.addAttribute("msg", "服务器错误");
			return "loginwin";
		}
	}

	/**
	 * 跳转到登陆界面
	 * @return
	 */
	@RequestMapping("/loginwin")
	public String getLoginwinPath()
	{
		return "loginwin";
	}

}
