package com.scm.procure.AdminModule;

import java.io.IOException;

import org.testng.annotations.Test;

import com.scm.procure.GenericUtils.BaseClass;
import com.scm.procure.pom.AdminHomePage;
import com.scm.procure.pom.ViewInvoicePage;

public class Search_the_invoice_by_Invoice_idTest extends BaseClass{
	
	@Test
	public void SearchtheinvoicebyInvoiceidTest() throws IOException, InterruptedException {


		AdminHomePage aHome = new AdminHomePage(driver);
		aHome.getInvoice_Btn().click();

		ViewInvoicePage viewInvoicePage = new ViewInvoicePage(driver);
		String invID = eLib.readDataFromExcel("inv", 1, 1);
		viewInvoicePage.searchInvoiceByIvoiceID(invID);
		
		viewInvoicePage.searchInvoiceByInvoiceIdValidation(driver, invID);
	

	}

}
