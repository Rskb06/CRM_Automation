package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class LandingPage extends TestBase{
	
	//page factory -OR(OBJECT REPOSITORY)
	//define the web elements present on the home page
	//initialize the web elements using PageFactory.initElements(driver, this);
	//create methods to interact with the web elements on the home page
	
	@FindBy(xpath="//span[normalize-space()='Log In']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement crmLogo;
	
	
	
	//initialize the web elements
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public LoginPage clickOnLoginBtn() {
		loginBtn.click();
		return new LoginPage();
	}
	
}
