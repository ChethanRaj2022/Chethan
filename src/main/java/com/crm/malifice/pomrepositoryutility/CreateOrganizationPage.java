package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameEtd;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement OrgSaveButton;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEtd() {
		return orgNameEtd;
	}

	public WebElement getOrgSaveButton() {
		return OrgSaveButton;
	}
	
	public void createOrg(String organizationName) {
		orgNameEtd.sendKeys(organizationName);
		OrgSaveButton.click();
	}

}
