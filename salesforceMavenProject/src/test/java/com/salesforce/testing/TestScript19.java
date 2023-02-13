package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript19 extends BaseTest {
	
	@Test
public void quaterlySummaryReport() {
	String expected="Opportunity Report ~ Salesforce - Developer Edition";
	
	LoginTest.logIn_to_Salesforce();
	
	WebElement oppourtunities= findElement("xpath", "//a[contains(text(),'Opportunities')]");
	oppourtunities.click();
	
	WebElement dialogBoxClose = findElement("id", "tryLexDialogX");
	dialogBoxClose.click();
	
	WebElement interval=findElement("xpath", "//select[@id='quarter_q']");
	interval.click();
	selectFromDropDown(interval, "Next FQ");
	
	WebElement include=findElement("xpath", "//select[@id='open']");
	include.click();
	selectFromDropDown(include, "Open Opportunities");
	
	WebElement runReport=findElement("xpath", "//tbody/tr[3]/td[1]/input[1]");
	runReport.click();
	
	String actual= driver.getTitle();
	assertEquals(actual, expected);
	
}
	

}
