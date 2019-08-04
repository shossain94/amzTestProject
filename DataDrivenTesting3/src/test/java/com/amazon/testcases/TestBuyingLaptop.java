package com.amazon.testcases;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestBuyingLaptop extends TestBase {

	
	
	@Test(priority=29,dataProvider="getData")
	public void testLogin(String id, String password) throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("accountListButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("emailTextBox"))).sendKeys(id);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("passwordTextBox"))).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signinButton"))).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=30,dataProvider="getUserData")
	public void buyLaptop(String fullname, String streetaddress, String city, String state,String zipcode,String phonenumber ) throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("searchBox"))).sendKeys("Laptop");
		driver.findElement(By.xpath(OR.getProperty("searchButton"))).click();
		driver.findElement(By.xpath(OR.getProperty("bestSellerTag"))).click();
		driver.findElement(By.xpath(OR.getProperty("laptopSelectOne"))).click();
		/*List<WebElement> lapRatings = driver.findElements(By.xpath(OR.getProperty("ratingList")));
		//List<int> lapRatings = ratings.stream().map(WebElement::getText).collect(Collectors.toList());
		for(WebElement laptop:lapRatings) {
			int v = Integer.parseInt( laptop.getText());
			System.out.println(v);
		}
		*/
		String im="mdkhab";
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("addToCartButton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("noProtectionPlanButton"))).click();
		driver.findElement(By.xpath(OR.getProperty("proceedToCheckoutButton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("newFullNameBox"))).clear();
		driver.findElement(By.xpath(OR.getProperty("newFullNameBox"))).sendKeys(fullname);
		driver.findElement(By.xpath(OR.getProperty("newAddressLine"))).sendKeys(streetaddress);
		driver.findElement(By.xpath(OR.getProperty("newcity"))).sendKeys(city);
		driver.findElement(By.xpath(OR.getProperty("newState"))).sendKeys(state);
		driver.findElement(By.xpath(OR.getProperty("newZip"))).sendKeys(zipcode);
		driver.findElement(By.xpath(OR.getProperty("newPhoneNumber"))).sendKeys(phonenumber);
		driver.findElement(By.xpath(OR.getProperty("addingAddressContinueButton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("deliveryContinueButton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("shippingContinueButton"))).click();
		Thread.sleep(5000);
	}
	
	
}
