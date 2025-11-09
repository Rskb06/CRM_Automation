package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LandingPage;
import qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	//Declare page objects , create references to page classes
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
	super();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
	    System.out.println("Initializing browser...");
	    initialization();
	    System.out.println("Browser initialized: " + driver);
	    Thread.sleep(1000);
	    landingpage = new LandingPage();
	    System.out.println("Landing page initialized");
	    Thread.sleep(1000);
	    loginpage = landingpage.clickOnLoginBtn();
	    System.out.println("Navigated to Login Page");
	}

	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Cogmento CRM");
	}
	@Test(priority=2)
	public void loginTest() {
	homepage =	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod()
	  
	  public void tearDown() {
		  driver.quit();
	  }
}
