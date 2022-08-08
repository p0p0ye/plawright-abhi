package com.aqm;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.emory.mathcs.backport.java.util.Collections;

public class CollectionClass {

	static HashMap<String,HashMap<String,String>> val = new HashMap<>();
		
	/*	{TC_NSTP_ActivHealthFamily_Floater_016={Status=FAILED, QuoteNumber=QU2020421250070030000},
			 TC_NSTP_ActivHealthFamily_Floater_038={Status=FAILED},
			 TC_NSTP_ActivHealthFamily_Floater_015={Status=FAILED, QuoteNumber=QU2020421250070010000}, TC_NSTP_ActivHealthFamily_Floater_037={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_012={Status=FAILED, QuoteNumber=QU2020421250069960000}, TC_NSTP_ActivHealthFamily_Floater_014={Status=FAILED, QuoteNumber=QU2020421250070000000}, TC_NSTP_ActivHealthFamily_Floater_036={Status=FAILED, QuoteNumber=QU2020421250070120000}, TC_NSTP_ActivHealthFamily_Floater_077={Status=FAILED, QuoteNumber=QU2020421250070190000}, TC_NSTP_ActivHealthFamily_Floater_099={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_013={Status=PASSED, QuoteNumber=QU2020421250069990000}, TC_NSTP_ActivHealthFamily_Floater_030={Status=FAILED, QuoteNumber=QU2020421250070100000}, TC_NSTP_ActivHealthFamily_Floater_052={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_076={Status=FAILED, QuoteNumber=QU2020421250070180000}, TC_NSTP_ActivHealthFamily_Floater_098={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_095={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_031={Status=FAILED, QuoteNumber=QU2020421250070110000}, TC_NSTP_ActivHealthFamily_Floater_053={Status=FAILED, QuoteNumber=QU2020421250070160000}, TC_NSTP_ActivHealthFamily_Floater_096={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_093={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_072={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_094={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_091={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_092={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_090={Status=FAILED, QuoteNumber=QU2020421250070230000}, TC_NSTP_ActivHealthFamily_Floater_005={Status=FAILED, QuoteNumber=QU2020421250069980000}, TC_NSTP_ActivHealthFamily_Floater_004={Status=PASSED, QuoteNumber=QU2020421250069970000}, TC_NSTP_ActivHealthFamily_Floater_029={Status=FAILED, QuoteNumber=QU2020421250070090000}, TC_NSTP_ActivHealthFamily_Floater_006={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_028={Status=FAILED, QuoteNumber=QU2020421250070080000}, TC_NSTP_ActivHealthFamily_Floater_001={Status=FAILED, QuoteNumber=QU2020421250069950000}, TC_NSTP_ActivHealthFamily_Floater_023={Status=FAILED, QuoteNumber=QU2020421250070070000}, TC_NSTP_ActivHealthFamily_Floater_045={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_068={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_101={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_022={Status=FAILED, QuoteNumber=QU2020421250070060000}, TC_NSTP_ActivHealthFamily_Floater_044={Status=FAILED, QuoteNumber=QU2020421250070130000}, TC_NSTP_ActivHealthFamily_Floater_047={Status=FAILED, QuoteNumber=QU2020421250070150000}, TC_NSTP_ActivHealthFamily_Floater_046={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_089={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_100={Status=FAILED, QuoteNumber=QU2020421250070240000}, TC_NSTP_ActivHealthFamily_Floater_064={Status=FAILED, QuoteNumber=QU2020421250070170000}, TC_NSTP_ActivHealthFamily_Floater_065={Status=FAILED}, TC_NSTP_ActivHealthFamily_Floater_021={Status=FAILED, QuoteNumber=QU2020421250070050000}, TC_NSTP_ActivHealthFamily_Floater_084={Status=FAILED, QuoteNumber=QU2020421250070210000}, TC_NSTP_ActivHealthFamily_Floater_020={Status=FAILED, QuoteNumber=QU2020421250070040000}, TC_NSTP_ActivHealthFamily_Floater_085={Status=FAILED, QuoteNumber=QU2020421250070220000}, TC_NSTP_ActivHealthFamily_Floater_080={Status=FAILED, QuoteNumber=QU2020421250070200000}, TC_NSTP_ActivHealthFamily_Floater_081={Status=FAILED}}
	*/
	public static void main(String[] args) throws IOException {
//		HashMap<String,String> val1 = new HashMap<>();
//		val1.put("Status", "FAILED");
//		val1.put("QuoteNumber", "QU2020421250070030000");
//		
//		val.put("TC_NSTP_ActivHealthFamily_Floater_016",val1);
//		
//		HashMap<String,String> val2 = new HashMap<>();
//		val2.put("Status", "FAILED");
//		
//		val.put("TC_NSTP_ActivHealthFamily_Floater_038",val2);
//		
//		HashMap<String,String> val3 = new HashMap<>();
//		val3.put("Status", "FAILED");
//		val3.put("QuoteNumber", "QU2020421250070010000");
//		
//		val.put("TC_NSTP_ActivHealthFamily_Floater_015",val3);
//
//		System.out.println(val);
		
//		
//		 XSSFWorkbook workbook = new XSSFWorkbook();
//	    	XSSFSheet sheet = workbook.createSheet("Result Summary");
//	    	int rowNumber = 0;
//	    	XSSFRow rowheadHeader = sheet.createRow((short)rowNumber++);
//	    	rowheadHeader.createCell(0).setCellValue("Scenario");
//	    	rowheadHeader.createCell(1).setCellValue("Status");
//	    	rowheadHeader.createCell(2).setCellValue("QuoteNo");
//	    	rowheadHeader.createCell(3).setCellValue("PolicyNo");
//	    	
//	    	Iterator<Map.Entry<String, HashMap<String, String>>> parent = val.entrySet().iterator();
//	    	while (parent.hasNext()) {
//	    	    Map.Entry<String, HashMap<String, String>> parentPair = parent.next();
//	    	    System.out.println("parentPair.getKey() :   " + parentPair.getKey() + " parentPair.getValue()  :  " + parentPair.getValue());
//
//	    	    Iterator<Map.Entry<String, String>> child = (parentPair.getValue()).entrySet().iterator();
//	    	    XSSFRow rowhead = sheet.createRow((short)rowNumber++);
//	    	    rowhead.createCell(0).setCellValue(parentPair.getKey());
//	    	    while (child.hasNext()) {
//	    	    	
//	    	    	String myKey = child.next().getKey();
//	    	    	String value = parentPair.getValue().get(myKey);
//	    	    	if(myKey.equalsIgnoreCase("Status")) {
//	    	    		rowhead.createCell(1).setCellValue(value);
//	    	    	}else if(myKey.equalsIgnoreCase("QuoteNumber")) {
//	    	    		rowhead.createCell(2).setCellValue(value);
//	    	    	}
//		        	//txt.quickquote.setQuoteNo(QuoteNo);
//		        	
////		        	 rowhead.createCell(2).setCellValue(ConfigReader.getInstance().getValue("Quote_No"));
//	    	        child.remove(); // avoids a ConcurrentModificationException
//	    	    }
//
//	    	}
//	       
//	        FileOutputStream fileOut = new FileOutputStream("D:\\ExecutionReports\\NSTP_Family_Questionarrie06-Feb-2021__10-59-55"+"\\LatestSheet.xlsx");
//	        workbook.write(fileOut);
//	        fileOut.close();
//	        workbook.close();
//		
//		Set<String> keys = val.keySet();
//		for (String key : keys) {
//			System.out.println("=====================================================>" + key);
//			String status = val.get(key).get("Status");
//			System.out.println(status);
//		}
		for(int i=0;i<100;i++) {
			Random r = new Random( );
		    System.out.println( ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000)));
		}
		
	    
		
	}

}
