package amazanUtil;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import amazonTest.BaseClass;

public class MyListenerTest implements ITestListener {

	private static final BaseClass TestCase1_LoginToAmazonLogout = null;
	WebDriver driver;
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Object currentClass = result.getInstance();
	    WebDriver driver = ((BaseClass) currentClass).driver;

	    if (driver != null) {
	    	TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\anbuj\\eclipse-workspace\\project1\\Screenshots\\Pass\\test"+new MyListenerTest().getClass()+".png");
			try {
				FileHandler.copy(src, dest);
				System.out.println("Sceenshots taken");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
	        System.out.println("Driver is null, cannot take screenshot.");
	    }
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Object currentClass = result.getInstance();
	    WebDriver driver = ((BaseClass) currentClass).driver;

	    if (driver != null) {
	    	TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\anbuj\\eclipse-workspace\\project1\\Screenshots\\Fail\\test"+new MyListenerTest().getClass()+".png");
			try {
				FileHandler.copy(src, dest);
				System.out.println("Sceenshots taken");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
	        System.out.println("Driver is null, cannot take screenshot.");
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Object currentClass = result.getInstance();
	    WebDriver driver = ((BaseClass) currentClass).driver;

	    if (driver != null) {
	    	TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\anbuj\\eclipse-workspace\\project1\\Screenshots\\Skip\\test"+new MyListenerTest().getClass()+".png");
			try {
				FileHandler.copy(src, dest);
				System.out.println("Sceenshots taken");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
	        System.out.println("Driver is null, cannot take screenshot.");
	    }
	}

	
}
