package com.sales.wb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author : Kruti Jani
 * */
@Entity
@Table(name="mst_area")
public class AreaMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mst_area_id")
	private Long mstAreaId;
	
	@Column(name="mst_area_code")
	private String mstAreaCode;
	
	@Column(name="mst_area_name")
	private String mstAreaName;

	public AreaMaster(Long mstAreaId, String mstAreaCode, String mstAreaName) {
		super();
		this.mstAreaId = mstAreaId;
		this.mstAreaCode = mstAreaCode;
		this.mstAreaName = mstAreaName;
	}

	public AreaMaster() {
		super();
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
	
	
}
