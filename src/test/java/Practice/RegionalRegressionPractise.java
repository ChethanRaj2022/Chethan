package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.malifice.pomrepositoryutility.ContactInfoPage;
import com.crm.malifice.pomrepositoryutility.ContactPage;
import com.crm.malifice.pomrepositoryutility.CreateContactPage;
import com.crm.malifice.pomrepositoryutility.CreateOrganizationPage;
import com.crm.malifice.pomrepositoryutility.HomePage;
import com.crm.malifice.pomrepositoryutility.LoginPage;
import com.crm.malifice.pomrepositoryutility.OrganizationInfoPage;
import com.crm.malifice.pomrepositoryutility.OrganizationInfoPage2;
import com.crm.malifice.pomrepositoryutility.OrganizationPage;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyfileUtility;
import genericUtility.WebdriverUtility;

public class RegionalRegressionPractise extends BaseClass{

	@Test(groups = "smokeTest")
	public void createOrg() throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		PropertyfileUtility plib=new PropertyfileUtility();
		WebdriverUtility wlib=new WebdriverUtility();

		//LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		OrganizationPage op=new OrganizationPage(driver);
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		OrganizationInfoPage2 oipp=new OrganizationInfoPage2(driver);

		int rannum = jlib.getrandominteger();
		hp.getOraganization().click();
		op.getCreateOrganizationButton().click();
		String val = elib.getExcelData("Sheet1", 0, 0);
		cop.getOrgNameEtd().sendKeys(val+rannum);
		cop.getOrgSaveButton().click();

		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		String actualval = orgInfo.getOrgSuccessfulMsg().getText();
		if(actualval.contains(val))
		{
			System.out.println("organization created");
		}
		else {
			System.out.println("organization not created");
		}

	}
	
	@Test(groups = "regressionTest")
	public void createContact() throws InterruptedException, EncryptedDocumentException, IOException {
		
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		PropertyfileUtility plib=new PropertyfileUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		String url=plib.getPropertyKeyvalue("url");
		driver.get(url);
		
		ContactPage cp=new ContactPage(driver);
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		ContactInfoPage cip=new ContactInfoPage(driver);
		CreateContactPage ccp=new CreateContactPage(driver);
		hp.getContacts().click();
		int rannum = jlib.getrandominteger();
		cp.gotoCreateContact();
		String lastName = elib.getExcelData("Sheet1", 0, 0);
		ccp.CreateContact(lastName+rannum);
		cip.getConHomeBut().click();
		
	}
}