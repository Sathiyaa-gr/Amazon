package amazonTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazonPackage.AmzCardDetailsPage;
import amazonPackage.AmzCartPage;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzLoginPage;
@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase16_CardDetails extends BaseClass
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
			
			AmzCardDetailsPage payement=new AmzCardDetailsPage(driver);
			payement.paymentSelection();
			
			payement.cardDetails();
			
			
		}

}
