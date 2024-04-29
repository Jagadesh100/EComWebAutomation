package com.demoshop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoshop.dataprovider.DataProviders;
import com.demoshop.pageobjects.HomePage;
import com.demostore.base.BaseClass;
import com.demoshop.pageobjects.SearchResultPage;
import com.demoshop.utilities.Log;

public class SearchResultPageTest extends BaseClass {
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void setUp(String browser){
		launchApp(browser);
	}
	
	@Test(dataProvider = "products" ,dataProviderClass = DataProviders.class  , groups = "Smoke")
	public void productAvailabilityTest(String Products, String ProductName) {
		Log.startTestCase("Product Availability");
		Log.info("User Lands on HomePage");
		homePage = new HomePage();
		Log.info("User Inputs the Product Name in Search Product Text Box");
		searchResultPage = homePage.searchProduct(Products);
		Log.info("Verify if Product is available");
		boolean result = searchResultPage.isProductAvailable(ProductName);
		if(result) {
			Log.info("Product Searched by the User is Available in the Store");;
		}
		else {
			Log.error("Product Searched by the User is not Available in the Store");
		}
		Assert.assertTrue(result);
		Log.endTestCase("Product Availability");
	}
	
	@AfterMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
