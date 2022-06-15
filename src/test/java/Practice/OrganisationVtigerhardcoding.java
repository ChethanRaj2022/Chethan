package Practice;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyfileUtility;
import genericUtility.WebdriverUtility;

public class OrganisationVtigerhardcoding {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		PropertyfileUtility plib=new PropertyfileUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		
		String url = plib.getPropertyKeyvalue("url");
		String un = plib.getPropertyKeyvalue("un");
		String pwd = plib.getPropertyKeyvalue("pwd");
		
		driver.get(url);
		
		int rand = jlib.getrandominteger();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='submiButton']")).click();
		driver.findElement(By.xpath("//a[.='Organizations']/../../td[6]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String val = elib.getExcelData("Sheet3", 0, 0);
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(val+rand);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/soft/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sin out"));
		
		
	
	}

}
