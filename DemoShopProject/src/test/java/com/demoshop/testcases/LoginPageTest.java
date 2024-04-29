package com.demoshop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoshop.dataprovider.DataProviders;
import com.demoshop.pageobjects.HomePage;
import com.demoshop.pageobjects.LoginPage;
import com.demoshop.utilities.Log;
import com.demostore.base.BaseClass;

public class LoginPageTest extends BaseClass{
	
	HomePage homePage;
	LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void setUp(String browser){
		launchApp(browser);
	}
	
	@Test(dataProvider = "credentials" , dataProviderClass = DataProviders.class , groups = {"Smoke" , "Sanity"})
	public void loginTest(String uname,String pwd) {
		Log.startTestCase("loginTest");
		homePage = new HomePage();
		Log.info("User Clicks on Login Button in Home Page");
		loginPage = homePage.clickOnLogin();
		Log.info("User Enters UserName and Password in Login Page");
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname, pwd);
		String actualUrl = homePage.getCurrentURL();
		String expectedUrl = "https://demo.nopcommerce.com/";
		Log.info("Verify if User is able to Login to Application");
		if(actualUrl.equals(expectedUrl)){
			Log.info("Login Sucess");
			Assert.assertEquals(actualUrl, expectedUrl);
			Log.endTestCase("loginTest");
		}
		else {
			Log.error("Login Failed");
			Assert.assertEquals(actualUrl, expectedUrl);
			Log.endTestCase("loginTest");
		}


	}
	
	@AfterMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
