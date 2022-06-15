package Practice;

import java.io.FileInputStream;
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

import com.crm.malifice.pomrepositoryutility.ContactInfoPage;
import com.crm.malifice.pomrepositoryutility.ContactPage;
import com.crm.malifice.pomrepositoryutility.CreateContactPage;
import com.crm.malifice.pomrepositoryutility.CreatePurchaseOrderPage;
import com.crm.malifice.pomrepositoryutility.CreateVendorPage;
import com.crm.malifice.pomrepositoryutility.HomePage;
import com.crm.malifice.pomrepositoryutility.LoginPage;
import com.crm.malifice.pomrepositoryutility.PurchaseOrderInfoPage;
import com.crm.malifice.pomrepositoryutility.PurchaseOrderPage;
import com.crm.malifice.pomrepositoryutility.VendoeInfoPage;
import com.crm.malifice.pomrepositoryutility.VendorPage;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyfileUtility;
import genericUtility.WebdriverUtility;

public class PurchaseOrderWIthItemAndAddServiceTest {

		public static void main(String[] args) throws IOException, InterruptedException {
			
			ExcelUtility elib=new ExcelUtility();
			JavaUtility jlib=new JavaUtility();
			PropertyfileUtility plib=new PropertyfileUtility();
			WebdriverUtility wlib=new WebdriverUtility();
			
			WebDriver driver=new FirefoxDriver();
			wlib.waitForElementInDOM(driver);
			
			LoginPage lp=new LoginPage(driver);
			HomePage hp=new HomePage(driver);
			ContactInfoPage cip=new ContactInfoPage(driver);
			ContactPage cp=new ContactPage(driver);
			CreateContactPage ccp=new CreateContactPage(driver);
			VendorPage vp=new VendorPage(driver);
			CreateVendorPage cvp=new CreateVendorPage(driver);
			VendoeInfoPage vip=new VendoeInfoPage(driver);
			PurchaseOrderInfoPage poip=new PurchaseOrderInfoPage(driver);
			PurchaseOrderPage pop=new PurchaseOrderPage(driver);
			CreatePurchaseOrderPage cpop=new CreatePurchaseOrderPage(driver);
			
			String url = plib.getPropertyKeyvalue("url");
			String un = plib.getPropertyKeyvalue("un");
			String pwd = plib.getPropertyKeyvalue("pwd");
			
			int rannum = jlib.getrandominteger();
			driver.get(url);
			lp.LoginToApp(un, pwd);
			hp.getContacts().click();
			cp.getAddContactButton().click();
			String cName = elib.getExcelData("Sheet1", 5, 0);
			ccp.getLastnameEtd().sendKeys(cName+rannum);
			ccp.getSaveCreateContact().click();
			cip.getConHomeBut().click();
			hp.getMore().click();
			hp.getVendors().click();
			vp.getAddVendorButton().click();
			String vName = elib.getExcelData("Sheet1", 1, 0);
			cvp.getVenNameEdt().sendKeys(vName+rannum);
			vip.getVenHomeBut().click();
			hp.getMore().click();
			hp.getPurchaseorder().click();
			
		
			
			/*FileInputStream fis1=new FileInputStream("./data/Pr.properties");
			Properties p=new Properties();
			p.load(fis1);
			String url=p.getProperty("url1");
			String un=p.getProperty("un1");
			String pwd=p.getProperty("pwd1");*/
			/*ExcelUtility elib=new ExcelUtility();
			JavaUtility jlib=new JavaUtility();
			PropertyfileUtility plib=new PropertyfileUtility();
			WebdriverUtility wlib=new WebdriverUtility();
			
			String url = plib.getPropertyKeyvalue("url");
			String un = plib.getPropertyKeyvalue("un");
			String pwd = plib.getPropertyKeyvalue("pwd");

			//to execute the code without getting alert pop up
			//Random ran=new Random();
			//int rannum=ran.nextInt(1000);
			//int rannum1=ran.nextInt(1000);
			
			int rand = jlib.getrandominteger();
			WebDriver driver=new FirefoxDriver();
			wlib.waitForElementInDOM(driver);
			driver.get(url);
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			String pro = elib.getExcelData("Sheet1", 0, 1);;
			String fpro = pro+rand;
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(fpro);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Services")).click();
			String serv = elib.getExcelData("Sheet1", 2, 1);
			String fserv = serv+rand;
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.xpath("//input[@name='servicename']")).sendKeys(fserv);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			/*FileInputStream fis=new FileInputStream("./data/excel1.xlsx");
			Workbook book1=WorkbookFactory.create(fis);
			Cell cell1 = book1.getSheet("Sheet1").getRow(1).getCell(0);
			String ven = cell1.getStringCellValue();
			String fven = ven+rannum1;*/
			/*driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Vendors")).click();
			String ven = elib.getExcelData("Sheet1", 1, 0);
			String fven = ven+rand;
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(fven);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Purchase Order")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			String sub = elib.getExcelData("Sheet1", 0, 0);
			String fsub = sub+rand;
			driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(fsub);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
			wlib.switchToWindow(driver, "Vendors&action");
			driver.findElement(By.linkText(fven)).click();
			wlib.switchToWindow(driver, "PurchaseOrder&action");
			String biladdr = elib.getExcelData("Sheet1", 2, 0);
			driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(biladdr);
			String shippaddr = elib.getExcelData("Sheet1", 3, 0);
			driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(shippaddr);
			driver.findElement(By.xpath("//img[@src='themes/images/products.gif']")).click();
			wlib.switchToWindow(driver, "Products&action");
			driver.findElement(By.linkText(fpro)).click();
			wlib.switchToWindow(driver, "PurchaseOrder&action");
			driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys("1");
			driver.findElement(By.xpath("//input[@value='Add Service']")).click();
			driver.findElement(By.xpath("//img[@src='themes/images/services.gif']")).click();
			wlib.switchToWindow(driver, "Services&action");
			driver.findElement(By.linkText(fserv)).click();
			wlib.switchToWindow(driver, "PurchaseOrder&action");
			driver.findElement(By.xpath("//input[@id='qty2']")).sendKeys("1");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wlib.mouseOverOnElement(driver, ele);
			driver.findElement(By.linkText("Sign Out")).click();*/
			

	}

}
