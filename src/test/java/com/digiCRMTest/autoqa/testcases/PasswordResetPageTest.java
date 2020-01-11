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

public class PasswordResetPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	PasswordResetPage passwordResetPage;
	
	public PasswordResetPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.gotoLogInPage();
		passwordResetPage = loginPage.gotoPasswordReset();
	}
	
	@Test(priority=1)
	public void resetPasswordTest() {
		passwordResetPage.resetPasswordRequest(prop.getProperty("email"));
		String responseMsg = passwordResetPage.reserPasswordPostMsg();
		Reporter.log(responseMsg);
		Assert.assertEquals(responseMsg,"Thank you. If this account is registered you will receive an email with a password reset link.");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
