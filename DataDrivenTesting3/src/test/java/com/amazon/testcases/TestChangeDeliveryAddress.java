package com.amazon.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

public class TestChangeDeliveryAddress extends TestBase {
	
	@Test(priority=4, dataProvider="getData")
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
	 
	@Test(priority=5,dataProvider="getUserData")
	public void changeDelivery(String fullname, String streetaddress, String city, String state,String zipcode,String phonenumber ) throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("deliverKey"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("manageAddressBookButton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("addressPlusButton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("fullNameBox"))).sendKeys(fullname);
		driver.findElement(By.xpath(OR.getProperty("streetAddressBox"))).sendKeys(streetaddress);
		driver.findElement(By.xpath(OR.getProperty("cityBox"))).sendKeys(city);
		driver.findElement(By.xpath(OR.getProperty("stateBox"))).sendKeys(state);
		driver.findElement(By.xpath(OR.getProperty("zipcodeBox"))).sendKeys(zipcode);
		driver.findElement(By.xpath(OR.getProperty("phonenumber"))).sendKeys(phonenumber);
		driver.findElement(By.xpath(OR.getProperty("addAddressButton"))).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=6)
	public void signOut() throws InterruptedException	{
		driver.findElement(By.xpath(OR.getProperty("openMenuButton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("signOutButton2"))).click();
	}
}
