package Practice;

import java.io.File;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


import genericUtility.BaseClass;
import genericUtility.JavaUtility;

public class ListenerImgClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		JavaUtility jlib=new JavaUtility();
		String testName = result.getMethod().getMethodName();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=eDriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+testName+"_"+jlib.getSystemDate()+".png");
		try {
			org.apache.commons.io.FileUtils.copyDirectory(src, dest);
		}
		catch(Exception e) {
			
		}
		
		
	}

}
