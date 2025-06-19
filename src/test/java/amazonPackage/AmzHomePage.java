package amazonPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmzHomePage 
{
	WebDriver driver;
	//step 1
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	WebElement accountandlist;
	
	@FindBy(xpath="(//span[.='Sign in'])[1]")
	WebElement signin_link;
	
	
	@FindBy(xpath="//span[normalize-space()='Sign Out']")
	WebElement signout;
	
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	
	@FindBy(xpath="//div[@id='hmenu-home-container']")
	WebElement home;

	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement cartIcon;
	
	@FindBy(xpath="//span[normalize-space()='Your Orders']")
	WebElement yourOrders;
	
	
	//step 2
	public void hoveroveraccountandlist(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(accountandlist).perform();
		
	}

	public void searchingtheproduct()
	{
		search.sendKeys("shoes for kids"+Keys.ENTER);
		
	}
	
	public void signin() throws InterruptedException
	{
		Thread.sleep(2000);
		signin_link.click();
		
	}
	public void logout()
	{
		signout.click();
		
	}
	public void navigate_home()
	{
		home.click();
	}
	public void clickCart() throws InterruptedException
	{
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 30);");
		js.executeScript("arguments[0].scrollIntoView(true);", cartIcon);
        Thread.sleep(2000); // short wait to let scroll finish

        // Click using JavaScript
        js.executeScript("arguments[0].click();", cartIcon);
	}
	
	
	public void yourOrders()
	{
		yourOrders.click();
	}
	
	//step 3
	public AmzHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 
}

