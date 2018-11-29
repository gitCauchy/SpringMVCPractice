package com.cauchy.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cauchy.ssm.po.ItemCustom;
import com.cauchy.ssm.service.ItemService;

@Controller
public class ItemController {
	// 商品查询：
	@Autowired
	private ItemService itemService;
	@RequestMapping("/queryItem.action")
	public ModelAndView queryItem() throws Exception{
		
		List<ItemCustom> itemList = itemService.findItemList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList",itemList);
		// 指定视图：
		modelAndView.setViewName("item/itemlist");
		return modelAndView;
	}
}
