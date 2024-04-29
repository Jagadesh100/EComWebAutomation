package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class PaymentMethodPage extends BaseClass{
	@FindBy(id = "paymentmethod_0")
	WebElement moneyOrder;
	
	@FindBy(id = "paymentmethod_0")
	WebElement check;
	
	@FindBy(id = "paymentmethod_1")
	WebElement creditCard;
	
	@FindBy(xpath = "//div[@id='payment-method-buttons-container']/p/a")
	WebElement backBtn;
	
	@FindBy(xpath = "//div[@id='payment-method-buttons-container']/button")
	WebElement continueBtn;
	
	public PaymentMethodPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public PaymentInformationPage clickOnContinueForPaymentMethod(String paymentMethod) {
		if(paymentMethod.contains("Cheque")) {
			Action.clickOnElement(check);
		}
		else if(paymentMethod.contains("Money Order")) {
			Action.clickOnElement(moneyOrder);
		}
		else if(paymentMethod.contains("Credit Card")) {
			Action.clickOnElement(creditCard);
		}
		Action.clickOnElement(continueBtn);
		return new PaymentInformationPage();
	}
}
