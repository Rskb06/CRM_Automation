package qa.testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LandingPage;
import qa.pages.LoginPage;

public class HomePageTest extends TestBase {
HomePage homepage;
LoginPage loginpage;
LandingPage landingpage;
	
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
		landingpage = new LandingPage();	
		Thread.sleep(1000);
		loginpage = landingpage.clickOnLoginBtn();
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
	
	@AfterMethod
	 public void tearDown() {
	  driver.quit();
  }
	
	
}
