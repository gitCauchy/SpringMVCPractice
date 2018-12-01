package com.cauchy.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginController {
	// 登录：
	@RequestMapping("/login.action")
	public String login(HttpSession session,String userName,String password)throws Exception{
		// 调用service：
		// ...
		session.setAttribute("userName", userName);
		// 重定向到商品列表查询界面
		return "redirect:item/queryItem.action";
	}
	// 退出
	@RequestMapping("/logout.action")
	public String logout(HttpSession session)throws Exception{
		// 清除session
		session.invalidate();
		return "redirect:item/queryItem.action";
	}
}
