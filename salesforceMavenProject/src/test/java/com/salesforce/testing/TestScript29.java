package com.salesforce.testing;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript29 extends BaseTest{
@Test
	public void contactNameTest() {
		String expected= "Contact: abcd ~ Salesforce - Developer Edition";
		
       LoginTest.logIn_to_Salesforce();
		
		WebElement contacts=findElement("xpath", "//a[@title='Contacts Tab']");
		contacts.click();
		
		WebElement closeDialogBox = findElement("id", "tryLexDialogX");
		closeDialogBox.click();
		
		WebElement recentContactsName= findElement("xpath", "//a[contains(text(),'abcd')]");
		recentContactsName.click();
		
		String actual= driver.getTitle();
		
		assertEquals(actual, expected);
		
		
		
	}
	
}
