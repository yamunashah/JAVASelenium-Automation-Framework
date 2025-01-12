package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase {
	protected HomePage homepage;
	private boolean isLambdaTest = true;
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description="Before Test load the homepage")
	public void setup(@Optional("chrome") String browser,@Optional("false") boolean isLambdaTest,@Optional("true") boolean isHeadless, ITestResult result)
	{
		this.isLambdaTest = isLambdaTest;
		WebDriver Lambdadriver;
		if(isLambdaTest)
		{
			Lambdadriver = LambdaTestUtility.InitializeLambdaSetup(browser, result.getMethod().getMethodName());
			homepage = new HomePage(Lambdadriver);
		}
		else
		{
			homepage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
			homepage.maximizeWindow();
		}
	}
	
	public BrowserUtility getInstance()
	{
		return homepage;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		if(isLambdaTest)
		{
			LambdaTestUtility.quitDriver();
		}
		else
		{
			homepage.closeBrowserWindow();
		}
	}
	
}
