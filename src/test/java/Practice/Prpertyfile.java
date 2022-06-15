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

public class Prpertyfile {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//get java representation of the object for physical file
		FileInputStream fis=new FileInputStream("./data/Pr.properties");//java.io package
		
		//create a object to property class to load all the keys
		Properties p=new Properties();//java.util package
		p.load(fis);
		
		//Read the value using getProperty("")
		String browser=p.getProperty("browser");
		String url = p.getProperty("url");
		String un=p.getProperty("un");
		String pwd=p.getProperty("pwd");
		
		WebDriver driver;
		if(browser.equals("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
	
		
		//launch the browser
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		Thread.sleep(2000);
		System.out.println(url);
		System.out.println(un);
		System.out.println(pwd);
		driver.close();
		


	}

}
