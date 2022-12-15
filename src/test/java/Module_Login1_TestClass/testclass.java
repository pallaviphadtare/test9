package Module_Login1_TestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.baseclass;
import Library_Files.utilityclass;
import Module_Login1.pom1;
import Module_Login1.pom2;
import junit.framework.Assert;

public class testclass extends baseclass
{

	
	pom1 p1;
	pom2 p2;
	int screenshots;
	
	@BeforeClass
	public void OpenBrowser()
	{
		openbrowser();
		 p1=new pom1(driver);
		 p2=new pom2(driver);
	}
	
	@BeforeMethod
	public void Login() throws IOException
	{
		p1.enterUN(utilityclass.getdatafrompropfile("UN"));
		p1.enterPSW(utilityclass.getdatafrompropfile("PSW"));
		p1.clickloginbutton();
	}
	
	@Test
	public void TC1() throws EncryptedDocumentException, IOException
	{
		String ExpectedUN=utilityclass.getdatafromexcelsheet(0, 0);
		String ActualUN=p2.verifyUN();
		Assert.assertEquals(ActualUN, ExpectedUN);
	}
	
	@AfterMethod
	public void Logout(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			utilityclass.takescreenshot(driver, screenshots);
		}
		p2.clickUN();
		p2.clicklogoutbtn();
		
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}
}
