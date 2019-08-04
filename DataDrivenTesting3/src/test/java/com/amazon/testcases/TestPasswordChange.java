package com.amazon.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestPasswordChange extends TestBase {

	@Test(priority=20,dataProvider="getData")
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
	
	@Test(priority=21)
	public void passwordChange() throws InterruptedException	{
		click("accountListButton");
		Thread.sleep(3000);
		click("login&SecurityButton");
		Thread.sleep(3000);
		click("passwordEditButton");
		Thread.sleep(3000);
		sendKeysOR("currentPasswordBox","password");
		Thread.sleep(3000);
		sendKeysOR("newPasswordBox","newPassword");
		Thread.sleep(3000);
		sendKeysOR("confirmPasswordBox","confirmPassword");
		Thread.sleep(3000);
		click("passwordSaveButton");
		Thread.sleep(3000);
	}
	
	@Test(priority=22)
	public void signOut() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("openMenuButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signOutButton2"))).click();
	}

}
