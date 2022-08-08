package GroupPages;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;

public class AddCustomerOnboarding extends GenericMethods {


	// AddCustomerOnboarding
	private By Customer_Type_DropDown = By.xpath("//select[@id='cust_custidentification_l_clientType']");
	private By Customer_Sub_TypeDropDown = By.xpath("//select[@id='cust_custidentification_l_clientSubType']");
	private By Classification_DropDown = By.xpath("//select[@id='cust_custClassification']");
	private By Date_Of_Birth_Or_Incorporation_Date = By.xpath("//input[@id='cust_custidentification_l_dateOfBirthEng']");
	private By Primary_ID_Type = By.xpath("//select[@id='cust_custidentification_l_idType']");
	private By Primary_ID_Reference = By.xpath("//input[@id='cust_custidentification_l_idReference']");
	private By Valid_From_Date = By.xpath("//input[@id='cust_custidentification_l_idIssueDate']");
	private By Valid_From_till = By.xpath("//input[@id='cust_custidentification_l_idExpiryDate']");
	private By Country = By.xpath("//select[@id='cust_custidentification_l_issueCountry']");
	private By Registered_Name = By.xpath("//input[@id='cust_custmaindetails_c_customerTradingName']");
	private By Local_Name = By.xpath("//input[@id='cust_custmaindetails_c_businessName']");
	private By Validate_Button = By.xpath("//button[@id='cust_custidentification_l_validateId']");


	WebDriverWait wait;

	public AddCustomerOnboarding(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2);

	}
	public void fillAndSubmitNewAddCustomerOnboarding(WebDriver driver, String testCaseName, XSSFWorkbook workbook,
			Connection conn, String stepGroup, CustomAssert customAssert) throws Exception {

		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName, stepGroup);

		Reporter.log("<B>Traverse To Customer On Boarding</B>");
		System.out.println("<<enter>>");

		switchtodefaultframe(driver);
		switchtoframe(driver, "frame-1-2");
		selectFromDropdownByVisibleText(Customer_Type_DropDown, dataRow.getProperty("CustomerType"), "CustomerType");
		selectFromDropdownByVisibleText(Customer_Sub_TypeDropDown, dataRow.getProperty("CustomerSubType"), "CustomerSubType");
		selectFromDropdownByVisibleText(Classification_DropDown, dataRow.getProperty("CustomerType"), "Classification_DropDown");
		clearAndSenKeys(Date_Of_Birth_Or_Incorporation_Date, dataRow.getProperty("DateOfBirth"), "DateOfBirth");
		selectFromDropdownByVisibleText(Primary_ID_Type, dataRow.getProperty("PrimaryIdType"), "PrimaryIdType");
		clearAndSenKeys(Primary_ID_Reference, getRndNumber(), "PrimaryIdRef");
		clearAndSenKeys(Valid_From_Date, dataRow.getProperty("ValidFrom"), "ValidFrom");
		clearAndSenKeys(Valid_From_till, dataRow.getProperty("ValidTill"), "ValidTill");
		selectFromDropdownByVisibleText(Country, dataRow.getProperty("IssueCountry"), "IssueCountry");
		clearAndSenKeys(Registered_Name, dataRow.getProperty("RegName"), "RegName");
		clearAndSenKeys(Local_Name, dataRow.getProperty("RegNameLocal"), "RegNameLocal");
		click(Validate_Button, "Validate_Button");
	}

}