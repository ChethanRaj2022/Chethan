package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addSerButton;
	
	public ServicesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddSerButton() {
		return addSerButton;
	}
	
	

}
