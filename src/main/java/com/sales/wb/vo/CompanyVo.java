package com.sales.wb.vo;
/*
 * Kruti Jani
 * */
public class CompanyVo {
	private Long companyID;
	private String CompanyName;
	private String CompanyAddress;
	private String CompanyPhoneNo;
	private String CompanyMobileNo;
	
	public CompanyVo() {
		super();
	}
	public CompanyVo(Long companyID, String companyName, String companyAddress,
			String companyPhoneNo, String companyMobileNo) {
		super();
		this.companyID = companyID;
		CompanyName = companyName;
		CompanyAddress = companyAddress;
		CompanyPhoneNo = companyPhoneNo;
		CompanyMobileNo = companyMobileNo;
	}
	public Long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCompanyAddress() {
		return CompanyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		CompanyAddress = companyAddress;
	}
	public String getCompanyPhoneNo() {
		return CompanyPhoneNo;
	}
	public void setCompanyPhoneNo(String companyPhoneNo) {
		CompanyPhoneNo = companyPhoneNo;
	}
	public String getCompanyMobileNo() {
		return CompanyMobileNo;
	}
	public void setCompanyMobileNo(String companyMobileNo) {
		CompanyMobileNo = companyMobileNo;
	}
	
}
