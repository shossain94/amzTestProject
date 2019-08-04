package com.amazon.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestAddingDeletePhoneNumber extends TestBase {

	@Test(priority=11,dataProvider="getData")
	public void testLogin(String id, String password) throws InterruptedException	{
		//driver.findElement(By.xpath(OR.getProperty("accountListButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("emailTextBox"))).sendKeys(id);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("passwordTextBox"))).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signinButton"))).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=12)
	public void testAddingDeletePhone() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("accountListButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("login&SecurityButton"))).click();
		Thread.sleep(3000);
		click("addPhoneNumberButton");
		sendKeys("inputPhoneNumber","4698880266");
		Thread.sleep(3000);
		click("textVerifyContinue");
		Thread.sleep(3000);
		click("sendTextOkButton");
		Thread.sleep(10000);
		click("textVerificationContinueButton");
		Thread.sleep(3000);
		click("phoneNumberVerificationButton");
		Thread.sleep(3000);
		click("passwordVerificationButton");
		Thread.sleep(3000);
		click("phoneNumberSave");
		Thread.sleep(3000);
		click("phoneNumberEdit");
		Thread.sleep(3000);
		click("deletePhoneNumber");
		Thread.sleep(3000);
		click("yesDeleteButton");
		Thread.sleep(3000);
		
		
	}
	@Test(priority=13)
	public void signOut() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("openMenuButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signOutButton2"))).click();
	}
}
