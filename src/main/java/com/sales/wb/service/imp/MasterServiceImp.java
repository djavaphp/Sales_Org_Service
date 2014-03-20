package com.sales.wb.service.imp;

import java.util.ArrayList;
import java.util.List;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.wb.common.MasterCommonMessages;
import com.sales.wb.common.Resp;
import com.sales.wb.common.RespCode;
import com.sales.wb.entity.AreaMaster;
import com.sales.wb.entity.BillBookMaster;
import com.sales.wb.entity.CompanyMaster;
import com.sales.wb.entity.ItemMaster;
import com.sales.wb.entity.MstEmployee;
import com.sales.wb.entity.RetailerMaster;
import com.sales.wb.facade.AreaFacade;
import com.sales.wb.facade.BillBookFacade;
import com.sales.wb.facade.CompanyFacade;
import com.sales.wb.facade.EmployeeMasterFacade;
import com.sales.wb.facade.ItemMasterFacade;
import com.sales.wb.facade.RetailerFacade;
import com.sales.wb.service.MasterService;
import com.sales.wb.service.vo.GetAllBillBookDtlResp;
import com.sales.wb.service.vo.GetAreaDtlResp;
import com.sales.wb.service.vo.GetCompanyResp;
import com.sales.wb.service.vo.GetEmployeeMasterResp;
import com.sales.wb.service.vo.GetItemMasterResp;
import com.sales.wb.service.vo.GetPaymentModeResp;
import com.sales.wb.service.vo.GetRetailerResp;
import com.sales.wb.utils.MasterDataUtil;
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
@Service
public class MasterServiceImp implements MasterService{

	private static final Logger log = Logger.getLogger(MasterServiceImp.class);
	/*AbstractDao is a common interface can not autowire with different bean 
	 * so used orignalbean to implement autowire
	 * @Qualifier can also be implemented if spring ver is 4+
	 * */
	@Autowired	
	private ItemMasterFacade itemFacade;
	
	@Autowired	
	private EmployeeMasterFacade empFacade;
	
	@Autowired
	private CompanyFacade companyFacade;
	
	@Autowired
	private BillBookFacade billBookFacade;
	
	@Autowired
	private AreaFacade areaFacade;	
	
