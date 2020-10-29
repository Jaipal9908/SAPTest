package com.Dimebox.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath="//div[contains(text(),'Sign up')]")
    private WebElement signupButton;
	@FindBy(linkText="Transactions")
	private WebElement transactionlink;
	@FindBy(linkText="Transactions tagged")
	private WebElement Transactionstagged;
	
	
//	public void navigateToSignUpPage() {
//
//	}


	public void navigateToSignUpPage() {
		signupButton.click();
		
	}
	

}
