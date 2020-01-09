package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestCRMBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends TestCRMBase {

	LoginPage loginPageObj;
	HomePage homePageObj;
	ContactPage contactPageObj;

	public ContactPageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {
		intialisation();
		loginPageObj = new LoginPage();
		homePageObj = new HomePage();
		contactPageObj = new ContactPage();

		homePageObj = loginPageObj.loginCRM(prop.getProperty("emailID"), prop.getProperty("password"));
		contactPageObj = homePageObj.clickOnContactLink();

	}
	
	@Test(priority = 1)
	public void verifyContactLabelTest() {
		Assert.assertTrue(contactPageObj.verifyContactLabel(), "Contact label is not displayed");
	}

	@AfterMethod
	public void tearDown() {
		driverObject.quit();
	}
}
