package Module_Login1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	@FindBy(xpath="//input[@name='username']") private WebElement UserName;
	@FindBy(xpath="//input[@name='password']") private WebElement Password;
	@FindBy(xpath="//button[text()=' Login ']") private WebElement LoginBtn;
	
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void EnterUN(String username)	// Admin
	{
		UserName.sendKeys(username);	// Admin
	}
	
	public void EnterPSW(String password)
	{
		Password.sendKeys(password);  // admin123
	}
	
	public void ClickLoginBtn()
	{
		LoginBtn.click();
	}
}
