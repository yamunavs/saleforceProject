package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestScript35 extends BaseTest{
public static void verfifyTabCustomization() {
	
	
	
	LoginTest.logIn_to_Salesforce();
	
	WebElement tabplus=findElement("xpath", "//li[@id='AllTab_Tab']");
	tabplus.click();
	String actuallAllTabPageTitle=driver.getTitle();
	


	
	WebElement customizeMyTabs=findElement("xpath", "//tbody/tr[1]/td[2]/input[1]");
	customizeMyTabs.click();
	
	WebElement assets= findElement("xpath", "//option[contains(text(),'Assets')]");
	assets.click();
	
	WebElement remove= findElement("xpath", "//a[@id='duel_select_0_left']");
	remove.click();
	WebElement saveButton= findElement("xpath", "//tbody/tr[1]/td[2]/input[1]");
	saveButton.click();
	
	WebElement usermenuDropDown= findElement("xpath", "//div[@id='userNav']");
	usermenuDropDown.click();
	
	WebElement logout=findElement("xpath", "//a[contains(text(),'Logout')]");
	logout.click();
	
	 
	
	
	
	}
	
	
	
	

public static void main(String[] args) {
	verfifyTabCustomization();
}
}
