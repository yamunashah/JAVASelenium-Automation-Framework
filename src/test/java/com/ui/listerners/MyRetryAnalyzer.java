package com.ui.listerners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSOnUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer{

//	private final static int MAX_NUMBER_OF_ATTEMPT = Integer.parseInt(PropertyUtil.ReadProperty(Env.QA,"MAX_NUMBER_OF_ATTEMPT"));
	private final static int MAX_NUMBER_OF_ATTEMPT = JSOnUtility.readJson(Env.DEV).getMAX_NUMBER_OF_ATTEMPT();
	private static int currentAttempt=1;
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_NUMBER_OF_ATTEMPT)
		{
			currentAttempt++;
			return true;
		}
		return false;
	}

	
}
