package com.sales.wb.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.sales.wb.common.Resp;
import com.sales.wb.service.vo.GetAllBillBookDtlResp;
import com.sales.wb.service.vo.GetAreaDtlResp;
import com.sales.wb.service.vo.GetCompanyResp;
import com.sales.wb.service.vo.GetEmployeeMasterResp;
import com.sales.wb.service.vo.GetItemMasterResp;
import com.sales.wb.service.vo.GetPaymentModeResp;
import com.sales.wb.service.vo.GetRetailerResp;
import com.sales.wb.vo.AreaVO;
import com.sales.wb.vo.BillBookVo;
import com.sales.wb.vo.EmployeeMasterVO;
import com.sales.wb.vo.ItemMasterVO;
import com.sales.wb.vo.RetailerVO;

/**
* ALL the Common Master Services : PaymentMode , Company , BillBook , Area , Employee , Item , Retailer
* @author Kruti Jani Last modified : 10-03-2014 
*/
@WebService
@Service
public interface MasterService {
	public GetPaymentModeResp getAllPaymentModes();
	public GetCompanyResp getCompanyDetail();
	public Resp createBillBook(BillBookVo vo);
	public Resp updateBillbook(BillBookVo vo);
	public GetAllBillBookDtlResp getAllBillBookdtl();	
	public Resp createArea(AreaVO vo);
	public Resp updateArea(AreaVO vo);
	public GetAreaDtlResp getAreaMasterDtl();
	public Resp createEmployee(EmployeeMasterVO empVo);
	public Resp updateEmployee(EmployeeMasterVO empVo);
	public Resp blockEmployee(Long empId);
	public GetEmployeeMasterResp getAllEmployee();
	public Resp createItem(ItemMasterVO itemMasterVO);	
	public Resp updateItem(ItemMasterVO itemMasterVO);
	public Resp blockItem(Long itemId);
	public GetItemMasterResp getAllItemMasterDtl();
	public Resp createRetailer(RetailerVO vo);
	public Resp updateRetailer(RetailerVO vo);
	public Resp blockRetailer(Long id);
	public GetRetailerResp getRetailerDtl();	
}
