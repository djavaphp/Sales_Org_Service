package com.sales.wb.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*
* @author Kruti Jani
*/
@Entity
@Table(name="mst_employee")
public class MstEmployee {
	

	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy = IDENTITY)
	private Long empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="is_active" )
	private Boolean isActive;
	
	@Column(name="password" )
	private String password;
	
	@Column(name="emp_code" )
	private String empCode;	

	@ManyToOne
	@JoinColumn(name = "role_id")
    private Role role; 
	
	public MstEmployee(Long empId, String empName) {	
		this.empId = empId;
		this.empName = empName;
	}

	public MstEmployee() {	
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
}
