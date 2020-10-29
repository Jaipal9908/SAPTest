package com.SAP.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Dimebox.ObjectRepository.HomePage;
import com.Dimebox.ObjectRepository.LoginPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.genericLib.BaseClass;

import config.PropertiesFile;

public class SapSignupTest extends BaseClass{
	
	   
//		WebDriver driver;

	@Test
	public void signUptest() {
		
		logger = extent.createTest("SignUp test");
		driver.get("https://cai.tools.sap/");	
		//div[contains(text(),"OK")]
		logger.log(Status.INFO, MarkupHelper.createCodeBlock("Launch the browser and navigate to home page"));

		driver.findElement(By.xpath("//div[contains(text(),'OK')]")).click();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.navigateToSignUpPage();
		logger.log(Status.INFO, MarkupHelper.createCodeBlock("Click on Signup button"));
		driver.switchTo().frame(driver.findElement(By.id("IDS_UI_Window")));

		LoginPage loginPage =new LoginPage(driver);
		loginPage.PerformSignup(driver);
		logger.log(Status.INFO, MarkupHelper.createCodeBlock("Entered the details and click on Submit button"));
		driver.close();
		logger.log(Status.INFO, MarkupHelper.createCodeBlock("close the Browser"));

	}

}
