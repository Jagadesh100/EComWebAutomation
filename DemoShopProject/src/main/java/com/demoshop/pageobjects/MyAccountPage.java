package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class MyAccountPage extends BaseClass{
	@FindBy(xpath = "nopCommerce demo store")
	WebElement imgLogo;
	
	@FindBy(id = "small-searchterms")
	WebElement searchProductBox;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchProductBtn;
	
	@FindBy(xpath = "//span[@class='wishlist-label']")
	WebElement wishList;
	
	@FindBy(xpath = "//span[@class='cart-label']")
	WebElement shoppingCart;
	
	@FindBy(linkText = "My account")
	WebElement myAccount;
	
	@FindBy(linkText = "Log out")
	WebElement logOut;
	
	@FindBy(linkText = "Log in")
	WebElement login;
	
	public MyAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnLogin() {
		Action.mouseClick(getDriver(), login);
		return new LoginPage();
	}
	
	public String getCurrentURL() {
		return getDriver().getCurrentUrl();
	}
}
