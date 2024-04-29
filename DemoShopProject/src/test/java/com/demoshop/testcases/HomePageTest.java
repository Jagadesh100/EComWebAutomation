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

public class HomePageTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void setUp(String browser)
	{
		launchApp(browser);
		homePage=new HomePage();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() {
		Log.startTestCase("Verify Logo");
		boolean result =  homePage.validateLogo();
		if(result) {
			Log.info("Logo is Present in the System");
			Assert.assertTrue(result);
			Log.endTestCase("Verify Logo Test Completed Successfully");
		}
		else {
			Log.error("Verfify Logo Test Failed");
			Assert.assertTrue(result);
			Log.endTestCase("");
		}
	}
	
	@Test(groups = "Smoke")
	public void verifyTitleOfThePage() {
		String actualTesult = homePage.getTitleofThePage();
		Assert.assertEquals(actualTesult, "nopCommerce demo store");
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void verifyWishList(String user,String pwd) {
		loginPage = homePage.clickOnLogin();
		//homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage = loginPage.login(user, pwd);
		boolean result = homePage.validateMyWishList();
		Assert.assertTrue(result);
	}
	
	@AfterMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void tearDown(){
		getDriver().quit();
	}
}
