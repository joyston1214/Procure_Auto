package com.scm.procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {
	

	public ManufacturerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText =   "Add Products")
	private WebElement addProduct_Btn;
	
	@FindBy(linkText =   "Products")
	private WebElement products_Btn;
	
	@FindBy(linkText =   "Edit Profile")
	private WebElement editProfile_Btn;

	public WebElement getEditProfile_Btn() {
		return editProfile_Btn;
	}

	public WebElement getAddProduct_Btn() {
		return addProduct_Btn;
	}

	public WebElement getProducts_Btn() {
		return products_Btn;
	}

	

}
