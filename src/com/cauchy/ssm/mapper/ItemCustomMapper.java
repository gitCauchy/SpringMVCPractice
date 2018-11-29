package com.cauchy.ssm.mapper;

import java.util.List;

import com.cauchy.ssm.po.ItemCustom;
import com.cauchy.ssm.po.ItemQueryVo;

public interface ItemCustomMapper {
	// 商品查询列表：
	public List<ItemCustom> findItemList(ItemQueryVo itemQueryVo)throws Exception;
}
