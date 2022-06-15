package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateServicePage {
	
	@FindBy(xpath="//input[@name='servicename']")
	private WebElement serNameEtd;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement serSaveButton;
	
	public CreateServicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSerNameEtd() {
		return serNameEtd;
	}

	public WebElement getSerSaveButton() {
		return serSaveButton;
	}
	
	

}
