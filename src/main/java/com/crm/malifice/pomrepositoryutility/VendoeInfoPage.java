package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendoeInfoPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement venHomeBut;
	
	public VendoeInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVenHomeBut() {
		return venHomeBut;
	}
	

}
