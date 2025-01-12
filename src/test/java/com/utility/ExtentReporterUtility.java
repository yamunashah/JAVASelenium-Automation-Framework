package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {

	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static void setupExtentReport(String filename)
	{
		ExtentSparkReporter extentsparkreport = new ExtentSparkReporter(filename);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentsparkreport);
	}
	
	public static void CreateTest(String testname)
	{
		ExtentTest test = extentReports.createTest(testname);
		extentTest.set(test);
	}
	
	public static ExtentTest getTest()
	{
		return extentTest.get();
	}
	
	public static void flushReport()
	{
		extentReports.flush();
	}
}
