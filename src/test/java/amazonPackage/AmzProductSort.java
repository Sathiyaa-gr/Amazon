package amazonPackage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmzProductSort {
	WebDriver driver;
	
	//step 1
	@FindBy(xpath="//select[@id='s-result-sort-select']")
	WebElement sort;
	
	//step 2
	
	public void sortProduct(int i) 
	{
		Select select=new Select(sort);
		select.selectByIndex(i);
		System.out.println("Sorted by Price: Low to High");
	}
	public void sortProductValue(String value) 
	{
		Select select=new Select(sort);
		select.selectByValue(value);
		System.out.println("Sorted by Customer Review");
	}
	
	public void sortProducttext(String text) 
	{
		Select select=new Select(sort);
		select.selectByValue(text);
		System.out.println("Sorted by Price: High to Low");
		Assert.assertEquals(driver.getTitle().contains("kids"), "Amazon.in : shoes for kids");
	}
	//step 3
	public AmzProductSort(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
    
	}
	
}
