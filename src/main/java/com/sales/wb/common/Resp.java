package com.sales.wb.common;

/**
*
* @author Kruti Jani
*/

public class Resp {
	private RespCode respCode;
	private String respMsg;	
	
	public Resp() {
		super();
	}

	public Resp(RespCode respCode, String respMsg) {
	
		this.respCode = respCode;
		this.respMsg = respMsg;
	}
	
	public RespCode getRespCode() {
		return respCode;
	}
	public void setRespCode(RespCode respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	
	

}
