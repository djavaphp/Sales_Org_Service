package com.sales.wb.service.vo;

import java.util.List;

import com.sales.wb.common.Resp;
import com.sales.wb.vo.ItemMasterVO;

/**
*
* @author Kruti Jani
*/
public class GetItemMasterResp {
	private Resp resp;
	private List<ItemMasterVO> itemList;	
	
	public GetItemMasterResp() {
		super();
	}
	public GetItemMasterResp(Resp resp, List<ItemMasterVO> list) {	
		this.resp = resp;
		this.itemList = list;
	}
	public GetItemMasterResp(Resp resp) {
		this.resp = resp;
	}
	public Resp getResp() {
		return resp;
	}
	public void setResp(Resp resp) {
		this.resp = resp;
	}
	public List<ItemMasterVO> getList() {
		return itemList;
	}
	public void setList(List<ItemMasterVO> list) {
		this.itemList = list;
	}

	
}
