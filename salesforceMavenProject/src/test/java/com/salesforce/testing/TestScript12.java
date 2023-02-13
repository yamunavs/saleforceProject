package com.salesforce.testing;

import org.openqa.selenium.WebElement;

public class TestScript12 extends BaseTest{

	public static void editViewTest() {
		LoginTest.logIn_to_Salesforce();
		WebElement accountslink = findElement("xpath", "//a[@title='Accounts Tab']");
		accountslink.click();
		WebElement dialogBoxClose = findElement("id", "tryLexDialogX");
		dialogBoxClose.click();
		
		WebElement viewDropdown = findElement("id", "");
		waitToLoadWebPage(viewDropdown);
		selectFromDropDown(viewDropdown, "abcd");
		WebElement edit=findElement("xpath", "//a[text()='Edit']");
		edit.click();
		WebElement ViewName = findElement("xpath", "//input[@id='fname']");
		enterText(ViewName, "EFGH");
		WebElement filterField=findElement("xpath", "//select[@id='fcol1']");
		selectFromDropDown(filterField, "Account Name");
		WebElement operator= findElement("xpath", "//select[@id='fop1']");
		selectFromDropDown(operator, "contains");
		WebElement value= findElement("xpath", "//input[@id='fval1']");
		value.sendKeys("a");
		WebElement saveButton=findElement("xpath", "//input[@title='Save']");
		saveButton.click();
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
editViewTest();
	}

}
