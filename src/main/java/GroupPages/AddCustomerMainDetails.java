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

public class AddCustomerMainDetails extends GenericMethods {
	private By Customer_Segment   = By.xpath("//select[@id='cust_custmaindetails_c_customerSegment']");
	private By Tax_Category  = By.xpath("//select[@id='cust_custidentification_l_taxCategory']");
	private By Legal_Form   = By.xpath("//select[@id='cust_custmaindetails_c_legalForm']");
	private By Owner_Classification   = By.xpath("//select[@id='cust_custmaindetails_corp_profitCostCentre']");
	private By Share_Holder_Declaration    = By.xpath("//select[@id='cust_custmaindetails_c_cntrlgShareholderDeclaration']");
	private By other_details   = By.xpath("//h2[@id='h2-panel-header-OtherDetails']");
	private By Relationship_Manager = By.xpath("//span[@id='span-cust_custmaindetails_c_manager']");
	private By Customer_Reference    = By.xpath("//input[@id='cust_searchbp_l_customerReference']");
	private By Customer_Search    = By.xpath("//button[@id='searchButton']");
	private By  select_Redio_Button    = By.xpath("//input[@id='cust_searchbp_l_BusinessPartnerListTable_selectRow_businessPartnerListTable1']");
	private By  select_Search  = By.xpath("//button [@id='cust_searchbp_l_customerSearch_selectAndProceed']");
	private By  Primary_Sector  = By.xpath("//select [@id='cust_custmaindetails_c_industrycode']");
	private By  contact_details  = By.xpath("//h2 [@id='h2-panel-header-communicationDetailsChanges']");
	private By  Contact_Type  = By.xpath("//select[@id='lbl_cust_commDetailstable_contactTypeRow_communicationDetailsTable1']");
	private By  Country_Code  = By.xpath("//select[@id='lbl_cust_commDetailstable_prefixRow_communicationDetailsTable1']");
	private By  Number  = By.xpath("//input[@id='lbl_cust_commDetailstable_phoneNumberRow_communicationDetailsTable1']");
	private By  Risk_Profiling  = By.xpath("//h2[@id='h2-panel-header-risk']");
	private By  Rating_Agency  = By.xpath("//select[@id='lbl_cust_custmaindetails_c_rateagencyRow_riskratingTable1']");
	private By  Rating  = By.xpath("//select[@id='lbl_cust_custmaindetails_c_ratingRow_riskratingTable1']");
	private By  Valid_From	  = By.xpath("//input[@id='lbl_cust_custidentificationdetails_c_validFromRow_riskratingTable1']");
	private By  submit	  = By.xpath("//button[@id='cust_custmaindetails_c_savegbp']");
	
	WebDriverWait wait;

	public AddCustomerMainDetails (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2);
	

}
	public void fillAndSubmitNewMainDetails(WebDriver driver, String testCaseName, XSSFWorkbook workbook,
			Connection conn, String stepGroup, CustomAssert customAssert) throws Exception {
		
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName, stepGroup);
	
		Reporter.log("<B>Traverse To Customer On Boarding</B>");
		System.out.println("<<enter>>");
		
		switchtodefaultframe(driver);
		switchtoframe(driver, "frame-1-2");
		  selectFromDropdownByVisibleText(Customer_Segment, dataRow.getProperty("CustomerSeg"), "CustomerSeg");
	        selectFromDropdownByVisibleText(Tax_Category, dataRow.getProperty("TaxCategory"), "TaxCategory");
	        selectFromDropdownByVisibleText(Legal_Form, dataRow.getProperty("LegalForm"), "LegalForm");
	        selectFromDropdownByVisibleText(Owner_Classification, dataRow.getProperty("OwnerClassification"), "OwnerClassification");
	        selectFromDropdownByVisibleText(Share_Holder_Declaration, dataRow.getProperty("ShareHolderDeclaration"), "ShareHolderDeclaration");
	        click(other_details, "other_details");
	        click(Relationship_Manager, "Relationship_Manager");
	        clearAndSenKeys(Customer_Reference, dataRow.getProperty("CustomerReference"), "CustomerReference");
	        click(Customer_Search, "Customer_Search");
	        click(select_Redio_Button, "select_Redio_Button");
	        click(select_Search, "select_Search");
	        selectFromDropdownByVisibleText(Primary_Sector, dataRow.getProperty("PrimarySector"), "PrimarySector");
	        click(contact_details, "contact_details");
	        selectFromDropdownByVisibleText(Contact_Type, dataRow.getProperty("ContactType"), "ContactType");
	        selectFromDropdownByVisibleText(Country_Code, dataRow.getProperty("CountryCode"), "CountryCode");
	        clearAndSenKeys(Number, dataRow.getProperty("Number"), "Number");
	        click(Risk_Profiling, "Risk_Profiling");
	        selectFromDropdownByVisibleText(Rating_Agency, dataRow.getProperty("RatingAgency"), "RatingAgency");
	        selectFromDropdownByVisibleText(Rating, dataRow.getProperty("Rating"), "Rating");	
	        clearAndSenKeys(Valid_From, dataRow.getProperty("ValidFrom"), "ValidFrom");
	        click(submit, "submit");
	        
	}
}
	
