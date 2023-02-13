package com.salesforce.testing;

import org.openqa.selenium.WebElement;

public class TestScript14 extends BaseTest {
	
	public static void createAccountReportTest() {
		LoginTest.logIn_to_Salesforce();
		WebElement accountslink = findElement("xpath", "//a[@title='Accounts Tab']");
		accountslink.click();
		
		WebElement dialogBoxClose = findElement("id", "tryLexDialogX");
		dialogBoxClose.click();
		
		WebElement accountsWithLastactivity=findElement("xpath", "//a[contains(text(),'Accounts with last activity > 30 days')]");
		accountsWithLastactivity.click();
		
		WebElement fromCalenderIcon=findElement("xpath", "//img[@id='ext-gen152']");
		fromCalenderIcon.click();
		
		WebElement today= findElement("xpath", "//table[@id='ext-comp-1111']");
		today.click();
		
		WebElement tocalenderIcon=findElement("xpath", "//img[@id='ext-gen154']");
		tocalenderIcon.click();
	
		
		WebElement todayButton= findElement("xpath", "//*[@id=\"ext-gen292\"]");
		todayButton.click();
		
		WebElement saveButton = findElement("xpath", "//button[@id='ext-gen49']");
		saveButton.click();
		
		WebElement reportName= findElement("xpath", "//input[@id='saveReportDlg_reportNameField']");
		reportName.sendKeys("abc");
		
		WebElement reportUniqueName= findElement("xpath", "//input[@id='saveReportDlg_DeveloperName']");
		reportUniqueName.sendKeys("abc123");
		
		WebElement saveAndRun= findElement("xpath", "//*[@id=\"dlgSaveAndRun\"]");
		saveAndRun.click();
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    createAccountReportTest();
	}

}
