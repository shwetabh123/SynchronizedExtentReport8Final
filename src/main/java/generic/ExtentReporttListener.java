/*package generic;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ExtentReporttListener extends BaseTest implements ITestListener {
	

//	private static ExtentReports extent = ExtentManager.GetExtent();
//	private static ThreadLocal parentTest = new ThreadLocal();
//    private static ThreadLocal test1 = new ThreadLocal();
   
	
	//Extent Report Declarations
    private static ExtentReports extent = ExtentManager.getExtentReport();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
 
	
//	public  static ExtentReports extent;
	public  static  ExtentTest extentTest; 

	
	public Logger log=Logger.getLogger(ExtentReporttListener.class);
			
	
	
	public synchronized void onStart(ITestContext result) {
    	
    
	//	extent = ExtentManager.GetExtent();
	//	  extentTest=extent.createTest(result.getCurrentXmlTest().getName());
			Reporter.log(result.getCurrentXmlTest().getName()+ " Class Started...");

			log.info(result.getCurrentXmlTest().getName()+ "  Class Started...");
    
    }

	@Override
	public synchronized void onFinish(ITestContext result) {
	//	extent.flush();
		


		
		Reporter.log(result.getName()+ "  Test Finished...");
	
	log.info(result.getName()+ " Test Finished...");
	}
	
	@Override
	public synchronized void onTestStart(ITestResult result) {
		

		
		//ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		   
	//	extentTest.log(Status.INFO, result.getName()+"  Test started ..");

		
	// ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
	       
	// test.set(extentTest);
		
		Reporter.log(result.getMethod().getMethodName()+ " Test Started...");
		

		log.info(result.getMethod().getMethodName()+ " Test Started...");
		
		

	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		//test."Test passed");
		
		
	//	extentTest.log(Status.INFO,result.getName()+ "Passed..");
		
		
		
		//  test.get().pass("Test passed");
		
		
		
	//	ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),"Test Case is passed");
		
		
	//	extentTest.log(Status.PASS, "TEST CASE PASSED IS ->"+result.getMethod().getMethodName()+"is passed"); //to add name in extent report


		
		Reporter.log(result.getMethod().getMethodName()+ "Test Passed...");

		log.info(result.getMethod().getMethodName()+ "Test Passed...");

		
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
	//	test.get().fail(result.getThrowable());
		
	//	extentTest.log(Status.FAIL, result.getThrowable());
	//	 test.get().fail(result.getThrowable());
		
				
		//	ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
				
				
		//		extentTest.log(Status.FAIL, "TEST CASE FAILED IS ->"+result.getThrowable()); //to add error/exception in extent report
		
		//		extent.flush();
		Reporter.log(result.getMethod().getMethodName()+ "Test Failed..."+result.getThrowable());
		
		
		log.error(result.getMethod().getMethodName()+ "Test Failed..."+result.getThrowable());

	}


	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		

		//test.get().skip(result.getThrowable());
		
	//	extentTest.log(Status.SKIP, result.getThrowable());
	//	 test.get().skip(result.getThrowable());
	
		
	//	extentTest.log(Status.SKIP, "TEST CASE FAILED IS ->"+result.getThrowable()); //to add error/exception in extent report
		

		
		Reporter.log(result.getMethod().getMethodName()+ "Test Skipped..."+result.getThrowable());
		
		
		log.warn(result.getMethod().getMethodName()+ "Test Skipped..."+result.getThrowable());

	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	
	
}

	

	
}*/