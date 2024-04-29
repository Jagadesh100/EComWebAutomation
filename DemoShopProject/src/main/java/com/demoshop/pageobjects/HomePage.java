package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//img[@alt='nopCommerce demo store']")
	WebElement imgLogo;
	
	@FindBy(id = "small-searchterms")
	WebElement searchProductBox;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchProductBtn;
	
	@FindBy(linkText = "Register")
	WebElement register;
	
	@FindBy(linkText = "Log in")
	WebElement login;
	
	@FindBy(xpath = "//span[@class='wishlist-label']")
	WebElement wishListMenu;
	
	@FindBy(xpath = "//span[@class='cart-label']")
	WebElement shoppingCartMenu;
	
	@FindBy(css = "div.master-wrapper-page:nth-child(7) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.home-page div.page-body div.product-grid.home-page-product-grid div.item-grid div.item-box:nth-child(1) div.product-item div.details div.add-info div.buttons > button.button-2.add-to-wishlist-button:nth-child(3)")
	WebElement wishListIcon;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnLogin() {
		Action.clickOnElement(login);
		//Action.mouseClick(driver, login);
		return new LoginPage();
	}
	
	public RegisterPage clickOnRegister() {
		Action.clickOnElement(register);
		//Action.mouseClick(driver, register);
		return new RegisterPage();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), imgLogo);
	}
	
	public String getTitleofThePage() {
		return getDriver().getTitle();
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.clickOnElement(searchProductBtn);
		//Action.mouseClick(driver, searchProductBtn);
		return new SearchResultPage();
	}
	
	public boolean validateMyWishList() {
		return Action.isDisplayed(getDriver(), wishListMenu);
	}
	
	
	public String getCurrentURL() {
		return getDriver().getCurrentUrl();
	}
}
