package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginVtiger {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		Thread.sleep(2000);
		driver.get("http://localhost:8888/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
