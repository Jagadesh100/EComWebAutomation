package com.demoshop.actiondriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demostore.base.BaseClass;

public class Action extends BaseClass{
	
	public static void scrollVisibilityOfElement(WebDriver driver,WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);"	, ele);
	}
	
	public static void mouseClick(WebDriver driver,WebElement ele) {
		Actions action=new Actions(driver);
		action.moveToElement(ele).click().build().perform();
	}
	
	public static boolean findElement(WebDriver driver,WebElement ele) {
		boolean flag=false;
		try {
			ele.isDisplayed();
			flag=true;
		}
		catch(Exception e){
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println("Element found at:");
			}
			else {
				System.out.println("Unable to Find Element at:");
			}
		}
		return flag;
	}
	
	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag=false;
		flag=findElement(driver, ele);
		if(flag) {
			flag=ele.isDisplayed();
			if(flag) {
				System.out.println(ele +" Element is Displayed");
			}
			else {
				System.out.println(ele +" Element is Not Displayed");
			}
		}
		else {
			System.out.println(ele +" Element is not displayed");
		}
		return flag;
	}
	
	public static boolean isSelected(WebDriver driver,WebElement ele) {
		boolean flag = false;
		flag=findElement(driver, ele);
		if(flag) {
			flag = ele.isSelected();
			if(flag) {
				System.out.println("Element is Selected");
			}
			else {
				System.out.println("Element is not Selected");
			}
		}
		else {
			System.out.println("Element is not Selected");
		}
		return flag;
	}
	
	public static boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		if(flag) {
			flag = ele.isEnabled();
			if(flag) {
				System.out.println("Element is Enabled");
			}
			else {
				System.out.println("Element is not Enabled");
			}
		}
		else {
			System.out.println("Element is not Enabled");
		}
		return flag;
	}
	
	public static boolean type(WebElement ele,String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		}
		catch(Exception e) {
			System.out.println("Location Not Found, Message: " +e);
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("Successfully Entered Value");
			}
			else {
				System.out.println("Unable To Enter value");
			}
		}
		return flag;
	}
	
	public static boolean selectBySendkeys(String value,WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");		
			} else {
				System.out.println("Not Selected value from the DropDown");
				// throw new ElementNotFoundException("", "", "")
			}
		}
	}
	
	public static boolean selectByIndex(WebElement ele,int index) {
		boolean flag = false;
		try {
			Select s=new Select(ele);
			s.selectByIndex(index);
			flag = true;
			return true;
		}
		catch(Exception e) {
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Option Selected by index");
			}
			else {
				System.out.println("Option not Selected by Index");
			}
		}
	}
	
	public static boolean selectByValue(WebElement ele,String value) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByValue(value);
			flag = true;
			return true;
		}
		catch(Exception e) {
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Option Selected by Value");
			}
			else {
				System.out.println("Option Not Selected by Value");
			}
		}
	}
	
	public static boolean selectByVisibleText(WebElement ele,String text) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(text);
			flag =  true;
			return true;
		}
		catch(Exception e) {
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Option Selected by Visible Text");
			}
			else {
				System.out.println("Option not selected by Visible text");
			}
		}
	}
	
	public static boolean mouseHoverByJavaScript(WebElement ele,WebDriver driver) {
		boolean flag = false;
		try {
			WebElement mouseHover = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript(javaScript, mouseHover);
			flag = true;
			return true;
		}
		catch(Exception e) {
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Mouse Hover Action Performed via Javascript");
			}
			else {
				System.out.println("Mouse Hover Action Not Performed");
			}
		}
	}
	
	public static boolean clickByJavaScript(WebDriver driver,WebElement clickElement) {
		boolean flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click", clickElement);
			flag = true;
			return true;
		}
		catch(Exception e) {
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Element Clicked By Javascript Method");
			}
			else {
				System.out.println("Element Not clicked By Javascript Method");
			}
		}
	}
	
	public static boolean switchToFrameByIndex(WebDriver driver , int index) {
		boolean flag = false;
		try {
			//new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		}
		catch(Exception e) {
			return false;
		}
		finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}
	
	public static boolean switchToFrameById(WebDriver driver , String id) {
		boolean flag = false;
		try {
			driver.switchTo().frame(id);
			flag = true;
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if (flag) {
				System.out.println("Frame with id \"" + id + "\" is selected");
			} else {
				System.out.println("Frame with id \"" + id + "\" is not selected");
			}
		}
	}
	
	public static boolean swicthToFrameByName(WebDriver driver,String name) {
		boolean flag = false;
		try {
			driver.switchTo().frame(name);
			flag = true;
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if (flag) {
				System.out.println("Frame with name \"" + name + "\" is selected");
			} else {
				System.out.println("Frame with name \"" + name + "\" is not selected");
			}
		}
	}
	
	public static boolean switchFrameToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Frame Switched To Default Content");
			}
			else {
				System.out.println("Frame Not Swicthed to Default Content");
			}
		}
	}
	
	public static void mouseOverElement(WebDriver driver , WebElement element) {
		boolean flag = false;
		try {
			Actions action=new Actions(driver);
			action.moveToElement(element).build().perform();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				System.out.println("Mouse over Action is Performed on element"+element);
			}
			else {
				System.out.println("Mouse over Action is Not Performed on element"+element);
			}
		}
	}
	
	public static boolean scrollAndMoveToElement(WebDriver driver , WebElement element) {
		boolean flag = false;
		try {
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView", element);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean mouseOver(WebDriver driver , WebElement element) {
		boolean flag = false;
		try {
			Actions action=new Actions(driver);
			action.moveToElement(element).build().perform();
			flag = true;
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Mouse over Action is Performed on element"+element);
			}
			else {
				System.out.println("Mouse over Action is Not Performed on element"+element);
			}
		}
	}
	
	public static boolean draggable(WebDriver driver , int x , int y , WebElement source) {
		boolean flag= false;
		try {
			Actions action = new Actions(driver);
			action.dragAndDropBy(source, x, y).build().perform();
			flag = true;
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Draggable Action is Performed on element"+source);
			}
			else {
				System.out.println("Draggable Action is Not Performed on element"+source);
			}
		}
	}
	
	public static boolean dranAndDrop(WebDriver driver , WebElement srcele , WebElement trgele) {
		boolean flag = false;
		try {
			Actions action = new Actions(driver);
			action.dragAndDrop(srcele, trgele);
			flag = true;
			return flag;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Drag And Drop Action Performed");
			}
			else {
				System.out.println("Drag And Drop Action not Performed");
			}
		}
	}
	
	public static boolean slider(WebDriver driver , int x , int y , WebElement source) {
		boolean flag= false;
		try {
			Actions action = new Actions(driver);
			action.dragAndDropBy(source, x, y).build().perform();
			flag = true;
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Draggable Action is Performed on element"+source);
			}
			else {
				System.out.println("Draggable Action is Not Performed on element"+source);
			}
		}
	}
	
	public static boolean rightClick(WebDriver driver , WebElement target) {
		boolean flag = false;
		try {
			Actions action = new Actions(driver);
			action.contextClick(target).perform();
			flag = true;
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Right Click Action is Performed on element"+target);
			}
			else {
				System.out.println("Right Click Action is Not Performed on element"+target);
			}
		}
	}
	
	public static boolean switchWindowByTitle(WebDriver driver,int count,String windowTitle) {
		boolean flag = false;
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			String[] array=windowHandles.toArray(new String[0]);
			driver.switchTo().window(array[count-1]);
			if(driver.getTitle().contains(windowTitle)) {
				flag = true;
			}
			else {
				flag = false;
			}
			return flag;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Navigate to Window with Title");
			}
			else {
				System.out.println("Window not Switched");
			}
		}
	}
	
	public static boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			Object[] popup=windowHandles.toArray();
			driver.switchTo().window((String) popup[1]);
			flag = true;
			return flag;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Navigated to New Window");
			}
			else {
				System.out.println("New Window not Switched");
			}
		}
	}
	
	public static boolean switchTooldWindow(WebDriver driver) {
		boolean flag = false;
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			Object[] popup=windowHandles.toArray();
			driver.switchTo().window((String) popup[0]);
			flag = true;
			return flag;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Navigated to Old Window");
			}
			else {
				System.out.println("old Window not Switched");
			}
		}
	}
	
	public static int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}
	
	public static int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}
	
	public static boolean Alert() {
		boolean flag = false;
		try {
			getDriver().switchTo().alert().accept();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		finally {
			if(flag){
				System.out.println("Alert Accepeted");
			}
			else {
				System.out.println("Alert Not Accepted");
			}
		}
		return flag;
	}
	
	public static boolean launchUrl(WebDriver driver,String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \""+url+"\"");				
			} else {
				System.out.println("Failed to launch \""+url+"\"");
			}
		}
	}
	
	public static boolean isAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (Exception Ex) 
		{ 
			return false; 
		}   // catch 
	}
	
	public static String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	
	public static String getCurrentURL(WebDriver driver)  {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}
	
	public static boolean click(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \""+locatorName+"\"");
			} else {
				System.out.println("Click Unable to click on \""+locatorName+"\"");
			}
		}
	}
	
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	public static String screenShot(WebDriver driver , String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String pathName = System.getProperty("user.dir")+"//Screenshots//"+filename+"_"+getCurrentTime()+".png";
		File dest = new File(pathName);
		try {
			FileUtils.copyFile(src, dest);
		}
		catch(Exception e) {
			e.getMessage();
		}
		return pathName;
	}
	
	public static void implicitWait(WebDriver driver , long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public static void pageLoadTimeouts(WebDriver driver , long seconds) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}
	
	public static void explicitWait(WebDriver driver , long seconds , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void fluentWait(WebDriver driver , long seconds , long interval , WebElement element) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Duration.ofSeconds(interval))
					.ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static String getCurrentDateTime() {
		String currentDateTime = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDateTime;
	}
	
}
