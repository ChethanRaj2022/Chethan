package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInfoPage {
	
	@FindBy(xpath="//span[@class'lvtHeaderText']")
	private WebElement purchaseOrderSuccessfulMsg;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement purHomeButton;
	
	public PurchaseOrderInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPurchaseOrderSuccessfulMsg() {
		return purchaseOrderSuccessfulMsg;
	}

	public WebElement getPurHomeButton() {
		return purHomeButton;
	}
	
	


}
