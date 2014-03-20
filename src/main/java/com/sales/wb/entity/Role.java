package com.sales.wb.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author kbjani
 *
 */
@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private Long roleID;
	
	@Column(name="role_desc")
	private String roleDesc;
	
	/*role is a varible name in Role entity. */
	@OneToMany(mappedBy="role", fetch=FetchType.EAGER)
	private List<MstEmployee> mstemployee;

	/**
	 * @param roleID
	 * @param roleDesc
	 */
	public Role(Long roleID, String roleDesc) {
		this.roleID = roleID;
		this.roleDesc = roleDesc;
	}

	public Role() {
	}

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public List<MstEmployee> getMstemployee() {
		return mstemployee;
	}

	public void setMstemployee(List<MstEmployee> mstemployee) {
		this.mstemployee = mstemployee;
	}	
}
