package amazonTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzProductSort;

@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase8_ProductSort extends BaseClass
{
	SoftAssert softassert=new SoftAssert();
	
		@Test(retryAnalyzer=IRetrylogic.class)
		public void withvalidvredentails() throws InterruptedException
		{
			
			AmzHomePage homepage=new AmzHomePage(driver);
			homepage.searchingtheproduct();
			 
			AmzProductSort sort=new AmzProductSort(driver);
			sort.sortProduct(1);
			Thread.sleep(1000);
			sort.sortProduct(3);
			Thread.sleep(1000);
			sort.sortProductValue("price-desc-rank");
									
		}

}
