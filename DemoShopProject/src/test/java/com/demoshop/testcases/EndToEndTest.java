package com.demoshop.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoshop.pageobjects.AddToCartPage;
import com.demoshop.pageobjects.BillingAddressPage;
import com.demoshop.pageobjects.HomePage;
import com.demoshop.pageobjects.LoginPage;
import com.demoshop.pageobjects.OrderConfirmationPage;
import com.demoshop.pageobjects.PaymentInformationPage;
import com.demoshop.pageobjects.PaymentMethodPage;
import com.demoshop.pageobjects.SearchResultPage;
import com.demoshop.pageobjects.ShippingMethodPage;
import com.demoshop.pageobjects.ShoppingCartPage;
import com.demostore.base.BaseClass;

public class EndToEndTest extends BaseClass{
	
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addtocartPage;
	ShoppingCartPage shoppingCartPage;
	LoginPage loginPage;
	BillingAddressPage billingAddressPage;
	ShippingMethodPage shippingMethodPage;
	PaymentMethodPage paymentMethodPage;
	PaymentInformationPage paymentInformationPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void setUp(String browser){
		launchApp(browser);
	}
	
	@Test(groups = "Regression")
	public void endToEndTest() {
		homePage = new HomePage();
		searchResultPage = homePage.searchProduct("phone");
		searchResultPage.isProductAvailable("HTC One Mini Blue");
		addtocartPage = searchResultPage.clickOnProduct();
		addtocartPage.enterQuantity("3");
		addtocartPage.clickOnAddToCart();
		shoppingCartPage = addtocartPage.proceedToshoppingCart();
		shoppingCartPage.clickOnCheckOut();
		billingAddressPage = shoppingCartPage.checkoutAsGuest();
		billingAddressPage.enterDetailsforBillingPage("Testing","Mr","test123@gmail.com","United States", "Florida", "ChurchHill", "Richie Street", "490384703", "345758395833");
		shippingMethodPage = billingAddressPage.clickOnContinue();
		paymentMethodPage = shippingMethodPage.clickOnContinueButton("Ground");
		paymentInformationPage = paymentMethodPage.clickOnContinueForPaymentMethod("Money Order");
		orderConfirmationPage = paymentInformationPage.clickOnContinueForPaymentInformation();
		boolean result = orderConfirmationPage.confirmMessage();
		Assert.assertTrue(result);
	}
	
	
	@AfterMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void tearDown() {
		//driver.quit();
	}
}
