package com.crm.malifice.organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.malifice.pomrepositoryutility.CreateOrganizationPage;
import com.crm.malifice.pomrepositoryutility.HomePage;
import com.crm.malifice.pomrepositoryutility.LoginPage;
import com.crm.malifice.pomrepositoryutility.OrganizationInfoPage;
import com.crm.malifice.pomrepositoryutility.OrganizationInfoPage2;
import com.crm.malifice.pomrepositoryutility.OrganizationPage;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyfileUtility;
import genericUtility.WebdriverUtility;

public class CreateOrgTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createOrg() throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		PropertyfileUtility plib=new PropertyfileUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		
		//LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		OrganizationPage op=new OrganizationPage(driver);
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		OrganizationInfoPage2 oipp=new OrganizationInfoPage2(driver);
		
		int rannum = jlib.getrandominteger();
		hp.getOraganization().click();
		op.getCreateOrganizationButton().click();
		String val = elib.getExcelData("Sheet1", 0, 0);
		cop.getOrgNameEtd().sendKeys(val+rannum);
		cop.getOrgSaveButton().click();
		
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		SoftAssert sa=new SoftAssert();
		String actualorgName = orgInfo.actualOrgName();
		sa.assertEquals(actualorgName.contains(val+rannum), true);
		//OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		/*String actualval = orgInfo.getOrgSuccessfulMsg().getText();
		if(actualval.contains(val))
		{
			System.out.println("organization created");
		}
		else {
			System.out.println("organization not created");
		}*/
		
		
		
		//driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
		//oipp.getOrghome().click();
		//WebElement ele = hp.getAdminimg();
		//wlib.mouseOverOnElement(driver, ele);
		//hp.getSignout.click();
		//Thread.sleep(2000);
		
		
		
		
		/*WebDriver driver=new FirefoxDriver();
		wlib.waitForElementInDOM(driver);
		
		int rannum = jlib.getrandominteger();
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		OrganizationPage op=new OrganizationPage(driver);
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		
		String url = plib.getPropertyKeyvalue("url");
		String un = plib.getPropertyKeyvalue("un");
		String pwd = plib.getPropertyKeyvalue("pwd");
		
		driver.get(url);
		lp.LoginToApp(un, pwd);
		hp.getOraganization().click();
		op.getCreateOrganizationButton().click();
		String org = elib.getExcelData("Sheet1", 4, 0);
		cop.createOrg(org+rannum);
		wlib.mouseOverOnElement(driver, oip.getOrgAdminImg());
		oip.getOrgsignOut().click();
		
		
		
		//WebElement ele1 = oip.getOrgAdminImg();
		//wlib.mouseOverOnElement(driver, ele1);
		//oip.getOrgsignOut().click();
		
		
		
		/*String url = plib.getPropertyKeyvalue("url");
		String un = plib.getPropertyKeyvalue("un");
		String pwd = plib.getPropertyKeyvalue("pwd");
		//FileInputStream fis1=new FileInputStream("./data/Pr.properties");
		//Properties p=new Properties();
		//p.load(fis1);
		//String url=p.getProperty("url1");
		//String un=p.getProperty("un1");
		//String pwd=p.getProperty("pwd1");
		
		//to execute the code without getting alert pop up
		//Random ran=new Random();
		//int rannum=ran.nextInt(1000);
		int rand = jlib.getrandominteger();

		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[.='Organizations']/../../td[6]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//FileInputStream fis=new FileInputStream("./data/excel1.xlsx");
		//Workbook book=WorkbookFactory.create(fis);
		//Sheet sheet = book.getSheet("Sheet1");
		//Row row = sheet.getRow(0);
		//Cell cell = row.getCell(1);
		//String val = cell.getStringCellValue();
		//String value = val+rannum;
		String val = elib.getExcelData("Sheet1", 1, 0);
		String value = val+rand;
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(value);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		WebElement texts = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actualval = texts.getText();
		if(actualval.contains(value))
		{
			System.out.println("organization created");
		}
		else {
			System.out.println("organization not created");
		}
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG\']"));
		//Actions act=new Actions(driver);
		//act.moveToElement(ele).perform();
		wlib.mouseOverOnElement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();*/


	}

}

