package com.digiCRMTest.autoqa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.digiCRMTest.autoqa.base.TestBase;
import com.digiCRMTest.autoqa.pages.HomePage;
import com.digiCRMTest.autoqa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test (priority=1)
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.getHomePageTitle(),"Cogmento CRM and Business Cloud Solutions");
		
	}
	
	@Test (priority=2)
	public void LoginButtonTest() {
		loginPage = homePage.gotoLogInPage();
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle,"Cogmento CRM");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
