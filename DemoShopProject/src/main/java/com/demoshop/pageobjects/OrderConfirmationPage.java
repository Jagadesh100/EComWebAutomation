package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	@FindBy(xpath = "//div[@id='confirm-order-buttons-container']/p/a")
	WebElement backBtn;
	
	@FindBy(xpath = "//div[@id='confirm-order-buttons-container']/button")
	WebElement continueBtn;
	
	@FindBy(xpath = "//div[@class='order-number']/strong")
	WebElement orderNumber;
	
	@FindBy(xpath = "//div[@class='page-title']/h1")
	WebElement confimationMessage;
	
	@FindBy(xpath ="//div[@id='confirm-order-buttons-container']/button[text()='Confirm']")
	WebElement confirmBtn;
	
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isConfirmButtonDisplayed() {
		return Action.isDisplayed(getDriver(), continueBtn);
		
	}
	
	public boolean confirmMessage() {
		Action.clickOnElement(confirmBtn);
		return Action.isDisplayed(getDriver(), confimationMessage);
	}
	
	public String getOrderNumber() {
		String OrderNumber=orderNumber.getText();
		return OrderNumber;
	}
}
