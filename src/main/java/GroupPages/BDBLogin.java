package GroupPages;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;

import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.LoginUserFromSyncMap;
import util.MapOfUserIDAssignedToAllocation;

public class BDBLogin extends GenericMethods {

	private String iframe = "//iframe[@title='Branch']";
	private String iframe1 = "//iframe[@title='Internal Operations']";
	private String iframe2 = "//iframe[@title='Cancel']";
	private String username = "//input[@id='login-username']";
	private String password = "//input[@id='password']";
	private String Submit = "//span[text()='Login']";
	private String Hamburger = "//div[@title='Click to open drawer']";
	private String Selc_cust = "//i[@class='fa fa-search']";
	private String Category = "//select[@id='crd_crdBranch_l_branchCodecust_searchcustomer_l_customerCategory']";
	private String cust_id = "//input[@id='custid']";
	private String Search_button_sc = "//button[@id='searchButton']";
	private String Customer_ref = "//a[@id='identificationReferenceRow_customerListTableModel1']";
	private String Home_button = "//a[@id='home']";
	private String Loan_service_tile = "//a[@id='appId_95']";
	private String HamBur_Loan = "//i[@class='fa fa-navicon']";
	private String Create_account = "//a[@id='mainContainerloanAccount']";
	private String product_search_icon = "//span[@id='span-loan_createLoanAccount_c_productReference']";
	private String Prodcut_acc_type = "//select[@id='loan_searchProduct_l_accountType']";
	private String radio_button_product = "//input[@id='3Row_productListTable1']";
	private String prod_searc_button = "//button[@id='searchButton']";
	private String prod_searc_select__button = "//button[@id='loan_searchProduct_l_productSearch_selectAndProceed']";
	private String branch_search_icon = "//span[@id='span-loan_createLoan_c_branch']";
	private String branch_id = "//input[@id='rs_searchunit_l_branchID']";
	private String radio_button = "//input[@id='acnt_accountsListQBE_l_selectProductRow_unitsListTable1']";
	private String branch_select = "//button[@id='rs_searchunit_l_fetch']";
	private String application_amount = "//input[@name='applicationAmount.amount']";
	private String purpose_code = "//select[@name='purposeCode']";
	private String Date_of_Sanction = "//input[@name='dateOfSanction']";
	private String sanction_authority = "//select[@id='loan_createLoan_c_sanctionAuthority']";
	private String Loan_Tenure = "//input[@name='loanTenorValue']";
	private String Loan_Tenure_drp = "//select[@id='loan_createLoan_c_loanTenor']";
	private String Repayment_Details = "//a[@id='nav-repaymentDetailsTab']";
	private String moratorium_checkbox = "//input[@name='moratoriumRequired']";
	private String moratoriumType = "//select[@id='loan_createLoanAccount_c_moratoriumType']";
	private String moratoriumValue = "//input[@id='loan_createLoanAccount_c_moratoriumPeriod']";
	private String moratoriumValueDrp = "//select[@id='loan_createLoanAccount_c_moratoriumPeriodFrequency']";
	private String repayment_frequency = "//select[@name='repaymentFrequency']";
	private String repay_day = "//input[@name='repayday']";
	private String Settlement_acc_no = "//input[@name='settlementAccountNumber']";
	private String Submit_repay = "//button[@name='Save']";
	private String landing = "//span[@id='appLanding']";
	private String logout = "//span[@id='logoutAnchor']";
	private String ok = "//button[@id='ok-button']";
	private String aq_tile = "//i[@title='Authorization Queues']";
	private String pool_queue_click = "//a[@id='nav-tblId_poolQueue']";
	private String pool_queue1 = "//a[@id='transactionIdRow_authQueueFromPoolTable1']";
	private String approve_radio = "//*[@id=\"lbl_radio_auth_txn_v_authorizerAction_0'\"]";
	private String aqsubmit = "//button[@id='auth_cd_c_submit']";
	private String quicksearch = "//input[@id='quickSearch']";
	private String qui_search_button = "//button[@id='searchButton']";
	private String advanced_search = "//a[text()='Advanced Search']";
	private String advn_cust_fer = "//input[@id='portfolioReference']";
	private String adv_searc_button = "//button[@id='retainSearch']";

	public BDBLogin(Page page) {
		super(page);

	}

	public void fillAndSubmitNewBDBLogin(Page page, String testCaseName, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		System.out.println("In BDB");

		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, "LoginPage", testCaseName, stepGroup);
		String user = LoginUserFromSyncMap.userIDForLogin(MapOfUserIDAssignedToAllocation.listOfUserIDForExecution,
				testCaseName);

		Reporter.log("<B>Traverse To Customer On Boarding</B>");
		fill(username, dataRow.getProperty("UserName"));
		fill(password, dataRow.getProperty("Password"));
		clickp(Submit, "Login Button");
		clickp(Hamburger, "ClicKed Hambuger");
		clickp(Selc_cust, "ClicKed Customer refrence");

