package com.cauchy.ssm.po;

import java.util.List;

public class ItemQueryVo {
	// 商品信息包装进来
	private Item item;
	// 为了系统的可扩展性，一般对原始的po进行扩展
	private ItemCustom itemCustom;
	// 产品批量信息
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
