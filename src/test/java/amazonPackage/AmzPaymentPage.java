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

public class AmzPaymentPage {
	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="(//div[@class='a-radio'])[2]")	WebElement bajaj;
	
	@FindBy(xpath="(//div[@class='a-radio'])[3]")	WebElement amazonPay;
	
	@FindBy(xpath="(//div[@class='a-radio'])[4]")	WebElement credit_debitCard;
	
	@FindBy(xpath="(//div[@class='a-radio'])[1]")	WebElement amazonPayBalance;
	
	@FindBy(xpath="(//div[@class='a-radio'])[5]")	WebElement otherUPI;

	@FindBy(xpath="(//div[@class='a-radio'])[6]")	WebElement cod;
	
	
	//step 2
	
	public void paymentSelection() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(amazonPayBalance));
		amazonPayBalance.click();
		Assert.assertFalse(amazonPayBalance.getAttribute("class").contains("a-radio-selected"));
		System.out.println("Selected AmazonPayBalance ");
				
		bajaj.click();
		System.out.println("Selected Bajaj Finser");
		
		amazonPay.click();
		System.out.println("Selected AmazonPay");
		
		credit_debitCard.click();
		System.out.println("Selected credit_debitCard");
		
		otherUPI.click();
		Assert.assertFalse(otherUPI.getAttribute("class").contains("a-radio-selected"));
		System.out.println("Selected otherUPI");
		Reporter.log("selected each payment ");
		
		
	}
	
	
	
	//step 3
	public AmzPaymentPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		    
	}

	
		
}
