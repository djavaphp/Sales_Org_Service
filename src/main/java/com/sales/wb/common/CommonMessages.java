package com.sales.wb.common;


/**
 * This static class holds inner classes which simply maps constants
 * to attribute keys, so we don't have strings floating around all
 * over the place.
 *
 * Also, this gives us a single place to document the various attributes.
* @author Kruti Jani
*/
public class CommonMessages {

	public static final String EXCEPTION_MESSAGE = "Exception";
	public static final String NO_DATA_FOUND = "No Data Found !";

	/* ItemMasterService CommonMessages */
	public static final String ITEM_MASTER_SERVICE_CREATE_SUCCESS = "Item saved Successfully ! Item Code is ";
	public static final String ITEM_MASTER_SERVICE_CREATE_FAILURE = "Item not saved properly. Please try again.";

	public static final String ITEM_MASTER_SERVICE_UPDATE_SUCCESS = "Item updated Successfully !";
	public static final String ITEM_MASTER_SERVICE_UPDATE_FAILURE = "Item not updated properly. Please try again.";
	

	public static final String ITEM_MASTER_SERVICE_DELETE_SUCCESS = "Item deleted Successfully !";
	public static final String ITEM_MASTER_SERVICE_DELETE_FAILURE = "Item not deleted properly. Please try again.";
	

	public static final String ITEM_MASTER_SERVICE_GET_SUCCESS = "Item Data Retrived Successfully";
	public static final String ITEM_MASTER_SERVICE_GET_FAILURE = "Not able to retrive Item Data. Please try again.";
	
	public static final String ITEM_MASTER_SERVICE_INVALID_ID="Invalid Item ID !";
	public static final String ITEM_MASTER_SERVICE_BLANK_ID="No Item ID Found!";
	
	/* EmployeeMasterService CommonMessages */
	public static final String EMPLOYEE_MASTER_SERVICE_CREATE_SUCCESS = "Employee saved Successfully ! Employee Code is ";
	public static final String EMPLOYEE_MASTER_SERVICE_CREATE_FAILURE= "Employee not saved properly. Please try again.";
	
	
	public static final String EMPLOYEE_MASTER_SERVICE_UPDATE_SUCCESS = "Employee updated Successfully !";
	public static final String EMPLOYEE_MASTER_SERVICE_UPDATE_FAILURE = "Employee not updated properly. Please try again.";
	

	public static final String EMPLOYEE_MASTER_SERVICE_DELETE_SUCCESS = "Employee deleted Successfully !";
	public static final String EMPLOYEE_MASTER_SERVICE_DELETE_FAILURE = "Employee not deleted properly. Please try again.";
	

	public static final String EMPLOYEE_MASTER_SERVICE_GET_SUCCESS = "Employee Data Retrived Successfully";
	public static final String EMPLOYEE_MASTER_SERVICE_GET_FAILURE = "Not able to retrive Employee Data. Please try again.";
	
	public static final String EMPLOYEE_MASTER_SERVICE_INVALID_ID="Invalid Employee ID !";
	public static final String EMPLOYEE_MASTER_SERVICE_BLANK_ID="No Employee ID Found!";
	
	/* CommonService CommonMessages */
	public static final String PAYMENT_MODE_GET_SUCCESS="Payment Mode data retrived succesfully !";
	public static final String PAYMENT_MODE_GET_FAILURE="No Payment Mode Data Found.";
	
	/* CommonService CommonMessages */
	public static final String COMPANY_DETAIILS_GET_SUCCESS="Company data retrived succesfully !";
	public static final String COMPANY_DETAIILS_GET_FAILURE="No Company Data Found.";

}
