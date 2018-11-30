package com.cauchy.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cauchy.ssm.controller.validation.ValidGroup1;
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
	public ModelAndView editItem(Model model,@RequestParam(value = "id",required =true) Integer id)throws Exception{
		// 调用service来查询商品信息：
		ItemCustom itemCustom = itemService.findItemById(id);
		ModelAndView modelAndView = new ModelAndView();
		// 将商品信息放到model中
		modelAndView.addObject("itemCustom",itemCustom);
		// 配置商品修改页面
		modelAndView.setViewName("item/edititem");
		return modelAndView;
	}
	// 商品修改提交：
	@RequestMapping("/editItemSubmit.action")
	public String editItemSubmit(Model model,HttpServletRequest request,Integer id,
			@Validated(value= {ValidGroup1.class}) ItemCustom itemCustom,BindingResult bindResult)
					throws Exception{
		// 获取校验错误信息
		if(bindResult.hasErrors()) {
			// 输出错误信息：
			List<ObjectError> allErrors = bindResult.getAllErrors();
			for(ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			// 错误信息页面
			model.addAttribute("allErrors",allErrors);
			return "item/edititem";
		}
		// 调用service更新商品信息，页面需要将商品信息传到此方法：
		itemService.updateItem(id,itemCustom);
		// 进行重定向：
		return "item/edititem";
	}
	// 批量删除：
	@RequestMapping("/deleteItem.action")
	public ModelAndView deleteItem(Integer[] itemsId) throws Exception{
		// 调用service
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
	// 批量修改页面：
	@RequestMapping("/editItemQuery.action")
	public ModelAndView editItemQuery(HttpServletRequest request,ItemQueryVo itemQueryVo)throws Exception{
		List<ItemCustom> itemList = itemService.findItemList(itemQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList",itemList);
		modelAndView.setViewName("item/edititemquery");
		return modelAndView;
	}
	// 批量修改商品提交：
	@RequestMapping("/editItemAllSubmit.action")
	public String editItemAllSubmit(ItemQueryVo itemQueryVo) throws Exception{
		//.....
		return "success";
	}
	
}
