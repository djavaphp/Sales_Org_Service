package com.sales.wb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.wb.common.CommonMessages;
import com.sales.wb.common.Resp;
import com.sales.wb.common.RespCode;
import com.sales.wb.entity.BillBookMaster;
import com.sales.wb.entity.CompanyMaster;
import com.sales.wb.facade.BillBookFacade;
import com.sales.wb.facade.CompanyFacade;
import com.sales.wb.service.CommonService;
import com.sales.wb.service.vo.GetAllBillBookDtlResp;
import com.sales.wb.service.vo.GetCompanyResp;
import com.sales.wb.service.vo.GetPaymentModeResp;
import com.sales.wb.utils.MasterDataUtil;
import com.sales.wb.vo.BillBookVo;
import com.sales.wb.vo.CompanyVo;
import com.sales.wb.vo.PaymentModeVo;
/**
 * 
 * @author Kruti Jani
 */
@Service
public class CommonServiceImp implements CommonService{

	@Autowired
	private CompanyFacade companyFacade;
	
	@Autowired
	private BillBookFacade billBookFacade;
	
	public GetPaymentModeResp getAllPaymentModes() {
		try{
			List<PaymentModeVo> list= MasterDataUtil.converPaymentMode();			
			if(list.size()>0){
				return new GetPaymentModeResp(new Resp(RespCode.SUCCESS, CommonMessages.PAYMENT_MODE_GET_SUCCESS),list);
			}else{
				return new GetPaymentModeResp(new Resp(RespCode.FAIL, CommonMessages.PAYMENT_MODE_GET_FAILURE));
			}
		}catch(Exception e){
			e.printStackTrace();
			return new GetPaymentModeResp(new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE));
		}		
	}
	
	@Transactional
	public GetCompanyResp getCompanyDetail(){
		try{
			List<CompanyVo> list=new ArrayList<CompanyVo>();
			List<CompanyMaster> companylist= companyFacade.getAll();			
			if(companylist.size()>0){
				for(CompanyMaster vo : companylist){
					CompanyVo companyVo = MasterDataUtil.converCompanyDtl(vo);
					list.add(companyVo);
				}
				return new GetCompanyResp(new Resp(RespCode.SUCCESS, CommonMessages.COMPANY_DETAIILS_GET_SUCCESS),list);
			}else{
				return new GetCompanyResp(new Resp(RespCode.FAIL, CommonMessages.COMPANY_DETAIILS_GET_FAILURE));
			}
		}catch(Exception e){
			e.printStackTrace();
			return new GetCompanyResp(new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE));
		}	
	}

	@Transactional
	public Resp createBillBook(BillBookVo vo) {
		try{
			if(vo!=null){				
				BillBookMaster billbook = MasterDataUtil.convertBillBookForCreate(vo);
				billBookFacade.create(billbook);
				return new Resp(RespCode.SUCCESS, CommonMessages.BILL_BOOK_SERVICE_CREATE_SUCCESS + billbook.getBillBookNumber());
			}else{
				return new Resp(RespCode.FAIL, CommonMessages.BILL_BOOK_SERVICE_CREATE_FAILURE);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE);
		}	
		
	}

	@Transactional
	public Resp updateBillbook(BillBookVo vo) {
		try{			
			if (vo != null) {
				if (vo.getBillBookId() != null) {
					BillBookMaster billbookmaster = billBookFacade.get(vo.getBillBookId());
					if (billbookmaster != null) {
						MasterDataUtil.convertBillBookMasterForUpdate(billbookmaster, vo);
						return new Resp(RespCode.SUCCESS,CommonMessages.BILL_BOOK_SERVICE_UPDATE_SUCCESS);
					} else {
						return new Resp(RespCode.FAIL,CommonMessages.BILL_BOOK_SERVICE_INVALID_ID);						
					}
				} else {
					return new Resp(RespCode.FAIL,CommonMessages.BILL_BOOK_SERVICE_BLANK_ID);
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
	public GetAllBillBookDtlResp getAllBillBookdtl() {
		try {			
			List<BillBookVo> getAllBillbookdata = new ArrayList<BillBookVo>();
			List<BillBookMaster> getList = billBookFacade.getAll();	
			if(getList.size()>0){				
				for (BillBookMaster vo : getList) {
					BillBookVo billbookvo= MasterDataUtil.convertBillBookForGetData(vo);					
					getAllBillbookdata.add(billbookvo);
				}
				return new GetAllBillBookDtlResp( new Resp(RespCode.SUCCESS, CommonMessages.BILL_BOOK_GET_SUCCESS), getAllBillbookdata);
			}else{
				return new GetAllBillBookDtlResp( new Resp(RespCode.FAIL, CommonMessages.BILL_BOOK_GET_FAILURE));	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return new GetAllBillBookDtlResp( new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE));
		}
	}

	
}