	@Autowired
	private RetailerFacade retailerFacade;
		
	
	public GetPaymentModeResp getAllPaymentModes() {
		log.info("==== Inside getAllPaymentModes =====");
		try{
			List<PaymentModeVo> list= MasterDataUtil.converPaymentMode();			
			if(list.size()>0){
				return new GetPaymentModeResp(new Resp(RespCode.SUCCESS, MasterCommonMessages.PAYMENT_MODE_GET_SUCCESS),list);
			}else{
				return new GetPaymentModeResp(new Resp(RespCode.FAIL, MasterCommonMessages.PAYMENT_MODE_GET_FAILURE));
			}
		}catch(Exception e){
			e.printStackTrace();
			return new GetPaymentModeResp(new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE));
		}		
	}	

	/*No Hibernate Session bound to thread, and configuration does not allow creation of
	 *  non-transactional one here if we dont implement @Transactional
	 */	
	
	@Transactional
	public GetCompanyResp getCompanyDetail(){
		log.info("==== Inside getCompanyDetail =====");
		try{
			List<CompanyVo> list=new ArrayList<CompanyVo>();
			List<CompanyMaster> companylist= companyFacade.getAll();			
			if(companylist.size()>0){
				for(CompanyMaster vo : companylist){
					CompanyVo companyVo = MasterDataUtil.converCompanyDtl(vo);
					list.add(companyVo);
				}
				return new GetCompanyResp(new Resp(RespCode.SUCCESS, MasterCommonMessages.COMPANY_DETAIILS_GET_SUCCESS),list);
			}else{
				return new GetCompanyResp(new Resp(RespCode.FAIL, MasterCommonMessages.COMPANY_DETAIILS_GET_FAILURE));
			}
		}catch(Exception e){
			e.printStackTrace();
			return new GetCompanyResp(new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE));
		}	
	}

	@Transactional
	public Resp createBillBook(BillBookVo vo) {
		log.info("==== Inside createBillBook =====");
		try{
			if(vo!=null){				
				BillBookMaster billbook = MasterDataUtil.convertBillBookForCreate(vo);
				billBookFacade.create(billbook);
				return new Resp(RespCode.SUCCESS, MasterCommonMessages.BILL_BOOK_SERVICE_CREATE_SUCCESS + billbook.getBillBookNumber());
			}else{
				return new Resp(RespCode.FAIL, MasterCommonMessages.BILL_BOOK_SERVICE_CREATE_FAILURE);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}			
	}

	@Transactional
	public Resp updateBillbook(BillBookVo vo) {
		log.info("==== Inside updateBillbook =====");
		try{			
			if (vo != null) {
				if (vo.getBillBookId() != null) {
					BillBookMaster billbookmaster = billBookFacade.get(vo.getBillBookId());
					if (billbookmaster != null) {
						MasterDataUtil.convertBillBookMasterForUpdate(billbookmaster, vo);
						return new Resp(RespCode.SUCCESS,MasterCommonMessages.BILL_BOOK_SERVICE_UPDATE_SUCCESS);
					} else {
						return new Resp(RespCode.FAIL,MasterCommonMessages.BILL_BOOK_SERVICE_INVALID_ID);						
					}
				} else {
					return new Resp(RespCode.FAIL,MasterCommonMessages.BILL_BOOK_SERVICE_BLANK_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,MasterCommonMessages.NO_DATA_FOUND);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}	
	}

	@Transactional
	public GetAllBillBookDtlResp getAllBillBookdtl() {
		log.info("==== Inside getAllBillBookdtl =====");
		try {			
			List<BillBookVo> getAllBillbookdata = new ArrayList<BillBookVo>();
			List<BillBookMaster> getList = billBookFacade.getAll();	
			if(getList.size()>0){				
				for (BillBookMaster vo : getList) {
					BillBookVo billbookvo= MasterDataUtil.convertBillBookForGetData(vo);					
					getAllBillbookdata.add(billbookvo);
				}
				return new GetAllBillBookDtlResp( new Resp(RespCode.SUCCESS, MasterCommonMessages.BILL_BOOK_GET_SUCCESS), getAllBillbookdata);
			}else{
				return new GetAllBillBookDtlResp( new Resp(RespCode.FAIL, MasterCommonMessages.BILL_BOOK_GET_FAILURE));	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return new GetAllBillBookDtlResp( new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE));
		}
	}

	@Transactional
	public Resp createArea(AreaVO vo) {
		log.info("==== Inside createArea =====");	
		try{
			if(vo!=null){				
				AreaMaster area = MasterDataUtil.convertAreaForCreate(vo);
				areaFacade.create(area);
				return new Resp(RespCode.SUCCESS, MasterCommonMessages.AREA_CREATE_SUCCESS + area.getMstAreaId());
			}else{
				return new Resp(RespCode.FAIL, MasterCommonMessages.AREA_CREATE_SUCCESS);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}	
	}

	@Transactional
	public Resp updateArea(AreaVO vo) {
		log.info("==== Inside updateAra =====");
		try{			
			if (vo != null) {
				if (vo.getAreaID() != null) {
					AreaMaster areaMaster = areaFacade.get(vo.getAreaID());
					if (areaMaster != null) {
						MasterDataUtil.convertAreaForUpdate(areaMaster, vo);
						return new Resp(RespCode.SUCCESS,MasterCommonMessages.AREA_UPDATE_SUCCESS);
					} else {
						return new Resp(RespCode.FAIL,MasterCommonMessages.AREA_INVALID_ID);						
					}
				} else {
					return new Resp(RespCode.FAIL,MasterCommonMessages.AREA_BLANK_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,MasterCommonMessages.NO_DATA_FOUND);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}	
	}

	@Transactional
	public GetAreaDtlResp getAreaMasterDtl() {
		log.info("==== Inside getAreaMasterDtl =====");
		try {			
			List<AreaVO> getAreadata = new ArrayList<AreaVO>();
			List<AreaMaster> getList = areaFacade.getAll();	
			if(getList.size()>0){				
				for (AreaMaster vo : getList) {
					AreaVO areavo= MasterDataUtil.convertAreaForGetData(vo);					
					getAreadata.add(areavo);
				}
				return new GetAreaDtlResp( new Resp(RespCode.SUCCESS, MasterCommonMessages.AREA_GET_SUCCESS), getAreadata);
			}else{
				return new GetAreaDtlResp( new Resp(RespCode.FAIL, MasterCommonMessages.AREA_GET_FAILURE));	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return new GetAreaDtlResp( new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE));
		}
	}

	@Transactional
	public Resp createEmployee(EmployeeMasterVO empVo) {
		log.info("==== Inside createEmployee =====");
		try{
			if(empVo!=null){
				MstEmployee employeeMaster = MasterDataUtil.convertEmployeeMasterForCreate(empVo);
				empFacade.create(employeeMaster);
				return new Resp(RespCode.SUCCESS, MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_CREATE_SUCCESS + employeeMaster.getEmpId());
			}else{
				return new Resp(RespCode.FAIL, MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_CREATE_FAILURE);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}	
		
	}
	
	@Transactional
	public Resp updateEmployee(EmployeeMasterVO empVo) {
		log.info("==== Inside updateEmployee =====");
		try{			
			if (empVo != null) {
				if (empVo.getEmpID() != null) {
					MstEmployee empMaster = empFacade.get(empVo.getEmpID());
					if (empMaster != null) {
						MasterDataUtil.convertEmployeeMasterForUpdateAndDelete(empMaster, empVo, true);
						return new Resp(RespCode.SUCCESS,MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_UPDATE_SUCCESS);
					} else {
						return new Resp(RespCode.FAIL,MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_INVALID_ID);						
					}
				} else {
					return new Resp(RespCode.FAIL,MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_BLANK_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,MasterCommonMessages.NO_DATA_FOUND);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}	
	}

	@Transactional
	public Resp blockEmployee(Long empId) {
		log.info("==== Inside blockEmployee =====");
		try{
			if (empId != null) {
				MstEmployee empMaster = empFacade.get(empId);	
				if (empMaster != null) {
					MasterDataUtil.convertEmployeeMasterForUpdateAndDelete(empMaster, null, false);
					return new Resp(RespCode.SUCCESS,MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_DELETE_SUCCESS);
				} else {
					return new Resp(RespCode.FAIL,MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_INVALID_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_BLANK_ID);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}
	}

	@Transactional
	public GetEmployeeMasterResp getAllEmployee() {
		log.info("==== Inside getAllEmployee =====");
		try {			
			List<EmployeeMasterVO> getAllEmpList = new ArrayList<EmployeeMasterVO>();
			List<MstEmployee> getList = empFacade.getAll();	
			if(getList.size()>0){				
				for (MstEmployee vo : getList) {
					EmployeeMasterVO empMasterVO= MasterDataUtil.convertEmployeeMasterForGetData(vo);					
					getAllEmpList.add(empMasterVO);
				}
				return new GetEmployeeMasterResp( new Resp(RespCode.SUCCESS, MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_GET_SUCCESS), getAllEmpList);
			}else{
				return new GetEmployeeMasterResp( new Resp(RespCode.FAIL, MasterCommonMessages.EMPLOYEE_MASTER_SERVICE_GET_FAILURE));	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return new GetEmployeeMasterResp( new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE));
		}
	}

	@Transactional
	public Resp createItem(ItemMasterVO vo) {
		log.info("==== Inside createItem =====");
		try{			
			if (vo != null) {
				ItemMaster itemMaster =	MasterDataUtil.converItemMasterForCreate(vo);
				itemFacade.create(itemMaster);			
				return new Resp(RespCode.SUCCESS, MasterCommonMessages.ITEM_MASTER_SERVICE_CREATE_SUCCESS + itemMaster.getItemcode());				
			} else {
				return new Resp(RespCode.FAIL, MasterCommonMessages.ITEM_MASTER_SERVICE_CREATE_FAILURE);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}		
	}

	@Transactional
	public GetItemMasterResp getAllItemMasterDtl() {
		log.info("==== Inside getAllItemMasterDtl =====");
		try {			
			List<ItemMasterVO> getAllItemList = new ArrayList<ItemMasterVO>();
			List<ItemMaster> getList = itemFacade.getAll();	
			if(getList.size()>0){				
				for (ItemMaster vo : getList) {
					ItemMasterVO itemMasterVO= MasterDataUtil.convertItemMasterForGetData(vo);					
					getAllItemList.add(itemMasterVO);
				}
				return new GetItemMasterResp( new Resp(RespCode.SUCCESS, MasterCommonMessages.ITEM_MASTER_SERVICE_GET_SUCCESS), getAllItemList);
			}else{
				return new GetItemMasterResp( new Resp(RespCode.FAIL, MasterCommonMessages.ITEM_MASTER_SERVICE_GET_FAILURE));	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return new GetItemMasterResp( new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE));
		}
	}

	@Transactional
	public Resp updateItem(ItemMasterVO itemMasterVO) {
		log.info("==== Inside updateItem =====");
		try{			
			if (itemMasterVO != null) {
				if (itemMasterVO.getItemId() != null) {
					ItemMaster itemMaster = itemFacade.get(itemMasterVO.getItemId());
					if (itemMaster != null) {
						MasterDataUtil.convertItemMasterForUpdateAndDelete(itemMaster, itemMasterVO, true);
						return new Resp(RespCode.SUCCESS,MasterCommonMessages.ITEM_MASTER_SERVICE_UPDATE_SUCCESS);
					} else {
						return new Resp(RespCode.FAIL,MasterCommonMessages.ITEM_MASTER_SERVICE_INVALID_ID);						
					}
				} else {
					return new Resp(RespCode.FAIL,MasterCommonMessages.ITEM_MASTER_SERVICE_BLANK_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,MasterCommonMessages.NO_DATA_FOUND);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}		
	}

	@Transactional
	public Resp blockItem(Long itemId) {	
		log.info("==== Inside blockItem =====");
		try{
			if (itemId != null) {
				ItemMaster itemMaster = itemFacade.get(itemId);				
				if (itemMaster != null) {
					MasterDataUtil.convertItemMasterForUpdateAndDelete(itemMaster, null, false);
					return new Resp(RespCode.SUCCESS,MasterCommonMessages.ITEM_MASTER_SERVICE_DELETE_SUCCESS);
				} else {
					return new Resp(RespCode.FAIL,MasterCommonMessages.ITEM_MASTER_SERVICE_INVALID_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,MasterCommonMessages.ITEM_MASTER_SERVICE_BLANK_ID);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}
	}

	@Transactional
	public Resp createRetailer(RetailerVO vo) {
		log.info("==== Inside createRetailer =====");
		try{			
			if (vo != null ) {
				if(vo.getAreaVO()!=null){
					AreaMaster areaMaster = areaFacade.get(vo.getAreaVO().getAreaID());
					if(areaMaster!=null){
						RetailerMaster retailerMaster =	MasterDataUtil.convertRetailerForCreate(vo, areaMaster);
						retailerFacade.create(retailerMaster);
						return new Resp(RespCode.SUCCESS, MasterCommonMessages.RETAILER_CREATE_SUCCESS + retailerMaster.getRetailerID());
					}else{
						return new Resp(RespCode.FAIL, MasterCommonMessages.RETAILER_AREA_ID_BLANK);
					}
				}else{
					return new Resp(RespCode.FAIL, MasterCommonMessages.RETAILER_AREA_ID_BLANK);
				}
												
			} else {
				return new Resp(RespCode.FAIL, MasterCommonMessages.RETAILER_CREATE_FAILURE);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}		
	}

	@Transactional
	public Resp updateRetailer(RetailerVO vo) {
		log.info("==== Inside updateRetailer =====");
		try{			
			if (vo != null) {
				if (vo.getRetailerID()!= null) {
					RetailerMaster retailermaster = retailerFacade.get(vo.getRetailerID());		
					if (retailermaster != null) {
						AreaMaster areaMaster;
						if(vo.getAreaVO().getAreaID()!=null){
							areaMaster = areaFacade.get(vo.getAreaVO().getAreaID());
						}else{
							areaMaster= retailermaster.getAreaMaster();
						}
						MasterDataUtil.convertRetailerMasterForUpdateAndDelete(retailermaster, vo, true , areaMaster);
						return new Resp(RespCode.SUCCESS,MasterCommonMessages.RETAILER_UPDATE_SUCCESS);
					} else {
						return new Resp(RespCode.FAIL,MasterCommonMessages.RETAILER_INVALID_ID);						
					}
				} else {
					return new Resp(RespCode.FAIL,MasterCommonMessages.RETAILER_BLANK_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,MasterCommonMessages.NO_DATA_FOUND);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}		
	}

	@Transactional
	public Resp blockRetailer(Long id) {
		log.info("==== Inside blockRetailer =====");
		try{
			if (id != null) {
				RetailerMaster retailermaster = retailerFacade.get(id);				
				if (retailermaster != null) {
					MasterDataUtil.convertRetailerMasterForUpdateAndDelete(retailermaster, null, false,null);
					return new Resp(RespCode.SUCCESS,MasterCommonMessages.RETAILER_DELETE_SUCCESS);
				} else {
					return new Resp(RespCode.FAIL,MasterCommonMessages.RETAILER_DELETE_FAILURE);
				}
			} else {
				return new Resp(RespCode.FAIL,MasterCommonMessages.RETAILER_BLANK_ID);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE);
		}
	}

	@Transactional
	public GetRetailerResp getRetailerDtl() {
		log.info("==== Inside getRetailerDtl =====");
		try {			
			List<RetailerVO> getRetailerList = new ArrayList<RetailerVO>();
			List<RetailerMaster> getList = retailerFacade.getAll();				
			if(getList.size()>0){				
				for (RetailerMaster vo : getList) {
					RetailerVO retailervo= MasterDataUtil.convertRetailerForGetData(vo);					
					getRetailerList.add(retailervo);
				}
				return new GetRetailerResp( new Resp(RespCode.SUCCESS, MasterCommonMessages.RETAILER_GET_SUCCESS), getRetailerList);
			}else{
				return new GetRetailerResp( new Resp(RespCode.FAIL, MasterCommonMessages.RETAILER_GET_FAILURE));	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return new GetRetailerResp( new Resp(RespCode.FAIL, MasterCommonMessages.EXCEPTION_MESSAGE));
		}
	}

	@Transactional
	public Resp authenticateUser(EmployeeMasterVO vo) {
		log.info("==== Inside authenticateUser =====");		
		try {
			if (vo.getEmpCode() != null) {
				if (vo.getPassword() != null) {
					MstEmployee empMaster = empFacade.getEmployee(vo.getEmpCode());
					if(empMaster!=null){
						if(empMaster.getPassword().equals(vo.getPassword())){
							return new Resp(RespCode.SUCCESS,MasterCommonMessages.SUCCESS_AUTHENTICATION);
						}else{
							return new Resp(RespCode.FAIL,MasterCommonMessages.INVALID_AUTHENTICATION);
						}						
					}else{
						return new Resp(RespCode.FAIL,MasterCommonMessages.INVALID_EMP_CODE);	
					}					
				} else {
					return new Resp(RespCode.FAIL,MasterCommonMessages.PASSWORD_BLANK);
				}
			} else {
				return new Resp(RespCode.FAIL,MasterCommonMessages.EMP_CODE_BLANK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Resp(RespCode.FAIL,	MasterCommonMessages.EXCEPTION_MESSAGE);
		}
	}
}
