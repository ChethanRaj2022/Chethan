package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithoutDDtTest {
	
	@Test(dataProvider="bookticketsdataprovider")
	public void bookTicket(String src,String dest,int ticket)
	{
		System.out.println("source is "+src+" destination is "+dest+" number of tickets are "+ticket);
	}
	
	@DataProvider
	public Object[][] bookticketsdataprovider()
	{
		Object[][] objarr=new Object[3][3];
		objarr[0][0]="Bangalore";
		objarr[0][1]="Mysore";
		objarr[0][2]=10;
		
		objarr[1][0]="Bangalore";
		objarr[1][1]="Goa";
		objarr[1][2]=20;
		
		objarr[2][0]="Bangalore";
		objarr[2][1]="Kerala";
		objarr[2][2]=30;
		
		return objarr;
		
	}

}
