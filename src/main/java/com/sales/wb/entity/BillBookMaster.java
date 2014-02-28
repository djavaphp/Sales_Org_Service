package com.sales.wb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author : Kruti Jani
 * */
@Entity
@Table(name="mst_bill_book")
public class BillBookMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bill_book_id")
	private Long billBookId;
	
	@Column(name="bill_book_number")
	private String billBookNumber;
	
	@Column(name="start_range")
	private String startRange;
	
	@Column(name="end_range")
	private String endRange;

	
	public BillBookMaster() {		
	}
	public BillBookMaster(Long billBookId, String billBookNumber,
			String startRange, String endRange) {	
		this.billBookId = billBookId;
		this.billBookNumber = billBookNumber;
		this.startRange = startRange;
		this.endRange = endRange;
	}
	public Long getBillBookId() {
		return billBookId;
	}
	public void setBillBookId(Long billBookId) {
		this.billBookId = billBookId;
	}
	public String getBillBookNumber() {
		return billBookNumber;
	}
	public void setBillBookNumber(String billBookNumber) {
		this.billBookNumber = billBookNumber;
	}
	public String getStartRange() {
		return startRange;
	}
	public void setStartRange(String startRange) {
		this.startRange = startRange;
	}
	public String getEndRange() {
		return endRange;
	}
	public void setEndRange(String endRange) {
		this.endRange = endRange;
	}
	
	
	
	
}
