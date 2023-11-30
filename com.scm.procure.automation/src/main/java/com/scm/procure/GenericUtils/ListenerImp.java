package com.scm.procure.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp implements ITestListener{
	
	
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"---TestScript execution starts from here---");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"===PASSED");
		Reporter.log(methodName+"---TestScript executed successfully---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String ss = methodName+" "+new JavaUtils().dateFormat();
		
		try {
			WebDriverUtils.getScreenshot(NonBaseClass.sdriver, ss);
			/*
			 * TakesScreenshot t=(TakesScreenshot) BaseClass.sdriver; File src =
			 * t.getScreenshotAs(OutputType.FILE); String path =
			 * ".\\ScreeenShot\\"+ss+".png"; File dest=new File(path);
			 * FileUtils.copyFile(src, dest);
			 */
		} catch (IOException e) {
			
		}
		test.addScreenCaptureFromPath(ss);
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, methodName+"===Failed");
		Reporter.log(methodName+"===TestScript execution failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"===Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"====TestScript execution skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./Extentreport/report.html");
		htmlreport.config().setDocumentTitle("Procure");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Admin Module");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("URL", "http://rmgtestingserver/domain/Supply_Chain_Management/");
		report.setSystemInfo("Reporter name", "Joyston");
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
	report.flush();
	}

	
}
