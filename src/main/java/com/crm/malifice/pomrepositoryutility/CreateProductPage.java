package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productNameEtd;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement productSaveButton;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameEtd() {
		return productNameEtd;
	}

	public WebElement getProductSaveButton() {
		return productSaveButton;
	}
	

	public void createProduct(String proName)
	{
		productNameEtd.sendKeys(proName);
		productSaveButton.click();
	}

}
