package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript24 extends BaseTest {
@Test
	public void newButtonLeadTest() {
		
		String expectedPageTitle="Lead Edit: New Lead ~ Salesforce - Developer Edition";
		
		LoginTest.logIn_to_Salesforce();

		WebElement lead = findElement("xpath", "//a[contains(text(),'Leads')]");
		lead.click();

		WebElement closeDialogBox = findElement("id", "tryLexDialogX");
		closeDialogBox.click();
		
		WebElement newButton= findElement("xpath", "//tbody/tr[1]/td[2]/input[1]");
		newButton.click();
		
		String actualPageTitle=driver.getTitle(); 
		assertEquals(actualPageTitle, expectedPageTitle);
		
		WebElement lastname= findElement("id", "name_lastlea2");
		enterText(lastname, "ABCD");
		
		WebElement companyName= findElement("id", "lea3");
		enterText(companyName, "ABCD");
		
		WebElement savebutton= findElement("xpath", "//input[@title='Save']");
		savebutton.click();
		
		
	}
	
}
