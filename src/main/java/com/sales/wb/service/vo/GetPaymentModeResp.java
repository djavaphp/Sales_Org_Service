package com.sales.wb.service.vo;

import java.util.List;

import com.sales.wb.common.Resp;
import com.sales.wb.vo.PaymentModeVo;
/**
 * 
 * @author Kruti Jani
 */
public class GetPaymentModeResp {
	private List<PaymentModeVo> paymentModeList;
	private Resp resp;
	public GetPaymentModeResp(List<PaymentModeVo> paymentModeList) {		
		this.paymentModeList = paymentModeList;
	}

	public GetPaymentModeResp() {		
	}
	
	public GetPaymentModeResp(Resp resp) {		
		this.resp = resp;
	}
	public GetPaymentModeResp(Resp resp, List<PaymentModeVo> paymentModeList) {
		this.paymentModeList = paymentModeList;
		this.resp = resp;
	}

	public Resp getResp() {
		return resp;
	}

	public void setResp(Resp resp) {
		this.resp = resp;
	}

	public List<PaymentModeVo> getPaymentModeList() {
		return paymentModeList;
	}

	public void setPaymentModeList(List<PaymentModeVo> paymentModeList) {
		this.paymentModeList = paymentModeList;
	}
	
}
