package com.sales.wb.entity;

import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * @author : Kruti Jani
 * */
@Entity
@Table(name = "mst_area")
public class AreaMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mst_area_id")
	private Long mstAreaId;

	@Column(name = "mst_area_code")
	private String mstAreaCode;

	@Column(name = "mst_area_name")
	private String mstAreaName;

	/*areaMaster is a varible name in RetailerMaster entity. */
	@OneToMany(mappedBy="areaMaster", fetch=FetchType.EAGER)
	private Collection<RetailerMaster> retailerMaster;

	public AreaMaster(Long mstAreaId, String mstAreaCode, String mstAreaName) {
		this.mstAreaId = mstAreaId;
		this.mstAreaCode = mstAreaCode;
		this.mstAreaName = mstAreaName;
	}

	public AreaMaster() {
	}

	/**
	 * @param mstAreaId
	 * @param mstAreaCode
	 * @param mstAreaName
	 * @param retailerMaster
	 */
	public AreaMaster(Long mstAreaId, String mstAreaCode, String mstAreaName,
			Collection<RetailerMaster> retailerMaster) {
		this.mstAreaId = mstAreaId;
		this.mstAreaCode = mstAreaCode;
		this.mstAreaName = mstAreaName;
		this.retailerMaster = retailerMaster;
	}

	public Long getMstAreaId() {
		return mstAreaId;
	}

	public void setMstAreaId(Long mstAreaId) {
		this.mstAreaId = mstAreaId;
	}

	public String getMstAreaCode() {
		return mstAreaCode;
	}

	public void setMstAreaCode(String mstAreaCode) {
		this.mstAreaCode = mstAreaCode;
	}

	public String getMstAreaName() {
		return mstAreaName;
	}

	public void setMstAreaName(String mstAreaName) {
		this.mstAreaName = mstAreaName;
	}

	public Collection<RetailerMaster> getRetailerMaster() {
		return retailerMaster;
	}

	public void setRetailerMaster(Collection<RetailerMaster> retailerMaster) {
		this.retailerMaster = retailerMaster;
	}

}
