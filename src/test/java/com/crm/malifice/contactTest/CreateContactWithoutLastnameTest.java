package com.crm.malifice.contactTest;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.crm.malifice.pomrepositoryutility.ContactPage;
import com.crm.malifice.pomrepositoryutility.CreateContactPage;
import com.crm.malifice.pomrepositoryutility.HomePage;

import genericUtility.BaseClass;


public class CreateContactWithoutLastnameTest extends BaseClass{
	
	@Test
	public void createContactWithoutLastnameTest()
	{
		HomePage hp=new HomePage(driver);
		ContactPage cp=new ContactPage(driver);
		CreateContactPage ccp=new CreateContactPage(driver);
		
		
		hp.getContacts().click();
		cp.getAddContactButton().click();
		ccp.getSaveCreateContact().click();
		Alert alt=driver.switchTo().alert();
		String msg = alt.getText();
		if(msg.equals("Last Name cannot be empty"))
		{
			System.out.println("alert handled");
		}
		else
		{
			System.out.println("alert not handled");
		}
		alt.accept();
		
		
		
		
	}
	
	

}
