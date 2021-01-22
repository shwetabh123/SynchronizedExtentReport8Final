	
	
	package com.pulse.Test;
	import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import com.pulse.Page.Analyse;
import com.pulse.Page.Author;
import com.pulse.Page.HomePage;
import com.pulse.Page.LoginPage;



//@Listeners(generic.RealGuru99TimeReport.class)


	public class AnalyseReport extends BaseTest{

	
	static int teststepcount=000000;
	
	
	//public static Logger APP_LOGS = Logger.getLogger("devpinoyLogger");


	  public static String logfiletimestamp;
	    
	public static	ITestResult result = null;
		
	
	/*
		@Test(priority=1)
		public void testAnalyseReport() throws Exception{
			
				String un=Excel.getCellValue(XLPATH,"ValidLogin",1,0);
				String pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1);
				String accnt=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
	
				String cb=Excel.getCellValue(XLPATH,"Author",1,3);
			       
				//Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
			     
				Logger APP_LOGS = Logger.getLogger(ValidLogin.class);
				  
	    		    
				//String HPT=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
				LoginPage l=new LoginPage(driver);
				
				BasePage b=new BasePage(driver);
				
				Analyse a=new Analyse(driver);
				
				
				teststepcount++;
				
				System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				
				APP_LOGS.info("Verifying CeB Logo");
				
				
				
				l.verifyCEBLogo(cb);
		
		
			   
			//	b.takeScreenshot();
			
		
			
				teststepcount++;
				
				
				System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				Thread.sleep(5000);
				
				
				APP_LOGS.info("type username");
				
				l.setUserName(un);
				
			//	b.takeScreenshot();
				
				Thread.sleep(5000);
				
	
				teststepcount++;
				
				
				System.out.println("Executing  Step No :"+teststepcount);
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				
				
				
				APP_LOGS.info("type password");
				 
				 
				l.setPassword(pw);
				
				Thread.sleep(5000);
			//	b.takeScreenshot();
				
				teststepcount++;
				

				System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("click select");
				
				l.clickLogin();
				
				Thread.sleep(5000);
			
		//		b.takeScreenshot();
				
				teststepcount++;
				
				
                  System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("click dropdown ");
				
				
				
				l.dropdowntheaccount(accnt);
				Thread.sleep(5000);
			
				
			//	b.takeScreenshot();
				
				teststepcount++;
				
	            System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				APP_LOGS.info("click select");
				
		
				l.clickselect();
				Thread.sleep(15000);
				
		//		b.takeScreenshot();
				
				System.out.println("Number of steps in TC are "+teststepcount);
				
				
				APP_LOGS.info("Number of steps in TC are "+teststepcount);
		
				
				
				
				APP_LOGS.info("click analyse");
				
				a.clickanalysebutton();
				
			//	b.takeScreenshot();
				
				
				APP_LOGS.info("Assert Title");
				
				
				b.assertTitle("Analyze - Pulse");
				
			//	b.takeScreenshot();
				
				
				APP_LOGS.info("Verifying presence of analyse button");
				
				a.verifyanalysebutton();

				
				
				APP_LOGS.info("Scrolld down");
				
			a.scrolldown();
		//	b.takeScreenshot();
			
			
			
			
			APP_LOGS.info("Open new tab");
			b.openNewTab(driver);
			
		//	b.takeScreenshot();
								
		}
	*/
	
	
		
		@Test(priority=1)
		public void testDVReport() throws Exception{
			
				String un=Excel.getCellValue(XLPATH,"ValidLogin",1,0);
				String pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1);
				String accnt=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
	
				String cb=Excel.getCellValue(XLPATH,"Author",1,3);
			       
				//Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
			     
				Logger APP_LOGS = Logger.getLogger(ValidLogin1.class);
				  
	    		    
				//String HPT=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
				LoginPage l=new LoginPage(driver);
				
				BasePage b=new BasePage(driver);
				
				Analyse a=new Analyse(driver);
				
		
				
				APP_LOGS.info("type username");
				
				l.setUserName(un);
				
			
				
				Thread.sleep(5000);
		
				
				APP_LOGS.info("type password");
				 
				 
				l.setPassword(pw);
				
				Thread.sleep(5000);
		
				
				APP_LOGS.info("click select");
				
				l.clickLogin();
				
				Thread.sleep(5000);
			
	
				
				
				l.dropdowntheaccount(accnt);
				Thread.sleep(5000);
			
				
			
				APP_LOGS.info("click select");
				
		
				l.clickselect();
				Thread.sleep(15000);
	
				
				APP_LOGS.info("click analyse");
				
				a.clickanalysebutton();

				
				a.clickanalyzesearch();
				
				
				Thread.sleep(15000);
				a.clickanalyzesearchbutton();
				Thread.sleep(15000);
				a.DVAnalyseCopyOfShwetabhDVSurveyConsumingAccountSA();
				
				Thread.sleep(35000);
				a.SpotLightReportsTab();
				Thread.sleep(5000);
				
				
				
				
	/*			
				a.btnSelectBenchMark();
				Thread.sleep(5000);
				
				
				a.VsBenchmarkCheckbox();
				Thread.sleep(5000);
				
				
				a.ApplyAnalysesettings();
				Thread.sleep(5000);
				*/
				
				a.PreviousStartDate();
				Thread.sleep(5000);
				
				
				
				a.PreviousEndDate();
				Thread.sleep(5000);
				
				
				a.Segment3Dropdown();
				Thread.sleep(5000);
				
				a.Segment2DemoValues();
				
				Thread.sleep(5000);
				a.Segment4Dropdown();
				Thread.sleep(5000);
				a.Segment3DemoValues();
				Thread.sleep(5000);
			
				
				Thread.sleep(5000);
				
	
				String data=b.preInitialize();
				
				
			//		b.getDownloadedFileDetails("downloadPath");
					
					Thread.sleep(25000);
					
					
			//	a.RunReport();
				
	
				a.actionbutton();

				Thread.sleep(15000);
			//	a.Download();

				Thread.sleep(45000);
				
				String fileName =b.getLastDownloadedFile("GetLastDownloadedFile");
				
				Thread.sleep(45000);
				System.out.println("Last downloaded file is "+fileName);
		
						
				Thread.sleep(45000);
		//		b.verifyCSVColumnTextWithPPT("downloadfolder-GetLastDownloadedFile","1");
				
				Thread.sleep(45000);
				
				
				
		}
	
	
	
	
	}









