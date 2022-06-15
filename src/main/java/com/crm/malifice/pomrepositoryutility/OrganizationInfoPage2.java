package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage2 {
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement oAdminImg;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement orghome;
	
	@FindBy(linkText="Organizations")
	private WebElement organizBut;
	
	@FindBy(linkText="Sign Out")
	private WebElement orgsignOut;
	

	public OrganizationInfoPage2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getoAdminImg() {
		return oAdminImg;
	}


	public WebElement getOrghome() {
		return orghome;
	}


	public WebElement getOrganizBut() {
		return organizBut;
	}


	public WebElement getOrgsignOut() {
		return orgsignOut;
	}
	
	

}
