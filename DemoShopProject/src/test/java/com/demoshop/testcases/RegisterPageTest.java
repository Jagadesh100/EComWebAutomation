package com.demoshop.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoshop.dataprovider.DataProviders;
import com.demoshop.pageobjects.HomePage;
import com.demoshop.pageobjects.RegisterPage;
import com.demoshop.utilities.Log;
import com.demostore.base.BaseClass;

public class RegisterPageTest extends BaseClass {
	HomePage homePage;
	RegisterPage registerPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void setUp(String browser){
		launchApp(browser);
	}
	
	@Test(dataProvider = "createaccount", dataProviderClass = DataProviders.class , groups = "Sanity")
	public void createAccouuntTest(String gender,String firstName,String lastName,String day,String month,String year,String email,String password,String confirmPassword) {
		Log.startTestCase("Account Creation Page Test");
		Log.info("User landed on Home Page");
		homePage = new HomePage();
		Log.info("User clicked on Register Button from HomePage");
		registerPage = homePage.clickOnRegister();
//		registerPage.createAccount
//		(prop.getProperty("gender"), 
//		prop.getProperty("firstname"), 
//		prop.getProperty("lastname"),
//		prop.getProperty("day"),
//		prop.getProperty("month"),
//		prop.getProperty("year"),
//		prop.getProperty("email"),
//		prop.getProperty("password"), 
//		prop.getProperty("confirmpassword"));
		Log.info("User Entered Mandatory details for Account Creation and Clicks on Register Button");
		registerPage.createAccount(gender, firstName, lastName, day, month, year, email, password, confirmPassword);
		boolean result =registerPage.ValidateAccountCreationPage();
		Log.info("Verify if User is able to create an account");
		if(result) {
			Log.info("User Succesfully Created an Account");
			Log.endTestCase("Account Creation Page Test Completed Successfully");
			Assert.assertTrue(result);
		}
		else {
			Log.error("Account Creation failed");
			Log.endTestCase("Account Creation Page Test Completed with Errors");
			Assert.assertTrue(result);
		}
	}
	
	@AfterMethod(groups = {"Sanity" , "Smoke" , "regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
