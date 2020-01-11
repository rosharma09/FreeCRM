package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestCRMBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestCRMBase {

	LoginPage loginPageObj;
	HomePage homePageObj;
	ContactPage contactPageObj;
	TestUtil testUtilObj;

	String ContactPageSheetName = "ContactPageDataSheet";

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

	@Test(priority = 2)
	public void createContactTest() throws InterruptedException {
		contactPageObj.clickOnNewContact();
		contactPageObj.createNewContact("Shubhangi", "vasista", "svasishta@gmail.com");
		Thread.sleep(1000);
		contactPageObj.clickOnContactButton();

	}

	@DataProvider
	public Object[][] getTestDataFromDataProvider() {
		Object data[][] = TestUtil.getTestData(ContactPageSheetName);
		return data;
	}

	@Test(priority = 3, dataProvider = "getTestDataFromDataProvider")
	public void ValidateMultipleContactTest(String FirstName, String SecondName, String EmailAddress)
			throws InterruptedException {
		contactPageObj.clickOnNewContact();
		contactPageObj.createNewContact(FirstName, SecondName, EmailAddress);
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		driverObject.quit();
	}
}
