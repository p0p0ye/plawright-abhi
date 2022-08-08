
package testRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.microsoft.playwright.Page;

import constants.PropertyConfigs;
import core.FrameworkServices;
import core.TestScriptStepGenerator;
import stepDefination.StepKeyword;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelDatabase;
import util.GenericMethods;
import util.LoginUserFromSyncMap;
import util.MapOfUserIDAssignedToAllocation;
import util.SetUpWebdriver;

public class TestExecutionSuite extends GenericMethods{


	public static XSSFWorkbook workbook = null;
	public static FileInputStream fileInputStream = null;
	public String GSTNID = "";
	public String PlaceOfSupply="";
	public String ScenarioID = "";
	public String ReturnType="";
	public String executionStatus = "";
	String filePath="";
	String MigrationFilePath="";
	String SheetName = "";
	public static String Browser,CONFIG_PATH;
	public static ConcurrentHashMap<String, ConcurrentHashMap<String,String>> scenarioStatus = new ConcurrentHashMap<>();
	volatile int counter;
	
	
	@Parameters({ "LoBName", "BrowserName", "TestScenario_RepositoryFileIndex" ,"TestData_RepositoryFile" })
	@BeforeSuite
	public void beforeSuite(String lobName,String browserName,String TestScenario_RepositoryFileIndex,String TestData_RepositoryFile) throws Exception
	{	
		Browser = ConfigReader.getInstance().getValue(PropertyConfigs.Browser);
		CONFIG_PATH = ConfigReader.getInstance().getValue(PropertyConfigs.TestDataFolder) + File.separator ;
		
		FileInputStream fileInputMasterStream = new FileInputStream(new File(CONFIG_PATH+"0001_MasterTestSuite.xlsx"));
		FrameworkServices.masterWorkbook = new XSSFWorkbook(fileInputMasterStream);
		
		fileInputStream = new FileInputStream(new File(CONFIG_PATH + TestData_RepositoryFile));
		workbook = new XSSFWorkbook(fileInputStream);
		
		
	}
	
