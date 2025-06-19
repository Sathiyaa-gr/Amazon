package amazonPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmzAccountPage {
	WebDriver driver;
	//step 1
	@FindBy(xpath="//span[normalize-space()='Your Account']")
	WebElement yourAccount;
	
	@FindBy(xpath="//h2[normalize-space()='Your Addresses']")
	WebElement your_Address;
	
	@FindBy(xpath="//h2[normalize-space()='Login & security']")	WebElement Login_security;
	
		
	//step 2
	public void yourAccount()
	{
		yourAccount.click();																																																													
	}
	public void Address()
	{
		your_Address.click();																																																													
	}
	public void Login_security()
	{
		Login_security.click();																																																													
	}
	//step 3
	public AmzAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
