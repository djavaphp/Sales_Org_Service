package com.sales.wb.service.vo;
/**
 * 
 * @author Kruti Jani
 */
import java.util.List;

import com.sales.wb.common.Resp;
import com.sales.wb.vo.AreaVO;

public class GetAreaDtlResp {
	private Resp resp;
	private List<AreaVO> list;
	/**
	 * @param resp
	 * @param list
	 */
	public GetAreaDtlResp(Resp resp, List<AreaVO> list) {
		super();
		this.resp = resp;
		this.list = list;
	}	
	public GetAreaDtlResp() {
		super();
	}	
	/**
	 * @param resp
	 */
	public GetAreaDtlResp(Resp resp) {
		super();
		this.resp = resp;
	}
	public Resp getResp() {
		return resp;
	}
	public void setResp(Resp resp) {
		this.resp = resp;
	}
	public List<AreaVO> getList() {
		return list;
	}
	public void setList(List<AreaVO> list) {
		this.list = list;
	}	
}
