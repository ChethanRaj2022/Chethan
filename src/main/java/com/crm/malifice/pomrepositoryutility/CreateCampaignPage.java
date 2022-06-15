package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.JavaUtility;
import genericUtility.WebdriverUtility;

public class CreateCampaignPage extends WebdriverUtility {
	WebDriver driver;
	JavaUtility jlib=new JavaUtility();
	
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campNameEtd;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement prodButton;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement campSaveButton;
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampNameEtd() {
		return campNameEtd;
	}

	public WebElement getProdButton() {
		return prodButton;
	}

	public WebElement getCampSaveButton() {
		return campSaveButton;
	}
	
	public void switchwindow()
	{
		prodButton.click();
		
		switchToWindow(null, null);
		
	}
	
	
	

}
