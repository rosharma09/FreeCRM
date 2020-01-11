package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;

public class TestCRMBase {

	// we are going to initialize the generic properties in the base class

	// Global variables
	public static WebDriver driverObject;
	public static Properties prop;
	public static EventFiringWebDriver e_driver ;
	public static WebEventListner eventListner;

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

		e_driver = new EventFiringWebDriver(driverObject); // Object of eventFiringWebDriver class
		// We create an object of eventListner to register it with EventFiringListner
		eventListner = new WebEventListner();
		e_driver.register(eventListner); // register eventListner object with event firing webdriver
		driverObject = e_driver;
		
		driverObject.manage().window().maximize();
		driverObject.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driverObject.manage().deleteAllCookies();
		driverObject.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);

		driverObject.get(prop.getProperty("URL"));

	}

	public static void explicitWait(WebDriver driver, WebElement locator, int timeOut) {
		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

	public static void highLightElement(WebDriver driver, WebElement locator) {
		String bgColor = locator.getCssValue("backgroundColor");

		for (int i = 0; i < 10; i++) {
			changeColorMethod(driver, locator, "rgb(0,200,0)");
			changeColorMethod(driver, locator, bgColor);
		}
	}

	public static void changeColorMethod(WebDriver driver, WebElement locator, String color) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argument[0].style.backgroundColor = '" + color + "'", locator);

	}
	
	public static void scrollDownPage(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHieght");
	}
	
	public static void scrollTillElementInView(WebDriver driver , WebElement locator) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argument[0].scrollIntoView", locator);
	}
}
