package com.digiCRMTest.autoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.digiCRMTest.autoqa.base.TestBase;

public class HomePage extends TestBase {
	
	//PageFactory - OR;
	
	@FindBy(xpath="//a[attribute::href='https://ui.cogmento.com\']")
	WebElement LogInBtn;
	
	@FindBy(xpath="//image[@xlink:href='/images/cogtiny1.jpg']")
	WebElement LogoImage;
	
	public HomePage() {
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage gotoLogInPage() {
		LogInBtn.click();
		return new LoginPage();
	}
	

}
