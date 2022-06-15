package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement HomeBut;
	
	public WebElement getHomeBut() {
		return HomeBut;
	}

	@FindBy(linkText="More")
	private WebElement proMoreButton;
	
	@FindBy(linkText="Campaigns")
	private WebElement proCampButton;
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProMoreButton() {
		return proMoreButton;
	}

	public WebElement getProCampButton() {
		return proCampButton;
	}
	
	
}
