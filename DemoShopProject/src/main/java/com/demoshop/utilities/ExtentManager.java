package com.demoshop.utilities;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class ExtentManager extends BaseClass implements ITestListener {
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest test;

	public static void extentSetup() throws Exception {
		String extentReportPath= "";
		String extentConfigFilePath = System.getProperty("user.dir")+"\\extent-config.xml";
		
		try {
			extentReportPath = System.getProperty("user.dir")+"\\test-output\\ExtentReport\\"+Action.getCurrentDateTime()+".html";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		htmlReporter=new ExtentSparkReporter(extentReportPath);
		htmlReporter.loadXMLConfig(extentConfigFilePath);
		
//		htmlReporter.config().setDocumentTitle("Listener Automation Report");
//		htmlReporter.config().setReportName("Orange HRM Test Demo");
//		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("HostName", "MyHost");
		extentReport.setSystemInfo("Os", "Windows 11");
		extentReport.setSystemInfo("ProjectName", "nopCommerce");
		extentReport.setSystemInfo("Tester", "Jagadesh");
		extentReport.setSystemInfo("Browser", "Chrome");
	}
	
	public static void endReport() {
		extentReport.flush();
	}
}
