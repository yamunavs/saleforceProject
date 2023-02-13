package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestScript21 extends BaseTest {
@Test
	public void leadsViewDropdownTest() {

		String[] expected = { "All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads",
				"View - Custom 1", "View - Custom 2" };
		List<String> listExpected = Arrays.asList(expected);

		LoginTest.logIn_to_Salesforce();

		WebElement lead = findElement("xpath", "//a[contains(text(),'Leads')]");
		lead.click();

		WebElement view = findElement("xpath", "//select[@id='fcf']");
		view.click();
		Select select = new Select(view);
		List<WebElement> alloption = select.getOptions();
		

		List<String> actualList = new ArrayList<String>();
		for (WebElement option : alloption) {
			actualList.add(option.getText());
		}

		assertEquals(actualList, listExpected);
		System.out.println(actualList);

	}

}
