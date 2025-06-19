package amazonTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import amazonPackage.AmzAddtoCart;
import amazonPackage.AmzCartPage;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzProductDetailPage;

@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase15_CartWithoutLogin extends BaseClass
{
	SoftAssert softassert=new SoftAssert();
	
		@Test(retryAnalyzer=IRetrylogic.class)
		public void withvalidvredentails() throws InterruptedException
		{
			
			AmzHomePage homepage=new AmzHomePage(driver);
			homepage.searchingtheproduct();
		
			AmzProductDetailPage pdpage=new AmzProductDetailPage(driver);
			pdpage.firstProduct();
			pdpage.switchToNewWindow();
			pdpage.productAdd2Cart();
						
			homepage.clickCart();
			
			
			
			
			
		}

}
