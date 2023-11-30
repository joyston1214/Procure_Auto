package com.scm.procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.procure.GenericUtils.WebDriverUtils;

public class LoginPage extends WebDriverUtils {

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(name="txtUsername")
	private WebElement usernameTF;
	
	@FindBy(name="txtPassword")
	private WebElement passwordTF;
	
	@FindBy(className ="submit_button")
	private WebElement loginBtn;
	
	@FindBy(name="login_type")
	private WebElement loginTypeDD;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getLoginTypeDD() {
		return loginTypeDD;
	}
	
	public void login(String un, String pwd, String loginType) {
		usernameTF.sendKeys(un);
		passwordTF.sendKeys(pwd);
		dropdown(loginTypeDD, loginType);
		loginBtn.click();
	}
	
	
	

}
