package amazonTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import amazanUtil.DataFetching;
import amazonPackage.AmzHomePage;
import amazonPackage.AmzInvalidLoginPage;

@Listeners(amazanUtil.MyListenerTest.class)
public class TestCase3_InvalidLogin extends BaseClass
{
		
	 	@Test(dataProvider="logindata",dataProviderClass=DataFetching.class)
		public void withInvalidcredentails(String user,String pwd) throws InterruptedException
		{
			
			AmzHomePage homepage=new AmzHomePage(driver);
			homepage.hoveroveraccountandlist(driver);
			homepage.signin();
			
			
			AmzInvalidLoginPage loginpage=new AmzInvalidLoginPage(driver);
			loginpage.un(user);
			loginpage.continueUN();
			loginpage.pwd(pwd);
			loginpage.sigin();
			
					
			
		}

}
