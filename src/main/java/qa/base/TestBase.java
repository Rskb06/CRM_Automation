package qa.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public TestBase(){ //constructor
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/qa/config/config.properties");
			 //specifies the path of the config file
			prop.load(ip); //loads the properties file
		} catch (Exception e) {
			e.printStackTrace();// why is this needed? 
			//prints the exception details in the console
		}
	}
		//why static? so that it can be accessed without creating an object of TestBase class
		//why Properties class? to read key-value pairs from the config file
		//why FileInputStream? to read the file from the specified path
		//why try-catch? to handle exceptions that may occur while reading the file
		//what is e.printStackTrace()? it prints the exception details in the console for debugging purposes
		//what is prop.load(ip)? it loads the properties file into the Properties object
		//what is the purpose of this class? to initialize the WebDriver and load the config properties

		public static void initialization() {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")) {//
				System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
				driver = new ChromeDriver();
			}
			else if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "/opt/homebrew/bin/geckodriver");
				driver = new FirefoxDriver();
			}
			//why System.setProperty? to set the path of the WebDriver executable
			//what is webdriver.chrome.driver? it is the key to set the path for ChromeDriver
			//what is /Applications/Google Chrome.app? it is the path to the Chrome
			
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().pageLoadTimeout(Duration. ofSeconds((TestUtil.PAGE_LOAD_TIMEOUT)));
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		   driver.get(prop.getProperty("url"));//opens the url specified in the config file
		   
		   
		}
	}

		//to be implemented: method to initialize WebDriver based on browser type from config file
	
