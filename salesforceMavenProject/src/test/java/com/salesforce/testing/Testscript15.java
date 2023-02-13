package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Testscript15 extends BaseTest {
@Test
	public static void oppourtunityDropDownTest() {
		
	    String[] expected= {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};
		List<String> listExpected=Arrays.asList(expected);
		
		LoginTest.logIn_to_Salesforce();
		
		WebElement oppourtunities= findElement("xpath", "//a[contains(text(),'Opportunities')]");
		oppourtunities.click();
		
		WebElement oppourtunityDropDown= findElement("xpath", "//select[@id='fcf']");
		waitToLoadWebPage(oppourtunityDropDown);
		oppourtunityDropDown.click();
		
		Select select=new Select(oppourtunityDropDown);
		List<WebElement> options =select.getOptions();
		List<String> actualList= new ArrayList<String>();
		for (WebElement option : options) {
			actualList.add(option.getText());
		}
		assertEquals(actualList, listExpected);
		System.out.println(actualList);
		
	}
	
}
