package com.demoshop.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

public class RegisterPage extends BaseClass {
	
	@FindBy(id = "gender-male")
	WebElement genderMale;
	
	@FindBy(id = "gender-female")
	WebElement genderFemale;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTextBox;
	
	@FindBy(id = "LastName")
	WebElement lastNameTextBox;
	
	//DOB to be done in Select Class
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement selectDate;
	
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement selectMonth;
	
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement selectYear;
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(id = "Company")
	WebElement companyTextBox;
	
	@FindBy(id = "Password")
	WebElement passwordTextBox;
	
	@FindBy(id ="ConfirmPassword")
	WebElement confirmPasswordTextBox;
	
	@FindBy(xpath = "//h1[contains(text(),'Register')]")
	WebElement expectedFormTitle;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement registerMessage;
	
//	@FindBy(className = "button-1 register-continue-button")
//	WebElement continueBtn;
	
	public RegisterPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void createAccount(String gender,String firstName,String lastName,String day,String month,String year,String email,String password,String confirmPassword) {
		if(gender.equalsIgnoreCase("male")) {
			Action.clickOnElement(genderMale);
		}
		else if(gender.equalsIgnoreCase("female")) {
			Action.clickOnElement(genderFemale);
		}
		Action.type(firstNameTextBox, firstName);
		Action.type(lastNameTextBox, lastName);
		Action.selectByValue(selectDate, day);
		Action.selectByValue(selectMonth, month);
		Action.selectByValue(selectYear, year);
		Action.type(emailTextBox, email);
		//Action.type(companyTextBox, confirmPassword)
		Action.type(passwordTextBox, password);
		Action.type(confirmPasswordTextBox, confirmPassword);
		Action.clickOnElement(registerBtn);
	}
	
	public boolean ValidateAccountCreationPage() {
		return Action.isDisplayed(getDriver(), registerMessage);
	}
}
