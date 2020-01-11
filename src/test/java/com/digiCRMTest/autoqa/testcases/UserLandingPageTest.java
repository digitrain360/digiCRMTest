package com.digiCRMTest.autoqa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.digiCRMTest.autoqa.base.TestBase;
import com.digiCRMTest.autoqa.pages.ContactsPage;
import com.digiCRMTest.autoqa.pages.DealsPage;
import com.digiCRMTest.autoqa.pages.HomePage;
import com.digiCRMTest.autoqa.pages.LoginPage;
import com.digiCRMTest.autoqa.pages.UserLandingPage;

public class UserLandingPageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	UserLandingPage userLandingPage;
	DealsPage dealsPage;
	ContactsPage contactsPage;
	
	public UserLandingPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.gotoLogInPage();
		String emailID = prop.getProperty("email");
		String password = prop.getProperty("password");
		userLandingPage = loginPage.loginCRM(emailID, password);
	}
	
	@Test (priority=1)
	public void userLandingPageTitleTest() {
		String currentPage = userLandingPage.getUserLandingPageTitle();
		Assert.assertEquals(currentPage,"Cogmento CRM");		
	}
	
	@Test (priority=2, dependsOnMethods={ "userLandingPageTitleTest" })
	public void userNameTest() {
		String userNameDisplayed = userLandingPage.getUserNameDisplayed();
		Reporter.log("User Name Displayed " + userNameDisplayed);
		Assert.assertEquals(userNameDisplayed,"Avinash Dyagala");
	}

	@Test (priority=2, dependsOnMethods={ "userLandingPageTitleTest" })
	public void dealLinkTest() {
		dealsPage = userLandingPage.gotoDealPage();
		String dealsPageHeader = dealsPage.getDealsPageUITitle();
		Reporter.log("Deals Page Header: " + dealsPageHeader);
		Assert.assertEquals(dealsPageHeader,"Deals");
	}

	@Test  (priority=2, dependsOnMethods={ "userLandingPageTitleTest" })
	public void ContactsLinkTest() {
		contactsPage = userLandingPage.gotoContactsPage();
	}

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
