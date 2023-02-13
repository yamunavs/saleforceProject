package com.salesforce.testing;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript28 extends BaseTest {
@Test
	public void myContactsViewTest() {
		LoginTest.logIn_to_Salesforce();
		
		WebElement contacts=findElement("xpath", "//a[@title='Contacts Tab']");
		contacts.click();
		
		WebElement closeDialogBox = findElement("id", "tryLexDialogX");
		closeDialogBox.click();
		
		WebElement view=findElement("id", "fcf");
		selectFromDropDown(view, "My Contacts");
		
		WebElement goButton= findElement("xpath", "//input[@title='Go!']");
		goButton.click();

	}
	
}
