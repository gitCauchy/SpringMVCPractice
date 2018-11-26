package com.cauchy.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.mvc.Controller;

import com.cauchy.ssm.po.Item;

public class ItemController2 implements HttpRequestHandler{
	
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
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
		// 设置模型数据
		request.setAttribute("itemList", itemList);
		// 设置转发视图：
		request.getRequestDispatcher("/WEB-INF/jsp/item/itemlist.jsp").forward(request, response);
	}
}
