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
	@FindBy(xpath="//a[@id='change-delivery-link']")	WebElement chngDeliveryAddr;
	
	@FindBy(xpath="(//input[@class='a-button-input'])[1]")	WebElement usepayment;
	
	@FindBy(xpath="//input[contains(@value,'COD')]")	WebElement cashOnDelivery;
	
	@FindBy(xpath="//span[normalize-space()='Amazon Pay']")	WebElement amazonPay;
	
	@FindBy(xpath="//span[normalize-space()='Amazon Pay']")	WebElement paynyUPI;

	@FindBy(xpath="//form[@id='pp-smirND-105']")	WebElement form;
	
	
	//step 2
	
	public void paymentOption()
	{
		driver.switchTo().frame(form);
		wait.until(ExpectedConditions.elementToBeClickable(amazonPay)).click(); 		 
		wait.until(ExpectedConditions.elementToBeClickable(usepayment)).click();
		Assert.assertTrue(driver.getPageSource().contains("Order Summary") || 
                driver.getTitle().contains("Place your order"), "Order Review not reached");
		Reporter.log("Order review reached successfully");
	}
	public void DeliveryAddress()
	{
		wait.until(ExpectedConditions.elementToBeClickable(chngDeliveryAddr));
		 Assert.assertTrue(chngDeliveryAddr.isDisplayed(), "Order Review section is not visible or clickable");
		 Reporter.log("Address verified");
	 }
	
	
	//step 3
	public AmzPaymentPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		    
	}

	
		
}
