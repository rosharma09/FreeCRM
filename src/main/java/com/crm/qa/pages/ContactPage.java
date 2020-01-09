package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestCRMBase;

public class ContactPage extends TestCRMBase {

	// Page object - Object repository

	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactLabel;

	public ContactPage() {
		PageFactory.initElements(driverObject, this);
	}
	
	public boolean verifyContactLabel() {
		return contactLabel.isDisplayed();
	}

}
