package com.scm.procure.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.procure.GenericUtils.WebDriverUtils;

public class ViewManufacturerPage {
	
	WebDriverUtils wLib=new WebDriverUtils();

	public ViewManufacturerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement delete_Btn;

	public WebElement getManufacturerNameTF() {
		return delete_Btn;
	}
	
	public void editManufacturer(WebDriver driver, String oldUn) {
		
		driver.findElement(By.xpath("(//td[contains(.,'"+oldUn+"')]/..)[2]//img")).click();
	}
	
	public void editIcon(WebDriver driver, String oUn) {
		WebElement editIcon = driver.findElement(By.xpath("(//td[contains(.,'" + oUn + "')]/..)[2]//img"));
		
		wLib.scrollAction(driver, editIcon);
		editIcon.click();
	}
	
	public void editManufacturerValidation(WebDriver driver,String[]s ) {
		
		for (int i = 0; i < s.length-1; i++) {
			String actRes = driver.findElement(By.xpath("(//td[contains(.,'"+s[3]+"')])[2]/preceding-sibling::td[contains(.,'"+s[i]+"')]")).getText();
			assertEquals(actRes, s[i]);
		}
		
		String actUn = driver.findElement(By.xpath("(//td[contains(.,'"+s[3]+"')])[2]")).getText();
		assertEquals(actUn, s[3]);
		System.out.println("retailer validated");
		
		

	}

}
