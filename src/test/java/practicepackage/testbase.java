package practicepackage;

import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testbase {
	public WebDriver driver;
	public Actions act;
	public Actions a;
	public FirefoxOptions options;
	public FirefoxProfile profile;
	Alert alert;
//	Logger log;
	
	@Given("^user set preference and launch \"([^\"]*)\"$")
    public void user_set_preference_and_launch_something(String strArg1) throws Throwable {
//		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
//		log = Logger.getLogger("devpinoyLogger.class");
//		log = Logger.getLogger(testbase.class);
		profile = new FirefoxProfile();
		//ChromeOptions options = new ChromeOptions();

		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", "C:\\Users\\LENOVO\\Downloads");
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		driver = new FirefoxDriver(options);
		act = new Actions(driver);
		driver.get("https://demoqa.com/");
//		log.info("Website Opened");
		driver.manage().window().maximize();
//		log.debug("Website Maximized");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
//		log.debug("Implicit wait set");
		System.out.println("HHHHHHHHHHHHHHHHHHHH");
	}
//	@Test
	@When("^I close the browser$")
    public void i_close_the_browser() throws Throwable {
        driver.close();
    }
	
//	public void demo() {
//		
//	}
}
