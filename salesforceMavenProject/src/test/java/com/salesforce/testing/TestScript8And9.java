package com.salesforce.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestScript8And9 extends BaseTest {
public static void developerConsoleTest() {
	UserMenuDropDownTest.userMenuDropDown();
	
	WebElement developerConsoleLink=findElement("xpath", "//a[contains(text(),'Developer Console')]");
	String baseWinsow=driver.getWindowHandle();
	developerConsoleLink.click();
	Set<String> allwindow= driver.getWindowHandles();
	
	for (String window : allwindow) {
		if (!window.equalsIgnoreCase(baseWinsow)) {
			driver.switchTo().window(window);
			driver.close();
			break;
		}
	}
	
}


public static void logoutTest() {
	String expected="Login | Salesforce";
	UserMenuDropDownTest.userMenuDropDown();
	WebElement logout=findElement("xpath", "//a[contains(text(),'Logout')]");
	logout.click();
	ThreadSleep(1000);
	String actual=driver.getTitle();
	testResult(actual, expected, "TestScript9");
	
}

	public static void main(String[] args) {
		//developerConsoleTest();
		logoutTest();
	}
	
}
