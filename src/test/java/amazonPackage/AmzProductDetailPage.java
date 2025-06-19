package amazonPackage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmzProductDetailPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	//step 1
	@FindBy(xpath="(//div[@class='a-section aok-relative s-image-tall-aspect'])[1]")
	WebElement firstProduct;
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement productAddtocart;
	
	@FindBy(xpath="(//div[@id='titleBlockLeftSection'])[1]")
	WebElement productTitle;
	
	@FindBy(xpath="//div[@id='averageCustomerReviews_feature_div']//div[@id='averageCustomerReviews']")
	WebElement reviews;
	
	@FindBy(xpath="//span[@class='a-size-small aok-offscreen']")
	WebElement mrpPrice;
	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	WebElement ourPrice;
	
	@FindBy(xpath="//span[@class='a-size-large a-color-price savingPriceOverride aok-align-center reinventPriceSavingsPercentageMargin savingsPercentage']")
	WebElement discount;
	
	@FindBy(xpath="//h2[normalize-space()='Product Description']")
	WebElement productdescription;
	//step 2
	public void firstProduct() 
	{
		wait.until(ExpectedConditions.visibilityOf(firstProduct));
		firstProduct.click();
	}
	public void productAdd2Cart() 
	{
		wait.until(ExpectedConditions.visibilityOf(productAddtocart));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", productAddtocart);
	}
	public boolean productTitle() 
	{
		
	    wait.until(ExpectedConditions.visibilityOf(productTitle));
	    return productTitle.isDisplayed();
		
	}
	public boolean reviews() 
	{
		wait.until(ExpectedConditions.visibilityOf(reviews));
        return reviews.isDisplayed();
	}
	
	public boolean mrp() 
	{
		wait.until(ExpectedConditions.visibilityOf(mrpPrice));
        return mrpPrice.isDisplayed();
	}
	public boolean ourPrice() 
	{
		wait.until(ExpectedConditions.visibilityOf(ourPrice));
        return ourPrice.isDisplayed();
	}
	public boolean discount() 
	{
		wait.until(ExpectedConditions.visibilityOf(discount));
        return discount.isDisplayed();
	}
	public boolean productdescription() 
	{
		try {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", productdescription);
		js.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.visibilityOf(productdescription));
        return productdescription.isDisplayed();
    } catch (Exception e) {
        System.out.println("Product description not found: " + e.getMessage());
        return false;
    	}
}
	
	//step 3
	public AmzProductDetailPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void switchToNewWindow() {
	    String parent = driver.getWindowHandle();
	    Set<String> handles = driver.getWindowHandles();
	    for (String handle : handles) {
	        if (!handle.equals(parent)) {
	            driver.switchTo().window(handle);
	            break;
	        }
	    }
	}
	
}
