package com.sales.wb.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sales.wb.common.PaymentMode;
import com.sales.wb.entity.AreaMaster;
import com.sales.wb.entity.BillBookMaster;
import com.sales.wb.entity.CompanyMaster;
import com.sales.wb.entity.MstEmployee;
import com.sales.wb.entity.ItemMaster;
import com.sales.wb.entity.RetailerMaster;
import com.sales.wb.service.imp.MasterServiceImp;
import com.sales.wb.vo.AreaVO;
import com.sales.wb.vo.BillBookVo;
import com.sales.wb.vo.CompanyVo;
import com.sales.wb.vo.EmployeeMasterVO;
import com.sales.wb.vo.ItemMasterVO;
import com.sales.wb.vo.PaymentModeVo;
import com.sales.wb.vo.RetailerVO;

/**
 * 
 * @author Kruti Jani
 */

public class MasterDataUtil {
	private static final Logger log = Logger.getLogger(MasterDataUtil.class);
	public static ItemMaster converItemMasterForCreate(ItemMasterVO vo) {
		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setItemcode(vo.getItemCode());
		itemMaster.setItemName(vo.getItemName());
		itemMaster.setActive(vo.isActive());
		return itemMaster;
	}
	public static void convertItemMasterForUpdateAndDelete(ItemMaster master , ItemMasterVO vo , Boolean isUpdate){		
		if(isUpdate){
			if(vo.getItemCode()!=null){
			master.setItemcode(vo.getItemCode());
			}
			if(vo.getItemName()!=null){
			master.setItemName(vo.getItemName());
			}
		}else{
			master.setActive(Boolean.FALSE);
		}		
	}
	public static ItemMasterVO convertItemMasterForGetData(ItemMaster vo){
		ItemMasterVO itemMasterVO = new ItemMasterVO();
		itemMasterVO.setItemCode(vo.getItemcode());
		itemMasterVO.setItemId(vo.getItemId());
		itemMasterVO.setItemName(vo.getItemName());
		itemMasterVO.setActive(vo.isActive());
		return itemMasterVO;
	}
	public static MstEmployee convertEmployeeMasterForCreate(EmployeeMasterVO vo){
		MstEmployee master = new MstEmployee();
		master.setEmpName(vo.getEmpName());
		return master;
	}
	public static void convertEmployeeMasterForUpdateAndDelete(MstEmployee master , EmployeeMasterVO vo , Boolean isUpdate){		
		if(isUpdate){
			master.setEmpName(vo.getEmpName());			
		}else{
			master.setIsActive(Boolean.FALSE);
		}		
	}
	public static EmployeeMasterVO convertEmployeeMasterForGetData(MstEmployee vo){
		EmployeeMasterVO empVo = new EmployeeMasterVO();
		empVo.setEmpName(vo.getEmpName());
		empVo.setIsActive(vo.getIsActive());
		empVo.setEmpID(vo.getEmpId());
		return empVo;
	}
	public static List<PaymentModeVo> converPaymentMode(){
		List<PaymentModeVo> list = new ArrayList<PaymentModeVo>();
		for(PaymentMode mode:PaymentMode.values()){
			 PaymentModeVo vo = new PaymentModeVo();			
			 vo.setPaymentModeId(mode.getPaymentModeID());
			 vo.setPaymentModeName(mode.toString());
			 list.add(vo);			
		}		
		return list;
	}	
	public static CompanyVo converCompanyDtl(CompanyMaster company){
		CompanyVo vo = new CompanyVo();
		vo.setCompanyID(company.getCompanyId());
		vo.setCompanyName(company.getCompanyName());
		vo.setCompanyAddress(company.getCompanyAddress());
		vo.setCompanyPhoneNo(company.getCompanyPhoneno());
		vo.setCompanyMobileNo(company.getCompanyMobileno());
		return vo;
	}
	
