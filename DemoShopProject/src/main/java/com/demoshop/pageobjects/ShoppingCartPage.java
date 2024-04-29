/**
 * 
 */
package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

/**
 * 
 */
public class ShoppingCartPage extends BaseClass{
	@FindBy(xpath = "//td[@class='unit-price']/span")
	WebElement unitPrice;
	
	@FindBy(xpath = "//span[@class='value-summary']/strong")
	WebElement totalPrice;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy(xpath = "//div[@class='buttons']/button[text()='Checkout as Guest']")
	WebElement checkoutAsGuest;
	
	@FindBy(id = "termsofservice")
	WebElement termsOFService;
	
	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		String unitPriceString = unitPrice.getText();
		String units = unitPriceString.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(units);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPriceString = totalPrice.getText();
		String tot = totalPriceString.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public void clickOnCheckOut() {
		Action.clickOnElement(termsOFService);
		Action.clickOnElement(checkoutBtn);
	}
	
	public BillingAddressPage checkoutAsGuest() {
		Action.clickOnElement(checkoutAsGuest);
		//Action.clickOnElement(checkoutBtn);
		return new BillingAddressPage();
	}
}
