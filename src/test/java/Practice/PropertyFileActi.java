package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyFileActi {
	public static void main(String[] args) throws IOException, InterruptedException {
		
	FileInputStream fis=new FileInputStream("./data/Pr.properties");
	Properties p=new Properties();
	p.load(fis);
	String browser=p.getProperty("browser");
	String url=p.getProperty("url");
	String un=p.getProperty("un");
	String pwd=p.getProperty("pwd");
	WebDriver driver;
	if(browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equals("firefox"))
	{
		//WebDriverManager.firefoxdriver();setup();
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	driver.get(url);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(pwd);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[.='Login ']")).click();
	Thread.sleep(2000);
	driver.close();
	
}
}