package com.digiCRMTest.autoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.digiCRMTest.autoqa.base.TestBase;

public class UserLandingPage extends TestBase {
	
	//PageFactory - OR;
	
	@FindBy(xpath="//div/a[attribute::href='/deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//div/a[attribute::href='/contacts']")
	WebElement contactsLink;
	
	@FindBy(className="user-display")
	WebElement userName;
	
	public UserLandingPage() {
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public String getUserLandingPageTitle() {
		return driver.getTitle();
	}
	
	public String getUserNameDisplayed() {
		String userNameStr = userName.getText();
		return userNameStr;
	}
	
	public DealsPage gotoDealPage() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public ContactsPage gotoContactsPage() {
		contactsLink.click();
		return new ContactsPage();
	}
	
}
