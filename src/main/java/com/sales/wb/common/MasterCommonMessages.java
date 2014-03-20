package com.sales.wb.common;


/**
 * This static class holds inner classes which simply maps constants
 * to attribute keys, so we don't have strings floating around all
 * over the place.
 *
 * Also, this gives us a single place to document the various attributes.
* @author Kruti Jani
*/
public class MasterCommonMessages {

	public static final String EXCEPTION_MESSAGE = "Exception";
	public static final String NO_DATA_FOUND = "No Data Found !";

	/*  MasterService MasterCommonMessages related to Item */
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
	
	/* MasterService MasterCommonMessages related to Employee */
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
	
	/* MasterService MasterCommonMessages related to Payment */
	public static final String PAYMENT_MODE_GET_SUCCESS="Payment Mode data retrived succesfully !";
	public static final String PAYMENT_MODE_GET_FAILURE="No Payment Mode Data Found.";
	
	/* MasterService MasterCommonMessages related to Company*/
	public static final String COMPANY_DETAIILS_GET_SUCCESS="Company data retrived succesfully !";
	public static final String COMPANY_DETAIILS_GET_FAILURE="No Company Data Found.";

	/*MasterService MasterCommonMessages related to BillBook*/
	public static final String BILL_BOOK_GET_SUCCESS="Bill Book data retrived succesfully !";
	public static final String BILL_BOOK_GET_FAILURE="No Bill Book Data Found.";
	
	public static final String BILL_BOOK_SERVICE_CREATE_SUCCESS = "Bill Book saved Successfully ! Bill Book Number is ";
	public static final String BILL_BOOK_SERVICE_CREATE_FAILURE= "Bill Book not saved properly. Please try again.";	
	
	public static final String BILL_BOOK_SERVICE_UPDATE_SUCCESS = "Bill Book updated Successfully !";
	public static final String BILL_BOOK_SERVICE_UPDATE_FAILURE = "Bill Book not updated properly. Please try again.";	
	
	public static final String BILL_BOOK_SERVICE_INVALID_ID="Invalid Bill Book ID !";
	public static final String BILL_BOOK_SERVICE_BLANK_ID="No Bill Book ID Found!";

	/* MasterService MasterCommonMessages related to Area Master*/
	public static final String AREA_GET_SUCCESS="Area data retrived succesfully !";
	public static final String AREA_GET_FAILURE="No Area Data Found.";
	
	public static final String AREA_CREATE_SUCCESS = "Area saved Successfully ! Area Number is ";
	public static final String AREA_CREATE_FAILURE= "Area not saved properly. Please try again.";	
	
	public static final String AREA_UPDATE_SUCCESS = "Area updated Successfully !";
	public static final String AREA_UPDATE_FAILURE = "Area not updated properly. Please try again.";	

	public static final String AREA_INVALID_ID="Invalid Area ID !";
	public static final String AREA_BLANK_ID="No Area ID Found!";
	
	/* MasterService MasterCommonMessages related to Retailer Master*/
	public static final String RETAILER_GET_SUCCESS="Retailer data retrived succesfully !";
	public static final String RETAILER_GET_FAILURE="No Retailer Data Found.";
	
	public static final String RETAILER_CREATE_SUCCESS = "Retailer saved Successfully ! Retailer Id is ";
	public static final String RETAILER_CREATE_FAILURE= "Retailer not saved properly. Please try again.";	
	
	public static final String RETAILER_UPDATE_SUCCESS = "Retailer updated Successfully !";
	public static final String RETAILER_UPDATE_FAILURE = "Retailer not updated properly. Please try again.";	

	public static final String RETAILER_DELETE_SUCCESS = "Retailer deleted Successfully !";
	public static final String RETAILER_DELETE_FAILURE = "Retailer not deleted properly. Please try again.";
	
	public static final String RETAILER_INVALID_ID="Invalid Retailer ID !";
	public static final String RETAILER_BLANK_ID="No Retailer ID Found!";
	public static final String RETAILER_AREA_ID_BLANK="No Area Found to mapped with Retailer!";
	
	/* MasterService MasterCommonMessages related to Authenticate User*/
	public static final String INVALID_EMP_CODE="Invalid Employee Code!";
	public static final String EMP_CODE_BLANK="Blank Employee Code!";
	public static final String PASSWORD_BLANK="Blank Password.";
	public static final String INVALID_AUTHENTICATION="Invalid Employee Code or Password.";
	public static final String SUCCESS_AUTHENTICATION="Login Successful.";
	

}
