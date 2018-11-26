package com.cauchy.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cauchy.ssm.po.Item;

// 使用Controller注解来标识它是一个控制器
@Controller
public class ItemController3 {
	// 商品列表查询，建议将方法名和URL一致，一个方法对应一个URL
	@RequestMapping("/queryItem3.action")
	public ModelAndView queryItem3() throws Exception{
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
		itemList.add(item1);
		itemList.add(item2);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList",itemList);
		// 指定视图：
		modelAndView.setViewName("/WEB-INF/jsp/item/itemlist.jsp");
		return modelAndView;
	}
}
