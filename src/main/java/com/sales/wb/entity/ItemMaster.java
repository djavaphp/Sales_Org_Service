package com.sales.wb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="item_master")
public class ItemMaster {
	@Id
	@Column(name="item_id")
	@GeneratedValue
	private Long itemId;
	
	@Column(name="item_code")
	private String itemcode;
	
	@Column(name="item_name")
	private String itemName;

	public Long getItemId() {
		return itemId;
	}

	public String getItemcode() {
		return itemcode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
	
}
