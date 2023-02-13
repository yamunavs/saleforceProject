package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript20 extends BaseTest{
@Test
	public void checkLeadTabTest()  {
		
		String expected="Leads: Home ~ Salesforce - Developer Edition";
		
		LoginTest.logIn_to_Salesforce();
		
		WebElement lead=findElement("xpath", "//a[contains(text(),'Leads')]");
		lead.click();
		
		String actual=driver.getTitle();
		assertEquals(actual, expected);
		
		
	}

}
