package com.sales.wb.service.vo;

import java.util.List;

import com.sales.wb.common.Resp;
import com.sales.wb.vo.CompanyVo;
/*
 * Kruti Jani
 * */
public class GetCompanyResp {
	private Resp resp;
	private List<CompanyVo> companyList;
	public GetCompanyResp(Resp resp, List<CompanyVo> companyList) {
		super();
		this.resp = resp;
		this.companyList = companyList;
	}
	public GetCompanyResp() {
		super();
	}
	
	public GetCompanyResp(Resp resp) {
		super();
		this.resp = resp;
	}
	public Resp getResp() {
		return resp;
	}
	public void setResp(Resp resp) {
		this.resp = resp;
	}
	public List<CompanyVo> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<CompanyVo> companyList) {
		this.companyList = companyList;
	}
	

}
