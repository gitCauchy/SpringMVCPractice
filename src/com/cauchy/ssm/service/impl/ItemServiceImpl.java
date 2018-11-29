package com.cauchy.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cauchy.ssm.mapper.ItemCustomMapper;
import com.cauchy.ssm.mapper.ItemMapper;
import com.cauchy.ssm.po.ItemCustom;
import com.cauchy.ssm.po.ItemQueryVo;
import com.cauchy.ssm.service.ItemService;

public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemCustomMapper itemCustomMapper;
	@Override
	public List<ItemCustom> findItemList(ItemQueryVo itemQueryVo) throws Exception {
		return itemCustomMapper.findItemList(itemQueryVo);
	}
	
}
