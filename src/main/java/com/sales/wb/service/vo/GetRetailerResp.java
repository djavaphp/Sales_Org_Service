package com.sales.wb.service.vo;

import java.util.List;

import com.sales.wb.common.Resp;
import com.sales.wb.vo.RetailerVO;

/**
 * @author kbjani
 *
 */
public class GetRetailerResp {
	private Resp resp;
	private List<RetailerVO> retailerlist;
	/**
	 * @param resp
	 * @param retailerlist
	 */
	public GetRetailerResp(Resp resp, List<RetailerVO> retailerlist) {
		this.resp = resp;
		this.retailerlist = retailerlist;
	}
	/**
	 * @param resp
	 */
	public GetRetailerResp(Resp resp) {
		this.resp = resp;
	}
	
	public GetRetailerResp() {
	}
	public Resp getResp() {
		return resp;
	}
	public void setResp(Resp resp) {
		this.resp = resp;
	}
	public List<RetailerVO> getRetailerlist() {
		return retailerlist;
	}
	public void setRetailerlist(List<RetailerVO> retailerlist) {
		this.retailerlist = retailerlist;
	}
	
}
