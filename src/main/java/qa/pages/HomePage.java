package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class HomePage extends TestBase{

	//now we obtain the locators
	
	@FindBy(xpath ="//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath ="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath ="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath ="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initialize page object
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		return new TasksPage();
	}
}

