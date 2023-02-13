package com.salesforce.testing;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript32 extends BaseTest {

	@Test
	public void checkSaveAndNewButton() {
         LoginTest.logIn_to_Salesforce();
		
		WebElement contacts=findElement("xpath", "//a[@title='Contacts Tab']");
		contacts.click();
		
		WebElement closeDialogBox = findElement("id", "tryLexDialogX");
		closeDialogBox.click();
		
		WebElement newButton= findElement("xpath", "//tbody/tr[1]/td[2]/input[1]");
		newButton.click();
		
		WebElement lastaName= findElement("id", "name_lastcon2");
		enterText(lastaName, "xyz");
		
		WebElement accountName= findElement("id", "con4");
		enterText(accountName, "yjvivek");
		
		WebElement newAndSave= findElement("xpath", "//input[@title='Save & New']");
		newAndSave.click();
		
		
	}
}
