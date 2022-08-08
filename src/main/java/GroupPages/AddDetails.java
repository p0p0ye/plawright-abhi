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

public class AddDetails extends GenericMethods {

	private By AddButton = By.xpath("//i[@class='fa fa-plus row-operation row-add']");

	private By Local_lang_add = By.xpath("//select[@id='cust_communicationDetails_c_languageselector']");

	private By Add_type = By.xpath("//select[@id='cust_communicationDetails_c_addressType']");

	private By Postal_code = By.xpath("//input[@id='cust_custmaindetails_c_zipCode_text']");

	private By Country = By.xpath("//select[@id='cust_communicationDetails_c_countryCode']");

	private By State = By.xpath("//input[@id='cust_communicationDetails_c_addressLine3']");

	private By Add_line_1 = By.xpath("//input[@id='cust_communicationDetails_c_mailBox']");

	private By Add_line_2 = By.xpath("//input[@id='cust_communicationDetails_c_streetName']");

	private By City = By.xpath("//input[@id='cust_communicationDetails_c_CityName']");

	private By Valid_From = By.xpath("//input[@id='cust_custidentification_validFrom']");

	private By submit = By.xpath("//button[@id='cust_communicationDetails_c_submit']");

	private By Ok = By.xpath("//button[@id='ok-button']");

	private By Address_Next = By.xpath("//button[@id='cust_custAddressDetails_l_nextgbp']");

	private By Identification_Details_Next = By.xpath("//button[@id='cust_custidentificationdetails_l_next']");

	public AddDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2);
	}

	public void fillAndSubmitNewAddDetails(WebDriver driver, String testCaseName, XSSFWorkbook workbook,
			Connection conn, String stepGroup, CustomAssert customAssert) throws Exception {

		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName, stepGroup);

		Reporter.log("<B>Traverse To Customer On Boarding</B>");
		System.out.println("<<enter>>");

		switchtodefaultframe(driver);
		switchtoframe(driver, "frame-1-2");

		click(AddButton, "AddButton");

		selectFromDropdownByVisibleText(Local_lang_add, dataRow.getProperty("IsLocalLangAddReq"), "IsLocalLangAddReq");

		clearAndSenKeys(Postal_code, dataRow.getProperty("PostalCode"), "PostalCode");

		clearAndSenKeys(State, dataRow.getProperty("State"), "State");

		clearAndSenKeys(City, dataRow.getProperty("City"), "City");

		selectFromDropdownByVisibleText(Country, dataRow.getProperty("Country"), "Country");

		clearAndSenKeys(Add_line_1, dataRow.getProperty("Add_line_1"), "Add_line_1");

		clearAndSenKeys(Add_line_2, dataRow.getProperty("Add_line_2"), "Add_line_2");

		click(submit, "submit");

		click(Ok, "Ok");

		click(Address_Next, "Address_Next");

		click(Identification_Details_Next, "Identification_Details_Next");

	}
}
