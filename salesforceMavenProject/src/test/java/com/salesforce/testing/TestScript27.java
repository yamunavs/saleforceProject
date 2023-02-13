package com.salesforce.testing;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript27 extends BaseTest{
@Test
	public void recentlyCreatedTest() {
		
		 LoginTest.logIn_to_Salesforce();
			
			WebElement contacts=findElement("xpath", "//a[@title='Contacts Tab']");
			contacts.click();
			
			WebElement closeDialogBox = findElement("id", "tryLexDialogX");
			closeDialogBox.click();
			
			WebElement view=findElement("id", "fcf");
			selectFromDropDown(view, "Recently Viewed Contacts");
			
			WebElement goButton= findElement("xpath", "//input[@title='Go!']");
			goButton.click();
			
			
		
	}
	
	
}
