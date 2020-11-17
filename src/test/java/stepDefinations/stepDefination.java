package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import practicepackage.testbase;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


//@RunWith(Cucumber.class)
public class stepDefination extends testbase {
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
	
    @When("^I drag and drop$")
    public void i_drag_and_drop_text_1_and_text() throws Throwable {
    	//a[text() = "Sortable"]
    			driver.findElement(By.xpath("//a[text() = \"Sortable\"]")).click();
    			List <WebElement> eleSortable =  driver.findElements(By.xpath("//ul[@id=\"sortable\"]/li"));
    			WebElement target = eleSortable.get(0);
    			WebElement dest = eleSortable.get(1);
    			a = new Actions(driver);
    			Point p = dest.getLocation();
    			System.out.println("x is : "+ p.getX()+" And y is: "+p.getY());
    			a.click(target).clickAndHold().moveToElement(dest).moveByOffset(0, 10).release().build().perform(); 
    }

    @When("^I test the working of selectable$")
    public void i_test_the_working_of_selectable() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Selectable']")).click();

		WebElement  first_WebElement = driver.findElement(By.xpath("//ol[@id=\"selectable\"]//li[text()='Item 1']"));
		WebElement  second_WebElement = driver.findElement(By.xpath("//ol[@id=\"selectable\"]//li[text()='Item 2']"));
		WebElement  third_WebElement = driver.findElement(By.xpath("//ol[@id=\"selectable\"]//li[text()='Item 3']"));  

