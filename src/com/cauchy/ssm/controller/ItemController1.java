package com.cauchy.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cauchy.ssm.po.Item;

public class ItemController1 implements Controller{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		// 调用service来查询数据库，查询商品列表，这里使用静态数据
		List<Item> itemList = new ArrayList<Item>();
		Item item1 = new Item();
		item1.setName("Cellphone");
		item1.setDetail("a beautiful cellphone");
		item1.setPrice(2000f);
		Item item2 = new Item();
		item2.setName("Computer");
		item2.setDetail("a handsome computer");
		item2.setPrice(5000f);
		itemList.add(item1);
		itemList.add(item2);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request中的setAttribute方法，在Jsp页面中可以调用来获取数据。
		modelAndView.addObject("itemList",itemList);
		// 指定视图：
		modelAndView.setViewName("/WEB-INF/jsp/item/itemlist.jsp");
		return modelAndView;
	}
}
