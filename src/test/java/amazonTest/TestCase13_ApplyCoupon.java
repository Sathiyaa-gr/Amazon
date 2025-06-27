package amazonTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import amazonPackage.AmzCartPage;
import amazonPackage.AmzCheckoutPage;
import amazonPackage.AmzCouponCode;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzLoginPage;
import amazonPackage.AmzPaymentPage;
import amazonPackage.AmzProductDetailPage;

@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase13_ApplyCoupon extends BaseClass
{
		@Test
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
			
			homepage.clickCart();
			AmzCartPage cartPage=new AmzCartPage(driver);
			cartPage.Checkout();
			
			AmzCouponCode code=new AmzCouponCode(driver);
			code.enterCopoun();
			
			
		}

}
