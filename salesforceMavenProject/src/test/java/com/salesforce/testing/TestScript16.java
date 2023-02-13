package com.salesforce.testing;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript16 extends BaseTest {
	
	
    public  static void createOppourtunityTest() {
		LoginTest.logIn_to_Salesforce();
		
		WebElement oppourtunities= findElement("xpath", "//a[contains(text(),'Opportunities')]");
		oppourtunities.click();
		
		WebElement dialogBoxClose = findElement("id", "tryLexDialogX");
		dialogBoxClose.click();
		
		
		WebElement newButton= findElement("xpath", "//tbody/tr[1]/td[2]/input[1]");
		newButton.click();
		
		WebElement oppourtunityName= findElement("xpath", "//input[@id='opp3']");
		enterText(oppourtunityName, "abc");
		
		WebElement accountName= findElement("xpath", "//tbody/tr[4]/td[2]/span[1]/a[1]/img[1]");
		enterText(accountName, "yjvivek");
		WebElement accountSearch=findElement("xpath", "//a[@id='opp4_lkwgt']");
		accountSearch.click();
		driver.switchTo().frame("resultsFrame");
		
		
		
		WebElement closeDate= findElement("xpath", "//input[@id='opp9']");
		closeDate.click();
		WebElement today= findElement("xpath", "//a[contains(text(),'Today')]");
		today.click();
		
		WebElement stage=findElement("xpath", "//select[@id='opp11']");
		stage.click();
		selectFromDropDown(stage, "Qualification");
		
		WebElement probablity = findElement("xpath", "//input[@id='opp12']");
		enterText(probablity, "10");
		
		WebElement leadsource= findElement("xpath", "//select[@id='opp6']");
		leadsource.click();
		selectFromDropDown(leadsource, "Web");
		
		WebElement save= findElement("xpath", "//input[@title='Save']");
		save.click();
		
		
		
		
		
	}
    public static void main(String[] args) {
		createOppourtunityTest();
	}
}
