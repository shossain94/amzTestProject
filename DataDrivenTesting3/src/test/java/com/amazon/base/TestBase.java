package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.amazon.utilities.ExcelReader;
import com.amazon.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	public final static String projectPath = System.getProperty("user.dir");
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(projectPath + "\\src\\test\\resources\\excel\\user_data.xlsx");
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		if (driver == null) {
			fis = new FileInputStream(projectPath + "\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			fis = new FileInputStream(projectPath + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
		}
		
		if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					projectPath + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (config.getProperty("browser").equals("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver",
					projectPath + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
		}

		// Driver initializing code
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Integer.parseInt(config.getProperty("implicit.wait")),

	}

	public boolean isElementPresent(By by) {
		try { // try control space
			driver.findElement(by);
			return true; // if NoSuchElementException occur
		} catch (NoSuchElementException e) {
			// import org.openqa.selenium.NoSuchElementException
			return false;
		}
	}// isElementPresent(By by)

	@DataProvider
	public Object[][] getData() {
		String sheetName = "user";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 1; rowNum <= rows - 1; rowNum++) {
			for (int colNum = 0; colNum <= cols - 1; colNum++) {
				data[rowNum - 1][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			} // inner for
		} // outer for
		return data;
	}// public Object[][] getData()

	@DataProvider
	public Object[][] getUserData() {
		String sheetName = "address_information";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 1; rowNum <= rows - 1; rowNum++) {
			for (int colNum = 0; colNum <= cols - 1; colNum++) {
				data[rowNum - 1][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			} // inner for
		} // outer for
		return data;
	}// public Object[][] getData()

	public void click(String xpath) {
		driver.findElement(By.xpath(OR.getProperty(xpath))).click();
	}

	public void clear(String xpath) {
		driver.findElement(By.xpath(OR.getProperty(xpath))).clear();
	}

	public void sendKeys(String xpath, String text) {
		driver.findElement(By.xpath(OR.getProperty(xpath))).sendKeys(text);
	}

	public void sendKeysOR(String xpath, String text) {
		driver.findElement(By.xpath(OR.getProperty(xpath))).sendKeys(OR.getProperty(text));
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}
}
