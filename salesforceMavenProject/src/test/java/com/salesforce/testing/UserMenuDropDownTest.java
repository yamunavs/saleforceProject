package com.salesforce.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bouncycastle.crypto.engines.ISAACEngine;
import org.bouncycastle.mime.MimeWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import okhttp3.internal.connection.RouteSelector.Selection;

public class UserMenuDropDownTest extends BaseTest {

	public static void userMenuDropDown() {
		String expected = "[My Profile, My Settings, Developer Console, Switch to Lightning Experience, Logout]";

		LoginTest.logIn_to_Salesforce();
		findElement("id", "userNavLabel").click();

		List<WebElement> dropdown = driver.findElements(By.className("menuButtonMenuLink"));
		ArrayList<String> list = new ArrayList<>();

		for (WebElement Element : dropdown) {
			if (!Element.getText().isBlank() || !Element.getText().isEmpty()) {
				list.add(Element.getText());

			}
		}
		String actual = list.toString();
		testResult(actual, expected, "TestCase5");

	}
	public static void editContactTest() {
		WebElement myProfile = findElement("xpath", "//a[text()='My Profile']");
		waitToLoadWebPage(myProfile);
		myProfile.click();
		System.out.println(driver.getTitle() + " is displayed");

		WebElement edit = findElement("xpath",
				"//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]");
		waitToLoadWebPage(edit);
		edit.click();

		driver.switchTo().frame("contactInfoContentId");

		WebElement aboutTab = findElement("id", "aboutTab");
		aboutTab.click();
		WebElement lastname = findElement("id", "lastName");
		enterText(lastname, "ABC");
		findElement("xpath", "//input[@value='Save All']").click();

	}
	public static void postTest() {
		
		WebElement postlink = findElement("id", "publisherAttachTextPost");
		waitToLoadWebPage(postlink);
		System.out.println(driver.getTitle() + " is displayed");
		postlink.click();
		WebElement post = findElement("xpath", "//*[@id=\"cke_43_contents\"]/iframe");
		waitToLoadWebPage(post);

		driver.switchTo().frame(post);

		findElement("xpath", "/html/body").sendKeys("hi");
		driver.switchTo().defaultContent();
		findElement("id", "publishersharebutton").click();

	}
	
	private static void uploadFileTest() {
		WebElement filelink = findElement("id", "publisherAttachContentPost");
		// waitToLoadWebPage(filelink);//
		filelink.click();
		WebElement uploadFile=findElement("id", "chatterUploadFileAction");
		waitToLoadWebPage(uploadFile);
		uploadFile.click();

//		ThreadSleep(500);

		WebElement chooseFile = findElement("id", "chatterFile");
		waitToLoadWebPage(chooseFile);//
		javaScriptexecutor(chooseFile,"arguments[0].click();");

		FileDialogPasteAndEnter("C:\\Users\\Vivek\\Desktop\\sample.pdf");
	
		ThreadSleep(500);

		WebElement share = findElement("id", "publishersharebutton");
		share.click();
	}
public static void profileImageTest() {
	Actions actions=new Actions(driver);
	WebElement profileImg=findElement("xpath", "//*[@id=\"photoSection\"]/span[2]/img[1]");
	actions.moveToElement(profileImg).build().perform();
	
	WebElement addPhoto=findElement("id", "uploadLink");
	//waitToLoadWebPage(addPhoto);
	addPhoto.click();
//	ThreadSleep(500);
	driver.switchTo().frame("uploadPhotoContentId");
	//*[@id="j_id0:uploadFileForm:uploadInputFile"]
	WebElement chooseimg= findElement("xpath", "//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]");
	chooseimg.sendKeys("C:\\Users\\Vivek\\Desktop\\pexels-pixabay-60597.jpg");
	//waitToLoadWebPage(chooseimg);
	//chooseimg.click();
	//javaScriptexecutor(chooseimg,"arguments[0].click();");
	
	
	//FileDialogPasteAndEnter("C:\\Users\\Vivek\\Desktop\\pexels-pixabay-60597.jpg");
	
	findElement("id", "j_id0:uploadFileForm:uploadBtn").click();
			
	WebElement selectarea= findElement("class", "imgCrop_selArea");	
	javaScriptexecutor(selectarea,"arguments[0].setAttribute('style', 'left: 46px; top: 14px; width: 249px; height: 249px;')");
	selectarea.click();
	findElement("xpath", "//*[@id=\"j_id0:j_id7:save\"]").click();
	
}
	public static void myProfileTest() {

		editContactTest();
		//postTest();
		//ThreadSleep(500);
		//uploadFileTest();
		//ThreadSleep(3000);		
		profileImageTest(); 
	}
     
	public static void main(String[] args) {
		userMenuDropDown();
		myProfileTest();
	}

}
