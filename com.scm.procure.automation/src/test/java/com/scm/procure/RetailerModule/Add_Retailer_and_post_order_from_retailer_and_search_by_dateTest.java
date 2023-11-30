package com.scm.procure.RetailerModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.scm.procure.GenericUtils.ExcelUtils;
import com.scm.procure.GenericUtils.FileUtils;
import com.scm.procure.GenericUtils.NonBaseClass;
import com.scm.procure.GenericUtils.WebDriverUtils;
import com.scm.procure.pom.AddRetailerPage;
import com.scm.procure.pom.AdminHomePage;
import com.scm.procure.pom.LoginPage;
import com.scm.procure.pom.OrderItemPage;
import com.scm.procure.pom.RetailerHomePage;

public class Add_Retailer_and_post_order_from_retailer_and_search_by_dateTest extends NonBaseClass {
	
	@Test
	public  void AddRetailerAndPostOrderFromRetailerAndSearchByDateTest() throws IOException, InterruptedException {

		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();

		String url = fLib.readDataFromPropertyFile("url");
		String adminUn = fLib.readDataFromPropertyFile("username");
		String adminPwd = fLib.readDataFromPropertyFile("password");
		String loginType = fLib.readDataFromPropertyFile("adminLoginType");


		driver.get(url);

		LoginPage lp = new LoginPage(driver);
		lp.login(adminUn, adminPwd, loginType);

		AdminHomePage aHome = new AdminHomePage(driver);
		aHome.getAddRetailers_Btn().click();

		AddRetailerPage retailerPage = new AddRetailerPage(driver);
		retailerPage.addRetailer(driver);

		wLib.alertPopupGetText(driver);
		wLib.alertPopUpAccept(driver);
		aHome.getRtailers_Btn().click();

		String retailerUn = eLib.readDataFromExcel("Sheet1", 0, 1);
		String retailerPwd = eLib.readDataFromExcel("Sheet1", 1, 1);
		String actRes = driver.findElement(By.xpath("//td[@id]//td[contains(.,'" + retailerUn + "')]")).getText();
		if (retailerUn.equals(actRes)) {
			System.out.println("retailer validated");
		} else {
			System.out.println("retailer not validated");
		}

		aHome.getLogout_Btn().click();
		String retailerLoginType = fLib.readDataFromPropertyFile("retailerLoginType");
		lp.login(retailerUn, retailerPwd, retailerLoginType);

		RetailerHomePage retailerHomePage = new RetailerHomePage(driver);
		retailerHomePage.getNewOrder_Btn().click();

		OrderItemPage orderItemPage = new OrderItemPage(driver);
		String product = eLib.readDataFromExcel("Sheet1", 1, 5);
		String qty = eLib.readDataFromExcel("Sheet1", 1, 6);
		orderItemPage.newOrder(driver, product, qty);

	}
}
