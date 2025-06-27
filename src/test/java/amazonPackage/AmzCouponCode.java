package amazonPackage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AmzCouponCode {
	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//div[@class='a-row a-spacing-top-small']/input")	WebElement enterCode;
	
	@FindBy(xpath="//input[@name='ppw-claimCodeApplyPressed']")	WebElement apply_btn;
	
	
	//step 2
	
	public void enterCopoun() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(enterCode));
		enterCode.sendKeys("GPAYB2G2TEC9IT94");
		wait.until(ExpectedConditions.visibilityOf(apply_btn));
		apply_btn.click();
		
	}
	
	
	
	//step 3
	public AmzCouponCode(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		    
	}

	
		
}
