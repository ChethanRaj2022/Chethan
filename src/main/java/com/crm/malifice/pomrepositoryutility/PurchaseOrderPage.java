package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	
	@FindBy(xpath="img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addPurOrdButton;
	
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddPurOrdButton() {
		return addPurOrdButton;
	}
	
	

}
