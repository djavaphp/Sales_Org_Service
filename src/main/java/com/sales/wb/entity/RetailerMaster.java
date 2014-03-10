package com.sales.wb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Kruti Jani
 */
@Entity
@Table(name = "retailer_master")
public class RetailerMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "retailer_id")
	private Long retailerID;

	@Column(name = "retailer_name")
	private String retailerName;

	@Column(name = "shop_address")
	private String shopAddress;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "shop_phone_number")
	private String shopPhoneNumber;

	@ManyToOne
	@JoinColumn(name = "area_id")
	private AreaMaster areaMaster;
	
	@Column(name="is_active" )
	private Boolean isActive;

	
	/**
	 * @param retailerID
	 * @param retailerName
	 * @param shopAddress
	 * @param shopName
	 * @param shopPhoneNumber
	 * @param areaMaster
	 */
	public RetailerMaster(Long retailerID, String retailerName,
			String shopAddress, String shopName, String shopPhoneNumber,
			AreaMaster areaMaster) {
		this.retailerID = retailerID;
		this.retailerName = retailerName;
		this.shopAddress = shopAddress;
		this.shopName = shopName;
		this.shopPhoneNumber = shopPhoneNumber;
		this.areaMaster = areaMaster;
	}

	public RetailerMaster() {		
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

	public AreaMaster getAreaMaster() {
		return areaMaster;
	}

	public void setAreaMaster(AreaMaster areaMaster) {
		this.areaMaster = areaMaster;
	}
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
