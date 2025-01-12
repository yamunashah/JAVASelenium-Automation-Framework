package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import  com.constants.Browser;

public abstract class BrowserUtility {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(Browser browser)
	{
		if(browser == Browser.CHROME)
		{
			driver.set(new ChromeDriver());
		}
		
		else if(browser == Browser.EDGE)
		{
				driver.set(new EdgeDriver());
		}
		else if(browser == Browser.FIREFOX)
		{
			driver.set(new FirefoxDriver());
		}
	}
	
	public BrowserUtility(Browser browser,boolean isHeadless)
	{
		if(browser == Browser.CHROME)
		{
			if(isHeadless)
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); //Ensure that browser opens in headless mode
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			}
			else
			{
				driver.set(new ChromeDriver());
			}
		}
		
		else if(browser == Browser.EDGE)
		{
			if(isHeadless)
			{
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			}
			else
			{
				driver.set(new EdgeDriver());
			}
		}
		else if(browser == Browser.FIREFOX)
		{
			if(isHeadless)
			{
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			}
			else
			{
				driver.set(new FirefoxDriver());
			}
		}
	}
	
	public void goToWebsite(String url)
	{
		driver.get().get(url);
	}

	public void maximizeWindow()
	{
		driver.get().manage().window().maximize();
	}
	
	public void closeBrowserWindow()
	{
		driver.get().quit();
	}
	
	public void ClickOnElement(By locator)
	{
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator,String texttoEnter)
	{
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(texttoEnter);
	}
	
	public String GetVisibleText(By locator)
	{
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	public String takeScreenShot(String name)
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
		String datetime=dateformat.format(date);
		String path = "./screenshots/" + name + "-" + datetime + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
		
	}
}
