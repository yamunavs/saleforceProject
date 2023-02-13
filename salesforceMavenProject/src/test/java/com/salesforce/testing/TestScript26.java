package com.salesforce.testing;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript26 extends BaseTest {
@Test
	public void newViewContactTest() {
		
        LoginTest.logIn_to_Salesforce();
		
		WebElement contacts=findElement("xpath", "//a[@title='Contacts Tab']");
		contacts.click();
		
		WebElement closeDialogBox = findElement("id", "tryLexDialogX");
		closeDialogBox.click();
		
		WebElement createNewView= findElement("xpath", "//a[contains(text(),'Create New View')]");
		createNewView.click();
		
		WebElement viewName= findElement("id", "fname");
		enterText(viewName, "testView");
		
		WebElement uniqueName=findElement("id", "devname");
		enterText(uniqueName, "testview123");
		
		WebElement saveButton= findElement("xpath", "//input[@title='Save']");
		saveButton.click();
		
		
		
		
	}
	
}
