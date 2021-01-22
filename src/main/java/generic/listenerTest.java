package generic;
/*package generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public  class listenerTest implements ITestListener, ISuiteListener, IInvokedMethodListener { 
 

	// Here we need to create logger instance so we need to pass Class name for 
     //which  we want to create log file in my case BaseTest is classname
	
	
	Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
     
	 protected static WebDriver driver;


    // It executes for on each test Start
    @Test
    public void onTestStart(ITestResult result) {
      
    	
    	System.out.println("Test Method Started and Test method deatils are :" + result.getName());
        
   	 // configure log4j properties file
       PropertyConfigurator.configure("Log4j.properties");
     
           APP_LOGS.info("Test Method Started and Test method deatils are :" + result.getName());
           
           
           
           if (result.getStatus() == ITestResult.STARTED)
           
           {
               TakesScreenshot ts = (TakesScreenshot)driver;
               File srcFile = ts.getScreenshotAs(OutputType.FILE);
               try {
      			FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
      		} catch (IOException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
               
               
               
               //result.getname() method will give you current test case name. 
               //./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
              }
             }
           
           
           
           
           
           
           
           
           
           
           
           
    
 
    // It executes for only Passed tests
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Method Passed and Test method deatils are:" + result.getName());
      	 // configure log4j properties file
        PropertyConfigurator.configure("Log4j.properties");
       
        APP_LOGS.info("Test Method Passed and Test method deatils are :" + result.getName());
        
        
		
		// Here will compare if test is failing then only it will enter into if condition
if(ITestResult.SUCCESS==result.getStatus())
{
try 
{
	
	String scrFolderLocWithName = "./screenshots/"+ new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();
	
	new File(scrFolderLocWithName).mkdir();
       


	
	
// Create refernce of TakesScreenshot
TakesScreenshot ts=(TakesScreenshot)driver;
 
// Call method to capture screenshot
File source=ts.getScreenshotAs(OutputType.FILE);
 
// Copy files to specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same


FileUtils.copyFile(source, new File(scrFolderLocWithName,result.getName()+".png"));

 
System.out.println("Screenshot taken Successfully");









} 
catch (Exception e)
{
 
System.out.println("Exception while taking screenshot "+e.getMessage());
} 
 
 
 
}
          }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   
 
    
    
    @Override
    // It executes for only Failed tests
    public void onTestFailure(ITestResult result)
    
    {
        System.out.println("Test Method Failed and Test method deatils are :" + result.getName());
        
        // configure log4j properties file
      //  PropertyConfigurator.configure("Log4j.properties");
       APP_LOGS.info("Test Method Failed and Test method deatils are :" + result.getName());
       
  
		
		// Here will compare if test is failing then only it will enter into if condition
if(ITestResult.FAILURE==result.getStatus())
{
try 
{
	
	String scrFolderLocWithName = "./screenshots/"+ new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();
	
	new File(scrFolderLocWithName).mkdir();
      


	
	
// Create refernce of TakesScreenshot
TakesScreenshot ts=(TakesScreenshot)driver;

// Call method to capture screenshot
File source=ts.getScreenshotAs(OutputType.FILE);

// Copy files to specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same


FileUtils.copyFile(source, new File(scrFolderLocWithName,result.getName()+".png"));


System.out.println("Screenshot taken Successfully");









} 
catch (Exception e)
{

System.out.println("Exception while taking screenshot "+e.getMessage());
} 



}
         
 
       }
       
    
 
    
    
    
    
    
    
    // It executes for only Skipped tests
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Method Skipped and Test method deatils are:" + result.getName());
        
        // configure log4j properties file
     //   PropertyConfigurator.configure("Log4j.properties");
        APP_LOGS.info("Test Method Skipped and Test method deatils are :" + result.getName());
        
        
        if (result.getStatus() == ITestResult.SKIP ){
            TakesScreenshot ts = (TakesScreenshot)driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            try {
   			FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
            
            
            
            //result.getname() method will give you current test case name. 
            //./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
           }
          }
        
        
        
    

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
 


	



}
*/