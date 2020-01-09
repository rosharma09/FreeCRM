package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestCRMBase;

public class HomePage extends TestCRMBase {

	// Page Factory - Object repository

	@FindBy(xpath = "//div//span[@class='user-display']")
	WebElement userInfoLabel;

	@FindBy(xpath = "//*[text()=\"Contacts\"]")
	WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Calendar')]")
	WebElement calendarLink;

	// intialise all the elements of the page
	public HomePage() {
		PageFactory.initElements(driverObject, this);
	}

	public String verifyHomePageTitle() {
		String homePageTitle = driverObject.getTitle();
		return homePageTitle;
	}
	
	public Boolean verifyCorrectUserName() {
		Boolean isDisplayed = userInfoLabel.isDisplayed();
		return isDisplayed;
	}

	public ContactPage clickOnContactLink() {
		contactsLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public CalendarPage clickOnCalendarLink() {
		calendarLink.click();
		return new CalendarPage();
	}
}