		// page change to customer search
		selectfromDropdownp(Category, dataRow.getProperty("Select_DrpDwn_Category"));
		fill(cust_id, dataRow.getProperty("Customer_id"));
		clickp(Search_button_sc, "ClicKed Search");
		clickp(Customer_ref, "ClicKed customer ref");

		// page change Home
		
		Thread.sleep(3000);
		frameSwitchClick("//iframe[@title='Branch']", Home_button);
		frameSwitchClick(iframe, Loan_service_tile);
		frameSwitchClick(iframe, HamBur_Loan);
		frameSwitchClick(iframe, Create_account);

		// page change Home
		frameSwitchClick(iframe, product_search_icon);
		frameSwitchClick(iframe, Prodcut_acc_type);
		frameSwitchselectfromDropdownp(iframe, Prodcut_acc_type, dataRow.getProperty("Select_DrpDwn_CategoryAcc"));
		frameSwitchClick(iframe, prod_searc_button);
		frameSwitchClick(iframe, radio_button_product);
		frameSwitchClick(iframe, prod_searc_select__button);

		// branch details

		frameSwitchClick(iframe, branch_search_icon);
		frameSwitchClick(iframe, branch_id);
		frameSwitchFill(iframe, branch_id, dataRow.getProperty("ranch_id"));
		frameSwitchClick(iframe, radio_button);
		frameSwitchClick(iframe, branch_select);
		frameSwitchFill(iframe, application_amount, dataRow.getProperty("application_amt"));
		frameSwitchselectfromDropdownp(iframe, purpose_code, dataRow.getProperty("purpose_code"));
		frameSwitchFill(iframe, Loan_Tenure, dataRow.getProperty("loan_tenure"));
		frameSwitchselectfromDropdownp(iframe, Loan_Tenure_drp, dataRow.getProperty("loan_tenure_years"));

		// Repayments Details
		frameSwitchClick(iframe, Repayment_Details);
		frameSwitchClick(iframe, Repayment_Details);
		frameSwitchClick(iframe, moratorium_checkbox);
		frameSwitchselectfromDropdownp(iframe, moratoriumType, dataRow.getProperty("moratorium_type"));
		frameSwitchFill(iframe, moratoriumValue, dataRow.getProperty("moratoriumValue"));
		frameSwitchselectfromDropdownp(iframe, moratoriumValueDrp, dataRow.getProperty("moratoriumValue_Time"));
		frameSwitchselectfromDropdownp(iframe, repayment_frequency, dataRow.getProperty("repayment_Frequency"));
		frameSwitchFill(iframe, repay_day, dataRow.getProperty("repayDay"));
		frameSwitchFill(iframe, Settlement_acc_no, dataRow.getProperty("settlementAccountNumber"));
		frameSwitchClick(iframe, Submit_repay);
	//	System.out.print(readTextPlaywright("//*[@id='user-action-error-container']/ul/li"));
		frameSwitchClick(iframe, ok);
		clickp(logout, ".");

		// Checker;
		fill(username, dataRow.getProperty("UserName1"));
		fill(password, dataRow.getProperty("Password"));
		clickp(Submit, "Login Button");
		
		// Authorization Queue
		frameSwitchClick(iframe1, aq_tile);
		frameSwitchClick(iframe1, pool_queue_click);

		frameSwitchClick(iframe1, advanced_search);
		frameSwitchFill(iframe1, advn_cust_fer, dataRow.getProperty("Customer_id"));
		frameSwitchClick(iframe1, adv_searc_button);

		frameSwitchClick(iframe1, pool_queue1);
		frameSwitchClick(iframe1, approve_radio);
		frameSwitchClick(iframe1, aqsubmit);
		frameSwitchClick(iframe1, ok);
		clickp(logout, ".");
        // last checker
		fill(username, dataRow.getProperty("UserName"));
		fill(password, dataRow.getProperty("Password"));
		clickp(Submit, "Login Button");
		clickp(Hamburger, "ClicKed Hambuger");
		clickp(Selc_cust, "ClicKed Customer refrence");

		// page change to customer search
		selectfromDropdownp(Category, dataRow.getProperty("Select_DrpDwn_Category"));
		fill(cust_id, dataRow.getProperty("Customer_id"));
		clickp(Search_button_sc, "ClicKed Search");
		clickp(Customer_ref, "ClicKed customer ref");

		// page change Home
		Thread.sleep(3000);
		frameSwitchClick("//iframe[@title='Branch']", Home_button);
		frameSwitchClick("//iframe[@title='Branch']", Home_button);
		frameSwitchClick(iframe, Loan_service_tile);
		frameSwitchClick(iframe, "//button[@id='searchButton']");
		frameSwitchClick(iframe, "//a[@id='1Row_LoanAccountListTable1']");
		frameSwitchClick(iframe, "//a[@id='div-vertical-menu-tran-conmenu3']");
		clickp(logout, ".");
		
		
		fill(username, dataRow.getProperty("UserName1"));
		fill(password, dataRow.getProperty("Password"));
		clickp(Submit, "Login Button");
	
		frameSwitchClick(iframe1, "//a[@id='appId_89']");
		//closewindow();
	}

}
