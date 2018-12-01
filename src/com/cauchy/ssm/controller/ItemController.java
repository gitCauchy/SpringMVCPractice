package com.cauchy.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cauchy.ssm.po.ItemCustom;
import com.cauchy.ssm.po.ItemQueryVo;
import com.cauchy.ssm.service.ItemService;
@Controller
@RequestMapping("/item")
public class ItemController {
	// 商品查询：
	@Autowired
	private ItemService itemService;
	@RequestMapping("/queryItem.action")
	public ModelAndView queryItem(HttpServletRequest request,ItemQueryVo itemQueryVo)throws Exception{
		List<ItemCustom> itemList = itemService.findItemList(itemQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList",itemList);
		modelAndView.setViewName("item/itemlist");
		return modelAndView;
	}
	// 商品信息修改页面：
	// 可以指定请求的方法
	@RequestMapping(value="/editItem.action",method = {RequestMethod.GET})
	// @RequestParam里指定参数名和形参进行绑定，required属性执行形参是否必须传入
	public String editItem(Model model,@RequestParam(value = "id",required = true) Integer id) throws Exception{
		// 调用service来查询商品信息：
		ItemCustom itemCustom = itemService.findItemById(id);
		// 将商品信息放到model中：
		model.addAttribute("itemCustom",itemCustom);
		return "item/edititem";
	}
	// 商品修改提交
	@RequestMapping("/editItemSubmit.action")
	public ModelAndView editItemSubmit()throws Exception{
		// 调用service更新商品信息：
		
		// 返回ModelAndView:
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
//	// 商品修改提交，返回视图名方法：
//		@RequestMapping("/editItemSubmit.action")
//		public String editItemSubmit()throws Exception{
//			// 调用service更新商品信息：
//			// 返回视图名
//			return "success";
//		}
//	// 商品修改提交后重定向到查询页面：
//	@RequestMapping("/editItemSubmit.action")
//	public String editItemSubmit()throws Exception{
//		// 重定向到商品查询页面：
//		return "redirect:queryItem.action";
//	}
//	 // 页面转发：
//	@RequestMapping("/editItemSubmit.action")
//	public String editItemSubmit()throws Exception{
//		// 重定向到商品查询页面：
//		return "froward:queryItem.action";
//	}
	// 删除：
	@RequestMapping("deleteItem.action")
	public String deleteItem(Integer[] itemId) throws Exception{
		// 调用service 删除商品：
		return "success";
	}
	// 批量修改商品页面：
	@RequestMapping("editItemQuery")
	public ModelAndView editItemQuery(HttpServletRequest request,ItemQueryVo itemQueryVo)throws Exception{
		List<ItemCustom> itemList = itemService.findItemList(itemQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList",itemList);
		modelAndView.setViewName("item/edititemquery");
		return modelAndView;
	}
	// 批量修改提交：
	@RequestMapping("editItemAllSubmit.action")
	public String editItemAllSubmit(ItemQueryVo itemQueryVo) throws Exception{
		// .....
		return "success";
	}
	
}
