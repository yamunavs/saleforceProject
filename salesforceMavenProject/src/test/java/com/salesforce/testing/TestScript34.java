package com.salesforce.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class TestScript34  extends BaseTest{
	@Test
public static void verifyEditedLastNameUpdate() {
	LoginTest.logIn_to_Salesforce();
	String expectedNameLinkpage="User: yamuna xyz ~ Salesforce - Developer Edition";
	String expectedContactElement= " Email";
	String expectedChangedName="yamuna abc  ";
	
	WebElement homeTab= findElement("xpath", "//a[@title='Home Tab']");
	homeTab.click();
	ThreadSleep(1000);
	
	WebElement closeDialogBox = findElement("id", "tryLexDialogX");
	closeDialogBox.click();
	
	
	WebElement firstnamelastNameLink= findElement("xpath", "//h1[@class='currentStatusUserName']//child::a");
	firstnamelastNameLink.click();
	ThreadSleep(1000);
	
	String actualNameLinkPage=driver.getTitle();
	assertEquals(actualNameLinkPage, expectedNameLinkpage);
	

	WebElement edit = findElement("xpath",
			"//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]");
	ThreadSleep(2000);
	edit.click();
	driver.switchTo().frame("contactInfoContentId");
	
//	WebElement email=findElement("xpath", "//*[@id=\"TabPanel:0:Body:2\"]/div[1]/div[1]/div/div[1]/label");
//	String actualContactElement=email.getText();
//	assertEquals(actualContactElement, expectedContactElement);
	
	WebElement aboutTab = findElement("id", "aboutTab");
	aboutTab.click();
	
	WebElement lastname = findElement("id", "lastName");
	enterText(lastname, "abc");
	findElement("xpath", "//input[@value='Save All']").click();
	String actualChangedName=findElement("id", "tailBreadcrumbNode").getText();
	assertEquals(actualChangedName, expectedChangedName);
	
	String actualChangedUserName= findElement("id", "userNav").getText();
	assertEquals(actualChangedUserName, expectedChangedName);
	
	
	
	
	
	
	
}

}
