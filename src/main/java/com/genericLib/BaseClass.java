package com.genericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.PropertiesFile;

public class BaseClass {

	public static String path = PropertiesFile.readPropertiesFile("Excelpath");

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;

	public ExtentTest logger;
	public WebDriver driver;
	public static String reportFullPath = "\\test-output\\" + "\\SAPtest_Automation_Report.html\\";

	

	@BeforeTest
	public void setup() throws IOException {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + reportFullPath);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "test");
		extent.setSystemInfo("User Name", "Auto Test");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\src\\main\\java\\config\\extent-config.xml");

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Exception", ExtentColor.ORANGE));

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));

		}
	}

	@AfterTest
	public void endReport() {
		extent.flush();

	}
	
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", PropertiesFile.readPropertiesFile("driverPath"));
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	


}
