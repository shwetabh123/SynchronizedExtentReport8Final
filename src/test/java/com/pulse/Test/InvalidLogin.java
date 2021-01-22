package com.pulse.Test;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import com.pulse.Page.LoginPage;

public class InvalidLogin extends BaseTest 


{
 @Test(priority=2)
 public void testInvalidLogin() throws InterruptedException{
	 int rc=Excel.getRowCount(XLPATH, "InvalidLogin");
	 
	 for(int i=1;i<=rc;i++)
	 
	 {
		 String un=Excel.getCellValue(XLPATH,"InvalidLogin",i,0);
		 String pw=Excel.getCellValue(XLPATH,"InvalidLogin",i,1);
		 LoginPage l=new LoginPage(driver);
		 l.setUserName(un);
		 Thread.sleep(3000);
		 l.setPassword(pw);
		 Thread.sleep(3000);
		 l.clickLogin();
		 Thread.sleep(3000);
		 l.verifyErrMsgIsDisplayed();
	
	 
	 
	 
	 }
 }
}
