package com.salesforce.testing;

import java.util.Set;

import org.openqa.selenium.WebElement;

import com.utilityclasses.PropertiesUtilities;

public class TestScript10 extends BaseTest {
	public static void createaccountTest() {
		LoginTest.logIn_to_Salesforce();
		WebElement accountslink = findElement("xpath", "//a[@title='Accounts Tab']");
		accountslink.click();
		WebElement dialogBoxClose = findElement("id", "tryLexDialogX");
		dialogBoxClose.click();

		WebElement newButton = findElement("xpath", "//input[@title='New']");
		waitToLoadWebPage(newButton);
		newButton.click();
		WebElement accountName = findElement("xpath", "//input[@id='acc2']");
		PropertiesUtilities ob = new PropertiesUtilities();
		ob.loadFile("applicationDataProperties");
		String accName = ob.getPropertyData("createAccount.accName");
		accountName.sendKeys(accName);

		WebElement type = findElement("xpath", "//select[@id='acc6']");
		selectFromDropDown(type, "Technology Partner");

		WebElement customerPriority = findElement("xpath", "//select[@id='00NDn00000SjV16']");
		selectFromDropDown(customerPriority, "High");

		WebElement saveButton = findElement("xpath", "//input[@title='Save']");
		saveButton.click();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createaccountTest();
	}

}
