/*
package generic;


import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class ExtentTestManager {  
    static Map extentTestMap = new HashMap();
     static ExtentReports extent = ExtentManager.getExtentReport();
    
    public static Map<Long, String> threadToExtentTestMap = new HashMap<Long, String>();
    public static Map<String, ExtentTest> nameToTestMap = new HashMap<String, ExtentTest>();
    
    public  static synchronized ExtentTest getTest(String testName, String testDescription) {


        // if this test has already been created return
        if (!nameToTestMap.containsKey(testName)) {
            Long threadID = Thread.currentThread().getId();
            ExtentTest test = ExtentManager.getExtentReport().startTest(testName, testDescription);
            nameToTestMap.put(testName, test);
            threadToExtentTestMap.put(threadID, testName);
        }
        return nameToTestMap.get(testName);
    }

    public  static synchronized ExtentTest getTest(String testName) {

        return getTest(testName, "");
    }
    public  static synchronized ExtentTest getTest() {

        Long threadID = Thread.currentThread().getId();
        String testName = null;
        if (threadToExtentTestMap.containsKey(threadID)) 
        {
            testName = threadToExtentTestMap.get(threadID);
           
        }
            return nameToTestMap.get(testName);
        

    }

    
    public  static synchronized void closeTest(String testName) {


        if (!testName.isEmpty()) {
            ExtentTest test = getTest(testName);
            ExtentManager.getExtentReport().endTest(test);
        }
        //browserName =null;
    }

    public  static  synchronized void closeTest(ExtentTest test) {

        if (test != null) {
        	ExtentManager.getExtentReport().endTest(test);
        }
        //browserName =null;
    }

    public  static synchronized void closeTest()  {

        ExtentTest test = getTest();
        closeTest(test);
    }

    public  static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

        return test;
    }
}*/