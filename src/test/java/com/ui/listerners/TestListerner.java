package com.ui.listerners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListerner implements ITestListener{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	
	
	public void onTestStart(ITestResult result) {
		logger.info("Test Execution Started!");
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.CreateTest(result.getMethod().getMethodName());
	  }
	
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS,result.getMethod().getMethodName() + "  PASSED");
	  }

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL,result.getMethod().getMethodName() + "  FAILED");
	  }
	
	public void onTestSkipped(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName() + "  SKIPPED");
	  }
	
	public void onStart(ITestContext context) {
		logger.info("Test Suite Execution Started");
		ExtentReporterUtility.setupExtentReport("report.html");
	  }
	
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Execution Finished");
		ExtentReporterUtility.flushReport();
	  }
}
