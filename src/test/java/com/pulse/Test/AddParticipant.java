package com.pulse.Test;
	import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import com.pulse.Page.Author;
import com.pulse.Page.CompanyDirectory;
import com.pulse.Page.HomePage;
import com.pulse.Page.LoginPage;
//@Listeners(generic.RealGuru99TimeReport.class)
	public class AddParticipant extends BaseTest{
	static int teststepcount=000000;
	//public static Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
	  public static String logfiletimestamp;
		public static Properties CONFIG;
	//public static	ITestResult result = null;
		@Test(priority=1)
		public void addparticipant(Method method) throws Exception
		{
	//		 Randomaplphanumber R=new Randomaplphanumber();
	//		String r=  R.Random();
				String un=Excel.getCellValue(XLPATH,"ValidLogin",1,0);
				String pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1);
				String accnt=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
				String cb=Excel.getCellValue(XLPATH,"Author",1,3);
				//Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
				Logger APP_LOGS = Logger.getLogger(AddParticipant.class);
				//String HPT=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
				CompanyDirectory cd=new CompanyDirectory(driver);
				LoginPage l=new LoginPage(driver);
				l.setUserName(un);
				l.setPassword(pw);
				l.clickLogin();
				l.dropdowntheaccount(accnt);
				l.clickselect();
				cd.clickArrow();
				cd.clickSettings();
				cd.clickCompanyDirectory();
				cd.clickParticipants();
				cd.clickuploadparticipantscompany();
				Thread.sleep(25000);
				//cd.configInitialize();
				//cd. preInitialize() ;
			/*	
				downloadPath = System.getProperty("user.dir");
				//String data=System.getProperty(downloadPath);
				System.out.println(downloadPath);*/
			//	String data=System.getProperty("downloadPath");
			BasePage b=new BasePage(driver);
			String data=b.preInitialize();
				b.getDownloadedFileDetails(data);
				cd.clickDownloadSampleImportTemplate();
			//	b.getLastDownloadedFile("GetLastDownloadedFile");
				String fileName =b.getLastDownloadedFile("GetLastDownloadedFile");
				System.out.println("Last downloaded file is "+fileName);
				//String fileLocationPath=b.getfiledownloadlocation(fileName);
				b.addeditTextinExcel(downloadPath, fileName, "Employee File", 0, 2, "charu2");
	}
}