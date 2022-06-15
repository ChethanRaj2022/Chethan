package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnameEtd;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement saveCreateContact;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameEtd() {
		return lastnameEtd;
	}

	public WebElement getSaveCreateContact() {
		return saveCreateContact;
	}
	
	public void CreateContact(String lastNamee)
	{
		lastnameEtd.sendKeys(lastNamee);
		saveCreateContact.click();
	}
	
	public void acceptAlert(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}

}
