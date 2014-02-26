package com.sales.wb.service;

import javax.jws.WebService;
import org.springframework.stereotype.Service;
import com.sales.wb.common.Resp;
import com.sales.wb.service.vo.GetEmployeeMasterResp;
import com.sales.wb.vo.EmployeeMasterVO;

/**
*
* @author Kruti Jani
*/
@WebService
@Service
public interface EmployeeMasterService {
	public Resp createEmployee(EmployeeMasterVO empVo);
	public Resp updateEmployee(EmployeeMasterVO empVo);
	public Resp blockEmployee(Long empId);
	public GetEmployeeMasterResp getAllEmployee();

}
