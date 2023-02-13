package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript33 extends BaseTest{
@Test
	public void verifyLoggedInUserLink() {
		String expected="Salesforce - Developer Edition";
		String expectedFinal="User: yamuna ABC ~ Salesforce - Developer Edition";
		LoginTest.logIn_to_Salesforce();
		
		WebElement home= findElement("xpath", "//a[@title='Home Tab']");
		home.click();
		
		WebElement closeDialogBox = findElement("id", "tryLexDialogX");
		closeDialogBox.click();
		
		
		String actual= driver.getTitle();
		assertEquals(actual, expected);
		
		WebElement usernameLink= findElement("xpath", "//a[contains(text(),'yamuna ABC')]");
		usernameLink.click();
		
		String actualFinal=driver.getTitle();
		
		assertEquals(actualFinal, expectedFinal);
		
		
		
		
		
	}
	
	
}
