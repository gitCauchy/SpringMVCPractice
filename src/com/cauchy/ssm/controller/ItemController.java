package com.cauchy.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cauchy.ssm.controller.validation.ValidGroup1;
import com.cauchy.ssm.exception.CustomException;
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
		// 判断商品是否为空：
		if(itemCustom == null) {
			throw new CustomException("修改的商品信息不存在");
 		}
		// 将商品信息放到model中：
		model.addAttribute("itemCustom",itemCustom);
		return "item/edititem";
	}
//	// 商品修改提交-ModelAndView
//	@RequestMapping("/editItemSubmit.action")
//	public ModelAndView editItemSubmit()throws Exception{
//		// 调用service更新商品信息：
//		
//		// 返回ModelAndView:
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("success");
//		return modelAndView;
//	}
	// 商品修改提交，返回视图名方法：
	@RequestMapping("/editItemSubmit.action")
	public String editItemSubmit(Model model,HttpServletRequest request,Integer id, 
			@Validated(value = {ValidGroup1.class}) ItemCustom itemCustom, BindingResult bindingResult)throws Exception{
		// 获取校验错误信息：
		if(bindingResult.hasErrors()) {
			// 输出错误信息：
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			// 错误信息输出到页面：
			model.addAttribute("allErrors",allErrors);
			return "item/edititem";
		}
		// 调用service更新商品信息：
		itemService.updateItem(id, itemCustom);
		// 进行重定向
		return "item/edititem";
	}
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
	@RequestMapping("/requestJson")
	public @ResponseBody ItemCustom requestJson(@RequestBody ItemCustom itemCustom){
		return itemCustom;
	}
	@RequestMapping("/responseJson")
	public @ResponseBody ItemCustom responseJson(ItemCustom itemCustom){
		return itemCustom;
	}
	// RESTful查询商品信息，输出Json
	@RequestMapping("/itemView/{id}")
	public @ResponseBody ItemCustom itemView(@PathVariable("id") Integer id) throws Exception{
		// 调用service来查询商品信息
		ItemCustom itemCustom = itemService.findItemById(id);
		return itemCustom;
	}
	
}
