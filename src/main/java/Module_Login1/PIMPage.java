package Module_Login1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage
{

	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']") private WebElement UN;
	@FindBy(xpath="//a[text()='Logout']") private WebElement logoutbtn;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]") private WebElement EmplID;
	
	public PIMPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String VerifyUN()
	{
		String ActualUN=UN.getText();
			return ActualUN;
	}
	
	public void clickusername()
	{
		UN.click();
	}
	
	public void clicklogoutbtn()
	{
		logoutbtn.click();
	}
	
	public void EnterEmplID(String emplID)
	{
		EmplID.sendKeys(emplID);
	}
	
	
}
