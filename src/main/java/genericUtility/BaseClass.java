package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.malifice.pomrepositoryutility.HomePage;
import com.crm.malifice.pomrepositoryutility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
//baseclass is edited
	public PropertyfileUtility filelib=new PropertyfileUtility();
	public WebdriverUtility drivlib=new WebdriverUtility();

	public WebDriver driver=null;
	public static WebDriver sdriver;

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void bs()
	{
		System.out.println("database connection");
	}
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void bt()
	{
		System.out.println("batch execution started");
	}
	//@Parameters("Browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	//public void launchBrowser(String Browser) throws Throwable
	public void bc() throws IOException
	{
		String browser=filelib.getPropertyKeyvalue("browser");
		if(browser.equalsIgnoreCase("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		drivlib.waitForElementInDOM(driver);
		sdriver=driver;
		String url=filelib.getPropertyKeyvalue("url");
		driver.get(url);
		
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void bm() throws IOException
	{
		String un = filelib.getPropertyKeyvalue("un");
		String pwd = filelib.getPropertyKeyvalue("pwd");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginToApp(un, pwd);
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void am()
	{
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void ac()
	{
		driver.quit();
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void at()
	{
		System.out.println("batch execution ended");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void as()
	{
		System.out.println("connection with database removed");
	}

}
