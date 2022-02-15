package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {
	WebDriver driver;

	@FindBy(xpath="//header/section[1]/div[1]/h4[1]/a[1]/span[1]")
	WebElement nameonMessageWindow;
	
	@FindBy(xpath = "//body[1]/div[6]/aside[1]/div[2]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/p[1]")
	WebElement messagecontent;
	
	@FindBy(xpath = "//p[contains(text(), 'Hello')]")
	List<WebElement> messageList;
	
	
	public MessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String profileNameonMessageWindow() {
		String profileName="";
		try {
			if(nameonMessageWindow!=null && nameonMessageWindow.isDisplayed()) 
				profileName = nameonMessageWindow.getText().split(" ")[0];		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profileName;
	}
	
	public void typeMessage(String message) {
		if(messagecontent!=null)
			messagecontent.sendKeys(message + "\n");
	}
	
	public String getLastMessageContent() {
		String lastMessage="";
		if(messageList!=null && messageList.size()>0)
			lastMessage=messageList.get(messageList.size()-1).getText();
		return lastMessage;
	}

}
