package com.sales.wb.service;

import javax.jws.WebService;

import com.sales.wb.common.Resp;
import com.sales.wb.vo.ItemMasterVO;

@WebService
public interface ItemMasterService {
	
	public Resp createItem(ItemMasterVO itemMasterVO);
	public ItemMasterVO getAllItemMaster();
	public Resp updateItem(ItemMasterVO itemMasterVO);
	public Resp deleteItem(Long itemId);
}
