package com.scm.procure.AdminModule;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.scm.procure.GenericUtils.BaseClass;
import com.scm.procure.GenericUtils.ExcelUtils;
import com.scm.procure.GenericUtils.WebDriverUtils;
import com.scm.procure.pom.AddRetailerPage;
import com.scm.procure.pom.AdminHomePage;
import com.scm.procure.pom.ViewRetailerPage;
@Listeners(com.scm.procure.GenericUtils.ListenerImp.class)
public class Add_Retailer_with_mandatory_fieldsTest extends BaseClass {

	@Test()
	public void AddRetailerwithmandatoryfieldsTest() throws IOException, InterruptedException {

		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();

		AdminHomePage aHome = new AdminHomePage(driver);
		aHome.getAddRetailers_Btn().click();

		Assert.fail();
		AddRetailerPage retailerPage = new AddRetailerPage(driver);
		retailerPage.addRetailer(driver);
		

		wLib.alertPopupGetText(driver);
		wLib.alertPopUpAccept(driver);
		aHome.getRtailers_Btn().click();

		String exp = eLib.readDataFromExcel("Sheet1", 0, 1);

		ViewRetailerPage viewRetailerPage = new ViewRetailerPage(driver);

		viewRetailerPage.newAddedRetailerValidation(driver, exp);

	}
	
	@Test
	public void ex() {
		System.out.println("sample");
	}

}
