package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript23 extends BaseTest {
 @Test
	public void todaysLeadTest() {
		String expected = "Leads ~ Salesforce - Developer Edition";

		LoginTest.logIn_to_Salesforce();

		WebElement lead = findElement("xpath", "//a[contains(text(),'Leads')]");
		lead.click();

		WebElement closeDialogBox = findElement("id", "tryLexDialogX");
		closeDialogBox.click();

		WebElement view = findElement("xpath", "//select[@id='fcf']");
		selectFromDropDown(view, "Today's Leads");

		WebElement goButton = findElement("xpath", "//input[@title='Go!']");
		goButton.click();

		String actual = driver.getTitle();
		assertEquals(actual, expected);

	}

}
