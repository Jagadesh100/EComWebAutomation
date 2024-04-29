package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class BillingAddressPage extends BaseClass{
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement country;
	
	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement state;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement Address1;
	
	@FindBy(id = "BillingNewAddress_Address2")
	WebElement Address2;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalCode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(name = "save")
	WebElement continueBtn;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstName;
	
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastName;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement email;
	
	@FindBy(id = "ShipToSameAddress")
	WebElement shipToSameAddress;
	
	public BillingAddressPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterDetailsforBillingPage(String fname,String lname,String inemail,String inCountry , String inState, String inCity, String inAddress, String inPostCode, String inPhoneNumber) {
		Action.type(firstName,fname);
		Action.type(lastName, lname);
		Action.type(email, inemail);
		Action.selectByVisibleText(country, inCountry);
		Action.selectByVisibleText(state, inState);
		Action.type(city, inCity);
		Action.type(Address1, inAddress);
		Action.type(postalCode, inPostCode);
		Action.type(phoneNumber, inPhoneNumber);
	}
	
	public ShippingMethodPage clickOnContinue() {
		Action.clickOnElement(continueBtn);
		return new ShippingMethodPage();
	}
	
	public ShippingAddressPage clickOnContinue1() {
		Action.clickOnElement(continueBtn);
		return new ShippingAddressPage();
	}
}
