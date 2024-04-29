/**
 * 
 */
package com.demoshop.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.actiondriver.Action;
import com.demostore.base.BaseClass;

/**
 * 
 */
public class SearchResultPage extends BaseClass {
	WebElement productresult;
	
	@FindBy(xpath = "//div[@class='details']/h2/a")
	List<WebElement> productItems;
	
	public SearchResultPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable(String productName) {
		boolean isProductItemAvailable = false;
		for(WebElement item:productItems) {
			if(productName.equalsIgnoreCase(item.getText())) {
				productresult = item;
				isProductItemAvailable = Action.isDisplayed(getDriver(), item);
			}
		}
		return isProductItemAvailable;
	}
	
	public AddToCartPage clickOnProduct() {
		Action.clickOnElement(productresult);
		return new AddToCartPage();
	}
}
