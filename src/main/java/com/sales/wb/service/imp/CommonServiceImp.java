package com.sales.wb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.wb.common.CommonMessages;
import com.sales.wb.common.Resp;
import com.sales.wb.common.RespCode;
import com.sales.wb.entity.CompanyMaster;
import com.sales.wb.facade.CompanyFacade;
import com.sales.wb.service.CommonService;
import com.sales.wb.service.vo.GetCompanyResp;
import com.sales.wb.service.vo.GetPaymentModeResp;
import com.sales.wb.utils.MasterDataUtil;
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
}
