package amazonTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import amazonPackage.AmzAddtoCart;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzLoginPage;
import amazonPackage.AmzYourOrdersPage;

@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase14_YourOrders extends BaseClass
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
						
			homepage.hoveroveraccountandlist(driver);
			homepage.yourOrders();
			
			AmzYourOrdersPage OrdersPage=new AmzYourOrdersPage(driver);
			OrdersPage.orderPlacedin("year-2024");
			
			OrdersPage.productReview();
			
			OrdersPage.rating();
			OrdersPage.writeReview();
			OrdersPage.submitRating();
			
			
			
		}

}
