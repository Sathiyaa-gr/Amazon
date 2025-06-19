package amazonTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import amazonPackage.AmzCartPage;
import amazonPackage.AmzCheckoutPage;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzLoginPage;
import amazonPackage.AmzProductDetailPage;

@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase11_ValidateCheckoutPage extends BaseClass
{
	SoftAssert softassert=new SoftAssert();
	
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
						
			AmzCartPage cartPage=new AmzCartPage(driver);
			cartPage.Cart();
			cartPage.Checkout();
			
			AmzCheckoutPage checkoutPage=new AmzCheckoutPage(driver);
			checkoutPage.paymentOption();
			checkoutPage.DeliveryAddress();
			checkoutPage.OrderReview();
			
			
			
		}

}
