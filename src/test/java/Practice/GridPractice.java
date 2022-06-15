package Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GridPractice {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:4444");
		DesiredCapabilities cap = new DesiredCapabilities();
	
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("http://gmail.com");


	}

}
