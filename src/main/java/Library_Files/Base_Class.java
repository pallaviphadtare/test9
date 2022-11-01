package Library_Files;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base_Class
{

	public WebDriver driver;
	
	
	
	public void openBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Eclips jun\\Maven_Project\\Browser\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//open webpage
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//wait
			Thread.sleep(2000);
			
		// maximize webpage
			driver.manage().window().maximize();
			
		// wait
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
	}
}
