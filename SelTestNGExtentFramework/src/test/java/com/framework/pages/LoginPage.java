package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.utility.BrowserFactory;

public class LoginPage {

	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Sign Up") WebElement signUp;
	@FindBy(name="email") WebElement email;
	@FindBy (name="password") WebElement password;
	@FindBy (xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]") WebElement loginButton;
	
	public void loginToApp(String appUsername , String appPassword) throws InterruptedException {
		int i=0;
		signUp.click();
		BrowserFactory.switchTab(driver,"Cogmento CRM");
		Thread.sleep(9000);
		while (!email.isDisplayed() && i<10000){
			Thread.sleep(90);
			i++;
		}
		System.out.println("Wait time was "+ 50*i);
		email.sendKeys(appUsername);
		password.sendKeys(appPassword);
		loginButton.click();
		
	}
	
	
	
}
