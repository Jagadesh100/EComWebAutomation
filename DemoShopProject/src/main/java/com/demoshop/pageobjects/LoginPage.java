package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class LoginPage extends BaseClass{
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Forgot password?")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//button[text()='Register']")
	WebElement registerBtn;
	
	public LoginPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public RegisterPage createAccount() {
		Action.mouseClick(getDriver(), registerBtn);
		return new RegisterPage();
	}
	
	public MyAccountPage login2(String userName , String pwd) {
		Action.type(email, userName);
		Action.type(password, pwd);
		Action.clickOnElement(loginBtn);
		//Action.mouseClick(driver, loginBtn);
		return new MyAccountPage();
	}
	
	public BillingAddressPage login1(String userName, String pwd) {
		Action.type(email, userName);
		Action.type(password, pwd);
		Action.clickOnElement(loginBtn);
		return new BillingAddressPage();
	}
	
	public HomePage login(String userName , String pwd) {
		Action.type(email, userName);
		Action.type(password, pwd);
		Action.clickOnElement(loginBtn);
		//Action.mouseClick(driver, loginBtn);
		return new HomePage();
	}
}
