package com.sales.wb.vo;

/**
 * @author kbjani
 *
 */
public class RoleVo {

	private String roleDesc;
	private Long roleId;
	/**
	 * @param roleDesc
	 * @param roleId
	 */
	public RoleVo(String roleDesc, Long roleId) {
		this.roleDesc = roleDesc;
		this.roleId = roleId;
	}
	/**
	 * 
	 */
	public RoleVo() {
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}
