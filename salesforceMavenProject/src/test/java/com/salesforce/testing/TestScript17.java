package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript17 extends BaseTest{

	@Test
	public static void oppourtunityPipelineReportTest() {
		
		String expected ="Opportunity Pipeline ~ Salesforce - Developer Edition";
		
		LoginTest.logIn_to_Salesforce();
		
		WebElement oppourtunities= findElement("xpath", "//a[contains(text(),'Opportunities')]");
		oppourtunities.click();
		
		WebElement dialogBoxClose = findElement("id", "tryLexDialogX");
		dialogBoxClose.click();
		
		WebElement oppourtunitypipeline= findElement("xpath", "//a[contains(text(),'Opportunity Pipeline')]");
		oppourtunitypipeline.click();
		
		String actual= driver.getTitle();
		assertEquals(actual, expected);
		
	}
}
