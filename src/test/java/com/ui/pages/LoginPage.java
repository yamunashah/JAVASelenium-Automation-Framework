package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	private static final By EMAIL_ADDRESS_TEXT_BOX_LOCATOR = By.xpath("//input[@id=\"email\"]");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@id=\"passwd\"]");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@id=\"SubmitLogin\"]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MyAccountPage doLoginWith(String emailAddress, String password)
	{
		enterText(EMAIL_ADDRESS_TEXT_BOX_LOCATOR,emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
		ClickOnElement(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myaccountpage= new MyAccountPage(getDriver());
		return myaccountpage;
	}

}
