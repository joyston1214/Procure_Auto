package com.scm.procure.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditManufacturerPage {

	public EditManufacturerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "txtManufacturerName")
	private WebElement editManufacturerNameTF;
	
	@FindBy(name = "txtManufacturerEmail")
	private WebElement editManufacturerEmailTF;

	@FindBy(name = "txtManufacturerPhone")
	private WebElement editManufacturerPhoneTF;
	
	@FindBy(name = "txtManufacturerUname")
	private WebElement editManufacturerUnTF;
	
	@FindBy(xpath = "//input[@value='Update Manufacturer']")
	private WebElement updateManufacturer_Btn;

	public WebElement getEditManufacturerNameTF() {
		return editManufacturerNameTF;
	}

	public WebElement getEditManufacturerEmailTF() {
		return editManufacturerEmailTF;
	}

	public WebElement getEditManufacturerPhoneTF() {
		return editManufacturerPhoneTF;
	}

	public WebElement getEditManufacturerUnTF() {
		return editManufacturerUnTF;
	}

	public WebElement getUpdateManufacturer_Btn() {
		return updateManufacturer_Btn;
	}
	
	public void updateManufacturerDetails(WebDriver driver,HashMap<String,String> map) {
		
		for (Entry<String, String> set : map.entrySet()) {
			WebElement ele = driver.findElement(By.name(set.getKey()));
			ele.clear();
			ele.sendKeys(set.getValue());
		}
		updateManufacturer_Btn.click();
	}
	
}
