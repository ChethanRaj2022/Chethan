package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgSuccessfulMsg;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement oAdminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement orgsignOut;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement orghome;
	
	@FindBy(linkText="Organizations")
	private WebElement organizBut;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgSuccessfulMsg() {
		return orgSuccessfulMsg;
	}

	public WebElement getOrgAdminImg() {
		return oAdminImg;
	}

	public WebElement getOrgsignOut() {
		return orgsignOut;
	}

	public WebElement getoAdminImg() {
		return oAdminImg;
	}

	public WebElement getOrghome() {
		return orghome;
	}
	
	public String actualOrgName()
	{
		return orgSuccessfulMsg.getText();
	}
	
	
	/*public void orgCreated(String text)
	{
		if(orgSuccessfulMsg.equals(text))
		{
			System.out.println("organization created");
		}
	}*/

}
