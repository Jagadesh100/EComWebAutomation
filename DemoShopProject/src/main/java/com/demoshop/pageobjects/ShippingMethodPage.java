package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class ShippingMethodPage extends BaseClass{
	@FindBy(name = "shippingoption")
	WebElement landTransport;
	
	@FindBy(id = "shippingoption_1")
	WebElement oneDayAirShipping;
	
	@FindBy(id = "shippingoption_2")
	WebElement twoDayAirShipping;
	
	
	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']/p/a")
	WebElement backBtn;
	
	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']/button")
	WebElement continueBtn;
	
	public ShippingMethodPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public PaymentMethodPage clickOnContinueButton(String shippingMethod) {
		if(shippingMethod.contains("Ground")) {
			Action.clickOnElement(landTransport);
		}
		else if(shippingMethod.contains("ond day air")) {
			Action.clickOnElement(oneDayAirShipping);
		}
		else if(shippingMethod.contains("two day air")) {
			Action.clickOnElement(twoDayAirShipping);
		}
		
		Action.clickOnElement(continueBtn);
		return new PaymentMethodPage(); 
	}
}
