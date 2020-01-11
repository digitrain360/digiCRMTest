package com.digiCRMTest.autoqa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.digiCRMTest.autoqa.base.TestBase;
import com.digiCRMTest.autoqa.pages.HomePage;
import com.digiCRMTest.autoqa.pages.LoginPage;
import com.digiCRMTest.autoqa.pages.PasswordResetPage;
import com.digiCRMTest.autoqa.pages.UserLandingPage;

public class LoginPageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	UserLandingPage userLandingPage;
	PasswordResetPage passwordResetPage;
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.gotoLogInPage();	
	}
	
	@Test (priority=1)
	public void loginPageTitleTest() {
		String currentPage = loginPage.getLoginPageTitle();
		Assert.assertEquals(currentPage,"Cogmento CRM");		
	}
	
	@Test (priority=2, dependsOnMethods={ "loginPageTitleTest" })
	public void LoginTest() {
		String emailID = prop.getProperty("email");
		String password = prop.getProperty("password");
		userLandingPage = loginPage.loginCRM(emailID, password);
		String actualTitle = userLandingPage.getUserLandingPageTitle();
		Reporter.log("Actual Title: " + actualTitle);
		Assert.assertEquals(actualTitle,"Cogmento CRM");
	}
	
	@Test (priority=2)
	public void PasswordResetLinkTest() {
		passwordResetPage = loginPage.gotoPasswordReset();
		String pageTitle = passwordResetPage.getPasswordResetPageTitle();
		Assert.assertEquals(pageTitle, "Reset Password");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
