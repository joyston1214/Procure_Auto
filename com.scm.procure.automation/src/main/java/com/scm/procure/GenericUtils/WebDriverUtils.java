package com.scm.procure.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void implicitlyWait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public void waitUntilElementToBeVisible(WebDriver driver, WebElement element, int sec) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element ,int sec) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void dropdown(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void dropdown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void dropdownByValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	
	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().perform();
	}
	public void scrollToElement(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.scrollToElement(ele).perform();
	}
	
	public void doubleClick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}
	
	public void doubleClick(WebDriver driver , WebElement target) {
		Actions a = new Actions(driver);
		a.doubleClick(target).perform();
	}
	
	public void rightClick(WebDriver driver ) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}
	
	public void rightClick(WebDriver driver , WebElement target) {
		Actions a = new Actions(driver);
		a.contextClick(target).perform();
	}
	
	public void keyPressEnter(WebDriver driver)  {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	public void keyPressEnterRobot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);	
	}
	
	public void keyReleaseEnterRobot() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);	
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
		
	}
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
		
	}
	public void switchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
		
	}
	
	public void switchToWindow(WebDriver driver, String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
	
	public void alertPopupGetText(WebDriver driver) {
		String value = driver.switchTo().alert().getText();
		System.out.println(value);
	}
	public void alertPopUpAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertPopUpDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0.500)", "");
	}
	
	public void scrollAction(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		int y = ele.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")");
	}
	
	public static void getScreenshot(WebDriver driver,String mname) throws IOException {
	
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		String path = ".\\ScreeenShot\\"+mname+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
	
		
	}
	
	

}
