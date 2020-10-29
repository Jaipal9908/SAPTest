package com.Dimebox.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericLib.ExcelLib;

import config.PropertiesFile;

public class LoginPage extends BasePage{
	
	String shName = PropertiesFile.readPropertiesFile("shName");

	String fName = ExcelLib.getExceldata(shName, 0, 1);
	String LName = ExcelLib.getExceldata(shName, 0, 2);
	String email = ExcelLib.getExceldata(shName, 0, 3);
	String pass = ExcelLib.getExceldata(shName, 0, 4);
	String rePass = ExcelLib.getExceldata(shName, 0, 5);

	
			
//	declaration
		@FindBy(id="firstName")
		private WebElement firstName;
		@FindBy(id="lastName")
		private WebElement lastName;
		@FindBy(id="mail")
		private WebElement mail;
		@FindBy(id="newPasswordInput")
		private WebElement password;
		@FindBy(id="retypeNewPasswordInput")
		private WebElement reEnterPassword;
		@FindBy(xpath = "//input[@class='js-remove-error-on-change' and @id='pdAccept']")
		private WebElement checkbox1;
		@FindBy(id="touAccept")
		private WebElement checkbox2;

		@FindBy(id="sapStoreRegisterFormSubmit")
		private WebElement submit;
		
		
		
		
//		Initialisation
		
		public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		}
		
		
//		Actions
		
		
		
		public void PerformSignup(WebDriver driver ) {
			
		
			enterText(driver, firstName, fName);
			enterText(driver, lastName, LName);
			enterText(driver, mail, email);
			enterText(driver, password, pass);
			enterText(driver, reEnterPassword, rePass);
			checkbox1.click();
			checkbox2.click();
			click(driver, submit);


			
//			firstName.sendKeys("jaipal");
//			lastName.sendKeys("K");
//			mail.sendKeys("kjaipal.ace1@gmail.com");
//			password.sendKeys("Jaipal@123");
//			reEnterPassword.sendKeys("Jaipal@123");
//			submit.click();
			
		}
		
	

}
