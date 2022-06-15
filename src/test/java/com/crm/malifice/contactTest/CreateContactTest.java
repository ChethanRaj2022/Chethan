package com.crm.malifice.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.malifice.pomrepositoryutility.ContactInfoPage;
import com.crm.malifice.pomrepositoryutility.ContactPage;
import com.crm.malifice.pomrepositoryutility.CreateContactPage;
import com.crm.malifice.pomrepositoryutility.HomePage;
import com.crm.malifice.pomrepositoryutility.LoginPage;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyfileUtility;
import genericUtility.WebdriverUtility;

public class CreateContactTest extends BaseClass {

@Test(groups = "regressionTest")
	public void createContact() throws InterruptedException, EncryptedDocumentException, IOException {
			
			
			ExcelUtility elib=new ExcelUtility();
			JavaUtility jlib=new JavaUtility();
			PropertyfileUtility plib=new PropertyfileUtility();
			WebdriverUtility wlib=new WebdriverUtility();
			
			//WebDriver driver=new FirefoxDriver();
			//wlib.waitForElementInDOM(driver);
			String url=plib.getPropertyKeyvalue("url");
			driver.get(url);
			
			ContactPage cp=new ContactPage(driver);
			HomePage hp=new HomePage(driver);
			LoginPage lp=new LoginPage(driver);
			ContactInfoPage cip=new ContactInfoPage(driver);
			CreateContactPage ccp=new CreateContactPage(driver);
			//lp.LoginToApp("admin", "admin");
			hp.getContacts().click();
			int rannum = jlib.getrandominteger();
			
			//FileInputStream fis1=new FileInputStream("./data/Pr.properties");
			//Properties p=new Properties();
			/*p.load(fis1);
			String url=p.getProperty("url1");
			String un=p.getProperty("un1");
			String pwd=p.getProperty("pwd1");*/
			
			
			//String un = plib.getPropertyKeyvalue("un");
			//String pwd = plib.getPropertyKeyvalue("pwd");
			
			//to execute the code without getting alert pop up
			//Random ran=new Random();
	        //int rannum=ran.nextInt(1000);
			//int rand = jlib.getrandominteger();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			cp.gotoCreateContact();
			String lastName = elib.getExcelData("Sheet1", 0, 0);
			ccp.CreateContact(lastName+rannum);
			SoftAssert sa=new SoftAssert();
			String actaulmsg = cip.actualmessage();
			sa.assertEquals(actaulmsg.contains(lastName+rannum), true);
			cip.getConHomeBut().click();
			//WebElement msg = cip.getSuccessfullMsg();
			//String sucmsg = msg.getText();
			/*if(sucmsg.contains("Contact Information "))
			{
				System.out.println("contact is created");
			}
			else {
				System.out.println("contact not created");
			}*/
			
			//WebElement ele = cip.getConAdminimg();
			//wlib.mouseOverOnElement(driver, ele);
			//cip.getSignout().click();
			
			/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			FileInputStream fis=new FileInputStream("./data/excel1.xlsx");
			Workbook book=WorkbookFactory.create(fis);
			Cell cell = book.getSheet("Sheet1").getRow(3).getCell(0);
			String text = cell.getStringCellValue();
			String val=text+rannum;*/
			/*String val = elib.getExcelData("Sheet1", 0, 0);
			String value = val+rand;
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(value);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			WebElement ele1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			String actual = ele1.getText();
			if(actual.contains(val))
			{
				System.out.println("contact created");
			}
			else
			{
				System.out.println("contact not created");
			}
			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG\']"));
			//Actions act=new Actions(driver);
			//act.moveToElement(ele).perform();
			wlib.mouseOverOnElement(driver, ele);
			driver.findElement(By.linkText("Sign Out")).click();
			WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wlib.mouseOverOnElement(driver, ele2);
			driver.findElement(By.linkText("Sign Out")).click();*/
	}

}
