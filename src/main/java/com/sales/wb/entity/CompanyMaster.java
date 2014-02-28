package com.sales.wb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author Kruti Jani
*/
@Entity
@Table(name="company")
public class CompanyMaster {

	@Id
	@Column(name="company_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long companyId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_address")
	private String companyAddress;
	
	@Column(name="company_phoneno")
	private String companyPhoneno;
	
	@Column(name="company_mobileno")
	private String companyMobileno;

	
	public CompanyMaster() {
		super();
	}

	public CompanyMaster(Long companyId, String companyName, String companyAddress,
			String companyPhoneno, String companyMobileno) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyPhoneno = companyPhoneno;
		this.companyMobileno = companyMobileno;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyPhoneno() {
		return companyPhoneno;
	}

	public void setCompanyPhoneno(String companyPhoneno) {
		this.companyPhoneno = companyPhoneno;
	}

	public String getCompanyMobileno() {
		return companyMobileno;
	}

	public void setCompanyMobileno(String companyMobileno) {
		this.companyMobileno = companyMobileno;
	}
	
	
}
