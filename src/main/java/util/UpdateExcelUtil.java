package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;

public class UpdateExcelUtil {
	
	public void updateValueInExcelSheet(String ColumnName, String value,WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception {
		
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		String TestCaseName=dataRow.getProperty(testCaseName);
		 
		
		String path = ConfigReader.getInstance().getValue("upadateExcel");
		FileInputStream fis = new FileInputStream(new File(path));
		@SuppressWarnings("resource")
		HSSFWorkbook work = new HSSFWorkbook(fis);
		HSSFSheet sheet = work.getSheet("Policy");
		DataFormatter formatter = new DataFormatter();
		Row dataRow1 = sheet.getRow(0);

		System.out.println(ColumnName + "==" + value);
		int cellNumber = 0;

		for (int i = 0; i < dataRow1.getLastCellNum(); i++) {

			if (formatter.formatCellValue(dataRow1.getCell(i)).trim().equalsIgnoreCase(ColumnName.trim())) {
				cellNumber = i;
				break;
			}
		}
		HSSFCell cell = sheet.getRow(1).getCell(cellNumber);
		cell.setCellValue(value);

		fis.close();
		
		java.util.Date date=new java.util.Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy__hh-mm-ss");
		String folderDate=simpleDateFormat.format(date);	
		FileOutputStream fos = new FileOutputStream(new File(path+"\\"+testCaseName+folderDate));
		work.write(fos);
		
		fos.close();

	}
	

}
