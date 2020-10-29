package com.Dimebox.ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	private JavascriptExecutor js;
	
	public void click(WebDriver driver, WebElement element) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void enterText(WebDriver driver, WebElement element, String text) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];", element, text);
	}

}
