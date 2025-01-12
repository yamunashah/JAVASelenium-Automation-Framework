package com.ui.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listerners.TestListerner.class)
public class LoginTest extends TestBase{

	
	// @Test(description="Verify that valid creds can be successfully login",groups= {"e2e"},dataProviderClass = com.ui.testdataprovider.TestDataProvider.class,dataProvider="TestUserData")
	// public void TestLogin(User user) {
		
	// 	String username=homepage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).GetUserName();
	// 	System.out.println(username);
	// 	AssertJUnit.assertEquals(username, "Yamuna shah");

	// }
	
	@Test(description="Verify that valid creds can be successfully login",groups= {"e2e"},dataProviderClass = com.ui.testdataprovider.TestDataProvider.class,dataProvider="TestUserCSVData",retryAnalyzer = com.ui.listerners.MyRetryAnalyzer.class)
	public void TestLoginCSVData(User user) {
		
		String username=homepage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).GetUserName();
		System.out.println(username);
		AssertJUnit.assertEquals(username, "Yamuna shah");

	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		homepage.closeBrowserWindow();
	}
//	
	
	
//	@Test(description="Verify that valid creds can be successfully login",groups= {"e2e"},dataProviderClass = com.ui.testdataprovider.TestDataProvider.class,dataProvider="TestUserExcelData")
//	public void TestLoginExcelData(User user) {
//		
//		String username=homepage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).GetUserName();
//		System.out.println(username);
//		AssertJUnit.assertEquals(username, "Yamuna shah");
//
//	}

}
