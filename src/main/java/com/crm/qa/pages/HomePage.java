package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestCRMBase;

public class HomePage extends TestCRMBase {

	// Page Factory - Object repository
	
	@FindBy(xpath = "//div//span[@class='user-display']")
	WebElement userInfoLabel;

	@FindBy(xpath = "//*[text()=\"Contacts\"]")
	WebElement contactsLink;
	
	@FindBy(xpath = "")
	
}
