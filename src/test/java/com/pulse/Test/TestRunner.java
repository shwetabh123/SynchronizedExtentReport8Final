package com.pulse.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;



public class TestRunner {
	
	public static void main(String[] args) {
		
	
		   

	TestNG runner =new TestNG();
	
	List<String> list=new ArrayList<String>();

	
	list.add("D:\\ShwetabhWorkspace\\SynchronizedExtentReport7-master\\test-output\\Extent Parallel Test\\testng-failed.xml");
	
	
	runner.setTestSuites(list);

	
	runner.run();
}


}
