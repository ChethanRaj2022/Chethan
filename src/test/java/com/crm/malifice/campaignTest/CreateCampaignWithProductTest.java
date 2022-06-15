package com.crm.malifice.campaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.malifice.pomrepositoryutility.CampaignInfoPage;
import com.crm.malifice.pomrepositoryutility.CampaignPage;
import com.crm.malifice.pomrepositoryutility.CreateCampaignPage;
import com.crm.malifice.pomrepositoryutility.CreateProductPage;
import com.crm.malifice.pomrepositoryutility.HomePage;
import com.crm.malifice.pomrepositoryutility.LoginPage;
import com.crm.malifice.pomrepositoryutility.ProductInfoPage;
import com.crm.malifice.pomrepositoryutility.ProductPage;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyfileUtility;
import genericUtility.WebdriverUtility;

public class CreateCampaignWithProductTest extends BaseClass {
@Test(groups = "smokeTest")
	public void createCampaignwithProduct() throws Throwable {
		/*FileInputStream fis1=new FileInputStream("./data/Pr.properties");
		Properties p=new Properties();
		p.load(fis1);
		String url=p.getProperty("url1");
		String un=p.getProperty("un1");
		String pwd=p.getProperty("pwd1");*/
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		PropertyfileUtility plib=new PropertyfileUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		
		//WebDriver driver=new FirefoxDriver();
		//wlib.waitForElementInDOM(driver);
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		ProductPage pp=new ProductPage(driver);
		CreateProductPage cp=new CreateProductPage(driver);
		CampaignPage camp=new CampaignPage(driver);
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		ProductInfoPage pip=new ProductInfoPage(driver);
		
		String url = plib.getPropertyKeyvalue("url");
		//String un = plib.getPropertyKeyvalue("un");
		//String pwd = plib.getPropertyKeyvalue("pwd");
		
		int rannum = jlib.getrandominteger();
		//driver.get(url);
		//lp.LoginToApp(un, pwd);
		hp.getProducts().click();
		pp.getCreateProductButton().click();
		String pName = elib.getExcelData("Sheet1", 0, 1);
		cp.getProductNameEtd().sendKeys(pName+rannum);
		cp.getProductSaveButton().click();
		pip.getHomeBut().click();
		hp.getMore().click();
		hp.getCampaigns().click();
		camp.getCreateCapmaignbutton().click();
		String cName = elib.getExcelData("Sheet1", 5, 0);
		ccp.getCampNameEtd().sendKeys(cName+rannum);
		ccp.getProdButton().click();
		wlib.switchToWindow(driver, "Products&action");
		driver.findElement(By.linkText(pName+rannum)).click();
		wlib.switchToWindow(driver, "Campaigns&action");
		ccp.getCampSaveButton().click();
	    cip.getCamHomeButton().click();
		//wlib.mouseOverOnElement(driver, cip.getCamAdminImg());
		//cip.getCamSignOut().click();
		
		
		
		
		
		
		
		/*String url = plib.getPropertyKeyvalue("url");
		String un = plib.getPropertyKeyvalue("un");
		String pwd = plib.getPropertyKeyvalue("pwd");

		//to execute the code without getting alert pop up
		//Random ran=new Random();
		//int rannum=ran.nextInt(1000);
		//int rannum1=ran.nextInt(1000);
		int rand = jlib.getrandominteger();
		WebDriver driver=new FirefoxDriver();
		wlib.waitForElementInDOM(driver);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		/*FileInputStream fis2=new FileInputStream("./data/excel1.xlsx");
		Workbook book=WorkbookFactory.create(fis2);
		Cell cell = book.getSheet("Sheet1").getRow(1).getCell(0);
		String pass = cell.getStringCellValue();
		String fpass = pass+rannum1;*/
		/*String pass = elib.getExcelData("Sheet1", 0, 0);
		String fpass = pass+rand;
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(fpass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		/*FileInputStream fis=new FileInputStream("./data/excel1.xlsx");
		Workbook book1=WorkbookFactory.create(fis);
		Cell cell1 = book1.getSheet("Sheet1").getRow(1).getCell(1);
		String texts = cell1.getStringCellValue();
		String val = texts+rannum;*/
		/*String val = elib.getExcelData("Sheet1", 1, 0);
		String value = val+rand;
		WebElement ele = driver.findElement(By.linkText("More"));
		//Actions act=new Actions(driver);
		//act.moveToElement(ele).perform();
		wlib.mouseOverOnElement(driver, ele);
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(value);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		/*while(it1.hasNext())
		{
			String Cid = it1.next();
			driver.switchTo().window(Cid);
			String title1 = driver.getTitle();
			if(title1.contains("Products&action"));
			{
				break;
			}
		}
		Thread.sleep(10000);*/
		/*wlib.switchToWindow(driver, "Products&action");
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(fpass);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(fpass)).click();
		/*Set<String> set2 = driver.getWindowHandles();
		Iterator<String> it2 = set2.iterator();
		while(it2.hasNext())
		{
			String Cid = it2.next();
			driver.switchTo().window(Cid);
			String title2 = driver.getTitle();
			if(title2.contains("Campaigns&action"))
			{
				break;
			}
		}*/
		/*wlib.switchToWindow(driver, "Campaigns&action");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOverOnElement(driver, ele1);
		driver.findElement(By.linkText("Sign Out")).click();*/
		

	}
}


