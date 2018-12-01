package com.cauchy.ssm.service;

import java.util.List;

import com.cauchy.ssm.po.ItemCustom;
import com.cauchy.ssm.po.ItemQueryVo;

public interface ItemService {
	// 商品查询列表：
	public List<ItemCustom> findItemList(ItemQueryVo itemQueryVo) throws Exception;
	// 根据ID来查询商品：
	public ItemCustom findItemById(int id) throws Exception;
	// 修改商品信息：
	public void updateItem(Integer id,ItemCustom itemCustom)throws Exception;
}
