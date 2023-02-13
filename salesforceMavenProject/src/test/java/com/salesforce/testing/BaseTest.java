package com.salesforce.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.utilityclasses.PropertiesUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver = null;
	
	
	//@BeforeMethod
	public void setupBeforeMethod() {
		
		getDriverInstance("chrome");
		PropertiesUtilities ob = new PropertiesUtilities();
		ob.loadFile("applicationDataProperties");
		String URL = ob.getPropertyData("url");
		goToUrl(URL);
	}
	//@AfterMethod
	public void teardownAfterMethod() {
		driver.close();
	}

	public static void getDriverInstance(String browsername) {

		switch (browsername) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

			break;

		default:
			System.out.println("Browser is not found");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void goToUrl(String url) {
		driver.get(url);
	}

	public static WebElement findElement(String locator, String locValue) {
		switch (locator) {
		case "id":
			return driver.findElement(By.id(locValue));

		case "xpath":
			return driver.findElement(By.xpath(locValue));
		case "class":
			return driver.findElement(By.className(locValue));

		default:
			System.out.println("Error-locator not found");
			break;
		}
		return null;
	}

	public static void enterText(WebElement element, String text) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		} else {
			System.out.println("Error-" + element + "not found");
		}
	}

	public static String getTextFromElement(WebElement element) {
		if (element.isDisplayed()) {
			return element.getText();
		} else {
			System.out.println("Element not found");
			return null;
		}
	}

	public static void waitToLoadWebPage(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void testResult(String actual, String expected, String testName) {
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println(testName + " is passed");
		} else {
			System.out.println(testName + " is  failed");
		}
	}

	public static void ThreadSleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void FileDialogPasteAndEnter(String path) {
		StringSelection selection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot = null;
		try {
			robot = new Robot();
			Thread.sleep(500);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void javaScriptexecutor(WebElement element, String script) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(script, element);

	}

	public static void selectFromDropDown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectCheckbox(WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}
}
