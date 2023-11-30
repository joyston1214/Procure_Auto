package com.scm.procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText =   "Add Retailers")
	private WebElement addRetailers_Btn;
	
	@FindBy(linkText = "Add Manufacturer")
	private WebElement addManufacturer_Btn;

	@FindBy(linkText = "Retailers")
	private WebElement retailers_Btn;
	
	@FindBy(linkText = "Manufacturers")
	private WebElement manufacturers_Btn;
	
	@FindBy(linkText = "Invoice")
	private WebElement invoice_Btn;
	
	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logout_Btn;

	public WebElement getLogout_Btn() {
		return logout_Btn;
	}

	public WebElement getAddRetailers_Btn() {
		return addRetailers_Btn;
	}

	public WebElement getAddManufacturer_Btn() {
		return addManufacturer_Btn;
	}

	public WebElement getRtailers_Btn() {
		return retailers_Btn;
	}

	public WebElement getManufacturers_Btn() {
		return manufacturers_Btn;
	}

	public WebElement getInvoice_Btn() {
		return invoice_Btn;
	}
	
	
	
	
}
