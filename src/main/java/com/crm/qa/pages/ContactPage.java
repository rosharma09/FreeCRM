package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestCRMBase;

public class ContactPage extends TestCRMBase {

	// Page object - Object repository

	
	// we can make use of cache lookUp in selenium to store the element details into cache memory
	// Elements that are accessed multiple times we can make use of cacheLookUp conceptss
	@FindBy(xpath = "//div[text()='Contacts']")
	@CacheLookup
	WebElement contactLabel;
	
	// Disadvantage of using cahceLookup : In case the page is refreshed or the DOM is changed, then it will throw StaleElementException.
	
	@FindBy(xpath = "//button[@class='ui linkedin button' and text()='New']")
	WebElement newContact;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
	WebElement secondName;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement emailAddress;
	
	@FindBy(xpath = "//*//button[@class='ui linkedin button']")
	WebElement contactSaveBtn;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]")
	WebElement newUserCreated;
	
	public ContactPage() {
		PageFactory.initElements(driverObject, this);
	}
	
	public boolean verifyContactLabel() {
		return contactLabel.isDisplayed();
	}
	
	public void clickOnContactButton() {
		contactLabel.click();
	}
	
	public void clickOnNewContact() {
		newContact.click();
	}
	
	public void createNewContact(String fName , String sName , String eId) {
		firstName.sendKeys(fName);
		secondName.sendKeys(sName);
		emailAddress.sendKeys(eId);
		
		contactSaveBtn.click();
	}

}
