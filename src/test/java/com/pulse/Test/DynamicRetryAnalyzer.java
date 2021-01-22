package com.pulse.Test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class DynamicRetryAnalyzer implements IRetryAnalyzer {

	int count=1;
	int maxRetryCount=3;
	
	
	
	@Override
	public boolean retry(ITestResult result) {
	
		
		if(count<maxRetryCount)
		{
			count ++;
			return true;
			
		}
		
		
		
		return false;
	}
	
	
	
	

}
