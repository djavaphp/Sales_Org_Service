package com.sales.wb.entity;



import javax.persistence.Column;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author Kruti Jani
*/
@Entity
@Table(name="item_master")
public class ItemMaster {
	
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy = IDENTITY)
	private Long itemId;
	
	@Column(name="item_code")
	private String itemcode;
	

	@Column(name="item_name")
	private String itemName;
	
	@Column(name="is_active" )
	private Boolean isActive;

	public ItemMaster() {		
	}

	public ItemMaster(Long itemId, String itemcode, String itemName) {		
		this.itemId = itemId;
		this.itemcode = itemcode;
		this.itemName = itemName;
	}

	
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

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
