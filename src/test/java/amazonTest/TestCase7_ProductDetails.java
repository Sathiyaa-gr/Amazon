package amazonTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzProductDetailPage;

@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase7_ProductDetails extends BaseClass
{
		@Test(retryAnalyzer=IRetrylogic.class)
		public void withvalidvredentails() throws InterruptedException
		{
			AmzHomePage homepage=new AmzHomePage(driver);
			homepage.searchingtheproduct();
			 
			AmzProductDetailPage pdpage=new AmzProductDetailPage(driver);
			pdpage.firstProduct();
			pdpage.ourPrice();
			pdpage.productdescription();
		}

}
