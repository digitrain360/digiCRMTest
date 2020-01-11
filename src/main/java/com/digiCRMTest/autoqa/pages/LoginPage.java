package com.digiCRMTest.autoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.digiCRMTest.autoqa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory - OR
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement signOnSubmit;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotPasswordLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public UserLandingPage loginCRM(String emailInput, String passwordInput) {
		email.sendKeys(emailInput);
		password.sendKeys(passwordInput);
		signOnSubmit.click();
		return new UserLandingPage();
	}
	
	public PasswordResetPage gotoPasswordReset() {
		forgotPasswordLink.click();
		return new PasswordResetPage();
	}
}
