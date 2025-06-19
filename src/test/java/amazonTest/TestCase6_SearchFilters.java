package amazonTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzSearchFilters;


@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase6_SearchFilters extends BaseClass
{
	
		@Test(retryAnalyzer=IRetrylogic.class)
		public void withvalidvredentails() throws InterruptedException
		{
			AmzHomePage homepage=new AmzHomePage(driver);
			/*homepage.hoveroveraccountandlist(driver);
			homepage.signin();
			
			AmzLoginPage loginpage=new AmzLoginPage(driver);
			loginpage.un();
			loginpage.continueUN();
			loginpage.pwd();
			loginpage.sigin();
			*/
			homepage.searchingtheproduct();
						 
			AmzSearchFilters filterpage=new AmzSearchFilters(driver);
			filterpage.brand_filter();
			
				
		}

}
