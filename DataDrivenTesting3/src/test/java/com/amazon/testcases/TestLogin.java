package com.amazon.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestLogin extends TestBase {
	// Actions actions= new Actions(driver);
	@Test(priority=1,dataProvider="getData")
	public void testLogin(String id, String password) throws InterruptedException	{
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("accountListButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("emailTextBox"))).sendKeys(id);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("passwordTextBox"))).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signinButton"))).click();
		Thread.sleep(3000);
	}
	@Test(priority=2)
	public void loginCheck()	{
		String login_message = driver.findElement(By.xpath(OR.getProperty("accountListButton"))).getText();
		boolean logc = login_message.contains("Hello, ");
		assertEquals(logc,true);
	}
/*
	@Test(priority=3)
	public void logOut() throws InterruptedException	{
		Actions actions= new Actions(driver);
		Thread.sleep(3000);
		WebElement target = driver.findElement(By.xpath(OR.getProperty("accountListButton")));
		Thread.sleep(3000);
		actions.moveToElement(target).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signoutButton"))).click();
		Thread.sleep(5000);
	}
	*/
	
	@Test(priority=3)
	public void signOut() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("openMenuButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signOutButton2"))).click();
	}
}

