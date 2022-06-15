package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement oraganization;
	
	@FindBy(linkText="Products")
	private WebElement products;

	@FindBy(linkText="Contacts")
	private WebElement contacts;
	
	@FindBy(linkText="More")
	private WebElement more;

	@FindBy(linkText="Campaigns")
	private WebElement campaigns;
	
	@FindBy(linkText="Services")
	private WebElement services;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseorder;
	
	@FindBy(linkText="Vendors")
	private WebElement vendors;
	
	@FindBy(linkText="Documents")
	private WebElement documents;
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	public WebElement getOraganization() {
		return oraganization;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getServices() {
		return services;
	}

	public WebElement getPurchaseorder() {
		return purchaseorder;
	}

	public WebElement getVendors() {
		return vendors;
	}

	public WebElement getDocuments() {
		return documents;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getAdminimg() {
		return adminimg;
	}
	
	public void logout(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		signout.click();
	}
	
	
	

}
