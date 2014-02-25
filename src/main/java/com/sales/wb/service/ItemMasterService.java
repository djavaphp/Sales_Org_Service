package com.sales.wb.service;


import javax.jws.WebService;
import org.springframework.stereotype.Service;
import com.sales.wb.common.Resp;
import com.sales.wb.service.vo.GetItemMasterResp;
import com.sales.wb.vo.ItemMasterVO;

/**
*
* @author Kruti Jani
*/
@Service
@WebService
public interface ItemMasterService {	
	public Resp createItem(ItemMasterVO itemMasterVO);	
	public Resp updateItem(ItemMasterVO itemMasterVO);
	public Resp blockItem(Long itemId);
	public GetItemMasterResp getAllItemMasterDtl();
}
