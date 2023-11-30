package com.scm.procure.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufactureEditProfilePage {
	

	public ManufactureEditProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "txtManufacturerName")
	private WebElement manufacturerNameTF;
	
	@FindBy(name = "txtManufacturerEmail")
	private WebElement manufacturerEmailTF;

	@FindBy(name = "txtManufacturerPhone")
	private WebElement manufacturerPhoneTF;
	
	@FindBy(xpath = "//input[@value='Change Password']")
	private WebElement changePassword_Btn;
	
	@FindBy(xpath = "//input[@value='Update Profile']")
	private WebElement updateProfile_Btn;
	
	@FindBy(name = "txtOldPassword")
	private WebElement oldOasswordTF;
	
	@FindBy(name = "txtNewPassword")
	private WebElement newPasswordTF;

	@FindBy(name = "txtConfirmPassword")
	private WebElement confirmPasswordTF;

	public WebElement getManufacturerNameTF() {
		return manufacturerNameTF;
	}

	public WebElement getManufacturerEmailTF() {
		return manufacturerEmailTF;
	}

	public WebElement getManufacturerPhoneTF() {
		return manufacturerPhoneTF;
	}

	public WebElement getChangePassword_Btn() {
		return changePassword_Btn;
	}

	public WebElement getUpdateProfile_Btn() {
		return updateProfile_Btn;
	}

	public WebElement getOldOasswordTF() {
		return oldOasswordTF;
	}

	public WebElement getNewPasswordTF() {
		return newPasswordTF;
	}

	public WebElement getConfirmPasswordTF() {
		return confirmPasswordTF;
	}
	
	public void changePassword(WebDriver driver,HashMap<String,String> map) {
		changePassword_Btn.click();
		for (Entry<String, String> set : map.entrySet()) {
			WebElement ele = driver.findElement(By.name(set.getKey()));
			ele.clear();
			ele.sendKeys(set.getValue());
		}
		changePassword_Btn.click();
	}

}
