package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;
import qa.pages.LandingPage;
import qa.pages.LoginPage;

public class LandingPageTest extends TestBase{
LandingPage landingpage;
LoginPage loginpage;
//test cases should be separated -- independent with each other

public LandingPageTest() {
	super(); //calls the constructor of the parent class TestBase	
}

@BeforeMethod
public void setup()
{
	initialization(); //initialize the WebDriver and open the browser
	landingpage = new LandingPage(); //create an object of LandingPage class
	
}

  @Test(priority=1)
  public void landingPageTitleTest() {
	 String title = landingpage.validateLandingPageTitle();
	 System.out.println(title);
	  Assert.assertEquals(title,"#1 Free CRM Business Software - Free Forever");
  }


  @Test(priority=2)
  public void landingPageLogoTest()
  {
	boolean flag =  landingpage.validateCRMImage();
	Assert.assertTrue(flag);
  }
  
  @Test(priority=3)
  public void LandingloginBtnClick()
  {
	  loginpage =  landingpage.clickOnLoginBtn();
	  
  }
  
  @AfterMethod()
  
	  public void tearDown() {
		  driver.quit();
	  }
  }
	

