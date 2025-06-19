package amazonPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AmzLoginPage {
	WebDriver driver;
	
	//step 1
	@FindBy(name="email")	WebElement username;
	
	@FindBy(id="continue")	WebElement continuefromUN;	
	
	@FindBy(id="ap_password")	WebElement password;
	
	@FindBy(id="signInSubmit")	WebElement signin_link;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")	WebElement user_msg;
		
	//step 2
	public void un()
	{
		username.sendKeys("9940271110");
		Assert.assertTrue(continuefromUN.isDisplayed());
		
	}
	public void continueUN()
	{
		continuefromUN.click();
		
	}
	
	public void  sigin() throws InterruptedException
	{
		Thread.sleep(2000);
		signin_link.click();
		String txt =user_msg.getText();
		System.out.println("Greeting message: " + txt);
		Assert.assertTrue(txt.contains("Hello"), "Login failed - Greeting not found.");
		
	}
	public void pwd()
	{			
		password.sendKeys("Jashu@16");
		Assert.assertTrue(signin_link.isDisplayed());
		}
	
	//step 3
	public AmzLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
