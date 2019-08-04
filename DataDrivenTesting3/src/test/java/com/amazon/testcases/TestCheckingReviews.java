package com.amazon.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestCheckingReviews extends TestBase {
	
	@Test(priority=26,dataProvider="getData")
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

	@Test(priority=27)
	public void checkingRevies() throws InterruptedException	{
		sendKeys("searchBox","Laptop");
		Thread.sleep(3000);
		click("searchButton");
		click("bestSellerTag");
		click("laptopSelectOne");
		Thread.sleep(5000);
		List<WebElement> productReviews = driver.findElements(By.xpath(OR.getProperty("productReviews")));
	Thread.sleep(3000);
		for(WebElement reviews:productReviews)	{
			System.out.println(reviews.getText());
		}
	}
	

	@Test(priority=28)
	public void signOut() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("openMenuButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signOutButton2"))).click();
	}
}
