package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//First we locate elements using @Findbby
	
	@FindBy(xpath="//input[@name = 'email']")
	WebElement email_field ;//
	
	@FindBy(xpath ="//input[@name = 'password']")
	WebElement password_field; 
	
	@FindBy(xpath ="//div[@class ='ui fluid large blue submit button']")
	WebElement login_pg_loginbtn;
	
	
	
	//initialize WebElements
	//create a constructor
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
   public HomePage login(String em, String pwd)
   {
	   email_field.sendKeys(em);
	   password_field.sendKeys(pwd);
	   login_pg_loginbtn.click();
	  return new HomePage();
   }
	
	
	
	

}
