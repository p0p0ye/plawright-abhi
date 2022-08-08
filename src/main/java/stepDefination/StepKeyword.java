package stepDefination;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;
import com.microsoft.playwright.Page;

import util.CustomAssert;

public class StepKeyword extends StepDefination {
	public StepKeyword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public StepKeyword(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public void executeTestStep(Page page, String testScenarioID, String step, String stepGroup, String GSTNID,
			String ReturnType, XSSFWorkbook workbook, Connection conn, CustomAssert customAssert) throws Exception {
		switch (step) {
	
		
		// Raj New 22-06-2022
		case "Login_Into_NewBDB":
			bdbLogin(page, testScenarioID, workbook, conn, stepGroup, customAssert);
			break;
		}
	}

}
