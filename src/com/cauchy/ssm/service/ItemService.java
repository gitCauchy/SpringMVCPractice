package com.cauchy.ssm.service;

import java.util.List;

import com.cauchy.ssm.po.ItemCustom;
import com.cauchy.ssm.po.ItemQueryVo;

public interface ItemService {
	// 商品查询列表
	public List<ItemCustom> findItemList(ItemQueryVo itemQueryVo) throws Exception;
}
