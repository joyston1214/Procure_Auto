package com.scm.procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {
	

	public RetailerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText =   "New Order")
	private WebElement newOrder_Btn;
	
	@FindBy(linkText =   "Products")
	private WebElement products_Btn;
	
	@FindBy(linkText =   "Home")
	private WebElement home_Btn;

	public WebElement getNewOrder_Btn() {
		return newOrder_Btn;
	}

	public WebElement getProducts_Btn() {
		return products_Btn;
	}

	public WebElement getHome_Btn() {
		return home_Btn;
	}
	

}
