package com.scm.procure.pom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.procure.GenericUtils.ExcelUtils;
import com.scm.procure.GenericUtils.WebDriverUtils;

public class AddRetailerPage extends WebDriverUtils{
	

	public AddRetailerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "txtRetailerUname")
	private WebElement retailerUnameTF;

	@FindBy(name = "txtRetailerPassword")
	private WebElement retailerPasswordTF;
	
	@FindBy(name = "txtRetailerPhone")
	private WebElement retailerPhoneTF;
	
	@FindBy(name = "txtRetailerEmail")
	private WebElement retailerEmailTF;
	
	@FindBy(name = "txtRetailerAddress")
	private WebElement retailerAddressTF;
	
	@FindBy(name = "cmbAreaCode")
	private WebElement areaCodeDD;
	
	@FindBy(xpath = "//input[@value='Add Retailer']")
	private WebElement addRetailer_Btn;

	public WebElement getRetailerUnameTF() {
		return retailerUnameTF;
	}

	public WebElement getRetailerPasswordTF() {
		return retailerPasswordTF;
	}

	public WebElement getRetailerPhoneTF() {
		return retailerPhoneTF;
	}

	public WebElement getRetailerEmailTF() {
		return retailerEmailTF;
	}

	public WebElement getRetailerAddressTF() {
		return retailerAddressTF;
	}

	public WebElement getAreaCodeDD() {
		return areaCodeDD;
	}

	public WebElement getAddRetailer_Btn() {
		return addRetailer_Btn;
	}

	public void addRetailer(String un,String pwd,String areaCode,String phone,String email,String address) {
		retailerUnameTF.sendKeys(un);
		retailerPasswordTF.sendKeys(pwd);
		dropdown(areaCodeDD, areaCode);
		retailerPhoneTF.sendKeys(phone);
		retailerEmailTF.sendKeys(email);
		retailerAddressTF.sendKeys(address);
		addRetailer_Btn.click();
	}
	
	public void addRetailer(WebDriver driver) throws EncryptedDocumentException, IOException {
		ExcelUtils eLib = new ExcelUtils();
		HashMap<String, String> map = eLib.readMultipleDataKeyAndValue("Sheet1", driver);
		for (Entry<String, String> set : map.entrySet()) {
			WebElement ele = driver.findElement(By.name(set.getKey()));
			ele.clear();
			ele.sendKeys(set.getValue());
		}
		String areaCodeValue =eLib.readDataFromExcel("Sheet1", 1, 3);
		dropdown(areaCodeDD, areaCodeValue);
		addRetailer_Btn.click();
	}

	
	
}
