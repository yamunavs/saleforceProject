package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript18 extends BaseTest {
	@Test
public void stuckOppourtunitiesReportTest() {
	
	String expected="Stuck Opportunities ~ Salesforce - Developer Edition";
	
	LoginTest.logIn_to_Salesforce();
	
	WebElement oppourtunities= findElement("xpath", "//a[contains(text(),'Opportunities')]");
	oppourtunities.click();
	
	WebElement dialogBoxClose = findElement("id", "tryLexDialogX");
	dialogBoxClose.click();
	
	WebElement stuckOpportunities=findElement("xpath", "//a[contains(text(),'Stuck Opportunities')]");
	stuckOpportunities.click();
	
	String actual= driver.getTitle();
	assertEquals(actual, expected);
	
}
	
}
