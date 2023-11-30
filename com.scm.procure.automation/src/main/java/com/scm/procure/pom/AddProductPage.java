package com.scm.procure.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.procure.GenericUtils.WebDriverUtils;

public class AddProductPage extends WebDriverUtils {
	

	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "txtProductName")
	private WebElement productNameTF;
	
	@FindBy(name = "txtProductPrice")
	private WebElement productPriceTF;
	
	@FindBy(name = "cmbProductUnit")
	private WebElement selectUnitDD;
	
	@FindBy(name = "cmbProductCategory")
	private WebElement selectCatagoryDD;
	
	@FindBy(xpath = "//input[@value='1']")
	private WebElement enableRadio_Btn;
	
	@FindBy(xpath = "//input[@value='2']")
	private WebElement disableRadio_Btn;
	
	@FindBy(name = "txtProductDescription")
	private WebElement productDescriptionTF;
	
	@FindBy(xpath = "//input[@value='Add Product']")
	private WebElement addProduct_Btn;

	public WebElement getProductNameTF() {
		return productNameTF;
	}

	public WebElement getProductPriceTF() {
		return productPriceTF;
	}

	public WebElement getSelectUnitDD() {
		return selectUnitDD;
	}

	public WebElement getSelectCatagoryDD() {
		return selectCatagoryDD;
	}

	public WebElement getEnableRadio_Btn() {
		return enableRadio_Btn;
	}

	public WebElement getDisableRadio_Btn() {
		return disableRadio_Btn;
	}

	public WebElement getProductDescriptionTF() {
		return productDescriptionTF;
	}

	public WebElement getAddProduct_Btn() {
		return addProduct_Btn;
	}
	
	public void addManufacturer(String productName, String productPrice, String unit, String catagory,String stockManagement, String description) {
		productNameTF.sendKeys(productName);
		productPriceTF.sendKeys(productPrice);
		dropdown(selectUnitDD, unit);
		dropdown(selectCatagoryDD, catagory);
		if (stockManagement.equalsIgnoreCase("Enable")) {
			enableRadio_Btn.click();
		} else {
			disableRadio_Btn.click();
		}
		productDescriptionTF.sendKeys(description);
		addProduct_Btn.click();
	}
	
	public void addProduct(WebDriver driver,HashMap<String,String> map,String catagory,String unit,String stockManagement) {
		for (Entry<String, String> set : map.entrySet()) {
			WebElement ele = driver.findElement(By.name(set.getKey()));
			ele.clear();
			ele.sendKeys(set.getValue());
		}
		dropdown(selectUnitDD, unit);
		dropdown(selectCatagoryDD, catagory);
		if (stockManagement.equalsIgnoreCase("Enable")) {
			enableRadio_Btn.click();
		} else {
			disableRadio_Btn.click();
		}
		addProduct_Btn.click();
	}



}
