package com.scm.procure.ManufacturerModule;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.procure.GenericUtils.ExcelUtils;
import com.scm.procure.GenericUtils.FileUtils;
import com.scm.procure.GenericUtils.NonBaseClass;
import com.scm.procure.GenericUtils.WebDriverUtils;
import com.scm.procure.pom.AddProductPage;
import com.scm.procure.pom.LoginPage;
import com.scm.procure.pom.ManufacturerHomePage;


@Listeners(com.scm.procure.GenericUtils.ListenerImp.class)
public class Manufacturer_Add_products_by_KG_and_enable_stockTest extends NonBaseClass{
	
	@Test
	public void ManufacturerAddProductsByKGAndEnableStockTest() throws IOException, InterruptedException {

		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		
		
		String url = fLib.readDataFromPropertyFile("url");
		String manufacturerUn = fLib.readDataFromPropertyFile("musername");
		String manufacturerPwd = fLib.readDataFromPropertyFile("mpassword");
		String loginType = fLib.readDataFromPropertyFile("manufacturerLoginType");
		
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.login(manufacturerUn, manufacturerPwd, loginType);

		ManufacturerHomePage mHomePage = new ManufacturerHomePage(driver);
		mHomePage.getAddProduct_Btn().click();
		Assert.fail();

		AddProductPage addProductPage = new AddProductPage(driver); 
		HashMap<String, String> productDetails = eLib.readMultipleDataKeyAndValue("productDetails", driver);
		String unit = eLib.readDataFromExcel("productDetails", 1, 3);
		String category = eLib.readDataFromExcel("productDetails", 1, 4);
		String stockManagement = eLib.readDataFromExcel("productDetails", 1, 5);
		addProductPage.addProduct(driver, productDetails, category, unit, stockManagement);

		wLib.alertPopupGetText(driver);
		wLib.alertPopUpAccept(driver);
		
		mHomePage.getProducts_Btn().click();
		
		String price = eLib.readDataFromExcel("productDetails", 1, 1);
		String product = eLib.readDataFromExcel("productDetails", 0, 1);
		String actRes = driver
				.findElement(By.xpath(
						"//td[contains(.,'" + price + "')]/preceding-sibling::td[contains(.,'" + product + "')]"))
				.getText();
		if (actRes.equals(product)) {
			System.out.println("product is validated, TC Passed");
		} else {
			System.out.println("product is validated, Tc Fail");
		}
		
	}

}
