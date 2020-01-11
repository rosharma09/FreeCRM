package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestCRMBase;

public class TestUtil extends TestCRMBase {

	public static long page_load_timeout = 30;
	public static long implicit_wait = 20;

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;

	public static String testSheetPath = "C:\\Users\\rosharma\\eclipse-workspace\\FreeCRMtest"
			+ "\\src\\main\\java\\com\\crm\\qa\\testdata\\TestCRM_TestData-Automation.xlsx";

	public void switchToFrame(String frameName) {
		driverObject.switchTo().frame(frameName);
	}
	
	//To take screenshot using selenium 
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driverObject).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(testSheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(fileInput);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			sheet = book.getSheet(sheetName);
		} catch (Exception e) {
			System.out.println("Sheet not present");
			e.printStackTrace();
		}
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// TO store the data in the excel file in the 2D array we are going to use for
		// loop

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;
	}
}
