package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class PaymentInformationPage extends BaseClass{
	@FindBy(xpath = "//div[@id='payment-info-buttons-container']/p/a")
	WebElement backBtn;
	
	@FindBy(xpath = "//div[@id='payment-info-buttons-container']/button")
	WebElement continueBtn;
	
	public PaymentInformationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnContinueForPaymentInformation() {
		Action.clickOnElement(continueBtn);
		return new OrderConfirmationPage();
	}
}
