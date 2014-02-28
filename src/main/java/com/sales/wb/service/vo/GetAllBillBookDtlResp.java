package com.sales.wb.service.vo;

import java.util.List;

import com.sales.wb.common.Resp;
import com.sales.wb.vo.BillBookVo;
/**
*
* @author Kruti Jani
*/
public class GetAllBillBookDtlResp {
	private Resp resp;
	private List<BillBookVo> billBookList;	
	
	public GetAllBillBookDtlResp() {
		super();
	}
	public GetAllBillBookDtlResp(Resp resp) {
		super();
		this.resp = resp;
	}
	public GetAllBillBookDtlResp(Resp resp, List<BillBookVo> billBookList) {
		super();
		this.resp = resp;
		this.billBookList = billBookList;
	}
	public Resp getResp() {
		return resp;
	}
	public void setResp(Resp resp) {
		this.resp = resp;
	}
	public List<BillBookVo> getBillBookList() {
		return billBookList;
	}
	public void setBillBookList(List<BillBookVo> billBookList) {
		this.billBookList = billBookList;
	}
}
