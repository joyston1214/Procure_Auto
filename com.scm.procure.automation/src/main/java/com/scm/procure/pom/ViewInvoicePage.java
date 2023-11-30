package com.scm.procure.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.procure.GenericUtils.WebDriverUtils;

public class ViewInvoicePage extends WebDriverUtils{
	

	public ViewInvoicePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='cmbFilter']")
	private WebElement searchByDD;
	
	@FindBy(name = "txtInvoiceId")
	private WebElement invoiceIdTF;
	
	@FindBy(name = "txtOrderId")
	private WebElement orderIDTF;
	
	@FindBy(name = "txtDate")
	private WebElement dateTF;
	
	@FindBy(name = "cmbRetailer")
	private WebElement selectRetailerDD;

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement search_Btn;

	public WebElement getSearchByDD() {
		return searchByDD;
	}

	public WebElement getInvoiceIdTF() {
		return invoiceIdTF;
	}

	public WebElement getOrderIDTF() {
		return orderIDTF;
	}

	public WebElement getDateTF() {
		return dateTF;
	}

	public WebElement getSelectRetailerDD() {
		return selectRetailerDD;
	}

	public WebElement getSearch_Btn() {
		return search_Btn;
	}
	
	public void searchInvoiceByIvoiceID(String invoiceId) {
		dropdownByValue(searchByDD, "invoiceId");
		
		invoiceIdTF.sendKeys(invoiceId);
		search_Btn.click();
	}
	
	public void searchInvoiceByOrderID(String orderID) {
		dropdown(searchByDD, "invoiceId");
		orderIDTF.sendKeys(orderID);
		search_Btn.click();
	}
	
	public void searchInvoiceByRetailer(String retailer) {
		dropdown(searchByDD, "invoiceId");
		dropdown(selectRetailerDD, retailer);
		search_Btn.click();
	}
	public void searchInvoiceByInvoiceIdValidation(WebDriver driver, String invID) {
		String actualRes = driver.findElement(By.xpath("//th[contains(.,'Invoice ID')]/../..//td[1]")).getText();
		assertEquals(actualRes, invID,"Searched invoice is not displayed");
		System.out.println("Searched invoice is displayed");

	}
	
	

}
