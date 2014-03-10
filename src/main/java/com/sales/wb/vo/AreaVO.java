package com.sales.wb.vo;

import java.util.List;

/**
 * 
 * @author Kruti Jani
 */
public class AreaVO {

	private Long areaID;
	private String areaCode;
	private String areaName;
	private List<RetailerVO> retailerList;
	
	/**
	 * @param areaID
	 * @param areaCode
	 * @param areaName
	 * @param retailerList
	 */
	public AreaVO(Long areaID, String areaCode, String areaName,
			List<RetailerVO> retailerList) {
		this.areaID = areaID;
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.retailerList = retailerList;
	}
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
	public List<RetailerVO> getRetailerList() {
		return retailerList;
	}
	public void setRetailerList(List<RetailerVO> retailerList) {
		this.retailerList = retailerList;
	}	
}
