package com.sales.wb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.wb.common.CommonMessages;
import com.sales.wb.common.Resp;
import com.sales.wb.common.RespCode;
import com.sales.wb.entity.MstEmployee;
import com.sales.wb.facade.EmployeeMasterFacade;
import com.sales.wb.service.EmployeeMasterService;
import com.sales.wb.service.vo.GetEmployeeMasterResp;
import com.sales.wb.utils.MasterDataUtil;
import com.sales.wb.vo.EmployeeMasterVO;

/**
*
* @author Kruti Jani , Feb 26th,2014 
*/
@Service
public class EmployeeMasterServiceImp implements EmployeeMasterService {
	/*AbstractDao is a common interface can not autowire with different bean 
	 * so used orignalbean to implement autowire
	 * @Qualifier can also be implemented if spring ver is 4+
	 * */
	@Autowired	
	private EmployeeMasterFacade empDao;
	
	/*No Hibernate Session bound to thread, and configuration does not allow creation of
	 *  non-transactional one here if we dont implement @Transactional
	 * */
	@Transactional
	public Resp createEmployee(EmployeeMasterVO empVo) {
		try{
			if(empVo!=null){
				MstEmployee employeeMaster = MasterDataUtil.convertEmployeeMasterForCreate(empVo);
				empDao.create(employeeMaster);
				return new Resp(RespCode.SUCCESS, CommonMessages.EMPLOYEE_MASTER_SERVICE_CREATE_SUCCESS + employeeMaster.getEmpId());
			}else{
				return new Resp(RespCode.FAIL, CommonMessages.EMPLOYEE_MASTER_SERVICE_CREATE_FAILURE);
			}			
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE);
		}	
		
	}
	@Transactional
	public Resp updateEmployee(EmployeeMasterVO empVo) {
		try{			
			if (empVo != null) {
				if (empVo.getEmpID() != null) {
					MstEmployee empMaster = empDao.get(empVo.getEmpID());
					if (empMaster != null) {
						MasterDataUtil.convertEmployeeMasterForUpdateAndDelete(empMaster, empVo, true);
						return new Resp(RespCode.SUCCESS,CommonMessages.EMPLOYEE_MASTER_SERVICE_UPDATE_SUCCESS);
					} else {
						return new Resp(RespCode.FAIL,CommonMessages.EMPLOYEE_MASTER_SERVICE_INVALID_ID);						
					}
				} else {
					return new Resp(RespCode.FAIL,CommonMessages.EMPLOYEE_MASTER_SERVICE_BLANK_ID);
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
	public Resp blockEmployee(Long empId) {
		try{
			if (empId != null) {
				MstEmployee empMaster = empDao.get(empId);	
				if (empMaster != null) {
					MasterDataUtil.convertEmployeeMasterForUpdateAndDelete(empMaster, null, false);
					return new Resp(RespCode.SUCCESS,CommonMessages.EMPLOYEE_MASTER_SERVICE_DELETE_SUCCESS);
				} else {
					return new Resp(RespCode.FAIL,CommonMessages.EMPLOYEE_MASTER_SERVICE_INVALID_ID);
				}
			} else {
				return new Resp(RespCode.FAIL,CommonMessages.EMPLOYEE_MASTER_SERVICE_BLANK_ID);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE);
		}
	}

	@Transactional
	public GetEmployeeMasterResp getAllEmployee() {
		try {			
			List<EmployeeMasterVO> getAllEmpList = new ArrayList<EmployeeMasterVO>();
			List<MstEmployee> getList = empDao.getAll();	
			if(getList.size()>0){				
				for (MstEmployee vo : getList) {
					EmployeeMasterVO empMasterVO= MasterDataUtil.convertEmployeeMasterForGetData(vo);					
					getAllEmpList.add(empMasterVO);
				}
				return new GetEmployeeMasterResp( new Resp(RespCode.SUCCESS, CommonMessages.EMPLOYEE_MASTER_SERVICE_GET_SUCCESS), getAllEmpList);
			}else{
				return new GetEmployeeMasterResp( new Resp(RespCode.FAIL, CommonMessages.EMPLOYEE_MASTER_SERVICE_GET_FAILURE));	
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return new GetEmployeeMasterResp( new Resp(RespCode.FAIL, CommonMessages.EXCEPTION_MESSAGE));
		}
	}

	
}
