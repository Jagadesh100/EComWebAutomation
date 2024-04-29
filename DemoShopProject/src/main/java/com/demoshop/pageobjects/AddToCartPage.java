package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class AddToCartPage extends BaseClass{
	@FindBy(xpath = "//div[@class='add-to-cart']/child::div//input")
	WebElement quantity;
	
	@FindBy(xpath = "//div[@class='add-to-cart']/child::div//button")
	WebElement addToCart;
	
	@FindBy(xpath = "//div[@id='bar-notification']/div/p")
	WebElement addToCartMessage;
	
	@FindBy(xpath = "//div[@id='bar-notification']/div/p/a")
	WebElement shoppingCart;
	
	public AddToCartPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	
	public void clickOnAddToCart() {
		Action.clickOnElement(addToCart);
	}
	
	public boolean validateAddToCart() {
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public ShoppingCartPage proceedToshoppingCart() {
		Action.fluentWait(getDriver(), 10, 10, shoppingCart);
		Action.clickOnElement(shoppingCart);
		return new ShoppingCartPage();
	}
}
