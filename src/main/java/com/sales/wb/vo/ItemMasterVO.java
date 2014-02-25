package com.sales.wb.vo;

/**
*
* @author Kruti Jani
*/
public class ItemMasterVO {
	private Long itemId;
	private String itemCode;
	private String itemName;
	private Boolean isActive;
	
	public Boolean isActive() {
		return isActive;
	}
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
