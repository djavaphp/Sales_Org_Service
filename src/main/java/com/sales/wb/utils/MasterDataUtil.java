package com.sales.wb.utils;

import java.util.ArrayList;
import java.util.List;

import com.sales.wb.common.PaymentMode;
import com.sales.wb.entity.MstEmployee;
import com.sales.wb.entity.ItemMaster;
import com.sales.wb.vo.EmployeeMasterVO;
import com.sales.wb.vo.ItemMasterVO;
import com.sales.wb.vo.PaymentModeVo;

/**
 * 
 * @author Kruti Jani
 */

public class MasterDataUtil {

	public static ItemMaster converItemMasterForCreate(ItemMasterVO vo) {
		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setItemcode(vo.getItemCode());
		itemMaster.setItemName(vo.getItemName());
		itemMaster.setActive(vo.isActive());
		return itemMaster;
	}
	public static void convertItemMasterForUpdateAndDelete(ItemMaster master , ItemMasterVO vo , Boolean isUpdate){		
		if(isUpdate){
			master.setItemcode(vo.getItemCode());
			master.setItemName(vo.getItemName());
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
}
