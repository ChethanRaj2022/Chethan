package genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	/**
	 * it is an implicitly wait, always wait for element in DOM document & release the control 
	  if element available 
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * it is Explicitly wait always wait for page to be loaded & available in GUI
	 * @param driver
	 * @param partialPageURL
	 */
	public void waitForPage(WebDriver driver,String partialPageURL)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.urlContains(partialPageURL));
	}

	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String currentWindowTitle=driver.getWindowHandle();
			if(currentWindowTitle.equals(partialWindowTitle))
			{
				break;
			}
		}
	}

	/**
	 * used to switch to alert window and click on ok button
	 * @param driver
	 * @param expectedMsg
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}

	/**
	 * used to switch to frame window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * used to switch to frame window based on id or name
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select value from drop down based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement ele,int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}

	/**
	 * used to select value from drop down based on value
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	//public void executeJavaScript(WebDriver driver , String javaScript) {
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeAsyncScript(javaScript, null);
	//}
	
    /**
     * used to wait and click on element for 20 times
     * @param element
     * @throws InterruptedException
     */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<20) {
			try {
				element.click();
				break;
			}catch(Throwable e){
				Thread.sleep(1000);
				count++;
			}
		}
	}
	

    /**
     * pass enter Key appertain in to Browser
     * @param driver
     */
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   } 
   
   /**
    * this method is used to take screenshot of web page
    * @param driver
    * @param path
    * @throws IOException
    */
   public void ScrShots(WebDriver driver,String path) throws IOException
   {
	   TakesScreenshot tss=(TakesScreenshot) driver;
	   File src=tss.getScreenshotAs(OutputType.FILE);
	   File desc=new File(path);
	   FileHandler.copy(src, desc);   
	   
   }
   
   



}
