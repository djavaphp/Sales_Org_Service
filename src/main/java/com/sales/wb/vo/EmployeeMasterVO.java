package com.sales.wb.vo;

/**
*
* @author Kruti Jani
*/
public class EmployeeMasterVO {
	
	private String empName;
	private Long empID;
	private Boolean isActive;
	public EmployeeMasterVO(String empName, Long empID) {		
		this.empName = empName;
		this.empID = empID;
	}
	public EmployeeMasterVO() {
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Long getEmpID() {
		return empID;
	}
	public void setEmpID(Long empID) {
		this.empID = empID;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
