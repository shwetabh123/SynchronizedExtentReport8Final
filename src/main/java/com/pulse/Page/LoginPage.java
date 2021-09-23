package com.pulse.Page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;

import generic.BasePage;
import generic.BaseTest;

public class LoginPage extends BasePage {

	Properties prop = null;

	@FindBy(xpath = "//*[@id='wrapper-inner']//h2[text()='CEB Pulse Surveys']")
	private WebElement CEBPulseSurveys;

	@FindBy(xpath = "//*[@id='j_username']")
	private WebElement puser;

	@FindBy(xpath = "//*[@id='j_password']")

	private WebElement ppassword;

	@FindBy(xpath = "//*[@id='proceed']")
	private WebElement plsignin;

	@FindBy(xpath = "//span[contains(.,' invalid')]")
	private WebElement errMsg1;

	@FindBy(xpath = "//LABEL[normalize-space(text())='Please enter a valid email address']")
	private WebElement errMsg;

	@FindBy(xpath = "	 //SELECT[@name='j_company'] ")
	private WebElement Selects3_CEBfirstDemoLibraryTestingJaghadhiniSecondDemoPulselibraryPulselibrarychildPulseNotLib_SELECT;

	@FindBy(xpath = " //BUTTON[@class='btn btn-primary']  ")
	private WebElement Select_Account;

	// ReadObject r=new ReadObject(driver);

	/*
	 * 
	 * public String RedConfigfile(WebElement we) {
	 * 
	 * File file = new File(
	 * "C:\\Users\\ssrivastava4\\workspace\\PulseProject6\\Config\\config.properties"
	 * );
	 * 
	 * FileInputStream fileInput = null; try { fileInput = new
	 * FileInputStream(file);
	 * 
	 * 
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace(); } prop = new
	 * Properties();
	 * 
	 * //load properties file try { prop.load(fileInput);
	 * 
	 * 
	 * System.out.println("Property class loaded"); } catch (IOException e) {
	 * e.printStackTrace(); } return prop.getProperty(we);
	 * 
	 * }
	 */

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// BasePage b=new BasePage(driver);

	/*
	 * 
	 * public void verifyCEBLogo(String cb) {
	 * 
	 * 
	 * b.verifyTextContains(driver,
	 * "//*[@id='wrapper-inner']//h2[text()='CEB Pulse Surveys']", cb);
	 * 
	 * 
	 * }
	 * 
	 */

	public void setUserName(String un)

	{

		puser.sendKeys(un);

		// b.type(driver, "//*[@id='j_username']", un);

	}

	public void setPassword(String pw)

	{

		ppassword.sendKeys(pw);

		// b.type(driver,"//*[@id='j_password']", pw);

	}

	public void clickLogin() {

		plsignin.click();

		// b.Click(driver, "//*[@id='proceed']");

	}

	public void dropdowntheaccount(String accnt) {

		Select oSelect = new Select(driver.findElement(By.xpath("//SELECT[@name='j_company']")));

		oSelect.selectByVisibleText(accnt);

	}

	public void clickselect() {
		// sleep(1);

		Select_Account.click();

		// driver.findElement(By.xpath(prop.getProperty("Select_Account"))).click();

	}

	public void verifyErrMsgIsDisplayed() {
		// sleep(2);

		Assert.assertTrue(errMsg.isDisplayed());

	}

	/*
	 * public void countobjects(){ List<Field> list = new
	 * ArrayList<>(Arrays.asList(LoginPage.class.getDeclaredFields()));
	 * 
	 * for(Iterator<Field> i = list.iterator(); i.hasNext();){ Field f = i.next();
	 * if(f.getModifiers() != Modifier.PRIVATE) i.remove(); } for(Field f : list) //
	 * System.out.println(f.getName());
	 * System.out.println("Objects of class are :----"+ f.getName());
	 * 
	 * 
	 * 
	 * }
	 */

	public void typegooglesearch() throws IOException, Exception {

		// driver.findElement( b.getObject(b.getObjectRepository(), "typegooglesearch",
		// "XPATH")).sendKeys("Google");;

		// WebElement we= driver.findElement(b.getObject(b.getObjectRepository(),
		// "typegooglesearch", "CLASSNAME"));

		// we.sendKeys(data);

		// b.type("typegooglesearch","Google");

	}

	public boolean getallobjectlist() {

		try {

			List<Field> list = new ArrayList<>(Arrays.asList(LoginPage.class.getDeclaredFields()));

			for (Iterator<Field> i = list.iterator(); i.hasNext();)

			{
				Field f = i.next();
				if (f.getModifiers() != Modifier.PRIVATE)
					i.remove();
			}
			for (Field f : list)
			// System.out.println(f.getName());
			{

				System.out.println("Objects of class are :----" + f.getName());

			}

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			DriverManager.setLoginTimeout(20);

			String dbUrl = "jdbc:mysql://127.0.0.1/automation";

			// Database Username
			String username = "root";

			// Database Password
			String password = "faridabad";

			// Query to Execute
			// String query = "select * from employee;";
			// String query1 = " INSERT INTO objectrepository (objectname )VALUES (?)";

			String query1 = "select *  from objectrepository;";

			Connection con = DriverManager.getConnection(dbUrl, username, password);

			// ResultSet rs= stmt.executeQuery(query1);

			// PreparedStatement preparedStmt = con.prepareStatement(query1);

			// preparedStmt.setString (1,f.getName());

			// execute the preparedstatement
			// preparedStmt.execute();

			Statement stmt = con.createStatement();

			// System.out.println(" SUCCESS!\n");

			// String query2 = " SELECT TestCaseID FROM testcase WHERE TestCaseID = (SELECT
			// MAX(TestCaseID) FROM testcase)";

			// String query2 = "SELECT max( TestCaseID ) FROM `testcase`";

			// Execute the SQL Query. Store results in ResultSet
			ResultSet rs = stmt.executeQuery(query1);

			// while (rs.next())

			{
				// int name = rs.getInt(1);

				// System.out.println("Max Run id is:"+name);

			}
			// While Loop to iterate through all data and print results
			while (rs.next()) {

				String id = rs.getString(1);
				String objectname = rs.getString(2);

				System.out.println("Object name of ID-- " + id + " are--  :" + objectname);

			}

			con.close();

			return true;
		}

		catch (SQLException | ClassNotFoundException e) {
			// keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
			e.printStackTrace();
			return false;

		} // end finally try

	}

}
