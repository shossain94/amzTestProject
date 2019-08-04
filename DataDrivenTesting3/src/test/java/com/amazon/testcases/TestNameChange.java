package com.amazon.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestNameChange extends TestBase {
	@Test(priority=23,dataProvider="getData")
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
	
	@Test(priority=24)
	public void nameChng() throws InterruptedException	{
		click("accountListButton");
		Thread.sleep(3000);
		click("login&SecurityButton");
		Thread.sleep(3000);
		click("nameEditButton");
		Thread.sleep(3000);
		clear("nameEditBox");
		Thread.sleep(3000);
		sendKeysOR("nameEditBox","newName");
		Thread.sleep(3000);
		click("saveNameButton");
		Thread.sleep(3000);
		
		
	}
	@Test(priority=25)
	public void signOut() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("openMenuButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signOutButton2"))).click();
	}

}
