package com.cauchy.ssm.po;

import java.util.List;

public class ItemQueryVo {
	// 将商品信息包装进来
	private Item item;
	// 为了系统的扩展性，对源po进行扩展
	private ItemCustom itemCustom;
	// 批量商品信息：
	private List<ItemCustom> itemList;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public ItemCustom getItemCustom() {
		return itemCustom;
	}
	public void setItemCustom(ItemCustom itemCustom) {
		this.itemCustom = itemCustom;
	}
	public List<ItemCustom> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemCustom> itemList) {
		this.itemList = itemList;
	}
	
	
}
