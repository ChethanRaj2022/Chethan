package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
	
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement VenNameEdt;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement venSaveButton;
	
	public CreateVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVenNameEdt() {
		return VenNameEdt;
	}

	public WebElement getVenSaveButton() {
		return venSaveButton;
	}
	
	

}
