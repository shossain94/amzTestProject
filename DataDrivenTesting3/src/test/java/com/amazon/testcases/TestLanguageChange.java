package com.amazon.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestLanguageChange extends TestBase {
	@Test(priority=7,dataProvider="getData")
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
	
	@Test(priority=8)
	public void testChangeLanguageOne() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("languageButton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("languageToESP"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("languageSaveButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("amazonSign"))).click();
		Thread.sleep(3000);
		String login_message = driver.findElement(By.xpath(OR.getProperty("accountListButton"))).getText();
		boolean logc = login_message.contains("Hola, ");
		assertEquals(logc,true);
	}
	
	@Test(priority=9)
	public void testChangeLanguageTwo() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("languageButton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("languageToENG"))).click();
		driver.findElement(By.xpath(OR.getProperty("languageSaveButton"))).click();
		driver.findElement(By.xpath(OR.getProperty("amazonSign"))).click();
		
		String login_message = driver.findElement(By.xpath(OR.getProperty("accountListButton"))).getText();
		boolean logc = login_message.contains("Hello, ");
		assertEquals(logc,true);

	}
	@Test(priority=10)
	public void signOut() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("openMenuButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signOutButton2"))).click();
	}
}
