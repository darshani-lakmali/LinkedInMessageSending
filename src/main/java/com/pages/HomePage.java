package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(xpath = "//body[1]/div[6]/header[1]/div[1]/div[1]/div[1]/button[1]/li-icon[1]/svg[1]/path[1]")
	WebElement searchField;

	@FindBy(xpath="//body/div[6]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/section[1]/div[2]/div[3]/div[1]/div[2]/a[1]")
	WebElement messageButton;
	
	@FindBy(xpath="//body[1]/div[5]/header[1]/div[1]/nav[1]/ul[1]/li[6]/div[1]/button[1]")
	WebElement profileIcon;
	
	@FindBy(xpath="//body/div[6]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/section[1]/div[2]/div[3]/div[1]/button[1]/span[1]")
	WebElement connectButton;
	
	@FindBy(xpath="//body[1]/div[5]/header[1]/div[1]/nav[1]/ul[1]/li[6]/div[1]/div[1]")
	WebElement signoutButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public MessagePage openMessageWindow() {
		try {
			 Thread.sleep(3000);
				messageButton.click();
		} catch (Exception e) {
			System.out.println("some exception occurred while waiting for the Message button....");
			e.printStackTrace();
		}
		return new MessagePage(driver);
		
	}
	
	public boolean isConnectButtonPresent() {
		boolean buttonPresent=false;
		try {
			Thread.sleep(3000);
			buttonPresent = connectButton.isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception occurred while waiting for the Connect button....");
			e.printStackTrace();
		}
		return buttonPresent;
		
	}
	
	public void logout() {
		try {
			Thread.sleep(6000);
			profileIcon.click();
			Thread.sleep(2000);
			signoutButton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  		
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
