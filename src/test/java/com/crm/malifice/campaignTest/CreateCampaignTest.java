package com.crm.malifice.campaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import com.crm.malifice.pomrepositoryutility.HomePage;
import com.crm.malifice.pomrepositoryutility.LoginPage;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyfileUtility;
import genericUtility.WebdriverUtility;

public class CreateCampaignTest extends BaseClass {
@Test(groups = "smokeTest")
	public void createCampaign() throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		PropertyfileUtility plib=new PropertyfileUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		
		//WebDriver driver=new FirefoxDriver();
		//wlib.waitForElementInDOM(driver);
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		CampaignPage cp=new CampaignPage(driver);
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		
		String url = plib.getPropertyKeyvalue("url");
		//String un = plib.getPropertyKeyvalue("un");
		//String pwd = plib.getPropertyKeyvalue("pwd");
		
		driver.get(url);
		int rannum = jlib.getrandominteger();
		//lp.LoginToApp(un, pwd);
		hp.getMore().click();
		hp.getCampaigns().click();
		cp.getCreateCapmaignbutton().click();
		String camName = elib.getNumberFromExcel("Sheet1", 5, 0);
		ccp.getCampNameEtd().sendKeys(camName+rannum);
		ccp.getCampSaveButton().click();
		cip.getCamHomeButton().click();
		//wlib.mouseOverOnElement(driver, cip.getCamAdminImg());
		//cip.getCamSignOut().click();
		
		
		
		/*String url = plib.getProper
		 * tyKeyvalue("url");
		 */
		//String un = plib.getPropertyKeyvalue("un");
		//String pwd = plib.getPropertyKeyvalue("pwd");
		
		/*FileInputStream fis1=new FileInputStream("./data/Pr.properties");
		Properties p=new Properties();
		p.load(fis1);
		String url=p.getProperty("url1");
		String un=p.getProperty("un1");
		String pwd=p.getProperty("pwd1");*/
		
		//to execute the code without getting alert pop up
		//Random ran=new Random();
		//int rannum=ran.nextInt(1000);
		/*int rand = jlib.getrandominteger();
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		WebElement ele = driver.findElement(By.linkText("More"));
		
		//Actions act=new Actions(driver);
		//act.moveToElement(ele).perform();
		/*wlib.mouseOverOnElement(driver, ele);
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		/*FileInputStream fis=new FileInputStream("./data/excel1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Cell cell = book.getSheet("Sheet1").getRow(1).getCell(1);
		String texts = cell.getStringCellValue();
		String val = texts+rannum;*/
		
		/*String val = elib.getExcelData("Sheet1", 0, 0);
		String value = val+rand;
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actual = ele1.getText();
		if(actual.contains(val))
		{
			System.out.println("campaign created");
		}
		else {
			System.out.println("campaign not created");
		}
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG\']"));
		//Actions act1=new Actions(driver);
		//act.moveToElement(ele2).perform();
		wlib.mouseOverOnElement(driver, ele2);
		driver.findElement(By.linkText("Sign Out")).click();
		WebElement ele5 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOverOnElement(driver, ele5);
		driver.findElement(By.linkText("Sign Out")).click();*/
		

	}

}
