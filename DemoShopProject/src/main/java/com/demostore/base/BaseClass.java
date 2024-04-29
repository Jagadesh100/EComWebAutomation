package com.demostore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.demoshop.actiondriver.Action;
import com.demoshop.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declare thread local driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@BeforeSuite(groups = {"Sanity" , "Smoke" , "regression"})
	public void loadConfig() throws Exception {
		ExtentManager.extentSetup();
		DOMConfigurator.configure("log4j.xml");
		prop=new Properties();
		FileInputStream fs;
		
		
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"//Configuration//config.properties");
			try {
				prop.load(fs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("Load Config File");
		}
	}
	
	
	public static void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
		
		 //String browserName=prop.getProperty("browser");
		 System.out.println(browserName);
		 if(browserName.equalsIgnoreCase("Chrome")) {
		 //driver=new ChromeDriver(); 
			 //Set Browser to ThreadLocalMap
			 driver.set(new ChromeDriver());
		 }
		 else if(browserName.equalsIgnoreCase("Edge")) {
		 //driver=new EdgeDriver();
			 driver.set(new EdgeDriver());
		 } 
		 else if(browserName.equalsIgnoreCase("Firefox")) {
		 //driver=new FirefoxDriver(); 
			 driver.set(new FirefoxDriver());
		 }
		Action.implicitWait(getDriver(), 20);
		Action.pageLoadTimeouts(getDriver(), 30);
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public static void AfterSuite() {
		ExtentManager.endReport();
	}
}
