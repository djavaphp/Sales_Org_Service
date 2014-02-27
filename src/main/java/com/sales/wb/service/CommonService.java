package com.sales.wb.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.sales.wb.service.vo.GetPaymentModeResp;

/**
* ALL the commonServices 
* @author Kruti Jani
*/
@WebService
@Service
public interface CommonService {
	public GetPaymentModeResp getAllPaymentModes();
}
