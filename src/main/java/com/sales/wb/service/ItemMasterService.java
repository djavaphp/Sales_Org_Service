package com.sales.wb.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.sales.wb.common.Resp;
import com.sales.wb.vo.GetItemMasterResp;
import com.sales.wb.vo.ItemMasterVO;
@Service
@WebService
public interface ItemMasterService {
	
	public Resp createItem(ItemMasterVO itemMasterVO);	
	public Resp updateItem(ItemMasterVO itemMasterVO);
	public Resp deleteItem(Long itemId);
	public GetItemMasterResp getAllItemMasterDtl();
}
