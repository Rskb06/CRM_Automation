package qa.testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.ContactsPage;
import qa.pages.HomePage;
import qa.pages.LandingPage;
import qa.pages.LoginPage;

public class HomePageTest extends TestBase {
HomePage homepage;
LoginPage loginpage;
LandingPage landingpage;
ContactsPage contactspage;
	
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Browser initialized: " + driver);
		Thread.sleep(6000);
		landingpage = new LandingPage();	
		Thread.sleep(6000);
		loginpage = landingpage.clickOnLoginBtn();
		Thread.sleep(6000);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=2)
	public void verifyHomePageTitleTest()
	{
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM", "Title does not match");
	}
	
	@Test(priority=1)
	public void verifyUsernameLabelTest()
	{
		Assert.assertTrue(homepage.verifyUserName());
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest()
	{
		contactspage =homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	 public void tearDown() {
	  driver.quit();
  }
	
	
}
