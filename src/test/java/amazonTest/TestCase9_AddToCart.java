package amazonTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazonPackage.AmzAddtoCart;
import amazonPackage.AmzCartPage;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzLoginPage;
import amazonPackage.AmzProductDetailPage;

@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase9_AddToCart extends BaseClass
{
		@Test(retryAnalyzer=IRetrylogic.class)
		public void withvalidvredentails() throws InterruptedException
		{
			
			AmzHomePage homepage=new AmzHomePage(driver);
			homepage.hoveroveraccountandlist(driver);
			homepage.signin();
			
			AmzLoginPage loginpage=new AmzLoginPage(driver);
			loginpage.un();
			loginpage.continueUN();
			loginpage.pwd();
			loginpage.sigin();
			
			homepage.searchingtheproduct();
					
			AmzProductDetailPage pdpage=new AmzProductDetailPage(driver);
			pdpage.firstProduct();
			pdpage.switchToNewWindow();
			pdpage.productAdd2Cart();
						
			homepage.clickCart();
		}

}
