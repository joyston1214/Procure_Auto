package com.scm.procure.GenericUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class NonBaseClass {
	

	public WebDriver driver;
	public static WebDriver sdriver;

	public DataBaseUtils dLib = new DataBaseUtils();
	public WebDriverUtils wLib = new WebDriverUtils();
	public FileUtils fLib = new FileUtils();
	public JavaUtils jLib = new JavaUtils();
	public ExcelUtils eLib = new ExcelUtils();
	  

	
	@BeforeClass
	public void BC() throws IOException, InterruptedException {
		String BROWSER = fLib.readDataFromPropertyFile("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("enter a valid browser name");
		}
		sdriver=driver;
		Thread.sleep(10000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("browser launched");
	}
	
	

}