	@Parameters({ "ScenarioID", "Module", "Description", "ScriptReference", "BrowserName","ScenarioUID", "TestScenario_RepositoryFileIndex" ,"TestData_RepositoryFile" })
	@Test(testName = "ScenarioID")
	public void executionSuite(String testScenario_Id, String Module, String Description,String scriptReference, String BrowserName, String ScenarioUID,String TestScenario_RepositoryFileIndex,String TestData_RepositoryFile)throws Exception
	{
		// Update GSTIN in MasterData sheet
		scenarioStatus.put(testScenario_Id, new ConcurrentHashMap<String, String>());
		
		
		//Fillo fl=new Fillo();
		//conn=fl.getConnection(filePath);
		WebDriver driver = null;
		Page page=null;
		//Fillo fillo = new Fillo();
		//connOfTestData = fillo.getConnection(filePath);
		//MigrationFilePath = CONFIG_PATH.concat(TestScenario_RepositoryFileIndex);
		//updateMigrationDataToMasterData(connOfTestData, MigrationFilePath, testScenario_Id, ScenarioUID);
		
		
		
		try {
			
		//	driver=SetUpWebdriver.setupWebDriver(Browser,testScenario_Id);
			page=SetUpWebdriver.setupWebDriver(Browser,testScenario_Id);
			CustomAssert customAssert = new CustomAssert(page);
			CustomAssert.executionFlag = true;
			
			StepKeyword keyword = new StepKeyword(page);
			for (TestScriptStepGenerator testScriptStepGenerator : FrameworkServices.getScriptStepFromScriptName(scriptReference)) {
				// TODO Amiya 05-10-2019
				Reporter.log("<B><I><Font color=\"BLUE\"><U> Step   ==>"+ testScriptStepGenerator.getStepKeyword() + " </U> ===></Font></I></B>");
				keyword.executeTestStep(page, testScenario_Id, testScriptStepGenerator.getStepKeyword(),testScriptStepGenerator.getStepGroup(),GSTNID,ReturnType, workbook,null,customAssert);
			}

			if (CustomAssert.executionFlag) {
				Reporter.log("Test Scenario has been passed");
				setScenarioStatus(testScenario_Id,"PASSED");
				// TO DO Amiya 01-11-2018
				// Update sheet Execution Status to passed if testcase excuted successfully.
				/*if (FrameworkServices.getConfigProperties().getProperty("ExecutionMode").equalsIgnoreCase("Migration")) {
					String MGFilePath = FrameworkServices.getConfigProperties().getProperty("TestDataFolder").concat(TestScenario_RepositoryFileIndex);
					Fillo fillo1 = new Fillo();
					Connection connOfTestData1 = fillo1.getConnection(filePath);
					updateExecutionStatus(connOfTestData1, MGFilePath, testScenario_Id, MigrationScenarioID, "Passed");
				}*/

			} 
			
			
			else {
				/*if (FrameworkServices.getConfigProperties().getProperty("ExecutionMode").equalsIgnoreCase("Migration")) {
					String MGFilePath = FrameworkServices.getConfigProperties().getProperty("TestDataFolder").concat(TestScenario_RepositoryFileIndex);
					Fillo fillo1 = new Fillo();
					Connection connOfTestData1 = fillo1.getConnection(filePath);
					updateExecutionStatus(connOfTestData1, MGFilePath, testScenario_Id, MigrationScenarioID, "Failed");
				}*/
				setScenarioStatus(testScenario_Id,"FAILED");
				throw new AssertionError();
			}
		} catch (Exception e) {

			// TO DO Amiya 06/11/2018
			// Update sheet Execution Status to passed if testcase excuted successfully.
			/*if (FrameworkServices.getConfigProperties().getProperty("ExecutionMode").equalsIgnoreCase("Migration")) {
				String MGFilePath = FrameworkServices.getConfigProperties().getProperty("TestDataFolder").concat(TestScenario_RepositoryFileIndex);
				Fillo fillo1 = new Fillo();
				Connection connOfTestData1 = fillo1.getConnection(filePath);
				updateExecutionStatus(connOfTestData1, MGFilePath, testScenario_Id, MigrationScenarioID, "Failed");
			}*/
			e.printStackTrace();
			setScenarioStatus(testScenario_Id,"FAILED");
			SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),testScenario_Id);
			
