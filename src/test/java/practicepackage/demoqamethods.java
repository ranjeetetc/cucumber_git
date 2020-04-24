package practicepackage;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class demoqamethods extends testbase {
	
	@Test(priority = 2)
	public void interationSortable  () {
		driver.findElement(By.xpath("//a[text() = \"Sortable\"]")).click();
//		log.debug("Cloicked sortable");
		List <WebElement> eleSortable =  driver.findElements(By.xpath("//ul[@id=\"sortable\"]/li"));
		WebElement target = eleSortable.get(0);
		WebElement dest = eleSortable.get(1);
		a = new Actions(driver);
		Point p = dest.getLocation();
		System.out.println("x is : "+ p.getX()+" And y is: "+p.getY());
//		log.debug("x is : "+ p.getX()+" And y is: "+p.getY());
		a.click(target).clickAndHold().moveToElement(dest).moveByOffset(0, 10).release().build().perform(); 
	}
	
	@Test(priority = 3)
	public void testSelectable() throws AWTException {
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
	
	@Test(priority = 4)
	public void testResizeable() {  
		driver.findElement(By.xpath("//a[text()='Resizable']")).click();
		WebElement resizeable = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		a.clickAndHold(resizeable).moveByOffset(90, 100).release().build().perform();
	}

	@Test(priority = 5)
	public void testDropable() {
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();;
		WebElement dragable = driver.findElement(By.id("draggable"));
		WebElement dropable = driver.findElement(By.id("droppable"));
		a.clickAndHold(dragable).moveToElement(dropable).release().build().perform();
	}

	@Test(priority = 6)
	public void testDragable() {
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();;
		WebElement dragable = driver.findElement(By.id("draggable"));
		a.clickAndHold(dragable).moveByOffset(10, 0).release().build().perform();
	}
	
	@Test(priority = 7)
	public void testDtestSwitchWindow() throws InterruptedException {
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
	
	@Test(priority = 8)
	public void testDtestSwitchMessageWindow() throws InterruptedException {
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
	
	@Test(priority = 9)
	public void testDtestSwitchMessageTab() throws InterruptedException {
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
	
	@Test(priority = 10)
	public void testTable() {
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
	
	@Test(priority = 11)
	public void testIframe() throws InterruptedException {
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
	
}
