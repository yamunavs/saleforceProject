package com.salesforce.testing;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilityclasses.PropertiesUtilities;

public class TestScript11 extends BaseTest {

	public static void createNewViewTest() {
		LoginTest.logIn_to_Salesforce();
		WebElement accountslink = findElement("xpath", "//a[@title='Accounts Tab']");
		accountslink.click();
		WebElement dialogBoxClose = findElement("id", "tryLexDialogX");
		dialogBoxClose.click();
		WebElement createNewView = findElement("xpath", "//a[contains(text(),'Create New View')]");
		createNewView.click();
		PropertiesUtilities ob = new PropertiesUtilities();
		ob.loadFile("applicationDataProperties");
		String viewName = ob.getPropertyData("createNewView.viewName");
		String uniquename = ob.getPropertyData("createNewView.uniqueName");

		WebElement ViewName = findElement("xpath", "//input[@id='fname']");
		waitToLoadWebPage(ViewName);
		enterText(ViewName, viewName);
		WebElement Uniquename = findElement("xpath", "//input[@id='devname']");
		enterText(Uniquename, uniquename);
		WebElement saveButton = findElement("xpath", "//input[@title='Save']");
		saveButton.click();

		WebElement viewDropdown = findElement("xpath", "//select[@class='title']");
		Select select = new Select(viewDropdown);
		String currentOption = select.getFirstSelectedOption().getText();
		testResult(currentOption, viewName, "TestCase11");
//		List<WebElement> options = select.getOptions();
//		for (WebElement option : options) {
//			if (option.getText().equalsIgnoreCase(viewName)) {
//				System.out.println("TestCase11 is passed");
//				break;
//			}
//
//		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createNewViewTest();
	}

}
