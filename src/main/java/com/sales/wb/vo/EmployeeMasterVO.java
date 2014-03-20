package com.sales.wb.vo;

/**
*
* @author Kruti Jani
*/
public class EmployeeMasterVO {
	
	private String empName;
	private String empCode;
	private Long empID;
	private Boolean isActive;
	private String password;
	private RoleVo roleVo;
	
	public EmployeeMasterVO(String empName, Long empID) {		
		this.empName = empName;
		this.empID = empID;
	}
	
	/**
	 * @param empName
	 * @param empID
	 * @param isActive
	 * @param password
	 */
	public EmployeeMasterVO(String empName, Long empID, Boolean isActive,
			String password) {
		this.empName = empName;
		this.empID = empID;
		this.isActive = isActive;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleVo getRoleVo() {
		return roleVo;
	}

	public void setRoleVo(RoleVo roleVo) {
		this.roleVo = roleVo;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}	
	
}
