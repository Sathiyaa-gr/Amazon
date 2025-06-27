package amazonPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AmzInvalidLoginPage {
	WebDriver driver;
	
	//step 1
	@FindBy(name="email")	WebElement username;
	
	@FindBy(id="continue")	WebElement continuefromUN;	
	
	@FindBy(id="ap_password")	WebElement password;
	
	@FindBy(id="signInSubmit")	WebElement signin_link;
	
	@FindBy(xpath = "//div[@class='a-alert-content']")	WebElement errorMessage;

		
	//step 2
	public void un(String user)
	{
		username.sendKeys(user);
		
	}
	public void continueUN()
	{
		continuefromUN.click();
		
	}
	
	public void  sigin() throws InterruptedException
	{
		
		signin_link.click();
		Assert.assertEquals(getErrorMessage(), "Your password is incorrect");
		Reporter.log("Invalid password");
	}
	
	public void pwd(String pwd)
	{
			password.sendKeys(pwd);
			
	}	
	
	public String getErrorMessage() 
	{
	    return errorMessage.getText();
	}
	
	
	//step 3
	public AmzInvalidLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
