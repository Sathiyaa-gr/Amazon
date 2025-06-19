package amazonPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmzYourOrdersPage 
{
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	//step 1
	@FindBy(xpath="//select[@id='time-filter']")
	WebElement orderplacedrp;
	@FindBy(xpath="(//a[@class='a-touch-link a-box a-touch-link-noborder'])[1]")
	WebElement orderItem;
	
	@FindBy(xpath="//a[@id='a-autoid-5-announce']")
	WebElement productReview;
	
	@FindBy(xpath="//textarea[@id='reviewText']")
	WebElement writeReview;
	
	@FindBy(xpath="//span/img[@alt='select to rate item five star.']")
	WebElement rating;
	
	@FindBy(xpath="//span[@class='a-button-inner']/input[@class='a-button-input']")
	WebElement submitRating;
	
	//step 2
	public void orderPlacedin(String val)
	{
		
		wait.until(ExpectedConditions.visibilityOf(orderplacedrp));		
		Select s=new Select(orderplacedrp);
		s.selectByValue(val);
	}
	public void writeReview()
	{
		wait.until(ExpectedConditions.visibilityOf(writeReview));		
		writeReview.sendKeys("Very Good");
	}

	public void productReview()
	{
		wait.until(ExpectedConditions.visibilityOf(productReview));		
		productReview.click();
				
	}
	public void rating()
	{
		wait.until(ExpectedConditions.visibilityOf(rating));		
		rating.click();		
	}
	public void submitRating()
	{
		wait.until(ExpectedConditions.visibilityOf(submitRating));		
		submitRating.click();	
	}
	
	//step 3
	public AmzYourOrdersPage(WebDriver driver)
	{
		this.driver=driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	 
}

