package com.sales.wb.service.imp;

import java.util.List;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.sales.wb.common.CommonMessages;
import com.sales.wb.common.Resp;
import com.sales.wb.common.RespCode;
import com.sales.wb.service.CommonService;
import com.sales.wb.service.vo.GetPaymentModeResp;
import com.sales.wb.utils.MasterDataUtil;
import com.sales.wb.vo.PaymentModeVo;
/**
 * 
 * @author Kruti Jani
 */
@WebService
@Service
public class CommonServiceImp implements CommonService{

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

}
