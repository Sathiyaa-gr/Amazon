package amazonPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmzCartPage {
	WebDriver driver;
	WebDriverWait wait;
	//step 1	
	@FindBy(xpath="//input[@value='Delete']")	WebElement deleteBtn;
	
	@FindBy(xpath="//a[normalize-space()='Go to Cart']")	WebElement cart;
	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")	WebElement proccedtoCheckout;
	//step 2
	public void Cart()
	{
		try {
			Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("/a[normalize-space()='Go to Cart']")
                
            ));
		Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
        } catch (Exception e) 
		{
            // No overlay found
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cart);

	}
	

	public void deleteProduct() 
	{
		try{
			deleteBtn=wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		deleteBtn.click();
		System.out.println("Deleted the product");
		}catch (TimeoutException e) {
	        System.out.println("Delete button not found or not clickable within timeout.");
	    } catch (NoSuchElementException e) {
	        System.out.println("Delete button not present on the page.");
	    }
	}
	public void Checkout() 
	{
		proccedtoCheckout.click();
	}
	
	//step 3
	public AmzCartPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		 
	}
	
}
