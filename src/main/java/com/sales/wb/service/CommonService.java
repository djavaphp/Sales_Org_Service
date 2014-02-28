package com.sales.wb.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.sales.wb.common.Resp;
import com.sales.wb.service.vo.GetAllBillBookDtlResp;
import com.sales.wb.service.vo.GetCompanyResp;
import com.sales.wb.service.vo.GetPaymentModeResp;
import com.sales.wb.vo.BillBookVo;

/**
* ALL the commonServices : PaymentMode , CompanyMaster , BillBookMaster
* @author Kruti Jani
*/
@WebService
@Service
public interface CommonService {
	public GetPaymentModeResp getAllPaymentModes();
	public GetCompanyResp getCompanyDetail();
	public Resp createBillBook(BillBookVo vo);
	public Resp updateBillbook(BillBookVo vo);
	public GetAllBillBookDtlResp getAllBillBookdtl();	
}
