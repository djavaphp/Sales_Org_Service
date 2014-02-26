package com.sales.wb.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.wb.common.CommonMessages;
import com.sales.wb.common.Resp;
import com.sales.wb.common.RespCode;
import com.sales.wb.entity.ItemMaster;
import com.sales.wb.facade.ItemMasterFacade;
import com.sales.wb.service.ItemMasterService;
import com.sales.wb.service.vo.GetItemMasterResp;
import com.sales.wb.utils.MasterDataUtil;
import com.sales.wb.vo.ItemMasterVO;

/**
*
* @author Kruti Jani
*/
@Service
public class ItemMasterServiceImp implements ItemMasterService {

	/*AbstractDao is a common interface can not autowire with different bean so 
	 * used orignalbean to implement autowire
	 * @Qualifier can also be implemented if spring ver is 4+
	  */
	@Autowired	
	private ItemMasterFacade itemFacade;

	@Transactional
	public Resp createItem(ItemMasterVO vo) {
		try{			
			if (vo != null) {
				ItemMaster itemMaster =	MasterDataUtil.converItemMasterForCreate(vo);
				itemFacade.create(itemMaster);			
				return new Resp(RespCode.SUCCESS, CommonMessages.ITEM_MASTER_SERVICE_CREATE_SUCCESS + itemMaster.getItemcode());				
			} else {
				return new Resp(RespCode.FAIL, CommonMessages.ITEM_MASTER_SERVICE_CREATE_FAILURE);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE);
		}		
	}

	@Transactional
	public GetItemMasterResp getAllItemMasterDtl() {		
		try {			
			List<ItemMasterVO> getAllItemList = new ArrayList<ItemMasterVO>();
			List<ItemMaster> getList = itemFacade.getAll();	
			if(getList.size()>0){				
				for (ItemMaster vo : getList) {
					ItemMasterVO itemMasterVO= MasterDataUtil.convertItemMasterForGetData(vo);					
					getAllItemList.add(itemMasterVO);
				}
				return new GetItemMasterResp( new Resp(RespCode.SUCCESS, CommonMessages.ITEM_MASTER_SERVICE_GET_SUCCESS), getAllItemList);
			}else{
				return new GetItemMasterResp( new Resp(RespCode.FAIL, CommonMessages.ITEM_MASTER_SERVICE_GET_FAILURE));	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return new GetItemMasterResp( new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE));
		}
	}

	@Transactional
	public Resp updateItem(ItemMasterVO itemMasterVO) {
		try{			
			if (itemMasterVO != null) {
				if (itemMasterVO.getItemId() != null) {
					ItemMaster itemMaster = itemFacade.get(itemMasterVO.getItemId());
					if (itemMaster != null) {
						MasterDataUtil.convertItemMasterForUpdateAndDelete(itemMaster, itemMasterVO, true);
						return new Resp(RespCode.SUCCESS,CommonMessages.ITEM_MASTER_SERVICE_UPDATE_SUCCESS);
					} else {
						return new Resp(RespCode.FAIL,CommonMessages.ITEM_MASTER_SERVICE_INVALID_ID);						
					}
				} else {
					return new Resp(RespCode.FAIL,CommonMessages.ITEM_MASTER_SERVICE_BLANK_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,CommonMessages.NO_DATA_FOUND);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE);
		}		
	}

	@Transactional
	public Resp blockItem(Long itemId) {	
		try{
			if (itemId != null) {
				ItemMaster itemMaster = itemFacade.get(itemId);				
				if (itemMaster != null) {
					MasterDataUtil.convertItemMasterForUpdateAndDelete(itemMaster, null, false);
					return new Resp(RespCode.SUCCESS,CommonMessages.ITEM_MASTER_SERVICE_DELETE_SUCCESS);
				} else {
					return new Resp(RespCode.FAIL,CommonMessages.ITEM_MASTER_SERVICE_INVALID_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,CommonMessages.ITEM_MASTER_SERVICE_BLANK_ID);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE);
		}
	}
	
}