			Reporter.log(e.toString());
			if(e.getMessage().equals(ConfigReader.getInstance().getValue("CustomExceptionMessage")) && CustomAssert.executionFlag)
			{	
				
				//Assert.assertEquals(true, true);
				
			}
			else
			{
			
			Reporter.log(e.getCause().getMessage());
			//Assert.assertEquals(true,false);
			
			}
		} finally {
			/*if(driver.toString()==null)
			{
				System.out.println("Browser is closed");
			}
			else
			{
				//Logout from Application
				System.out.println("Go to Home Page");
			}*/
			try {
//				driver.close();
//				driver.quit();
//				driver = null;
				page.close();
				System.out.println(++counter);
			} catch (Exception e2) {
			}
			
			
			//ExcelDatabase.close_connection(); 
			UserIDRelease(testScenario_Id);
			System.out.println("All Closed");
		}
	}
	
	public static void setScenarioStatus(String testId,String status){
		ConcurrentHashMap<String, String> statusMap = TestExecutionSuite.scenarioStatus.get(testId);
		statusMap.put("Status", status);
	}
	
	@AfterClass 
	public void tearDown() throws IOException {
//		ExcelDatabase.updateBorders(MigrationFilePath);
//		ExcelDatabase.updateBorders(filePath);
		
	}
	
	@AfterSuite
	public void afterSuite() throws Exception {
		System.out.println("After Suite method executed");
		//ScenarioType
		System.out.println(scenarioStatus);
		String ScanerioType=ConfigReader.getInstance().getValue(PropertyConfigs.ScanerioType);
		
		 XSSFWorkbook workbook = new XSSFWorkbook();
	    	XSSFSheet sheet = workbook.createSheet("Result Summary");
	    	int rowNumber = 0;
	    	XSSFRow rowheadHeader = sheet.createRow((short)rowNumber++);
	    	rowheadHeader.createCell(0).setCellValue("Scenario");
	    	rowheadHeader.createCell(1).setCellValue("Status");
	    	rowheadHeader.createCell(2).setCellValue("QuoteNo");
	    	rowheadHeader.createCell(3).setCellValue("PolicyNo");
	    	
	    	Iterator<Map.Entry<String, ConcurrentHashMap<String, String>>> parent = scenarioStatus.entrySet().iterator();
	    	while (parent.hasNext()) {
	    	    Map.Entry<String, ConcurrentHashMap<String, String>> parentPair = parent.next();
	    	    System.out.println("parentPair.getKey() :   " + parentPair.getKey() + " parentPair.getValue()  :  " + parentPair.getValue());

	    	    Iterator<Map.Entry<String, String>> child = (parentPair.getValue()).entrySet().iterator();
	    	    XSSFRow rowhead = sheet.createRow((short)rowNumber++);
	    	    rowhead.createCell(0).setCellValue(parentPair.getKey());
	    	    while (child.hasNext()) {
	    	    	
	    	    	String myKey = child.next().getKey();
	    	    	String value = parentPair.getValue().get(myKey);
	    	    	if(myKey.equalsIgnoreCase("Status")) {
	    	    		rowhead.createCell(1).setCellValue(value);
	    	    	}else if(myKey.equalsIgnoreCase("QuoteNumber")) {
	    	    		rowhead.createCell(2).setCellValue(value);
	    	    	}
		        	//txt.quickquote.setQuoteNo(QuoteNo);
		        	
//		        	 rowhead.createCell(2).setCellValue(ConfigReader.getInstance().getValue("Quote_No"));
	    	       // child.remove(); // avoids a ConcurrentModificationException
	    	    }

	    	}
	       
	        FileOutputStream fileOut = new FileOutputStream(TestEngine.excutionFolder+"\\LatestSheet.xlsx");
	        workbook.write(fileOut);
	        fileOut.close();
	        workbook.close();
	        String cssOut = ".invocation-failed,  .test-failed  { background-color: #E53030; }\n" + 
					".invocation-percent, .test-percent { background-color: #006600; }\n" + 
					".invocation-passed,  .test-passed  { background-color: #0D5D12; }\n" + 
					".invocation-skipped, .test-skipped { background-color: #A5A129; }\n" + 
					"\n" + 
					".main-page {\n" + 
					"  font-size: x-large;\n" + 
					"}\n" + 
					"\n" + 
					"body{background-color: #5A5353;color: white;}\n" + 
					"table{border-color: black;}\n" + 
					"";
	        FileWriter fw=new FileWriter(TestEngine.excutionFolder+"\\"+ScanerioType+"\\testng.css");    
	           fw.write(cssOut);    
	           fw.close();
	if(!scenarioStatus.isEmpty()) {
		File pass = new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\PASS");
		File fail = new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\FAIL");
		File assertion = new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\ASSERT");
		
		if(!pass.exists()) {
			pass.mkdir();
			
		}
		if(!fail.exists()) {
			fail.mkdir();
		}
		if(!assertion.exists()) {
			assertion.mkdir();
			
		}
		Set<String> keys = scenarioStatus.keySet();
		for (String key : keys) {
			System.out.println("=====================================================>" + key);
			ConcurrentHashMap<String,String> map = scenarioStatus.get(key);
			String status = map.get("Status");
			System.out.println(status);
			File htmlFileToMove = new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\" + key + ".html");
			File xmlFileToMove = new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\" + key + ".xml");

			if(status.equalsIgnoreCase("PASSED")) {
				htmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\PASS\\" + key + ".html"));
				xmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\PASS\\" + key + ".xml"));
			}else if(status.equalsIgnoreCase("FAILED")) {
				htmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\FAIL\\" + key + ".html"));
				xmlFileToMove.renameTo(new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\FAIL\\" + key + ".xml"));
			}
			else {
				htmlFileToMove.renameTo(new File(TestEngine.excutionFolder +"\\"+ScanerioType+"\\ASSERT\\" + key + ".html"));
				xmlFileToMove.renameTo(new File(TestEngine.excutionFolder + "\\"+ScanerioType+"\\ASSERT\\" + key + ".xml"));
			}
		}
		
		
	}
	TestExecutionSuite.fileInputStream.close();
	TestExecutionSuite.workbook.close();
	System.out.println("After Suite method executed");
	}


	public void updateExecutionStatus(Connection connForTestData, String migrationTestData, String scenarioId,String migrationId, String Status) throws FilloException, IOException {

		try {

			/*Fillo fillo = new Fillo();
			ExcelDatabase excelDatabase = new ExcelDatabase();
			Connection connOfMigrationTestData = fillo.getConnection(migrationTestData);
			String fetchMigrationPropasal = "select * from MigrationTestData where MigrationScenarioID='"+migrationId+"'";
			Recordset recordsetMigration = connOfMigrationTestData.executeQuery(fetchMigrationPropasal);
			String updateMigrationIntoTestData = "Update MigrationTestData Set Status='"+ Status+"' Where MigrationScenarioID='"+migrationId+"' and ProposalNumber='"+ ProposalNumbers+"'";
			excelDatabase.sheetsname.add("MigrationTestData");
			connOfMigrationTestData.executeUpdate(updateMigrationIntoTestData);
			recordsetMigration.close();
			connOfMigrationTestData.close();*/

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	//TODO Amiya Modified 09/10/2019
	@SuppressWarnings("static-access")
	public void updateMigrationDataToMasterData(Connection connForTestData, String migrationTestData, String scenarioId,String scenarioUid) throws FilloException {
		try{
			Fillo fillo = new Fillo();
			Connection connOfMigrationTestData = fillo.getConnection(migrationTestData);
			//String ProposalNumber = "";
			
			String fetchMigrationPropasal = "select * from TestScenarios where ScenarioUID='"+scenarioUid+"'";
			Recordset recordsetMigration = connOfMigrationTestData.executeQuery(fetchMigrationPropasal);
			while (recordsetMigration.next()) {
				GSTNID = recordsetMigration.getField("GSTNid");
				PlaceOfSupply=recordsetMigration.getField("PlaceOfSupply");
				ReturnType=recordsetMigration.getField("ReturnType");
			}
			String updateMigrationIntoTestData = "Update MASTERTESTDATA set GSTNID='"+GSTNID+"', PlaceOfSupply='"+PlaceOfSupply+"',ReturnType='"+ReturnType+"' where TCID='"+scenarioId +"'";
			connForTestData.executeUpdate(updateMigrationIntoTestData);
			connOfMigrationTestData.close();
			recordsetMigration.close();
			//TODO Amiya added 27/12/2018
			ExcelDatabase excelDatabase = new ExcelDatabase();
			excelDatabase.sheetsname.add("MASTERTESTDATA");
		}catch(Exception e){
			System.out.println(e);
			Reporter.log(e.getMessage());
		}
	}
	
	private synchronized void UserIDRelease(String executionTestScenario_TestScenarioReference){
        String user="";
        if(MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.containsValue(executionTestScenario_TestScenarioReference)){
            user = LoginUserFromSyncMap.getKeyByValue(MapOfUserIDAssignedToAllocation.listOfUserIDForExecution,executionTestScenario_TestScenarioReference);
            if (!user.equals("")){
                MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.put(user,"Free");
            }
            System.out.println("User ID is blank !!!");
        }
        System.out.println("");
        System.out.println("Execution Done for: "+executionTestScenario_TestScenarioReference+" User ID: "+user+" released");
        System.out.println("After release of USER ID Updated__MAP shows as below");
        System.out.println("Status wise MAP::"+MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.toString());
        System.out.println("");
    }
	
}

