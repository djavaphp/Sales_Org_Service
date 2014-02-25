package com.sales.wb.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sales.wb.common.Resp;
import com.sales.wb.common.RespCode;
import com.sales.wb.entity.ItemMaster;
import com.sales.wb.facade.AbstractDao;
import com.sales.wb.facade.ItemMasterDao;
import com.sales.wb.service.ItemMasterService;
import com.sales.wb.vo.GetItemMasterResp;
import com.sales.wb.vo.ItemMasterVO;

@Service
public class ItemMasterServiceImp  implements ItemMasterService {

	@Autowired
	private	AbstractDao<ItemMaster> itemFacade;
	
	@Transactional
	public Resp createItem(ItemMasterVO vo) {
		Resp resp = new Resp();
		if (vo != null) {
			System.out.println("--- Item Code : "+ vo.getItemCode());
			System.out.println("--- Item Name : "+ vo.getItemName());
			ItemMaster itemMaster = new ItemMaster();
			itemMaster.setItemcode(vo.getItemCode());
			itemMaster.setItemName(vo.getItemName());
			itemFacade.create(itemMaster);
			System.out.println("****  Created Succesfully. Item Code is :  "+ itemMaster.getItemcode());
			resp.setRespCode(RespCode.SUCCESS);
			resp.setRespMsg("Item inserted Succesfully !");
		} else {
			resp.setRespCode(RespCode.FAIL);
			resp.setRespMsg("Failure !");

		}		
		return resp;
	}
	
	@Transactional
	public GetItemMasterResp getAllItemMasterDtl() {
		GetItemMasterResp resp = new GetItemMasterResp();
		try{
			List<ItemMasterVO> getAllItemList = new ArrayList<ItemMasterVO>();
			List<ItemMaster> getList = new ArrayList<ItemMaster>();		
			getList= itemFacade.getAll();
			System.out.println(" **** List Size :  "+ getList.size());
			ItemMasterVO itemMasterVO;
			for(ItemMaster vo : getList){
				itemMasterVO = new ItemMasterVO();
				itemMasterVO.setItemCode(vo.getItemcode());
				itemMasterVO.setItemId(vo.getItemId());
				itemMasterVO.setItemName(vo.getItemName());
				getAllItemList.add(itemMasterVO);
			}
			resp.setList(getAllItemList);
			resp.setResp(new Resp(RespCode.SUCCESS, "Data Retrived Successfully"));
			return resp;
		}catch(Exception e){
			e.printStackTrace();	
			resp.setResp(new Resp(RespCode.FAIL, "Exception."));
			return resp;
		}
		
	}

	@Transactional
	public Resp updateItem(ItemMasterVO itemMasterVO) {
		Resp resp = new Resp();
		if (itemMasterVO != null) {
			resp.setRespCode(RespCode.SUCCESS);
			resp.setRespMsg("Item updated Succesfully !");
		} else {

			resp.setRespCode(RespCode.FAIL);
			resp.setRespMsg("Failure !");

		}
		return resp;
	}

	@Transactional
	public Resp deleteItem(Long itemId) {
		Resp resp = new Resp();
		if (itemId != null) {
			resp.setRespCode(RespCode.SUCCESS);
			resp.setRespMsg("Item deleted Succesfully !");
		} else {

			resp.setRespCode(RespCode.FAIL);
			resp.setRespMsg("Failure !");

		}
		return resp;
	}	
}

