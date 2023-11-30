package com.scm.procure.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.procure.GenericUtils.WebDriverUtils;

public class AddManufacturerPage extends WebDriverUtils {
	
	public AddManufacturerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "txtManufacturerName")
	private WebElement manufacturerNameTF;

	@FindBy(name = "txtManufacturerEmail")
	private WebElement manufacturerEmailTF;

	@FindBy(name = "txtManufacturerPhone")
	private WebElement manufacturerPhoneTF;

	@FindBy(name = "txtManufacturerUname")
	private WebElement manufacturerUnamTF;

	@FindBy(name = "txtManufacturerPassword")
	private WebElement manufacturerPasswordTF;

	@FindBy(xpath = "//input[@value='Add Manufacturer']")
	private WebElement addManufacturer_Btn;

	public WebElement getManufacturerNameTF() {
		return manufacturerNameTF;
	}

	public WebElement getManufacturerEmailTF() {
		return manufacturerEmailTF;
	}

	public WebElement getManufacturerPhoneTF() {
		return manufacturerPhoneTF;
	}

	public WebElement getManufacturerUnamTF() {
		return manufacturerUnamTF;
	}

	public WebElement getManufacturerPasswordTF() {
		return manufacturerPasswordTF;
	}

	public WebElement getAddManufacturer_Btn() {
		return addManufacturer_Btn;
	}

	public void addManufacturer(String name, String phone, String email, String un, String pwd) {
		manufacturerNameTF.sendKeys(name);
		manufacturerPhoneTF.sendKeys(phone);
		manufacturerEmailTF.sendKeys(email);
		manufacturerUnamTF.sendKeys(un);
		manufacturerPasswordTF.sendKeys(pwd);
		addManufacturer_Btn.click();
	}
	
	public void addManufacturer(WebDriver driver,HashMap<String,String> map) {
		for (Entry<String, String> set : map.entrySet()) {
			WebElement ele = driver.findElement(By.name(set.getKey()));
			ele.clear();
			ele.sendKeys(set.getValue());
		}
		addManufacturer_Btn.click();
	}

}
