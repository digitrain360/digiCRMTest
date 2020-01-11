package com.digiCRMTest.autoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.digiCRMTest.autoqa.base.TestBase;

public class DealsPage extends TestBase {

	
	//PageFactory - OR;
	
	@FindBy(xpath="//div[attribute::class='ui header item mb5 light-black\']")
	WebElement dealsPageTitle;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public String getDealsPageUITitle() {
		return dealsPageTitle.getText();
	}
}
