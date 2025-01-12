package com.ui.pages;

import static com.constants.Env.DEV;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSOnUtility;

public final class HomePage extends BrowserUtility {
	
	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");
	
	public HomePage(Browser browser,boolean isHeadless) {
		super(browser,isHeadless);
//		goToWebsite(PropertyUtil.ReadProperty(QA,"URL"));
		goToWebsite(JSOnUtility.readJson(DEV).getURL());
	}
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		goToWebsite(JSOnUtility.readJson(DEV).getURL());
	}
	
	public LoginPage goToLoginPage()
	{
		ClickOnElement(SIGN_IN_LOCATOR);
		LoginPage login=new LoginPage(getDriver());
		return login;
	}

}
