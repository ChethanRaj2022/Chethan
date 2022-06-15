package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;

public class DataOroviderWithDDtTest {
	
	@Test(dataProvider="bookticketDataProvider")
	public void bookTicket(String src,String dest,String ticket)
	{
		System.out.println("source is "+src+" destination is "+dest+" number of tickets is "+ticket);
	}
	
	@DataProvider
	public Object[][] bookticketDataProvider() throws EncryptedDocumentException, IOException
	{
		ExcelUtility elib=new ExcelUtility();
		String src1=elib.getExcelData("Sheet2", 0, 0);
		String dest1=elib.getExcelData("Sheet2", 0, 1);
		String ticket1=elib.getNumberFromExcel("Sheet2", 0, 2);
		
		String src2=elib.getExcelData("Sheet2", 1, 0);
		String dest2=elib.getExcelData("Sheet2", 1, 1);
		String ticket2=elib.getNumberFromExcel("Sheet2", 1, 2);
		
		String src3=elib.getExcelData("Sheet2", 2, 0);
		String dest3=elib.getExcelData("Sheet2", 2, 1);
		String ticket3=elib.getNumberFromExcel("Sheet2", 2, 2);
		
		Object[][] objarr=new Object[3][3];
		objarr[0][0]=src1;
		objarr[0][1]=dest1;
		objarr[0][2]=ticket1; 
		
		objarr[1][0]=src2;
		objarr[1][1]=dest2;
		objarr[1][2]=ticket2;
		
		objarr[2][0]=src3;
		objarr[2][1]=dest3;
		objarr[2][2]=ticket3;
		return objarr;
		
		
	}

}
