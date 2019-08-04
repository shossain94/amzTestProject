package com.amazon.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestGettingNamesOfBrowsingHistory extends TestBase{

	@Test(priority=14,dataProvider="getData")
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
	
	@Test(priority=15)
	public void productNamesBrowsingHistory()	{
		click("browsingHistoryButton");
		List<WebElement> productNames = driver.findElements(By.xpath(OR.getProperty("listOfRecentlyViewd")));
		for(WebElement product:productNames) {
			System.out.println(product.getText());
		}
	}
	@Test(priority=16)
	public void signOut() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("openMenuButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signOutButton2"))).click();
	}
	
	
}
