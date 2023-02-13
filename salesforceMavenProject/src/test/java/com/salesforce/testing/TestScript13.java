package com.salesforce.testing;

import org.openqa.selenium.WebElement;

public class TestScript13 extends BaseTest {

	public static void mergeAccountTest() {
		LoginTest.logIn_to_Salesforce();
		WebElement accountslink = findElement("xpath", "//a[@title='Accounts Tab']");
		accountslink.click();
		WebElement dialogBoxClose = findElement("id", "tryLexDialogX");
		dialogBoxClose.click();
		WebElement mergeAccount = findElement("xpath", "//a[contains(text(),'Merge Accounts')]");
		mergeAccount.click();
		WebElement searchAcc = findElement("xpath", "//input[@id='srch']");
		enterText(searchAcc, "yj");
		WebElement findAcc = findElement("xpath", "//input[@value='Find Accounts']");
		findAcc.click();
		WebElement firstAccCheckBox = findElement("xpath", "//input[@id='cid0']");
		selectCheckbox(firstAccCheckBox);
		
		WebElement secondAccCheckBox = findElement("xpath", "//input[@id='cid1']");
		selectCheckbox(secondAccCheckBox);
		WebElement nextbutton = findElement("xpath", "//input[@value=' Next ']");
		nextbutton.click();
		WebElement mergeButton = findElement("xpath", "//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[2]");
		waitToLoadWebPage(mergeButton);
		mergeAccount.click();
		driver.switchTo().alert().accept();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeAccountTest();
	}

}
