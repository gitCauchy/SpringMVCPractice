package com.cauchy.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cauchy.ssm.po.ItemCustom;
import com.cauchy.ssm.po.ItemQueryVo;
import com.cauchy.ssm.service.ItemService;

@Controller
@RequestMapping("item")
public class ItemController {
	// 商品查询：
	@Autowired
	private ItemService itemService;
	@RequestMapping("/queryItem.action")
	public ModelAndView queryItem(HttpServletRequest request,ItemQueryVo itemQueryVo) throws Exception{
		
		List<ItemCustom> itemList = itemService.findItemList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList",itemList);
		// 指定视图：
		modelAndView.setViewName("item/itemlist");
		return modelAndView;
	}
	//商品信息修改页面显示：
	@RequestMapping("/editItem.action")
	public ModelAndView editItem()throws Exception{
		// 调用service来查询商品信息：
		ItemCustom itemCustom = itemService.findItemById(1);
		ModelAndView modelAndView = new ModelAndView();
		// 将商品信息放到model中
		modelAndView.addObject("itemCustom",itemCustom);
		// 配置商品修改页面
		modelAndView.setViewName("item/edititem");
		return modelAndView;
	}
	// 商品修改提交：
	@RequestMapping("/editItemSubmit.action")
	public ModelAndView editItemSubmit()throws Exception{
		// 调用service更新商品信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
}
