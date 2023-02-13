package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestScript22 extends BaseTest {
	@Test
	public void goFunctionalityTest() {
		String expected = "Leads ~ Salesforce - Developer Edition";
		LoginTest.logIn_to_Salesforce();

		WebElement lead = findElement("xpath", "//a[contains(text(),'Leads')]");
		lead.click();

		WebElement closeDialogBox = findElement("id", "tryLexDialogX");
		closeDialogBox.click();

		WebElement view = findElement("xpath", "//select[@id='fcf']");
		selectFromDropDown(view, "My Unread Leads");

		WebElement userMenu = findElement("id", "userNavLabel");
		userMenu.click();

		WebElement logout = findElement("xpath", "//a[contains(text(),'Logout')]");
		logout.click();

		LoginTest.logIn_to_Salesforce();

		lead = findElement("xpath", "//a[contains(text(),'Leads')]");
		lead.click();

		closeDialogBox = findElement("id", "tryLexDialogX");
		closeDialogBox.click();

		view = findElement("xpath", "//select[@id='fcf']");
		Select select = new Select(view);
		select.getFirstSelectedOption();

		WebElement goButton = findElement("xpath", "//input[@title='Go!']");
		goButton.click();

		String actual = driver.getTitle();
		assertEquals(actual, expected);

	}

}
