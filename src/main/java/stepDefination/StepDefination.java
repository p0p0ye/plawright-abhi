package stepDefination;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;
import com.microsoft.playwright.Page;

import GroupPages.AddCustomerOnboarding;
import GroupPages.AddDetails;
import GroupPages.BDBLogin;
//import ut.ExcelDatabase;
import util.CustomAssert;
import util.ExcelDatabase;
import util.GenericMethods;

public class StepDefination extends GenericMethods {

	String dbConnectionSheetName = "DatabaseLogin";
	String puttyLoginSheetName = "PuttyLogin";
	static String party = "";

	public static String getParty() {
		return party;
	}

	public static void setParty(String party) {
		StepDefination.party = party;
	}

	ExcelDatabase excelDatabase = new ExcelDatabase();

	public StepDefination(WebDriver driver) {
		super(driver);

	}
	public StepDefination(Page page) {
		super(page);

	}
	

// Raj New 
	public void bdbLogin(Page page, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		BDBLogin bdbLogin = new BDBLogin(page);
		bdbLogin.fillAndSubmitNewBDBLogin(page, testScenarioID, workbook, conn, stepGroup, customAssert);
	}

	public void onboarding(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		AddCustomerOnboarding onboarding = new AddCustomerOnboarding(driver);
		onboarding.fillAndSubmitNewAddCustomerOnboarding(driver, testScenarioID, workbook, conn, stepGroup,
				customAssert);
	}

	public void AddrDetails(WebDriver driver, String testScenarioID, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		AddDetails AddressDetails = new AddDetails(driver);
		AddressDetails.fillAndSubmitNewAddDetails(driver, testScenarioID, workbook, conn, stepGroup, customAssert);
	}

}