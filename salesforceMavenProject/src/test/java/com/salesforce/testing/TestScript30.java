package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript30 extends BaseTest{
@Test
	public void checjErrorMessageInCreateView() {
		
		String expected= "Error: You must enter a value";
		
		 LoginTest.logIn_to_Salesforce();
			
			WebElement contacts=findElement("xpath", "//a[@title='Contacts Tab']");
			contacts.click();
			
			WebElement closeDialogBox = findElement("id", "tryLexDialogX");
			closeDialogBox.click();
			
			WebElement createNewView= findElement("xpath", "//a[contains(text(),'Create New View')]");
			createNewView.click();
			
			WebElement uniqueName=findElement("id", "devname");
			enterText(uniqueName, "EFGH");
			
			WebElement saveButton= findElement("xpath", "//input[@title='Save']");
			saveButton.click();
			
			WebElement error= findElement("xpath", "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[2]");
			String actual=error.getText();
			
			assertEquals(actual, expected);
	}
	
}
