package Practice;

import org.testng.annotations.Test;
//@Test
public class SampleTest {
	@Test(priority=0)
	public void createContactTest()
	{
		System.out.println("createContactTest");
	}
	
	@Test
	public void modifyContactTest()
	{
		System.out.println("contact modified");
	}
	
	@Test(priority=2)
	public void deleteContactTest()
	{
		System.out.println("contact deleted");
	}

}
