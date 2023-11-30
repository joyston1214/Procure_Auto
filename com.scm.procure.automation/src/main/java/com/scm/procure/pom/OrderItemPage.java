package com.scm.procure.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.procure.GenericUtils.WebDriverUtils;

public class OrderItemPage extends WebDriverUtils {
	

	public OrderItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Post Order']")
	private WebElement postOrder_Btn;

	public WebElement getPostOrder_Btn() {
		return postOrder_Btn;
	}
	
	
	public void newOrder(WebDriver driver,String product,String qty) {
		scrollAction(driver, driver.findElement(By.xpath("//td[contains(.,'"+product+"')]/../td/input")));
		driver.findElement(By.xpath("//td[contains(.,'"+product+"')]/../td/input")).sendKeys(qty);
		scrollAction(driver, postOrder_Btn);
		postOrder_Btn.click();
	}
	
	
	

}
