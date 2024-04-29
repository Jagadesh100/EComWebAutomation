package com.demoshop.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.demostore.base.BaseClass;
import com.demoshop.actiondriver.Action;

public class ListenerClass extends ExtentManager implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		test=extentReport.createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() +" - Test Case Passed", ExtentColor.GREEN));
//		String pathString=Action.screenShot(BaseClass.getDriver(), result.getName());
//		test.addScreenCaptureFromPath(pathString);
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +" - TestCase failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +" -TestCase Failed", ExtentColor.RED));
		
		String pathString=Action.screenShot(BaseClass.getDriver(), result.getName());
		test.addScreenCaptureFromPath(pathString);
		
		//test.fail("Screenshot is attached", MediaEntityBuilder.createScreenCaptureFromBase64String(pathString).build());
	}
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" - Test Case Skipped", ExtentColor.GREY));
	}
}