	public static BillBookMaster convertBillBookForCreate(BillBookVo vo){
		BillBookMaster master = new BillBookMaster();
		master.setBillBookNumber(vo.getBillBookNum());
		master.setStartRange(vo.getStartRange());
		master.setEndRange(vo.getEndRange());
		return master;
	}
	public static void convertBillBookMasterForUpdate(BillBookMaster master , BillBookVo vo){			
			master.setBillBookNumber(vo.getBillBookNum());
			master.setEndRange(vo.getEndRange());
			master.setStartRange(vo.getStartRange());		
	}
	public static BillBookVo convertBillBookForGetData(BillBookMaster vo){
		BillBookVo billbook = new BillBookVo();
		billbook.setBillBookId(vo.getBillBookId());
		billbook.setBillBookNum(vo.getBillBookNumber());
		billbook.setStartRange(vo.getStartRange());
		billbook.setEndRange(vo.getEndRange());
		return billbook;
	}
	public static AreaMaster convertAreaForCreate(AreaVO vo){
		AreaMaster master = new AreaMaster();
		master.setMstAreaCode(vo.getAreaCode());
		master.setMstAreaId(vo.getAreaID());
		master.setMstAreaName(vo.getAreaName());
		return master;
	}
	public static void convertAreaForUpdate(AreaMaster master , AreaVO vo){			
		master.setMstAreaCode(vo.getAreaCode());
		master.setMstAreaId(vo.getAreaID());
		master.setMstAreaName(vo.getAreaName());	
	}
	public static AreaVO convertAreaForGetData(AreaMaster master){
		AreaVO area = new AreaVO();
		area.setAreaCode(master.getMstAreaCode());
		area.setAreaID(master.getMstAreaId());
		area.setAreaName(master.getMstAreaName());
		Collection<RetailerMaster> list=master.getRetailerMaster();
		List<RetailerVO> retailerList= new ArrayList<RetailerVO>();
		log.info("==== Inside convertAreaForGetData == Retailer Size is :  "+ list.size());
		if(list.size()>0){			
			for(RetailerMaster retailermaster :list){
				RetailerVO vo= convertRetailerForGetData(retailermaster);
				retailerList.add(vo);
			}
			area.setRetailerList(retailerList);
		}		
		return area;
	}
	public static RetailerVO convertRetailerForGetData(RetailerMaster master){
		RetailerVO vo = new RetailerVO();
		vo.setRetailerID(master.getRetailerID());
		vo.setRetailerName(master.getRetailerName());
		vo.setShopAddress(master.getShopAddress());
		vo.setShopName(master.getShopName());
		vo.setShopPhoneNumber(master.getShopPhoneNumber());
		vo.setIsActive(master.getIsActive());
		AreaVO areaVO = new AreaVO();
		areaVO.setAreaCode(master.getAreaMaster().getMstAreaCode());
		areaVO.setAreaID(master.getAreaMaster().getMstAreaId());
		areaVO.setAreaName(master.getAreaMaster().getMstAreaName());		
		vo.setAreaVO(areaVO);
		return vo;
	}
	public static void convertRetailerMasterForUpdateAndDelete(RetailerMaster master , RetailerVO vo , Boolean isUpdate){		
		if(isUpdate){
			AreaMaster areaMaster= new AreaMaster();
			areaMaster.setMstAreaCode(vo.getAreaVO().getAreaCode());
			areaMaster.setMstAreaId(vo.getAreaVO().getAreaID());
			areaMaster.setMstAreaName(vo.getAreaVO().getAreaName());			
			master.setAreaMaster(areaMaster);
			master.setRetailerName(vo.getRetailerName());
			master.setShopAddress(vo.getShopAddress());
			master.setShopName(vo.getShopName());
			master.setShopPhoneNumber(vo.getShopPhoneNumber());
		}else{
			master.setIsActive(false);
		}		
	}
	public static RetailerMaster convertRetailerForCreate(RetailerVO vo , AreaMaster areaMaster){
		RetailerMaster master = new RetailerMaster();				
		master.setAreaMaster(areaMaster);
		master.setRetailerName(vo.getRetailerName());
		master.setShopAddress(vo.getShopAddress());
		master.setShopName(vo.getShopName());
		master.setShopPhoneNumber(vo.getShopPhoneNumber());
		master.setIsActive(true);
		return master;
	}
}
