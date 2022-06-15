package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement camSuccessfulMsg;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement camAdminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement camSignOut;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement camHomeButton;
	
	public WebElement getCamHomeButton() {
		return camHomeButton;
	}

	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCamSuccessfulMsg() {
		return camSuccessfulMsg;
	}

	public WebElement getCamAdminImg() {
		return camAdminImg;
	}

	public WebElement getCamSignOut() {
		return camSignOut;
	}
	
	
	
}
