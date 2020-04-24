package practicepackage;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class demoqamethodsPart2 extends testbase {
	//@Test(priority = 12)
	public void testAutomationPractiveForm() {
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
	
//		driver.findElement(By.xpath("//a[text()='Selenium Automation Hybrid Framework']")).click();;
//		driver.findElement(By.xpath("//a[text()='Test File to Download']")).click();;
		Select s = new Select(driver.findElement(By.id("continents")));
		s.selectByVisibleText("Antarctica");
		
	
		Select s1 = new Select(driver.findElement(By.id("continentsmultiple")));
//		a.keyDown(Keys.CONTROL).perform();
		s1.selectByVisibleText("North America");
		s1.selectByVisibleText("Antarctica");
//		a.keyUp(Keys.CONTROL).perform();
		
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
	//@Test(priority = 12)
	public void htmlContact() {		
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
		//div[@class= 'page-content']/p
		String exptextP = "It looks like nothing was found at this location. Maybe try a search?";
		String acttextP = driver.findElement(By.xpath("//div[@class= 'page-content']/p")).getText();
		assertEquals(acttextP, exptextP);
		driver.navigate().back();
	}
//	@Test(priority = 12)
	public void keyboardevent() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//a[text()='Keyboard Events']")).click();
		driver.findElement(By.id("browseFile")).sendKeys("C:\\Users\\LENOVO\\Desktop\\test.txt");		
		driver.findElement(By.id("uploadButton")).click();
		driver.switchTo().alert();
		System.out.println("Alert message is: "+ driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();		
	}
//	@Test(priority = 12)
	public void dblClick(){
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
	@Test(priority = 12)
	public void tooltip() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Tooltip']")).click();
		WebElement target = driver.findElement(By.id("age"));
//		act.moveToElement(target).perform();
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
//		((JavascriptExecutor) driver).executeScript("document.getElementByClassName('ui-menu ui-widget ui-widget-content ui-front').style.display='block';");
		wait.until(ExpectedConditions.elementToBeClickable(rc));
		act.moveToElement(rc).perform();
//		act.moveToElement(cl).perform();
		wait.until(ExpectedConditions.elementToBeClickable(cl));
		cl.click();
		driver.findElement(By.xpath("//a[text()='Datepicker']")).click();
		driver.findElement(By.id("datepicker")).click();
		WebElement tbl = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody"));	
		List<WebElement> tblRows = tbl.findElements(By.tagName("tr"));
		System.out.println("Table has total rows: "+tblRows.size());
		List <WebElement> tblRow_Column = tblRows.get(3).findElements(By.tagName("td"));
		System.out.println("Total column in first row is : "+ tblRow_Column.size());
		tblRow_Column.get(6).click();
	
		
		driver.findElement(By.xpath("//a[text()='Checkboxradio']")).click();
		driver.findElement(By.xpath("//label[text()='2 Star']")).click();
		System.out.println("Last step");
	}
}
