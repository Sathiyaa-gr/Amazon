package amazonTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class  BaseClass
{
public WebDriver driver;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void browserlaunch(@Optional("chrome") String Browsername)
	{
		if(Browsername.equalsIgnoreCase("Chrome")) 
		{
			//driver=new ChromeDriver();
			//Reporter.log("Chrome browser launching");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			
		}
		if(Browsername.equalsIgnoreCase("Edge")) 
		{
			driver=new EdgeDriver();
			Reporter.log("Edge browser launching");
		}
		
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	@AfterMethod
	public void browserquit() throws InterruptedException
	{
		driver.quit();
	}
	
	
}
