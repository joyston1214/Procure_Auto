package com.scm.procure.GenericUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.scm.procure.pom.AdminHomePage;
import com.scm.procure.pom.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;

	public DataBaseUtils dLib = new DataBaseUtils();
	public WebDriverUtils wLib = new WebDriverUtils();
	public FileUtils fLib = new FileUtils();
	public JavaUtils jLib = new JavaUtils();
	public ExcelUtils eLib = new ExcelUtils();

	@BeforeSuite(alwaysRun = true)
	public void BS() throws SQLException {
		//dLib.connectDB();
		System.out.println("connected to data base");

	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
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

	@BeforeMethod(alwaysRun = true)
	public void BM() throws IOException {

		String url = fLib.readDataFromPropertyFile("url");
		String un = fLib.readDataFromPropertyFile("username");
		String pwd = fLib.readDataFromPropertyFile("password");
		String lt = fLib.readDataFromPropertyFile("adminLoginType");

		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pwd, lt);
		System.out.println("loged into the application");

	}

	@AfterMethod(alwaysRun = true)
	public void AM() {
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		adminHomePage.getLogout_Btn().click();
		System.out.println("loged out of application");
	}

	@AfterClass(alwaysRun = true)
	public void AC() {

		driver.quit();
		System.out.println("browser closed");
	}

	@AfterSuite(alwaysRun = true)
	public void AS() throws SQLException {
		//dLib.disconnect();
		System.out.println("Data base disconnected");

	}

}
