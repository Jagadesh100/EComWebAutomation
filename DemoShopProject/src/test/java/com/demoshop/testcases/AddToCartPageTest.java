package com.demoshop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoshop.dataprovider.DataProviders;
import com.demoshop.pageobjects.AddToCartPage;
import com.demoshop.pageobjects.HomePage;
import com.demoshop.pageobjects.SearchResultPage;
import com.demoshop.utilities.Log;
import com.demostore.base.BaseClass;

public class AddToCartPageTest extends BaseClass{
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void setUp(String browser){
		launchApp(browser);
	}
	
	@Test(dataProvider = "products" , dataProviderClass = DataProviders.class , groups = {"Regression","Sanity"})
	public void addToCartTest(String Product,String ProductName,String Quantity) {
		Log.startTestCase("Product Availability");
		Log.info("User Lands on HomePage");
		homePage = new HomePage();
		searchResultPage = homePage.searchProduct(Product);
		Log.info("Verify if Product is available");
		boolean result = searchResultPage.isProductAvailable(ProductName);
		if(result) {
			Log.info("Product Searched by the User is Available in the Store");;
		}
		else {
			Log.error("Product Searched by the User is not Available in the Store");
		}
		Log.info("User Clicks on the Product from Search Reuslt Page");
		addToCartPage = searchResultPage.clickOnProduct();
		Log.info("User Entered quantity as "+Quantity);
		addToCartPage.enterQuantity(Quantity);
		Log.info("User Clicks on the Add To Cart Button");
		addToCartPage.clickOnAddToCart();
		boolean result1 = addToCartPage.validateAddToCart();
		if(result1) {
			Log.info("Product Successfully Added to the cart");
		}
		else {
			Log.error("Product not added to the Cart");
		}
		Assert.assertTrue(result1);
		Log.endTestCase("Add To Cart");
	}
	
	@AfterMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