		a.keyDown(Keys.LEFT_CONTROL)
		.click(first_WebElement)
		.click(second_WebElement)
		.click(third_WebElement)
		.keyUp(Keys.LEFT_CONTROL)
		.build()
		.perform();
    }

    @When("^I test the working of resizeable$")
    public void i_test_the_working_of_resizeable() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='Resizable']")).click();
		WebElement resizeable = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		a.clickAndHold(resizeable).moveByOffset(90, 100).release().build().perform();
    }

    @When("^I test the working of Dropable$")
    public void i_test_the_working_of_dropable() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='Droppable']")).click();;
		WebElement dragable = driver.findElement(By.id("draggable"));
		WebElement dropable = driver.findElement(By.id("droppable"));
		a.clickAndHold(dragable).moveToElement(dropable).release().build().perform();
    }

    @When("^I test the working of Dragable$")
    public void i_test_the_working_of_dragable() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='Draggable']")).click();;
		WebElement dragable = driver.findElement(By.id("draggable"));
		a.clickAndHold(dragable).moveByOffset(10, 0).release().build().perform();
    }

    @When("^I test the working of Switch window$")
    public void i_test_the_working_of_switch_window() throws Throwable {
    	String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Automation Practice Switch Windows']")).click();
		driver.findElement(By.id("button1")).click();
		Set <String> wndHandles = driver.getWindowHandles();

		for (String handle : wndHandles) 
		{
			if (!mainWindow.equalsIgnoreCase(handle)) 
			{
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				Thread.sleep(5000);
				String strExpectedTitle = "Free QA Automation Tools Tutorial for Beginners with Examples";
				assertEquals(driver.getTitle(), strExpectedTitle);
				driver.close();
				driver.switchTo().window(mainWindow);	
				break;
			}
		}
    }

    @When("^I test the working of switch message window$")
    public void i_test_the_working_of_switch_message_window() throws Throwable {
    	String mainWindow = driver.getWindowHandle();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		Set <String> wndHandles = driver.getWindowHandles();

		for (String handle : wndHandles) 
		{
			if (!mainWindow.equalsIgnoreCase(handle)) 
			{
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				Thread.sleep(5000);
				//				String strExpectedTitle = "Free QA Automation Tools Tutorial for Beginners with Examples";
				//assertEquals(driver.getTitle(), strExpectedTitle);	
				driver.close();
				driver.switchTo().window(mainWindow);	
				break;
			}
		}
    }

    @When("^I test the working of message tab$")
    public void i_test_the_working_of_message_tab() throws Throwable {
    	String mainWindow = driver.getWindowHandle();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
		Set <String> wndHandles = driver.getWindowHandles();

		for (String handle : wndHandles) 
		{
			if (!mainWindow.equalsIgnoreCase(handle)) 
			{
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				Thread.sleep(5000);
				String strExpectedTitle = "Free QA Automation Tools Tutorial for Beginners with Examples";
				assertEquals(driver.getTitle(), strExpectedTitle);	
				driver.close();
				driver.switchTo().window(mainWindow);	
				break;
			}
		}
    }

    @When("^I test the working of table$")
    public void i_test_the_working_of_table() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='Automation practice table']")).click();

		WebElement tbl = driver.findElement(By.xpath("//table[@summary='Sample Table']"));
		List <WebElement> col = tbl.findElements(By.tagName("td"));
		List <WebElement> row = tbl.findElements(By.tagName("tr"));
		System.out.println("Row count is: " + row.size());
		System.out.println("Column count is: " + col.size());
		for(int r=0;r<row.size();r++)
		{
			List <WebElement> colimn_row =	row.get(r).findElements(By.tagName("td"));
			System.out.println("Number of cells In Row " + r + " are " + colimn_row.size());
			for(int c=0;c<colimn_row.size();c++)
			{
				String celtext = colimn_row.get(c).getText();
				System.out.println("Cell Value of row number " + r + " and column number " + c + " Is " + celtext);
			}
			System.out.println("--------------------------------------------------------------------");
		}
    }

    @When("^I test the working of iFrame$")
    public void i_test_the_working_of_iframe() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='IFrame practice page']")).click();
		driver.switchTo().frame("IF1");
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='TestNG Tutorial']")));
		driver.findElement(By.xpath("//span[text()='TestNG Tutorial']")).click();
		String strExph1 = "TestNG Tutorial";
		String strActh1 = driver.findElement(By.xpath("//div[@id=\"page\"]/div[4]/div/div[1]/h1")).getText();
		assertEquals(strActh1, strExph1);
		System.out.println(strExph1+"========="+strActh1);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("IF2");
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[text() = 'Sortable']")));
		driver.findElement(By.xpath("//a[text() = 'Sortable']")).click();
		List <WebElement> eleSortable =  driver.findElements(By.xpath("//ul[@id=\"sortable\"]/li"));
		js.executeScript("arguments[0].scrollIntoView(true);", eleSortable.get(0));	
		String existtxt = null;
		for(int s=0;s<eleSortable.size();s++)
		{
			String txt = eleSortable.get(s).getText();
			existtxt = existtxt+","+txt;			
		}
		System.out.println("before sorting text value is :-" + existtxt);
		
		WebElement newTarget = eleSortable.get(0);
		WebElement newDest = eleSortable.get(1);

		a.clickAndHold(newTarget).moveToElement(newDest).moveByOffset(0,50).release().build().perform();
		Thread.sleep(3000);
		List <WebElement> eleSortable1 =  driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		existtxt = null;
		for(int k=0;k<eleSortable1.size();k++)
		{
			String txt = eleSortable1.get(k).getText();
			existtxt = existtxt+","+txt;		
		}
		System.out.println("after sorting text value is :-" + existtxt);
		driver.switchTo().defaultContent();
	}
    
    @When("^I test the working of form$")
    public void i_test_the_working_of_form() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='Automation practice form']")).click();
		//div[@id='content']/h1
		String expActForm = "Automation practice form";
		expActForm = expActForm.trim();
		String actFormText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		actFormText = actFormText.trim();
		assertEquals(actFormText, actFormText);
		driver.findElement(By.partialLinkText("Partial Link Te")).click();
		assertEquals(driver.getTitle(), "Page Not Found | TOOLSQA");
		driver.navigate().back();
		driver.findElement(By.linkText("Link Test")).click();
		assertEquals(driver.getTitle(), "Page Not Found | TOOLSQA");
		driver.navigate().back();
		driver.findElement(By.name("firstname")).sendKeys("AutoUser");
		driver.findElement(By.id("lastname")).sendKeys("AutoUser_lastname");
		if (!driver.findElement(By.id("sex-0")).isSelected())
		{
			driver.findElement(By.id("sex-0")).click();
		}
		
		if (!driver.findElement(By.id("exp-6")).isSelected())
		{
			driver.findElement(By.id("exp-6")).click();
		}
		driver.findElement(By.id("datepicker")).sendKeys("12/12/2020");
		
		if (!driver.findElement(By.id("profession-0")).isSelected())
		{
			driver.findElement(By.id("profession-0")).click();
		}
		
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\LENOVO\\Desktop\\test.txt");
		Select s = new Select(driver.findElement(By.id("continents")));
		s.selectByVisibleText("Antarctica");
		Select s1 = new Select(driver.findElement(By.id("continentsmultiple")));
		s1.selectByVisibleText("North America");
		s1.selectByVisibleText("Antarctica");		
		Select s2 = new Select(driver.findElement(By.id("selenium_commands")));
		s2.selectByVisibleText("WebElement Commands");
		List <WebElement> allSelected = s2.getAllSelectedOptions();
		String lstName = "WebElement Commands";
		String[] lstArray = lstName.split(",");
		for(int m=0;m<allSelected.size();m++)
		{		
			assertEquals(allSelected.get(m).getText(), lstArray[m]);
			System.out.println(allSelected.get(m).getText()+" And is equal to : "+lstArray[m]);
		}	
		List <WebElement> lstCoffee = driver.findElements(By.xpath("//ul[@id='beverages']/li"));
		System.out.println("Count of li is: " + lstCoffee.size());
		String lstall = "";
		for(int j=0;j<lstCoffee.size();j++)
		{
			String lst = lstCoffee.get(j).getText();
			lstall = lstall + "," + lst;		
		}
		System.out.println(lstall);
    }

    @When("^I test the working of html contact$")
    public void i_test_the_working_of_html_contact() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='HTML contact form']")).click();
		driver.findElement(By.xpath("//input[@placeholder= 'Your name..']")).sendKeys("Auto_User");
		driver.findElement(By.xpath("//input[@placeholder= 'Your last name..']")).sendKeys("Auto_Last_User");	
		driver.findElement(By.xpath("//input[@placeholder= 'Your last name..']")).sendKeys("Enter your Country");
		driver.findElement(By.partialLinkText("Google Li")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("Google Link is here")).click();
		driver.navigate().back();
		driver.findElement(By.id("subject")).sendKeys("hihhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		String exptextP = "It looks like nothing was found at this location. Maybe try a search?";
		String acttextP = driver.findElement(By.xpath("//div[@class= 'page-content']/p")).getText();
		assertEquals(acttextP, exptextP);
		driver.navigate().back();
    }

    @When("^I test the working of keyboard event$")
    public void i_test_the_working_of_keyboard_event() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='Keyboard Events']")).click();
		driver.findElement(By.id("browseFile")).sendKeys("C:\\Users\\LENOVO\\Desktop\\test.txt");		
		driver.findElement(By.id("uploadButton")).click();
		driver.switchTo().alert();
		System.out.println("Alert message is: "+ driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
    }

    @When("^I test the working of Double click$")
    public void i_test_the_working_of_double_click() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='Tooltip and Double click']")).click();
		WebElement dbl = driver.findElement(By.id("doubleClickBtn"));
		act.doubleClick(dbl).perform();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		WebElement rgl = driver.findElement(By.id("rightClickBtn"));
		WebElement edt = driver.findElement(By.xpath("//div[text()='Edit this']"));
		
		act.contextClick(rgl).click(edt).build().perform();
		String edttext = driver.switchTo().alert().getText();
		System.out.println(edttext);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		WebElement tt = driver.findElement(By.id("tooltipDemo"));
		act.moveToElement(tt).perform();	
		String tltip = tt.getText();
		System.out.println("Tooltip text is: "+tltip);
    }

    @When("^I test the working of tooltip$")
    public void i_test_the_working_of_tooltip() throws Throwable {
    	driver.findElement(By.xpath("//a[text()='Tooltip']")).click();
		WebElement target = driver.findElement(By.id("age"));
		String ttt = target.getAttribute("title");
		System.out.println("Tooltip text is: "+ttt);
		driver.findElement(By.xpath("//a[text()='Slider']")).click();
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		act.dragAndDropBy(slider, 300, 0).perform();
		driver.findElement(By.xpath("//a[text()='Selectmenu']")).click();
		driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']")).click();	
		driver.findElement(By.xpath("//div[text()='Faster']")).click();
		
		driver.findElement(By.xpath("//span[@id='files-button']//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']")).click();	
		driver.findElement(By.xpath("//div[text()='ui.jQuery.js']")).click();
		
		driver.findElement(By.xpath("//a[text()='Menu']")).click();
		WebElement elc = driver.findElement(By.id("ui-id-4"));
		WebElement carfi = driver.findElement(By.xpath("//div[text()='Car Hifi']"));
		act.moveToElement(elc).perform();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(carfi));
		carfi.click();
		Thread.sleep(5000);
	
		WebElement mu = driver.findElement(By.xpath("//div[@id='ui-id-9']"));
		WebElement rc = driver.findElement(By.xpath("//div[text()='Rock']"));
		WebElement cl = driver.findElement(By.xpath("//div[text()='Classic']"));
		
		act.moveToElement(mu).perform();
		wait.until(ExpectedConditions.elementToBeClickable(rc));
		act.moveToElement(rc).perform();
		wait.until(ExpectedConditions.elementToBeClickable(cl));
		cl.click();
		driver.findElement(By.xpath("//a[text()='Datepicker']")).click();
		driver.findElement(By.id("datepicker")).click();
		WebElement tbl = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody"));
		List<WebElement> tblRows = tbl.findElements(By.tagName("tr"));
		System.out.println("Table has total rows: " + tblRows.size());
		List<WebElement> tblRow_Column = tblRows.get(3).findElements(By.tagName("td"));
		System.out.println("Total column in first row is : " + tblRow_Column.size());
		tblRow_Column.get(6).click();
		driver.findElement(By.xpath("//a[text()='Checkboxradio']")).click();
		driver.findElement(By.xpath("//label[text()='2 Star']")).click();
	}

	public void test() {

	}

	public void test1() {

	}

	public void test1() {

	}
}