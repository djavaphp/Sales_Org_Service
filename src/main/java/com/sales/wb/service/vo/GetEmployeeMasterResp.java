package com.sales.wb.service.vo;

import java.util.List;

import com.sales.wb.common.Resp;
import com.sales.wb.vo.EmployeeMasterVO;
/**
*
* @author Kruti Jani
*/
public class GetEmployeeMasterResp {
	private Resp resp;
	private List<EmployeeMasterVO> employeeList;
	public GetEmployeeMasterResp(Resp resp, List<EmployeeMasterVO> employeeList) {		
		this.resp = resp;
		this.employeeList = employeeList;
	}
	public GetEmployeeMasterResp() {}
	public GetEmployeeMasterResp(Resp resp) {
		this.resp = resp;
	}
	public Resp getResp() {
		return resp;
	}
	public void setResp(Resp resp) {
		this.resp = resp;
	}
	public List<EmployeeMasterVO> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeMasterVO> employeeList) {
		this.employeeList = employeeList;
	}
	
	
	
}
