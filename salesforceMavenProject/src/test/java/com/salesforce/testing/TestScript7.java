package com.salesforce.testing;

import java.util.Set;

import org.openqa.selenium.WebElement;

import com.utilityclasses.PropertiesUtilities;

public class TestScript7 extends BaseTest{

	public static void mySettingsTest() {
		
		UserMenuDropDownTest.userMenuDropDown();

		WebElement mySettingsLink=findElement("xpath", "//a[contains(text(),'My Settings')]");
		mySettingsLink.click();
		WebElement personal=findElement("xpath", "//tbody/tr[1]/td[1]/div[1]/div[4]/div[2]/a[1]");
		personal.click();
		WebElement loginHistory=findElement("xpath", "//a[@id='LoginHistory_font']");
		loginHistory.click();
		WebElement downloadLoginHistory=findElement("xpath", "//a[contains(text(),'Download login history for last six months, includ')]");
		downloadLoginHistory.click();
		WebElement displayLayoutLink= findElement("xpath", "//tbody/tr[1]/td[1]/div[1]/div[4]/div[3]/a[1]");
		displayLayoutLink.click();
		WebElement customizeTab= findElement("xpath", "//a[@id='CustomizeTabs_font']");
		customizeTab.click();
		
		WebElement customAppDropDown=findElement("id", "p4");
		selectFromDropDown(customAppDropDown, "Salesforce Chatter");
		
		WebElement availableTabs=findElement("id", "duel_select_0");
		selectFromDropDown(availableTabs, "Reports");
		
		WebElement add=findElement("xpath", "//a[@id='duel_select_0_right']");
		add.click();
		
		WebElement save=findElement("xpath", "//tbody/tr[1]/td[2]/input[1]");
		save.click();
		
		WebElement emailLink= findElement("xpath", "//tbody/tr[1]/td[1]/div[1]/div[4]/div[4]/a[1]");
		emailLink.click();
		
		WebElement myEmailSettings= findElement("xpath", "//a[@id='EmailSettings_font']");
		myEmailSettings.click();
		
		WebElement emailAdress=findElement("id", "sender_email");
		PropertiesUtilities ob= new PropertiesUtilities();
		ob.loadFile("applicationDataProperties");
		String Email=ob.getPropertyData("emailaddress");
		enterText(emailAdress, Email);
		
		WebElement automaticBCC=findElement("id", "auto_bcc1");
		automaticBCC.click();
		
		WebElement saveButton= findElement("xpath", "//tbody/tr[1]/td[2]/input[1]");
		saveButton.click();
		
		WebElement calenderRemainders= findElement("xpath", "//*[@id=\"CalendarAndReminders\"]/a");
		calenderRemainders.click();
		
		WebElement activityRemainders=findElement("xpath", "//a[@id='Reminders_font']");
		activityRemainders.click();
		String baseWindow=driver.getWindowHandle();
		WebElement openTestRemainder=findElement("xpath", "//input[@id='testbtn']");
		openTestRemainder.click();
		
		Set<String> allwindows=driver.getWindowHandles();
		String Actualtitle;
		for (String window : allwindows) {
			if (!window.equalsIgnoreCase(baseWindow)) {
				if (driver.getTitle().contains("Reminders")) {
					System.out.println("TestCase7 passed");
				}else {
					System.out.println("Testcase7 failed");
				}
			
				break;
			}
			
		}
		
		
		
		
		
	}
	public static void main(String[] args) {
		mySettingsTest();
	}
	
	
}
