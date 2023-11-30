package com.scm.procure.AdminModule;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.scm.procure.GenericUtils.BaseClass;
import com.scm.procure.pom.AdminHomePage;
import com.scm.procure.pom.EditManufacturerPage;
import com.scm.procure.pom.ViewManufacturerPage;

public class Edit_Manfacturer_From_AdminTest extends BaseClass {

	@Test
	public void EditManfacturerFromAdminTest() throws EncryptedDocumentException, IOException, InterruptedException {

		AdminHomePage aHome = new AdminHomePage(driver);
		aHome.getManufacturers_Btn().click();

		String oUn = eLib.readDataFromExcel("manufacturer", 1, 3);
		ViewManufacturerPage viewManufacturerPage = new ViewManufacturerPage(driver);
		viewManufacturerPage.editIcon(driver, oUn);

		EditManufacturerPage editManufacturerPage = new EditManufacturerPage(driver);
		HashMap<String, String> data = eLib.readMultipleDataKeyAndValue("manufacturer", driver);
		editManufacturerPage.updateManufacturerDetails(driver, data);

		wLib.alertPopupGetText(driver);
		wLib.alertPopUpAccept(driver);

		String[] readMultipleCellData = eLib.readMultipleCellData("manufacturer", 1, driver);

		viewManufacturerPage.editManufacturerValidation(driver, readMultipleCellData);

	}

}
