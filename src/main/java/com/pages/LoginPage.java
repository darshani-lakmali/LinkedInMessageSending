package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	//web elements
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement signInButton ;
			
	@FindBy(xpath = "//span[contains(text(),'Who viewed your profile')]")
	WebElement LeftPaneText;
	
	//constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	//page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public void Login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
	}
	
	public HomePage ClickonLoginbutton() {
		signInButton.click();
		return new HomePage(driver);
	}
	
	public HomePage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInButton.click();
		return new HomePage(driver);
	}
	
	public String getLeftPaneTextOfHomePage() {
		return LeftPaneText.getText();
	}
}
