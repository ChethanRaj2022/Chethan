package Practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyfileUtility;
import genericUtility.WebdriverUtility;

public class PurcahseOrderTestWithDocumentsTest {
	public static void main(String[] args) throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		PropertyfileUtility plib=new PropertyfileUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		
		String url = plib.getPropertyKeyvalue("url");
		String un = plib.getPropertyKeyvalue("un");
		String pwd = plib.getPropertyKeyvalue("pwd");
		
		WebDriver driver=new FirefoxDriver();
		wlib.waitForElementInDOM(driver);
		driver.get(url);
		
		int rand = jlib.getrandominteger();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		driver.findElement(By.linkText("More")).click();
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
		String quanty = elib.getNumberFromExcel("Sheet2",0,0);
		System.out.println(quanty);
		driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys(quanty);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Documents")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		String doc = elib.getExcelData("Sheet1", 3, 1);
		String fdoc = doc+rand;
		driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(fdoc);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOverOnElement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
