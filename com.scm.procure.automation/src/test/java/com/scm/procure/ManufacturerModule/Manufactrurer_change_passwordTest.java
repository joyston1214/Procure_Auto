package com.scm.procure.ManufacturerModule;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.scm.procure.GenericUtils.ExcelUtils;
import com.scm.procure.GenericUtils.FileUtils;
import com.scm.procure.GenericUtils.WebDriverUtils;
import com.scm.procure.pom.AdminHomePage;
import com.scm.procure.pom.LoginPage;
import com.scm.procure.pom.ManufactureEditProfilePage;
import com.scm.procure.pom.ManufacturerHomePage;

public class Manufactrurer_change_passwordTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		
		
		String url = fLib.readDataFromPropertyFile("url");
		String manufacturerUn = fLib.readDataFromPropertyFile("musername");
		String manufacturerPwd = fLib.readDataFromPropertyFile("mpassword");
		String loginType = fLib.readDataFromPropertyFile("manufacturerLoginType");
		
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.implicitlyWait(driver, 10);
		Thread.sleep(10000);
		driver.get(url);
		

		LoginPage lp = new LoginPage(driver);
		lp.login(manufacturerUn, manufacturerPwd, loginType);
		
		ManufacturerHomePage mHomePage = new ManufacturerHomePage(driver);
		mHomePage.getEditProfile_Btn().click();
		
		ManufactureEditProfilePage editProfilePage = new ManufactureEditProfilePage(driver);
		HashMap<String, String> newPwd = eLib.readMultipleDataKeyAndValue("mpwd", driver);
		editProfilePage.changePassword(driver, newPwd);		
		
		wLib.alertPopupGetText(driver);
		wLib.alertPopUpAccept(driver);
		
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		adminHomePage.getLogout_Btn().click();
		String newPwd1 = eLib.readDataFromExcel("mpwd", 1, 1);
		

		try {
			lp.login(manufacturerUn, newPwd1, loginType);
			System.out.println("TC validation Passed");
		} catch (Exception e) {
			System.out.println("TC validation Failed");	
		}
	}

}
