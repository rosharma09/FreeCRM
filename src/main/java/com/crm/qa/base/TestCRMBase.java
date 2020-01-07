package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestCRMBase {

	// we are going to initialize the generic properties in the base class

	// Global variables 
	public static WebDriver driverObject;
	public static Properties prop;

	public TestCRMBase() {

		try {
			prop = new Properties();
			FileInputStream fileInput = new FileInputStream(
					"C:\\Users\\rosharma\\eclipse-workspace\\FreeCRMtest\\src\\main\\java\\com\\crm\\qa\\config\\CRMconfig.properties");
			prop.load(fileInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void intialisation() {
		String browserName = prop.getProperty("webBrowser");
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\rosharma\\Downloads\\geckoDrivers\\Chrome\\chromedriver.exe");
			driverObject = new ChromeDriver();
		}

		if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\rosharma\\Downloads\\geckoDrivers\\firefox\\geckodriver.exe");
			driverObject = new FirefoxDriver();
		}

		driverObject.manage().window().maximize();
		driverObject.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driverObject.manage().deleteAllCookies();
		driverObject.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);

		driverObject.get(prop.getProperty("URL"));

	}
}
