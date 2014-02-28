package com.sales.wb.vo;
/**
*
* @author Kruti Jani
*/
public class BillBookVo {

	private Long billBookId;
	private String BillBookNum;
	private String startRange;
	private String endRange;
	public BillBookVo(Long billBookId, String billBookNum, String startRange,
			String endRange) {
		super();
		this.billBookId = billBookId;
		BillBookNum = billBookNum;
		this.startRange = startRange;
		this.endRange = endRange;
	}
	public BillBookVo() {
		super();
	}
	public Long getBillBookId() {
		return billBookId;
	}
	public void setBillBookId(Long billBookId) {
		this.billBookId = billBookId;
	}
	public String getBillBookNum() {
		return BillBookNum;
	}
	public void setBillBookNum(String billBookNum) {
		BillBookNum = billBookNum;
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
