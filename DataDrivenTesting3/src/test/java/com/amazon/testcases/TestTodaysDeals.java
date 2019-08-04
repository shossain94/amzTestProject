package com.amazon.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestTodaysDeals extends TestBase {
	@Test(priority = 17, dataProvider = "getData")
	public void testLogin(String id, String password) throws InterruptedException {
		//driver.findElement(By.xpath(OR.getProperty("accountListButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("emailTextBox"))).sendKeys(id);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("passwordTextBox"))).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signinButton"))).click();
		Thread.sleep(3000);
	}

	@Test(priority = 18)
	public void computerDeals() throws InterruptedException {
		click("todaysDealButton");
		Thread.sleep(5000);
		List<WebElement> productPictures = driver.findElements(By.xpath(OR.getProperty("todaysDealsPictures")));
		List<WebElement> productPrices = driver.findElements(By.xpath(OR.getProperty("todaysDealsPrices")));
		for (WebElement pics : productPictures) {
			
				System.out.println(pics.getText());
				
			}
		for (WebElement prices : productPrices) {
			System.out.println(prices.getText());
		}
	}

	@Test(priority = 19)
	public void signOut() throws InterruptedException {
		driver.findElement(By.xpath(OR.getProperty("openMenuButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signOutButton2"))).click();
	}

}
