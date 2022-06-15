package com.crm.malifice.pomrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePurchaseOrderPage {
	
	@FindBy(xpath="input[@name='subject']")
	private WebElement subNameEtd;
	
	@FindBy(xpath="img[@src='themes/softed/images/select.gif']")
	private WebElement venBut;
	
	@FindBy(xpath="img[@src='themes/softed/images/select.gif']")
	private WebElement conBut;
	
	@FindBy(xpath="textarea[@name='bill_street']")
	private WebElement billNameEtd;
	
	@FindBy(xpath="textarea[@name='ship_street']")
	private WebElement shipNameEtd;
	
	@FindBy(xpath="img[@src='themes/images/products.gif']")
	private WebElement proBut;
	
	@FindBy(xpath="input[@id='qty1']")
	private WebElement proQty;
	
	@FindBy(xpath="input[@class='crmbutton small create']")
	private WebElement addSerBut;
	
	@FindBy(xpath="img[@src='themes/images/services.gif']")
	private WebElement serBut;
	
	@FindBy(xpath="input[@id='qty2']")
	private WebElement serQty;
	
	@FindBy(xpath="input[@title='Save [Alt+S]']")
	private WebElement purOrdSaveBut;
	
	public CreatePurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubNameEtd() {
		return subNameEtd;
	}

	public WebElement getVenBut() {
		return venBut;
	}

	public WebElement getConBut() {
		return conBut;
	}

	public WebElement getBillNameEtd() {
		return billNameEtd;
	}

	public WebElement getShipNameEtd() {
		return shipNameEtd;
	}

	public WebElement getProBut() {
		return proBut;
	}

	public WebElement getProQty() {
		return proQty;
	}

	public WebElement getAddSerBut() {
		return addSerBut;
	}

	public WebElement getSerBut() {
		return serBut;
	}

	public WebElement getSerQty() {
		return serQty;
	}

	public WebElement getPurOrdSaveBut() {
		return purOrdSaveBut;
	}
	
	
	

}
