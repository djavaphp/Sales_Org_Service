package com.sales.wb.vo;


/**
 * @author Kruti Jani
 *
 */
public class RetailerVO {
	private Long retailerID;	
	private String retailerName;	
	private String shopAddress;	
	private String shopName;	
	private String shopPhoneNumber;	
	private AreaVO areaVO;
	private Boolean isActive;
	/**
	 * @param retailerID
	 * @param retailerName
	 * @param shopAddress
	 * @param shopName
	 * @param shopPhoneNumber
	 * @param areaVO
	 */
	public RetailerVO(Long retailerID, String retailerName, String shopAddress,
			String shopName, String shopPhoneNumber, AreaVO areaVO) {
		this.retailerID = retailerID;
		this.retailerName = retailerName;
		this.shopAddress = shopAddress;
		this.shopName = shopName;
		this.shopPhoneNumber = shopPhoneNumber;
		this.areaVO = areaVO;
	}
	
	public RetailerVO() {
	}

	public Long getRetailerID() {
		return retailerID;
	}

	public void setRetailerID(Long retailerID) {
		this.retailerID = retailerID;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopPhoneNumber() {
		return shopPhoneNumber;
	}

	public void setShopPhoneNumber(String shopPhoneNumber) {
		this.shopPhoneNumber = shopPhoneNumber;
	}

	public AreaVO getAreaVO() {
		return areaVO;
	}

	public void setAreaVO(AreaVO areaVO) {
		this.areaVO = areaVO;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
