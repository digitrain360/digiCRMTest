package com.digiCRMTest.autoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.digiCRMTest.autoqa.base.TestBase;

public class PasswordResetPage extends TestBase {
	
	//Page Factory
	
	@FindBy (id="email")
	WebElement resetEmail;
	
	@FindBy (xpath="//button[contains(text(),'Reset password')]")
	WebElement resetButton;
	
	@FindBy (xpath="//div[contains(text(),'Thank you')]")
	WebElement postresetMessage;
	
	//Actions
	
	public PasswordResetPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public String getPasswordResetPageTitle() {
		return driver.getTitle();
	}
	
	public void resetPasswordRequest(String email) {
		resetEmail.sendKeys(email);
		resetButton.click();
	}
	public String reserPasswordPostMsg() {
		return postresetMessage.getText();
	}
}