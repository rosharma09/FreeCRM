package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestCRMBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestCRMBase {

	LoginPage loginPageObject;
	HomePage homePageObject;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialisation();
		loginPageObject = new LoginPage();
	}
	
	@Test(priority = 1)
	public void titleTest() {
		String title = loginPageObject.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM" , "The title is incorrect");
	}
	
	@Test(priority = 2)
	public void notificationTest() {
		Boolean isDisplayed = loginPageObject.validateNotificationIcon();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homePageObject = loginPageObject.loginCRM(prop.getProperty("emailID"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driverObject.quit();
	}
}
