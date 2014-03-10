package com.sales.wb.vo;

public class AreaVO {

	private Long areaID;
	private String areaCode;
	private String areaName;
	/**
	 * @param areaID
	 * @param areaCode
	 * @param areaName
	 */
	public AreaVO(Long areaID, String areaCode, String areaName) {
		super();
		this.areaID = areaID;
		this.areaCode = areaCode;
		this.areaName = areaName;
	}	
	public AreaVO() {
		super();
	}
	public Long getAreaID() {
		return areaID;
	}
	public void setAreaID(Long areaID) {
		this.areaID = areaID;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
}
