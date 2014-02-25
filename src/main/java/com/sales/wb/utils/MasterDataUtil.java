package com.sales.wb.utils;

import com.sales.wb.entity.ItemMaster;
import com.sales.wb.vo.ItemMasterVO;

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

}
