package com.cauchy.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cauchy.ssm.mapper.ItemCustomMapper;
import com.cauchy.ssm.mapper.ItemMapper;
import com.cauchy.ssm.po.Item;
import com.cauchy.ssm.po.ItemCustom;
import com.cauchy.ssm.po.ItemQueryVo;
import com.cauchy.ssm.service.ItemService;

public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemCustomMapper itemCustomMapper;
	@Autowired
	private ItemMapper itemMapper;
	@Override
	public List<ItemCustom> findItemList(ItemQueryVo itemQueryVo) throws Exception {
		return itemCustomMapper.findItemList(itemQueryVo);
	}
	@Override
	public ItemCustom findItemById(int id) throws Exception {
		 Item item = itemMapper.selectByPrimaryKey(id);
		 ItemCustom itemCustom = new ItemCustom();
		 BeanUtils.copyProperties(item, itemCustom);
		 return itemCustom;
	}
	@Override
	public void updateItem(int id, ItemCustom itemCustom) throws Exception {
		// 添加业务校验，对关键参数进行校验
		// 校验id，如果为空就抛出异常
		// 更新商品信息，可以更新表中的很多字段，包括大文本类型字段，要求必须传入id
		itemCustom.setId(id);
		itemMapper.updateByPrimaryKeyWithBLOBs(itemCustom);
	}
	
}
