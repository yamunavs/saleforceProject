package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.utilityclasses.PropertiesUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest {
	@Test
	public void error_logIn() {
		//logger.info("inside errorlogin method");
		String expected = "Please enter your password.";
		getDriverInstance("chrome");
		PropertiesUtilities ob = new PropertiesUtilities();
		ob.loadFile("applicationDataProperties");
		String URL = ob.getPropertyData("url");
		goToUrl(URL);
		
		ob.loadFile("applicationDataProperties");

		String username = ob.getPropertyData("login.valid.usename");
		WebElement userNameElement = findElement("id", "username");
		enterText(userNameElement, username);

		WebElement loginElement = findElement("id", "Login");
		loginElement.click();

		WebElement error = findElement("id", "error");
		waitToLoadWebPage(error);
		String actual = getTextFromElement(error);
		
		}
		//testResult(actual, expected, "TestCase1");
	

	

	public static void logIn_to_Salesforce() {
		String expectedPageTitle = "Home Page ~ Salesforce - Developer Edition";
		getDriverInstance("chrome");
		PropertiesUtilities ob = new PropertiesUtilities();
		ob.loadFile("applicationDataProperties");
		String URL = ob.getPropertyData("url");
		goToUrl(URL);
		String username = ob.getPropertyData("login.valid.usename");
		WebElement userNameElement = findElement("id", "username");
		enterText(userNameElement, username);

		String password = ob.getPropertyData("login.valid.password");
		WebElement passwordElement = findElement("id", "password");
		enterText(passwordElement, password);

		WebElement loginElement = findElement("id", "Login");
		loginElement.click();
		WebElement LoggedInUser = findElement("id", "userNav");
		waitToLoadWebPage(LoggedInUser);

		String actual = driver.getTitle();
		System.out.println(actual);
		testResult(actual, expectedPageTitle, "TestCase2");
		// driver.close();

	}

	public static void checkRememberMe() {

		getDriverInstance("chrome");
		PropertiesUtilities ob = new PropertiesUtilities();
		ob.loadFile("applicationDataProperties");
		String URL = ob.getPropertyData("url");
		goToUrl(URL);
		String username = ob.getPropertyData("login.valid.usename");
		String expected = username;
		WebElement userNameElement = findElement("id", "username");
		enterText(userNameElement, username);

		String password = ob.getPropertyData("login.valid.password");
		WebElement passwordElement = findElement("id", "password");
		enterText(passwordElement, password);

		WebElement remElement = findElement("id", "rememberUn");
		remElement.click();

		WebElement loginElement = findElement("id", "Login");
		loginElement.click();

		WebElement LoggedInUser = findElement("id", "userNav");
		LoggedInUser.click();

		findElement("xpath", "//a[@title='Logout']").click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement remUserName = findElement("id", "username_container");

		// waitToLoadWebPage(remUserName);
		String actual = remUserName.getText();
		testResult(actual, expected, "TestCase3");
		driver.close();
	}

	public static void forgetPasswordTest() {
		String expectedTitle = "Check Your Email | Salesforce";
		getDriverInstance("chrome");
		PropertiesUtilities ob = new PropertiesUtilities();
		ob.loadFile("applicationDataProperties");
		String URL = ob.getPropertyData("url");
		goToUrl(URL);
		String username = ob.getPropertyData("login.valid.usename");

		findElement("id", "forgot_password_link").click();
		findElement("id", "un").sendKeys(username);
		findElement("id", "continue").click();

		String actualTitle = driver.getTitle();
		testResult(actualTitle, expectedTitle, "TestCase4-A");
	}

	public static void LogInErrorWithInvalidInputs() {
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		getDriverInstance("chrome");
		PropertiesUtilities ob = new PropertiesUtilities();
		ob.loadFile("applicationDataProperties");
		String URL = ob.getPropertyData("url");
		goToUrl(URL);

		String username = ob.getPropertyData("login.invalid.usename");
		WebElement userNameElement = findElement("id", "username");
		enterText(userNameElement, username);

		String password = ob.getPropertyData("login.invalid.password");
		WebElement passwordElement = findElement("id", "password");
		enterText(passwordElement, password);

		WebElement loginElement = findElement("id", "Login");
		loginElement.click();

		String actual = findElement("id", "error").getText();
		testResult(actual, expected, "TestCase4-B");
		driver.close();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// error_logIn();
		// logIn_to_Salesforce();
		// checkRememberMe();
		// forgetPasswordTest();
		// LogInErrorWithInvalidInputs();
	}

}
