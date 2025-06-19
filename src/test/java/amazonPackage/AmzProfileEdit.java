package amazonPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AmzProfileEdit {
	WebDriver driver;
	//step 1
		
	@FindBy(xpath="//a[@aria-label='Edit name']")	WebElement edit_name_btn;
	
	@FindBy(xpath="//input[@id='ap_customer_name']")	WebElement customer_name;

	@FindBy(xpath="//input[@id='cnep_1C_submit_button']")	WebElement savechanges;
	
	@FindBy(xpath="//div[@class='a-alert-content']")	WebElement updated_msg;
		
	//step 2
	
	public void editName_btn()
	{
		
		edit_name_btn.click();
		
	}
	public void customer_name()
	{
		String old=customer_name.getAttribute("value");
		System.out.println("Before edit: "+old);
		customer_name.clear();
		customer_name.sendKeys("Sathiyaa");
		
	}
	public void click_savechanges()
	{
		savechanges.click();
		String msg=updated_msg();
		Assert.assertEquals(msg, "Name updated.");
		Reporter.log("Profile Name edited");
		
		
	}
	
	public String updated_msg() {
	    return updated_msg.getText().trim();
	}
	
	//step 3
	public AmzProfileEdit(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
