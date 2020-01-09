package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestCRMBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestCRMBase {

	// Object of loginPage Class

	LoginPage loginPageObj;

	// Object of HomePage Class

	HomePage homePageObj;

	// object of testUtil class

	TestUtil testUtilObj;

	// contact page object

	ContactPage contactPageObj;

	// create the constructor of home page test
	public HomePageTest() {
		super(); // call the base class constructor
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
		testUtilObj = new TestUtil();
		loginPageObj = new LoginPage();
		contactPageObj = new ContactPage();
		// login into the application
		homePageObj = loginPageObj.loginCRM(prop.getProperty("emailID"), prop.getProperty("password"));
	}

	// test cases for home page

	// NOTE : test cases should be independent
	// For each test case we should create a new session in the browser
	// After the test execution close the browser

	@Test(priority = 1)
	public void verfiyHomePageTitleTest() {
		String homePageTitle = homePageObj.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page title is not matched"); // we can pass message in
																								// case the test case
																								// fails
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Boolean userNameDisplayed = homePageObj.verifyCorrectUserName();
		Assert.assertTrue(userNameDisplayed, "The username is not displayed");

		// or we can pass the method directly in assertTrue method

		// Assert.assertTrue(homePageObj.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyContactLnkText() {
		contactPageObj = homePageObj.clickOnContactLink();
	}

	@AfterMethod
	public void tearDown() {
		driverObject.quit();
	}

}
