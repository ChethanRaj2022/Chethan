package Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;

@Listeners(Practice.ListenerImgClass.class)

public class SampTest extends BaseClass{
	@Test
	public void aa()
	{
		System.out.println("Test Start");
		Assert.assertEquals(false, true);
		System.out.println("Test Fail");
	}
	
	
	


}
