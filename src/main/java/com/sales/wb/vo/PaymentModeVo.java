package com.sales.wb.vo;

/**
 * @author kbjani
 *
 */
public class PaymentModeVo {

	private int paymentModeId;
	private String paymentModeName;
	
	public PaymentModeVo() {
		super();
	}
	public PaymentModeVo(int paymentModeId, String paymentModeName) {
		super();
		this.paymentModeId = paymentModeId;
		this.paymentModeName = paymentModeName;
	}
	public int getPaymentModeId() {
		return paymentModeId;
	}
	public void setPaymentModeId(int paymentModeId) {
		this.paymentModeId = paymentModeId;
	}
	public String getPaymentModeName() {
		return paymentModeName;
	}
	public void setPaymentModeName(String paymentModeName) {
		this.paymentModeName = paymentModeName;
	}
	
}
