package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;

public class ContactInfoPage extends WebdriverUtility {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successfullMsg;
	
	@FindBy(xpath="//input[@name='Delete']")
	private WebElement deletebutton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement conAdminimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement conHomeBut;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getDeletebutton() {
		return deletebutton;
	}
	
	public WebElement getConAdminimg() {
		return conAdminimg;
	}


	public WebElement getSignout() {
		return signout;
	}


	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}
	
	public void deleteContact(WebDriver driver)
	{
		deletebutton.click();
		switchToAlertWindowAndAccept(driver);
	}


	public WebElement getConHomeBut() {
		return conHomeBut;
	}
	
	public String actualmessage() {
		String actualMsg = successfullMsg.getText();
		return actualMsg;
	}
	
	
	
	
	
	

}
