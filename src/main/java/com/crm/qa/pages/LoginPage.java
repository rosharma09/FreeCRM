package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestCRMBase;

public class LoginPage extends TestCRMBase {

	// Page factory - ObjectReposatory

	@FindBy(name = "email")
	WebElement emailId;

	@FindBy(name = "password")
	WebElement passWord;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signUpBtn;

	@FindBy(xpath = "//a[text()='Classic CRM']")
	WebElement classicCRMLink;

	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement forgotPwd;

	@FindBy(xpath = "//div[@class='onesignal-bell-launcher-button']")
	WebElement notificationIcon;

	// To initialise the page objects
	public LoginPage() {
		PageFactory.initElements(driverObject, this);
	}

	// Verify the title of the page
	public String validateLoginPageTitle() {
		return driverObject.getTitle();
	}

	// to validate whether the element is displayed
	public boolean validateNotificationIcon() {
		return notificationIcon.isDisplayed();
	}

	public HomePage loginCRM(String Id, String pwd) {
		emailId.sendKeys(Id);
		passWord.sendKeys(pwd);
	    loginBtn.click();
	    
	    return new HomePage();
	}
}
