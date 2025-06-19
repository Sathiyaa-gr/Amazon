package amazonTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazonPackage.AmzAccountPage;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzLoginPage;
import amazonPackage.AmzProfileEdit;


@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase4_ProfileEdit2 extends BaseClass
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
			AmzAccountPage accountpage=new AmzAccountPage(driver);
			accountpage.yourAccount();
			accountpage.Login_security();
			
			AmzProfileEdit profilePage=new AmzProfileEdit(driver);
			
			profilePage.editName_btn();
			
			profilePage.customer_name();
			profilePage.click_savechanges();
			
			
			
			
			
			
			
			
		}

}
