package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript31 extends BaseTest{
@Test
	public void checkCancelButton() {
		
		String expected= "Contacts: Home ~ Salesforce - Developer Edition";
		
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
		
		WebElement cancel= findElement("xpath", "//input[@title='Cancel']");
		cancel.click();
		
		String actual=driver.getTitle();
		
		assertEquals(actual, expected);
		
		
	}
	
}
