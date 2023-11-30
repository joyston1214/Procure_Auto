package com.scm.procure.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewRetailerPage {

	public ViewRetailerPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement delete_Btn;

	public WebElement getDelete_Btn() {
		return delete_Btn;
	}

	public void newAddedRetailerValidation(WebDriver driver, String exp) {
		String actRes = driver.findElement(By.xpath("//td[@id]//td[contains(.,'" + exp + "')]")).getText();
		assertEquals(actRes, exp);
		System.out.println("retailer validated");
		
	

	}

}
