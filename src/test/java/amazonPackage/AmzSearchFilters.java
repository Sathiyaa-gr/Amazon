package amazonPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class AmzSearchFilters {
	WebDriver driver;
	WebDriverWait wait;
	SoftAssert sa=new SoftAssert();
	
	//step 1
	@FindBy(xpath="//a[@aria-label='Apply the filter Puma to narrow results']//i[@class='a-icon a-icon-checkbox']")
	WebElement ckh_brand;
	
	@FindBy(xpath="//input[@id='p_36/range-slider_slider-item_lower-bound-slider']")	WebElement min_price;
	
	@FindBy(xpath="//input[@id='p_36/range-slider_slider-item_upper-bound-slider']")	WebElement max_price;
	
	@FindBy(xpath="//input[@aria-label='Go - Submit price range']")	WebElement btn_go;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base']")	WebElement results;
	//step 2
	
	public void brand_filter() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(ckh_brand)).click();
		
		sa.assertTrue(results.isSelected(), "Puma filter not applied");
		Reporter.log("Brand verified");
		return  ;
	}
	
	
	//step 3
	public AmzSearchFilters(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
	}
	
}
