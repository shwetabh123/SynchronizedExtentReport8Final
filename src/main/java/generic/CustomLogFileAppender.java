package generic;
/*package generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.apache.log4j.RollingFileAppender;
import org.testng.annotations.Test;

import com.pulse.test.Randomaplphanumber;
import com.pulse.test.ValidLogin;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;


public class CustomLogFileAppender extends RollingFileAppender
{
    public static String logfiletimestamp;
    
    final static Logger log = Logger.getLogger(CustomLogFileAppender.class);
    
    
    @Test
    public void setFile()
    {
 
    	
			 
	
    
    	        
    	       // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
    	        
    	        // logfiletimestamp = "AutomationLog_TestRunId-"+testRunId+"_"+format.format(d);
    	       // System.setProperty("current.date.time", dateFormat.format(new Date()));
    	        
    	      
    	        
    	        
    	//        System.setProperty("current.date.time", dateFormat.format(new Date()));
    	    
    	        
    	        
    	        
    	        
    	    	String scrFolderLocWithName = "./log/"+ new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();
    			
    			new File(scrFolderLocWithName).mkdir();
    			
    			
    			

    	    	String scrFolderLocWithName = "./log/"+ new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();
    			
    			new File(scrFolderLocWithName).mkdir();
    			
    		    System.setProperty("current.date.time", new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString());
        	    
    	        
    			
    			
    
    	      

    	
	   
	
	//    Date d = new Date();
	  //  SimpleDateFormat format = new SimpleDateFormat(  "dd.MMMMM.yyyy.hh.mm");
	    
	    
	   logfiletimestamp = "AutomationLog_TestRunId_"+new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();

	 
	   
	    String fileName = System.getProperty( logfiletimestamp);
	    
	 
	    System.out.println(fileName);
	    
	    
	   // 	fileName=fileName+logfiletimestamp;
	    
	   // 	   System.setProperty("current.date.time",fileName);
	   	    
	   	    
	    //	   String logPath=null;
	    		
	   		
	   		
	   //		logPath=System.getProperty("current.date.time");

	 //  	System.out.println("LogPath..."+logPath);


        log.trace("This is Trace Message.");
        log.debug("This is Debug Message.");
        
        
        log.info("This is Info Message.");
        
        
        log.warn("This is Warn Message.");
        log.error("This is Error Message.");
        log.fatal("This is Fatal Message.");        




	super.setFile(fileName);
	
	
}



	
	
	
	
	
	
    }
    
*/