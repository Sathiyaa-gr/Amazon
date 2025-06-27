package amazonPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AmzCardDetailsPage {
	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//iframe[@name='ApxSecureIframe']")	WebElement iframe;
		
	@FindBy(xpath="//input[@value='SelectableAddCreditCard']")	WebElement credit_debitCard;
	@FindBy(xpath="//a[@class='a-link-emphasis pmts-add-cc-default-trigger-link']")	WebElement addCard;
	
	@FindBy(xpath="//input[@name='addCreditCardNumber']")
	WebElement cardNumber;
	
	@FindBy(xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent']")	WebElement Btncontinue;
	@FindBy(xpath="(//span[@class='a-list-item'])[1]")	WebElement errormsg1;
	@FindBy(xpath="(//span[@class='a-list-item'])[2]")	WebElement errormsg2;
	
	
	
	//step 2
	
	public void paymentSelection() throws InterruptedException
	{
			wait.until(ExpectedConditions.elementToBeClickable(credit_debitCard));
			credit_debitCard.click();
			//System.out.println("Selected credit_debitCard");
			addCard.click();
			Reporter.log("Selected credit_debitCard");
						
	}
	
	public void cardDetails() throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(
			    By.name("ApxSecureIframe")));
		driver.switchTo().frame(iframe);
		wait.until(ExpectedConditions.visibilityOf(cardNumber));
		cardNumber.sendKeys("654626544465");
		Btncontinue.click();
		Assert.assertEquals(errormsg1.getText().trim(), "Card number is not correct.", "Card number error mismatch");
	    Assert.assertEquals(errormsg2.getText().trim(), "Expiration date is not correct.", "Expiration date error mismatch");

		Reporter.log("Error 1: " + errormsg1.getText(), true);
		Reporter.log("Error 2: " + errormsg2.getText(), true);
						
	}
	
	//step 3
	public AmzCardDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
}
