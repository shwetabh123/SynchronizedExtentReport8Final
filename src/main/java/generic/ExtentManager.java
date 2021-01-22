/*package generic;

import java.util.HashMap;
import java.util.Map;


import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ExtentManager {
	   // static ExtentReports extent;
	
	 final static String workingDir = System.getProperty("user.dir");
	
	  //  final static String filePath = "./test-output/MyReport.html";
	  final static String filePath = "\\test-output\\MyReport.html";
	    
		private static ExtentHtmlReporter htmlReporter = null;
		private static ExtentReports reporter = null;

	    public static Map<Long, String> threadToExtentTestMap = new HashMap<Long, String>();
	    public static Map<String, ExtentTest> nameToTestMap = new HashMap<String, ExtentTest>();

	    public static String browserName;
	    
	    public synchronized static ExtentReports getReporter() {
	        if (extent == null) {
	      
	            extent = new ExtentReports(filePath, true);

	        }
	        
	        return extent;
	    }
	    
	    
	    
	   
   
	    
	    
	    
	    
	    public  static synchronized ExtentReports getExtentReport() {

	        if (reporter == null) {
	  
	    		
	        	
	        	
	            reporter = new ExtentReports(workingDir+filePath, true, DisplayOrder.NEWEST_FIRST);
	            System.out.println("Test report is generating for browser :"+ browserName);
	       
	            reporter
                .addSystemInfo("Host Name", "Shwetabh")
                .addSystemInfo("Environment", "Stage");
	        
	        
	        }
	        return reporter;

	    }
	    
	    
	}



*/