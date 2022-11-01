package Module_Login1_TestClass;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.Base_Class;
import Library_Files.Utility_Class;
import Module_Login1.LoginPage;
import Module_Login1.PIMPage;

public class TestNG_Test_Class extends Base_Class
{

	// openBrowser() will internally present here because of inheritance
	// open webpage will internally present here because of inheritance
	// public WebDriver driver; will internally present here because of inheritance
	
	LoginPage LP;
	PIMPage PP;
	int TestCaseID;
	
	@BeforeClass
	public void OpenBrowser() throws InterruptedException
	{
		openBrowser();
		
	// create object of LoginPage POM class
		LP=new LoginPage(driver);
		
	// create object of PIMPage POM class
		PP=new PIMPage(driver);
			
	}
	
	@BeforeMethod
	public void Login() throws IOException
	{
		LP.EnterUN(Utility_Class.getdatafrompropfile("UN"));	// Admin
		LP.EnterPSW(Utility_Class.getdatafrompropfile("PSW"));	//admin123
		LP.ClickLoginBtn();
	}
	
	@Test(priority=1)
	public void TC1() throws EncryptedDocumentException, IOException
	{
		TestCaseID=1;
		String ExpectedUN=Utility_Class.getdatfromexcelsheet(0, 0);
		String ActualUN=PP.VerifyUN();
		Assert.assertEquals(ActualUN, ExpectedUN);
	}
	
	@Test(priority=2)
	public void TC2() throws EncryptedDocumentException, IOException
	{
		TestCaseID=2;
		String ActualTitle=driver.getTitle();
		String ExpectedTitle=Utility_Class.getdatfromexcelsheet(0, 1);
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Test(priority=3)
	public void TC3() throws EncryptedDocumentException, IOException
	{
		TestCaseID=3;
		PP.EnterEmplID(Utility_Class.getdatafrompropfile("EID"));
		
	}
	
	@AfterMethod
	public void LogOut(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.takeScreenshot(driver,TestCaseID);
		}
				
		PP.clickusername();
		PP.clicklogoutbtn();
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}
	

}
