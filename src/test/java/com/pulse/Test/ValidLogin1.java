package com.pulse.Test;

import static org.testng.Assert.assertEquals;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import com.pulse.Page.Author;
import com.pulse.Page.HomePage;
import com.pulse.Page.LoginPage;

public class ValidLogin1 extends BaseTest {

	public static String appURL = "https://www.google.com";
	public static String appURL1 = "https://in.yahoo.com/";
	public static String appURL2 = "https://www.sabtv.com/en_in/";
	public static String appURL3 = "https://economictimes.indiatimes.com/";
	static Excel eLib = new Excel();
	public static String url = eLib.getCellValue(path, "PreCon", 1, 0);
	public static String logfiletimestamp;

	@Test(description = "This test case is to verify that the firstname and lastname is entered.", groups = { "abc" })
	// (retryAnalyzer=DynamicRetryAnalyzer.class)
	// (description = "This test case is to verify that the firstname and lastname
	// is entered.", groups= {"abc"})
	
	public void TC1(Method method) throws IOException, Exception {
		BasePage b = new BasePage(driver);
		// driver.navigate().to(appURL);
		driver.get(appURL);
		Thread.sleep(5000);
	
		b.type("typegooglesearch", "Google");
		// l.typegooglesearch();
		childTestnew.get().log(Status.INFO, "Type in Google search ");
		
		childTestnew.get().log(Status.INFO, "Running" + method.getName());
		 childTestnew.get().assignCategory("smoke testing ");
		childTestnew.get().log(Status.INFO, "Logged into  " + appURL);
		Thread.sleep(5000);
		System.out.println("TC1 Passed");
		/*
		 * Thread.sleep(2000); l.typegooglesearch(); childTestnew.get().log(Status.INFO,
		 * "Type in Google search ");
		 */
		System.out.println("Test Case One in " + getClass().getSimpleName()
				+ " with Thread Id:- " + Thread.currentThread().getId());
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		
		extent.flush();
		//driver.quit();
	}

	@Test(description = "This test case verifies whether the radio button single is selected.")
	// (retryAnalyzer=DynamicRetryAnalyzer.class)
	// (description = "This test case verifies whether the radio button single is
	// selected.")
	public void TC2(Method method) throws InterruptedException {
		driver.navigate().to(appURL);
		childTestnew.get().log(Status.INFO, "Running " + method.getName());
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		assertEquals(actualTitle, expectedTitle);
		 childTestnew.get().assignCategory("smoke testing ");
		childTestnew.get().log(Status.INFO, "Verifying Title " + appURL);
		System.out.println("TC2 Passed");
	//	driver.quit();
		
		System.out.println("Test Case Two in " + getClass().getSimpleName()
				+ " with Thread Id:- " + Thread.currentThread().getId());
		
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		
		extent.flush();
	//	driver.quit();
	}

	/*
	 * @Test public void testValidLogin1() throws Exception {
	 * driver.navigate().to(url); String
	 * un=Excel.getCellValue(XLPATH,"ValidLogin",1,0); String
	 * pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1); String
	 * accnt=Excel.getCellValue(XLPATH,"ValidLogin",1,2); String
	 * cb=Excel.getCellValue(XLPATH,"Author",1,3); LoginPage l=new
	 * LoginPage(driver); BasePage b=new BasePage(driver);
	 * driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys(un);;
	 * l.setPassword(pw); Thread.sleep(5000); l.clickLogin(); Thread.sleep(30000);
	 * l.dropdowntheaccount(accnt); Thread.sleep(5000); l.clickselect();
	 * Thread.sleep(5000); HomePage h=new HomePage(driver); driver.close();
	 * ExtentTestManager.getTest().log(LogStatus.PASS, "Log from threadId: " +
	 * Thread.currentThread().getId());
	 * ExtentTestManager.getTest().log(LogStatus.INFO, "Log from threadId: " +
	 * Thread.currentThread().getId());
	 * Assert.assertEquals(ExtentTestManager.getTest().getRunStatus(),
	 * LogStatus.PASS); driver.close(); }
	 * 
	 * @Test public void testValidLogin2() throws Exception {
	 * driver.navigate().to(url); Randomaplphanumber R=new Randomaplphanumber();
	 * String r= R.Random(); String un=Excel.getCellValue(XLPATH,"ValidLogin",2,0);
	 * String pw=Excel.getCellValue(XLPATH,"ValidLogin",2,1); String
	 * accnt=Excel.getCellValue(XLPATH,"ValidLogin",2,2); String
	 * cb=Excel.getCellValue(XLPATH,"Author",1,3); LoginPage l=new
	 * LoginPage(driver); BasePage b=new BasePage(driver);
	 * driver.findElement(By.xpath("//*[@id='j_username']")).sendKeys(un);; // r=
	 * BaseTest.getScreenshot(driver, method.getName()); l.setPassword(pw);
	 * Thread.sleep(25000); // r= BaseTest.getScreenshot(driver, method.getName());
	 * l.clickLogin(); Thread.sleep(25000); l.dropdowntheaccount(accnt);
	 * Thread.sleep(25000); l.clickselect(); Thread.sleep(5000); HomePage h=new
	 * HomePage(driver); driver.close();
	 * ExtentTestManager.getTest().log(LogStatus.PASS, "Log from threadId: " +
	 * Thread.currentThread().getId());
	 * ExtentTestManager.getTest().log(LogStatus.INFO, "Log from threadId: " +
	 * Thread.currentThread().getId());
	 * Assert.assertEquals(ExtentTestManager.getTest().getRunStatus(),
	 * LogStatus.PASS); }
	 */
}