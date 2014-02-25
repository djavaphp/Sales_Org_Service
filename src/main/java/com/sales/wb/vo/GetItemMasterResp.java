package com.sales.wb.vo;

import java.util.List;

import com.sales.wb.common.Resp;

public class GetItemMasterResp {
	private Resp resp;
	private List<ItemMasterVO> list;
	
	
	public GetItemMasterResp() {
		super();
	}
	public GetItemMasterResp(Resp resp, List<ItemMasterVO> list) {	
		this.resp = resp;
		this.list = list;
	}
	public Resp getResp() {
		return resp;
	}
	public void setResp(Resp resp) {
		this.resp = resp;
	}
	public List<ItemMasterVO> getList() {
		return list;
	}
	public void setList(List<ItemMasterVO> list) {
		this.list = list;
	}

	
}
