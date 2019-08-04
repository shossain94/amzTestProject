package com.amazon.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.amazon.base.TestBase;
import com.amazon.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = rep.startTest(result.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
		try {//import com.plaid.utilities.TestUtil;
			TestUtil.captureScreenshot();  //capture screenshot
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.setProperty("org.uncommons.reportng.escape-output", "false"); 
		Reporter.log("Capturing Screen shot"); 
		Reporter.log("<a target=\"_blank\" href=\"" + TestUtil.screenshotName + "\">Login Screen link</a>");
		
	//	Reporter.log("<a target=\"_blank\" href=\"abc.jpg\">Login Screen link</a>");
		///           <a target="_blank" href="abc.jpg">Login Screen link</a>                    
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"" + TestUtil.screenshotName + "\"><img src=\"" + TestUtil.screenshotName + "\" width=50 height=50></img></a>");

		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		rep.endTest(test); //to close the test
		rep.flush(); //to generate the report

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		try {//import com.plaid.utilities.TestUtil;
			TestUtil.captureScreenshot();  //capture screenshot
		} catch (IOException e) {
			e.printStackTrace();
		}                                                        
		System.setProperty("org.uncommons.reportng.escape-output", "false"); 
		Reporter.log("Capturing Screen shot");
		Reporter.log("<a target=\"_blank\" href=\"" + TestUtil.screenshotName + "\">Login Screen link</a>");
		
	//	Reporter.log("<a target=\"_blank\" href=\"abc.jpg\">Login Screen link</a>");
		///           <a target="_blank" href="abc.jpg">Login Screen link</a>                    
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"" + TestUtil.screenshotName + "\"><img src=\"" + TestUtil.screenshotName + "\" width=50 height=50></img></a>");

		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" FAILED with exception: "+ result.getThrowable() );
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName) );
		rep.endTest(test); //to end the test
		rep.flush(); //to generate the report

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
