package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
/*
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hslf.usermodel.HSLFShape;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFTextParagraph;
*/
//import org.apache.poi.hslf.usermodel.HSLFTextShape;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
//import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;


import org.testng.*;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import au.com.bytecode.opencsv.CSVReader;
public class BasePage {
	static Properties p;
	String itrFileName = null;
	static Logger APP_LOGS = Logger.getLogger("BasePage");
	protected WebDriver driver;
	public Set<String> DownloadedFiles = new HashSet<String>();
	public static String screenshotPath = null;
	public String downloadPath = null;
	public static String uploadPath = null;
	public static String sqlresultPath = null;
	public static Properties CONFIG;
	public static HashMap<String, String> runTimeVariable = new HashMap<String, String>();
	public static HashMap<String, HashMap<String, String>> runTimeVariableMap = new HashMap<String, HashMap<String, String>>();
	public String browsername;
	static int testRunId = 000000;
	static WebElement we = null;
	public static boolean status = false;
	public static String keyerrormsg = "";


	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * public void verifyTitle(String eTitle){ WebDriverWait wait=new
	 * WebDriverWait(driver,10); try{
	 * wait.until(ExpectedConditions.titleIs(eTitle));
	 * Reporter.log("PASS: Title is Matching",true); } catch(Exception e){
	 * Reporter.log("FAIL: Title is NOT Matching",true); Assert.fail(); } }
	 */
	public static Properties loadPropertyFile(String FilePath) throws IOException {
		p = new Properties();
		// Read object repository file
		// InputStream stream = new FileInputStream(new
		// File(System.getProperty("user.dir")+"\\src\\objects\\object.properties"));
		InputStream stream = new FileInputStream(new File(FilePath));
		// load all objects
		p.load(stream);
		return p;
	}

	public String getData(String ElementName) throws Exception {
		// Read value using the logical name as Key
		String data = p.getProperty(ElementName);
		return data;
	}

	/*
	 * public static By getObject(Properties p,String objectName,String objectType)
	 * throws Exception{ //Find by xpath if(objectType.equalsIgnoreCase("XPATH")){
	 * return By.xpath(p.getProperty(objectName)); } //find by class else
	 * if(objectType.equalsIgnoreCase("CLASSNAME")){ return
	 * By.className(p.getProperty(objectName)); } //find by name else
	 * if(objectType.equalsIgnoreCase("NAME")){ return
	 * By.name(p.getProperty(objectName)); } //Find by css else
	 * if(objectType.equalsIgnoreCase("CSS")){ return
	 * By.cssSelector(p.getProperty(objectName)); } //find by link else
	 * if(objectType.equalsIgnoreCase("LINK")){ return
	 * By.linkText(p.getProperty(objectName)); } //find by partial link else
	 * if(objectType.equalsIgnoreCase("PARTIALLINK")){ return
	 * By.partialLinkText(p.getProperty(objectName)); }else { throw new
	 * Exception("Wrong object type"); } }
	 */
	public By getLocator(String ElementName) throws Exception {
		// Read value using the logical name as Key
		String locator = p.getProperty(ElementName);
		
		// Split the value which contains locator type and locator value
		
		String locatorType = locator.split(":")[0];
		
		String locatorValue = locator.split(":")[1];
		
		// Return a instance of By class based on type of locator
		if (locatorType.toLowerCase().equals("id"))
			
			return By.id(locatorValue);
		
		else if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("Locator type '" + locatorType + "' not defined!!");
	}

	public void sleep(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static int i = 0;

	/*
	 * public void moveCursorToElement(WebElement element) { Actions a = new
	 * Actions(BasePage.driver); a.moveToElement(element); }
	 */
	
	
	
	
	
	//using webelement
	public void moveToElementAndClick_custom(WebElement element){
		try{
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			
			Actions actions = new Actions(driver);		
			
			actions.moveToElement(element).build().perform();
			Thread.sleep(5000);
			actions.moveToElement(element).click(element).build().perform();
			
			Thread.sleep(1000);
		}catch(Exception e){
			 e.printStackTrace();
		}
	}
	
	//using string location
	public boolean mouseHoverToElementAndClick(WebDriver driver, String selector) {
		APP_LOGS.info("Mouse Hover to Element and perform click");
		String framedxpath = "";
		try {
			WebElement we = driver.findElement(By.xpath(selector));
			// element=findElement(object,data);
			Actions action = new Actions(driver);
			Action move = action.moveToElement(we).build();
			move.perform();
			Thread.sleep(5000);
			move = action.moveToElement(we).click(we).build();
			move.perform();
		} catch (Throwable e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
			return false;
		}
		APP_LOGS.info("Mouse Hover to Element and perform click succeed       ");
		return true;
	}

	public boolean assertTitle(String data) {
		APP_LOGS.debug("assertTitleOnUI Title expected:" + data);
		String Result = "Test";
		int second = 0;
		String Actualtext = "";
		try {
			Actualtext = driver.getTitle();
			System.out.println("Title is :" + Actualtext);
			APP_LOGS.info("assertTitle actual is :" + Actualtext);
			if (Actualtext.toLowerCase().equals(data.toLowerCase())) {
				Result = "Pass";
				APP_LOGS.info("Title is correct");
			}
			if (!Result.equals("Pass")) {
				for (second = 0; second < 30; second++) {// George comment on 14-Oct-'14 since when it fails it takes
															// long time.
															// Thread.sleep(20L);
					if (driver.getTitle().toLowerCase().equals(data.toLowerCase())) {
						Result = "Pass";
						APP_LOGS.info("Title is correct");
						return true;
					}
				}
				if (second >= 30) {
					throw new NoSuchElementException("Title Does not exist");
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
			return false;
		}
		return true;
	}

	public boolean SpecialKeysaction(WebDriver driver, String selector, String data) {
		APP_LOGS.info("Inside SpecialKeysaction");
		Robot robot;
		try {
			robot = new Robot();
			if (!selector.isEmpty()) {
				WebElement we = driver.findElement(By.xpath(selector));
           //	element = findElement(object,data);
				if (!we.equals(null)) {
					try {
						if (data.equalsIgnoreCase("Tab"))
							we.sendKeys(Keys.TAB);
						else if (data.equalsIgnoreCase("Shift"))
							we.sendKeys(Keys.SHIFT);
						else if (data.equalsIgnoreCase("Leftarrow"))
							we.sendKeys(Keys.ARROW_LEFT);
						else if (data.equalsIgnoreCase("Rightarrow"))
							we.sendKeys(Keys.ARROW_RIGHT);
						else if (data.equalsIgnoreCase("Uparrow"))
							we.sendKeys(Keys.ARROW_UP);
						else if (data.equalsIgnoreCase("Downarrow"))
							we.sendKeys(Keys.ARROW_DOWN);
						else if (data.equalsIgnoreCase("Enter"))
							we.sendKeys(Keys.ENTER);
						else if (data.equalsIgnoreCase("Control"))
							we.sendKeys(Keys.CONTROL);
						else if (data.equalsIgnoreCase("Backspace"))
							we.sendKeys(Keys.BACK_SPACE);
						else if (data.equalsIgnoreCase("Pagedown"))
							we.sendKeys(Keys.PAGE_DOWN);
						else if (data.equalsIgnoreCase("Pageup"))
							we.sendKeys(Keys.PAGE_UP);
						else if (data.equalsIgnoreCase("Delete"))
							we.sendKeys(Keys.DELETE);
						else if (data.equalsIgnoreCase("Home"))
							we.sendKeys(Keys.HOME);
						else if (data.equalsIgnoreCase("End"))
							we.sendKeys(Keys.END);
						else if (data.equalsIgnoreCase("Insert"))
							we.sendKeys(Keys.INSERT);
						else if (data.equalsIgnoreCase("Clear"))
							we.sendKeys(Keys.CLEAR);
						else if (data.equalsIgnoreCase("Control+End")) {
							Long last_height;
							Long new_height;
							do {
								last_height = (Long) ((JavascriptExecutor) driver)
										.executeScript("return window.pageYOffset;");
								// last_height = (Long) ((JavascriptExecutor)driver).executeScript("return
								// window.scrollY;");
								System.out.println("vertical Scrollbar is present on page.");
								APP_LOGS.info("vertical Scrollbar is present on page.");
								we.sendKeys(Keys.CONTROL, Keys.END);
								// waitForAjax("","");
								new_height = (Long) ((JavascriptExecutor) driver)
										.executeScript("return window.pageYOffset;");
								// new_height = (Long) ((JavascriptExecutor)driver).executeScript("return
								// window.scrollY;");
							} while (last_height.longValue() < new_height.longValue());
						} else if (data.equalsIgnoreCase("Esc"))
							we.sendKeys(Keys.ESCAPE);
						else if (data.equalsIgnoreCase("Control+c"))
							we.sendKeys(Keys.CONTROL, Keys.chord("C"));
						else if (data.equalsIgnoreCase("Control+a"))
							we.sendKeys(Keys.CONTROL, Keys.chord("A"));
						else if (data.equalsIgnoreCase("Control+v"))
							we.sendKeys(Keys.CONTROL, Keys.chord("V"));
						else if (data.equalsIgnoreCase("Control+T") || data.equalsIgnoreCase("Control+t")) {
							driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
						} else if (data.equalsIgnoreCase("Control+N") || data.equalsIgnoreCase("Control+n")) {
							driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
						}
					} catch (Exception e) {
						keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
						APP_LOGS.info(keyerrormsg);
						return false;
					}
				} else {
					keyerrormsg = " Element is Null";
					APP_LOGS.info(keyerrormsg);
					return false;
				}
			} else {
				if (data.equalsIgnoreCase("Alt+S") || data.equalsIgnoreCase("Alt+s")) {
					robot.keyPress(KeyEvent.VK_ALT);
					robot.keyPress(KeyEvent.VK_S);
					robot.keyRelease(KeyEvent.VK_S);
					robot.keyRelease(KeyEvent.VK_ALT);
				}
				if (data.equalsIgnoreCase("Control+T") || data.equalsIgnoreCase("Control+t")) {
					// driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL + "t");
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_T);
					robot.keyRelease(KeyEvent.VK_T);
					robot.keyRelease(KeyEvent.VK_CONTROL);
				}
				if (data.equalsIgnoreCase("Control+N") || data.equalsIgnoreCase("Control+n")) {
					// driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL + "n");
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_N);
					robot.keyRelease(KeyEvent.VK_N);
					robot.keyRelease(KeyEvent.VK_CONTROL);
				}
				if (data.equalsIgnoreCase("Backspace") || data.equalsIgnoreCase("backspace")) {
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.BACK_SPACE);
				}
				if (data.equalsIgnoreCase("Control+End")) {
					Long last_height;
					Long new_height;
					do {
						last_height = (Long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
						System.out.println("vertical Scrollbar is present on page.");
						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
						// waitForAjax("","");
						new_height = (Long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
					} while (last_height.longValue() < new_height.longValue());
				}
			}
			return true;
		} catch (AWTException e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
			return false;
		}
	}

	public static void scrollUpToTopOfTheApp(WebDriver driver) {
		// Ctrl+Home | Scroll to Bottom of the page
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	}

	/*
	 * public static void takeScreenshot(WebDriver driver, Method method , String
	 * screenshotFolderLocation) throws IOException { String scrFolderLocWithName =
	 * "./screenshots/"+ new
	 * SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()
	 * ).toString(); new File(scrFolderLocWithName).mkdir(); File scrFile =
	 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //copy
	 * screenshot to screenshot folder i++; // FileUtils.copyFile(scrFile,new
	 * File(screenshotFolderLocation+ "/screenshot"+method.getName() +i+ ".png"));
	 * FileUtils.copyFile(scrFile,new File(screenshotFolderLocation+
	 * "/screenshot"+scrFolderLocWithName +i+ ".png")); }
	 */
	/*
	 * public static void takeScreenshot() throws Exception { String timeStamp; File
	 * screenShotName; String Runid; String runid; BasePage b=new BasePage(driver);
	 * File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * //The below method will save the screen shot in d drive with name
	 * "screenshot.png" String scrFolderLocWithName1 = ".\\screenshots\\"+"Test_Run
	 * id _"+b.getlastRunid(); new File(scrFolderLocWithName1).mkdir(); timeStamp =
	 * new
	 * SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	 * screenShotName = new File(
	 * "C:\\Users\\ssrivastava4\\workspace\\PulseProject3\\"+scrFolderLocWithName1,timeStamp+"
	 * .png"); FileUtils.copyFile(scrFile, screenShotName); String filePath =
	 * screenShotName.toString(); String path = "<img src=\"file://" + filePath +
	 * "\" alt=\"\"/>"; // String path = "<img src=\"file://" + filePath +
	 * "\" alt=\"\"/>"; Reporter.log(path); }
	 */
	/*
	 * public static void takeScreenshot() throws Exception { String timeStamp; File
	 * screenShotName; String Runid; String runid; BasePage b=new BasePage(driver);
	 * //test = reports.startTest(result.getMethod().getMethodName()); File scrFile
	 * = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //The below
	 * method will save the screen shot in d drive with name "screenshot.png" String
	 * scrFolderLocWithName1 = ".\\screenshots\\"+"Test_Run id _"+b.getlastRunid();
	 * new File(scrFolderLocWithName1).mkdir(); timeStamp = new
	 * SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	 * screenShotName = new File(
	 * "C:\\Users\\ssrivastava4\\workspace\\PulseProject3\\"+scrFolderLocWithName1,timeStamp+"
	 * .png"); FileUtils.copyFile(scrFile, screenShotName); String filePath =
	 * screenShotName.toString(); String path = "<img src=\"file://" + filePath +
	 * "\" alt=\"\"/>"; // String path = "<img src=\"file://" + filePath +
	 * "\" alt=\"\"/>"; Reporter.log(path); // test.log(LogStatus.INFO,
	 * test.addScreenCapture(filePath)); // test.log(LogStatus.INFO,
	 * result.getMethod().getMethodName() + "  test is failed",
	 * result.getThrowable().getMessage()); }
	 
	 
	 */
	public String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	/*
	 * public static void takeScreenshot() throws Exception { String
	 * scrFolderLocWithName = "./screenshots/"+ new
	 * SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()
	 * ).toString(); //new File(scrFolderLocWithName).mkdir(); // Create refernce of
	 * TakesScreenshot TakesScreenshot ts=(TakesScreenshot)driver; // Call method to
	 * capture screenshot File source=ts.getScreenshotAs(OutputType.FILE); // Copy
	 * files to specific location here it will save all screenshot in our project
	 * home directory and // result.getName() will return name of test case so that
	 * screenshot name will be same FileUtils.copyFile(source, new
	 * File(scrFolderLocWithName,".png")); String filePath = new
	 * File(scrFolderLocWithName,".png").toString(); String path =
	 * "<img src=\"file://" + filePath + "\" alt=\"\"/>"; Reporter.log(path); }
	 */
	/*
	 * public static String createFolder() { String scrFolderLocWithName =
	 * "./screenshots/"+ new
	 * SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()
	 * ).toString(); new File(scrFolderLocWithName).mkdir(); return
	 * scrFolderLocWithName; }
	 */
	public static void scrollDownToBottomOfTheApp(WebDriver driver) {
		// Ctrl+End | Scroll to Bottom of the page
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	}

	public static void scrollIntoTheElement(WebDriver driver, WebElement element) throws InterruptedException {
		Point hoverItem = element.getLocation();
		((JavascriptExecutor) driver).executeScript("return window.title;");
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + (hoverItem.getY()) + ");");
	}

	/*
	 * public static void WebDriverWaitForVisibilityOf(WebDriver driver,WebElement
	 * element) { WebDriverWait wait = new WebDriverWait(driver,40);
	 * wait.until(ExpectedConditions.visibilityOf(element)); } public static void
	 * WebDriverWaitForElementToBeClickable(WebDriver driver,WebElement element) {
	 * WebDriverWait wait = new WebDriverWait(driver,40);
	 * wait.until(ExpectedConditions.elementToBeClickable(element)); }
	 */
	/**
	 * Find element BY using object type and value
	 * 
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	/*
	 * public Properties getObjectRepository() throws IOException { Properties p =
	 * new Properties(); //Read object repository file InputStream stream = new
	 * FileInputStream(new
	 * File(System.getProperty("user.dir")+"\\src\\objects\\object.properties"));
	 * //load all objects p.load(stream); return p; }
	 */
	public static boolean Click(WebDriver driver, String selector) {
		try {
			driver.findElement(By.xpath(selector)).click();
			return false;
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			System.out.println(keyerrormsg);
			APP_LOGS.info("keyerrormsg=" + keyerrormsg);
			return false;
		}
	}
	public static boolean Click_custom(WebElement element) {
		try {
			element.click();
			
			return false;
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			System.out.println(keyerrormsg);
			APP_LOGS.info("keyerrormsg=" + keyerrormsg);
			
			return false;
		}
	}
	
	
	

	/*
	 * public static void ClickWithWait(WebDriver driver, String selector) { (new
	 * WebDriverWait(driver, 1))
	 * .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)
	 * )).click(); }
	 */
	public static void dropdownSelect(WebDriver driver, String selector, String selection) {
		Select element = new Select(driver.findElement(By.cssSelector(selector)));
		element.selectByValue(selection);
	}

	public boolean verifyTextContains(WebDriver driver, String selector, String data) {
		try {
			String Result = "Fail";
			we = driver.findElement(By.xpath(selector));
			String Text = we.getText();
			System.out.println("Actual Text is :" + Text);
			if (Text.equals("")) {
				Text = we.getAttribute("value");
				System.out.println("Attribute Value Text:" + Text);
			}
			if (!Text.equals(null) || !Text.equals("")) {
				if (Text.contains(data))
					Result = "Pass";
				System.out.println("Actual Text " + Text + "  Matches with expected Text" + data);
			} else {
				Text = we.getAttribute("value");
				if (Text.contains(data))
					Result = "Pass";
			}
			if (Result == "Pass")
				return true;
			else
				return false;
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			System.out.println(keyerrormsg);
			return false;
		}
	}

	public boolean type(String ElementName, String data) throws IOException
	
	{
		// loadPropertyFile is a user defined method to locate multiple properties file
		Properties configProp = loadPropertyFile(System.getProperty("user.dir") + "\\src\\main\\java\\objects\\object.properties");
		System.out.println("Data--->>" + data);
		try {
			// WebElement we= driver.findElement(this.getObject(this.getObjectRepository(),
			// "typegooglesearch", "CLASSNAME"));
			// WebElement we= driver.findElement(By.xpath(selector));
			WebElement we = driver.findElement(this.getLocator(ElementName));
			if (!we.equals(null) || !we.equals("")) {
				if (!data.isEmpty()) {
					if (we.isEnabled() == true) {
						if (we.getAttribute("type") != null) {
							if (!we.getAttribute("type").equalsIgnoreCase("file")) // this line added for KR-5389
							{
								we.clear();
								// element = findElement(object,data);
								if (!we.getAttribute("value").isEmpty()) {
									Actions action = new Actions(driver);
									action.doubleClick(we).perform();
									we.sendKeys(Keys.DELETE);
								}
							}
						} else
							we.clear();
					}
					we.sendKeys(data);
					// element.sendKeys(Keys.chord(data));
				} else {
					if (we.isEnabled() == true) {
						we.clear();
					}
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			System.out.println(keyerrormsg);
			APP_LOGS.info("keyerrormsg=" + keyerrormsg);
			return false;
		}
	}

	
public boolean type_custom(WebElement we, String data) throws IOException
	
	{
		
		Properties configProp = loadPropertyFile(System.getProperty("user.dir") + "\\src\\main\\java\\objects\\object.properties");
		System.out.println("Data--->>" + data);
		try {
			
			
			
			if (!we.equals(null) || !we.equals("")) {
				if (!data.isEmpty()) {
					if (we.isEnabled() == true) {
						if (we.getAttribute("type") != null) {
							if (!we.getAttribute("type").equalsIgnoreCase("file")) // this line added for KR-5389
							{
								we.clear();
								// element = findElement(object,data);
								if (!we.getAttribute("value").isEmpty()) {
									Actions action = new Actions(driver);
									action.doubleClick(we).perform();
									we.sendKeys(Keys.DELETE);
								}
							}
						} else
							we.clear();
					}
					we.sendKeys(data);
					// element.sendKeys(Keys.chord(data));
				} else {
					if (we.isEnabled() == true) {
						we.clear();
					}
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			System.out.println(keyerrormsg);
			APP_LOGS.info("keyerrormsg=" + keyerrormsg);
			return false;
		}
	}

	
	
	
	
	
	
	public boolean isDisplayed(WebDriver driver, String selector) {
		try {
			WebElement we = driver.findElement(By.xpath(selector));
			if (we.isDisplayed()) {
				System.out.println("Element is displayed");
				return true;
			} else {
				return false;
			}
		} catch (Throwable e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			System.out.println(keyerrormsg);
			return false;
		}
	}

	
	public boolean isDisplayed_Custom(WebElement we) {
		try {
			
			if (we.isDisplayed()) {
				System.out.println("Element is displayed");
				return true;
			} else {
				return false;
			}
		} catch (Throwable e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			System.out.println(keyerrormsg);
			return false;
		}
	}
	
	public boolean verifyElementPresent(WebDriver driver, String selector) {
		try {
			WebElement we = driver.findElement(By.xpath(selector));
			APP_LOGS.info("Element exists");
			System.out.println("Element exists");
			return true;
		} catch (NoSuchElementException e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			System.out.println(keyerrormsg);
			APP_LOGS.info("Element does not exists");
			System.out.println("Element does not exists");
			return false;
		}
	}

	
	
	public boolean verifyElementPresent_custom(WebElement element) {
		try {
			element.isDisplayed();
			
			APP_LOGS.info("Element exists");
			System.out.println("Element exists");
			return true;
		} catch (NoSuchElementException e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			System.out.println(keyerrormsg);
			APP_LOGS.info("Element does not exists");
			System.out.println("Element does not exists");
			return false;
		}
	}

	
	
	
	
	public boolean openNewTab(WebDriver driver) {
		try {
			int oldwindowsize = 0;
			int newwindowsize = 0;
			
			Set<String> all_Window = driver.getWindowHandles();
			
			oldwindowsize = all_Window.size();
			
			APP_LOGS.info("Before opening Window size is :" + oldwindowsize);
			
			((JavascriptExecutor) driver).executeScript("window.open();");
			
			Set<String> all_Window_new = driver.getWindowHandles();
			
			newwindowsize = all_Window_new.size();
			
			APP_LOGS.info("After opening Window size is  :" + newwindowsize);
			if (newwindowsize > oldwindowsize) 
			{
				APP_LOGS.info("Open new tab is passed");
				return true;
			} else {
				APP_LOGS.info("Open new tab is failed");
				return false;
			}
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
			APP_LOGS.info("openNewTab has issue");
			return false;
		}
	}

	public boolean DragAndDrop(WebDriver driver, String selector1, String selector2) {
		APP_LOGS.info("DragAndDrop");
		try {
			WebElement From = driver.findElement(By.xpath(selector1));
			WebElement To = driver.findElement(By.xpath(selector1));
			/*
			 * Thread.sleep(3000); Actions builder = new Actions(driver); Action action =
			 * builder.moveToElement(dragElement).build(); action.perform();
			 * Thread.sleep(3000); action=builder.clickAndHold(dragElement).build();
			 * action.perform(); Thread.sleep(3000); action =
			 * builder.moveToElement(dropElement).build(); action.perform();
			 * Thread.sleep(3000);
			 */
			/*
			 * //Element which needs to drag. WebElement
			 * From=driver.findElement(By.xpath("//*[@id='credit2']/a")); //Element on which
			 * need to drop. WebElement
			 * To=driver.findElement(By.xpath("//*[@id='bank']/li"));
			 */
			// Using Action class for drag and drop.
			Actions act = new Actions(driver);
			// Dragged and dropped.
			act.dragAndDrop(From, To).build().perform();
			return true;
		} catch (Exception e) {
			keyerrormsg = "DragAndDrop exception :" + e.getMessage().split("\n")[0];
			APP_LOGS.info(keyerrormsg);
			if (e.getClass().getName().contains("WebDriverException"))
				if (e.getMessage().contains("Cannot press more then one button or an already pressed button")) {
					WebElement From = driver.findElement(By.xpath(selector1));
					Actions builder = new Actions(driver);
					Action action = builder.moveToElement(From).release(From).build();
					action.perform();
				}
			return false;
		}
	}

	/*
	 * public boolean pushObjectTextToDB(WebDriver driver, String selector, String
	 * data) { try { // TQA- Created for MTM Class
	 * APP_LOGS.info("In pushObjectTextToDB"); String ObjectText; String Key;
	 * Boolean Flag; //String Env = getRunOnEnviroment(); Flag=false; String[]
	 * TempObject = object.split("\\|"); for (int val = 0; val < TempObject.length;
	 * val++) { APP_LOGS.info("TempObject Value : " + TempObject[val]); } WebElement
	 * we = driver.findElement(By.xpath(selector)); //element =
	 * findElement(TempObject[0],data); // ObjectText =
	 * element.getAttribute("value") ObjectText = we.getText(); if
	 * (!ObjectText.equals("")) { APP_LOGS.info("Object text is: " + ObjectText);
	 * Flag=true; } else { ObjectText=we.getAttribute("value");
	 * if(!ObjectText.equals("")) { APP_LOGS.info("Object text is: " + ObjectText);
	 * Flag=true; } } Scanner first = new Scanner(System.in); String f =
	 * first.nextLine(); Scanner last = new Scanner(System.in); String l =
	 * last.nextLine(); Class.forName("com.mysql.jdbc.Driver"); // STEP 3: Open a
	 * connection System.out.println("Connecting to a selected database...");
	 * DriverManager.setLoginTimeout(20); String dbUrl =
	 * "jdbc:mysql://127.0.0.1/automation"; //Database Username String username =
	 * "root"; //Database Password String password = "faridabad"; //Query to Execute
	 * //String query = "select *  from employee;"; //String query1 =
	 * " INSERT INTO testcase (TestCaseDesc)VALUES (?)"; String query1 =
	 * " INSERT INTO testcase (TempGBValye)VALUES ('\" + ObjectText+ \"')";
	 * Connection con = DriverManager.getConnection(dbUrl,username,password);
	 * //ResultSet rs= stmt.executeQuery(query1); PreparedStatement preparedStmt =
	 * con.prepareStatement(query1); //String SQL = "INSERT INTO testcase VALUES ('"
	 * + ObjectText+ "')"; //st.executeUpdate(SQL); //PreparedStatement ps =
	 * conn.prepareStatement("INSERT INTO test VALUES (?, ?)");
	 * preparedStmt.setString(1, ObjectText); preparedStmt.executeUpdate();
	 * //updateValuetoDB(TempObject[1],ObjectText); } catch(Exception e){
	 * keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
	 * APP_LOGS.info(keyerrormsg); return false; } return true; }
	 */
	public boolean executesqlandverifytext() {
		try {
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
			String query = "select *  from testcase;";
			// String query1 = " INSERT INTO employee (AGE,Name)VALUES (4341,'Praveen1')";
			Connection con = DriverManager.getConnection(dbUrl, username, password);
			// Create Statement Object
			Statement stmt = con.createStatement();
			// stmt.executeUpdate(query1);
			System.out.println(" SUCCESS!\n");
			// Execute the SQL Query. Store results in ResultSet
			ResultSet rs = stmt.executeQuery(query);
			// While Loop to iterate through all data and print results
			while (rs.next()) {
				String TestCaseID = rs.getString(1);
				String TestCaseDesc = rs.getString(2);
				System.out.println("Test Case Description of Test Case ID" + TestCaseID + " are :" + TestCaseDesc);
			}
			con.close();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			// keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
			e.printStackTrace();
			return false;
		} // end finally try
	}

	public boolean insertsql(String data) {
		String TempData1 = data.split("\\|")[0];
		try {
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
			String query1 = " INSERT INTO testcase (TestCaseDesc )VALUES (?)";
			Connection con = DriverManager.getConnection(dbUrl, username, password);
			// ResultSet rs= stmt.executeQuery(query1);
			PreparedStatement preparedStmt = con.prepareStatement(query1);
			preparedStmt.setString(1, TempData1);
			// execute the preparedstatement
			preparedStmt.execute();
			Statement stmt = con.createStatement();
			// System.out.println(" SUCCESS!\n");
			// String query2 = " SELECT TestCaseID FROM testcase WHERE TestCaseID = (SELECT
			// MAX(TestCaseID) FROM testcase)";
			String query2 = "SELECT max( TestCaseID ) FROM `testcase`";
			// Execute the SQL Query. Store results in ResultSet
			ResultSet rs = stmt.executeQuery(query2);
			// while (rs.next())
			{
				// int name = rs.getInt(1);
				// System.out.println("Max Run id is:"+name);
			}
			// While Loop to iterate through all data and print results
			while (rs.next()) {
				/*
				 * String TestCaseID = rs.getString(1); String TestCaseDesc = rs.getString(2);
				 * System. out.println("Test Case Description of Test Case ID are :"); System.
				 * out.println(TestCaseID+" : "+TestCaseDesc);
				 */
				// closing DB Connection
				// con.close();
				System.out.println(" SUCCESS! TESTCASE DESC " + TempData1 + "  and Test Case ID " + rs.getString(1)
						+ " inserted successfully \n");
			}
			con.close();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			// keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
			e.printStackTrace();
			return false;
		} // end finally try
	}

	public static String getlastRunid() {
		String name = null;
		try {
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
			Connection con = DriverManager.getConnection(dbUrl, username, password);
			// System.out.println(" SUCCESS!\n");
			// String query2 = " SELECT TestCaseID FROM testcase WHERE TestCaseID = (SELECT
			// MAX(TestCaseID) FROM testcase)";
			String query2 = "SELECT max( TestCaseID ) FROM `testcase`";
			Statement stmt = con.createStatement();
			// Execute the SQL Query. Store results in ResultSet
			ResultSet rs = stmt.executeQuery(query2);
			while (rs.next()) {
				// name = rs.getInt(1);
				name = rs.getString(1);
				System.out.println("Latest Run id is:" + name);
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			// keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
			e.printStackTrace();
		} // end finally try
		return name;
	}

	public boolean openBrowser(String object, String data) {
		APP_LOGS.info("Inside openBrowser");
		try {
			if (browsername.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browsername.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("InternetExplorer")) {
				driver = new InternetExplorerDriver();
			} else if (browsername.equalsIgnoreCase("Safari")) {
				driver = new SafariDriver();
			} else {
				APP_LOGS.debug(object + " Browser does not support");
				return false;
			}
			return true;
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
			return false;
		}
	}

	public boolean navigateURL(String object, String data) {
		try {
			APP_LOGS.info("In Navigate URL Keyword");
			// String URL=list.get(2);
			String URL = data;
			System.out.println("URL......." + URL);
			String concatenateURL = URL;
			String finalURL = concatenateURL.replace("////", "//");
			System.out.println("finalURL......" + finalURL);
			driver.navigate().to(finalURL);
			status = true;
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
			status = false;
		}
		return status;
	}

	public boolean getDownloadedFileDetails(String data) {
		try {// TQA-373
			/*
			 * FileInputStream fileConfig = new FileInputStream(
			 * System.getProperty("user.dir") + "//Config//config.properties"); CONFIG = new
			 * Properties(); APP_LOGS.info("Initialize ==> Starts1" + fileConfig);
			 * CONFIG.load(fileConfig);
			 */
			// downloadPath=CONFIG.getProperty("Reportsharepath");
			APP_LOGS.info("In GetDownloadedFileDetails");
			String path = "";
			// data = data.replaceAll("\\", "\");
			if (data.equalsIgnoreCase(downloadPath)) {
				path = downloadPath;
			} else {
				path = downloadPath;
			}
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			// folder.
			// Set<String> FileName = new HashSet<String>();
			String itrFileName = null;
			listOfFiles = folder.listFiles();
			int NoOfFiles = listOfFiles.length;
			APP_LOGS.info("NoOfFiles" + NoOfFiles);
			for (int i = 0; i < listOfFiles.length; i++) {
				itrFileName = listOfFiles[i].getName();
				if (listOfFiles[i].isFile()) {
					DownloadedFiles.add(itrFileName);
					APP_LOGS.info("DownloadedFiles-->" + itrFileName);
				} else if (listOfFiles[i].isDirectory()) {
					APP_LOGS.info("Directory " + listOfFiles[i].getName());
				}
			}
			APP_LOGS.info("GetDownloadedFileDetails Executed");
			return true;
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
			return false;
		}
	}

	public String getLastDownloadedFile(String data) {
		String Key = "";
		String Value = "";
		try {// TQA-373 modified for
			APP_LOGS.info("In GetLastDownloadedFile");
			String path = "";
//String[] Tempdata = data.split("\\|");
//if(Tempdata.length==2)
//{
			/*
			 * if(Tempdata[1].equalsIgnoreCase("GetLastDownloadedFile")) path=downloadPath;
			 * }
			 */
			if (data.equalsIgnoreCase("GetLastDownloadedFile")) {
				path = downloadPath;
			}
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
// folder.
// Set<String> FileName = new HashSet<String>();
//String itrFileName = null;
			listOfFiles = folder.listFiles();
			int NoOfFiles = listOfFiles.length;
			if (DownloadedFiles.size() <= NoOfFiles) {
				for (int i = 0; i < NoOfFiles; i++) {
					itrFileName = listOfFiles[i].getName();
					if (listOfFiles[i].isFile()) {
						if (!DownloadedFiles.contains(itrFileName)) {
							DownloadedFiles.add(itrFileName);
							break;
						}
					} else if (listOfFiles[i].isDirectory()) {
						APP_LOGS.info("Directory " + listOfFiles[i].getName());
					}
				}
				// setRunTimeVariable("GetLastDownloadedFile", itrFileName);
				if (itrFileName == null) {
					itrFileName = "";
					keyerrormsg = "No File Downloaded";
					APP_LOGS.info(keyerrormsg);
					// return false;
				}
				APP_LOGS.info("In setRunTimeVariable ");
				runTimeVariable.put(Key, Value);
				APP_LOGS.info("In setRunTimeVariable Key: " + Key + " Value: " + Value + "added successfully");
				setRunTimeVariable(data, itrFileName);
				APP_LOGS.info("GetLastDownloadedFile name is " + itrFileName);
				// return true;
			} else {
				APP_LOGS.info("No File Downloaded");
//	return false;
			}
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
//return itrFileName;
		}
		return itrFileName;
	}

	public void configInitialize() throws IOException {
		APP_LOGS.info("Initialize config File ==> Starts");
		System.out.println("Initializing config File ==> Starts");
		FileInputStream fileConfig = new FileInputStream(
				System.getProperty("user.dir") + "//Config//config.properties");
		CONFIG = new Properties();
		APP_LOGS.info("Initialize ==> Starts1" + fileConfig);
		CONFIG.load(fileConfig);
		// int size=CONFIG.size();
		APP_LOGS.info("DB URL===>" + CONFIG.getProperty("DB_URL"));
//	APP_LOGS.info("USERNAME===> " + CONFIG.getProperty("USERNAME"));
//	APP_LOGS.info("PASSWORD===>" + CONFIG.getProperty("PASSWORD"));
		// APP_LOGS.info("AjaxendcallRetry_Attempts===>" +
		// CONFIG.getProperty("AjaxendcallRetry_Attempts "));
		// APP_LOGS.info("CheckForAjaxwaitloopClearForce===>" +
		// CONFIG.getProperty("CheckForAjaxwaitloopClearForce"));
		// APP_LOGS.info("CheckForAjaxwaitloopGFE===>" +
		// CONFIG.getProperty("CheckForAjaxwaitloopGFE"));
		// APP_LOGS.info("CheckForAjaxwaitloopMTM===>" +
		// CONFIG.getProperty("CheckForAjaxwaitloopMTM"));
		/*
		 * APP_LOGS.info("CheckForAjaxwaitloop===>" + CheckForAjaxwaitloop);
		 * APP_LOGS.info("Random Value Length===>" + randomValueLength);
		 * APP_LOGS.info("Random String Type===>" + randomCharacterType);
		 */
		// randomValueLength=Integer.parseInt(CONFIG.getProperty("RandomValuelength"));
		// randomCharacterType=CONFIG.getProperty("RandomStringType");
		// offSetVal=CONFIG.getProperty("offSetVal");
		// continueonKeyword=CONFIG.getProperty("continueonKeyword").split("\\|");
		APP_LOGS.info("Initialize config File ==> Ends");
	}

	public String preInitialize() throws Exception {
		/*
		 * if(CONFIG.getProperty("runlocation").equalsIgnoreCase("server")) {
		 * downloadPath = CONFIG.getProperty("Reportsharepath"); uploadPath=
		 * CONFIG.getProperty("Reportsharepath");
		 * screenshotPath=CONFIG.getProperty("Reportsharepath");
		 * sqlresultPath=CONFIG.getProperty("Reportsharepath"); }
		 */
		/*
		 * else {
		 */
		downloadPath = System.getProperty("user.dir");
		uploadPath = System.getProperty("user.dir");
		screenshotPath = System.getProperty("user.dir");
		sqlresultPath = System.getProperty("user.dir");
		/* } */
		downloadPath = downloadPath + "\\AutomationNG_Reports\\Reports\\Downloads";
		/*
		 * uploadPath=uploadPath +"\\AutomationNG\\Upload\\";
		 * screenshotPath=screenshotPath+
		 * "\\AutomatioNG_Reports\\Reports\\Test_RunId\\Screenshots\\";
		 * sqlresultPath=sqlresultPath+
		 * "\\AutomatioNG_Reports\\Reports\\Test_RunId_\\SqlResults\\";
		 */
		File dpath = new File(downloadPath);
		if (!dpath.exists()) {
			if (!dpath.mkdirs()) {
				APP_LOGS.debug("download folder not able to create");
			}
		}
		File spath = new File(screenshotPath);
		if (!spath.exists()) {
			if (!spath.mkdirs()) {
				APP_LOGS.debug("screenshotPath folder not able to create");
			}
		}
		File srpath = new File(sqlresultPath);
		if (!srpath.exists()) {
			if (!srpath.mkdirs()) {
				APP_LOGS.debug("sqlresultPath folder not able to create");
			}
		}
		return downloadPath;
	}

	public void setRunTimeVariable(String Key, String Value) {// TQA-348
		try {
			APP_LOGS.info("In setRunTimeVariable ");
			runTimeVariable.put(Key, Value);
			APP_LOGS.info("In setRunTimeVariable Key: " + Key + " Value: " + Value + "added successfully");
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
		}
	}

	public void setRunTimeVariableMap(String Key, HashMap<String, String> Value) {// TQA-348
		try {
			APP_LOGS.info("In setRunTimeVariableMap ");
			runTimeVariableMap.put(Key, Value);
			APP_LOGS.info("In setRunTimeVariable Key: " + Key + " Value: " + Value + "added successfully");
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
		}
	}

	public String getRunTimeVariable(String Key) {// TQA-365
		String KeyValue;
		try {
			APP_LOGS.info("In getRunTimeVariable");
			if (runTimeVariable.containsKey(Key)) {
				if (runTimeVariable.get(Key) != null)
					KeyValue = runTimeVariable.get(Key).toString();
				else
					KeyValue = "";
				APP_LOGS.info("Data value for the key(" + Key + ") is " + KeyValue);
			} else {
				KeyValue = "";
				APP_LOGS.info("No data is capture for this key =" + Key);
			}
			return KeyValue;
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
			KeyValue = "";
			return KeyValue;
		}
	}

	public Map getRunTimeVariableMap(String Key) {// TQA-365
		Map KeyValue;
		try {
			APP_LOGS.info("In getRunTimeVariableMap");
			if (runTimeVariableMap.containsKey(Key)) {
				if (runTimeVariableMap.get(Key) != null)
					KeyValue = runTimeVariableMap.get(Key);
				else
					KeyValue = null;
				APP_LOGS.info("Data value for the key(" + Key + ") is " + KeyValue);
			} else {
				KeyValue = null;
				APP_LOGS.info("No data is capture for this key =" + Key);
			}
			return KeyValue;
		} catch (Exception e) {
			keyerrormsg = e.getMessage().split("\n")[0].split("<")[0];
			APP_LOGS.info(keyerrormsg);
			KeyValue = null;
			return KeyValue;
		}
	}

	/*
	 * public String getfiledownloadlocation(String w) throws IOException { File
	 * fileLocation = new File(w); //File fileLocation1 = new
	 * File(fileLocation.getName()); String fileLocationPath = null;
	 * if(fileLocation.exists()) { fileLocationPath = fileLocation.getPath();
	 * fileLocationPath = fileLocation.getAbsolutePath(); fileLocationPath =
	 * fileLocation.getCanonicalPath(); } else{ throw new
	 * FileNotFoundException("File with name "+w+" may not exits at the location");
	 * } return fileLocationPath; }
	 */
	public boolean addeditTextinExcel(String filepath, String fileName, String sheetName, int ColNumber, int RowNumber,
			String dataToWrite) throws IOException {
		try {
			XSSFRow row = null;
			XSSFCell cell = null;
			String xlFilePath = null;
			FileOutputStream fos = null;
			// Get the excel file.
			FileInputStream file = new FileInputStream(new File(filepath + "\\" + fileName));
			// Get workbook for XLS file.
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get first sheet from the workbook.
			// If there have >1 sheet in your workbook, you can change it here IF you want
			// to edit other sheets.
			XSSFSheet sheet = workbook.getSheetAt(0);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(RowNumber);
			if (row == null)
				row = sheet.createRow(RowNumber);
			cell = row.getCell(ColNumber);
			if (cell == null)
				cell = row.createCell(ColNumber);
			cell.setCellValue(dataToWrite);
			fos = new FileOutputStream(new File(filepath + "\\" + fileName));
			workbook.write(fos);
			System.out.println(dataToWrite + "added successfully at Column Number-> " + ColNumber + " and Row Number ->"
					+ RowNumber);
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean getallmethodlist() {
		try {
			Class<BasePage> c = BasePage.class;
			Method[] m = c.getDeclaredMethods();
//      for (int i = 0; i < m.length; i++)
//    System.out.println(m[i].toString());
			for (Method method : m) {
				System.out.println("Methods are :--" + method.getName());
			}
			// public boolean insertsql(String data)
			// {
			// String TempData1 = data.split("\\|")[0];
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
			// String query1 = " INSERT INTO keyword (Keywordname )VALUES (?)";
			String query1 = "select *  from keyword;";
			Connection con = DriverManager.getConnection(dbUrl, username, password);
			Statement stmt = con.createStatement();
			// stmt.executeUpdate(query1);
			System.out.println(" SUCCESS!\n");
			// Execute the SQL Query. Store results in ResultSet
			ResultSet rs = stmt.executeQuery(query1);
			// While Loop to iterate through all data and print results
			while (rs.next()) {
				String id = rs.getString(1);
				String Keywordname = rs.getString(2);
				System.out.println("Keywords of ID--->" + id + " are :" + Keywordname);
			}
			con.close();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			// keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
			e.printStackTrace();
			return false;
		} // end finally try
	}
	/*
	 * public boolean verifyCSVColumnTextWithPPT (String data,String data1)throws
	 * InterruptedException, Exception { //CA-4566 for pulse //This keyword is to
	 * compare the text available in the Source-Downloaded csv(i.e.text on a
	 * specific column and Row ) with Destination -Downloaded PPT File. String[]
	 * TempData = data.split("\\|"); int intSlideCount = 0; int intSlideNo = 0;
	 * boolean blnFlag = true; try { String Result = "Fail"; int Fail = 0; int
	 * passCount=0; String sColumnName=""; String sDataFromFile=""; String
	 * ssDataFromFile=""; int sRowNumber=0; int eRowNumber=0; int k=0; int
	 * sHeaderIndex=0; ArrayList<String> al1= new ArrayList<String>();
	 * //ArrayList<String> al3= new ArrayList<String>(); //Print CSV
	 * Data************************* FileReader fileReader=null; fileReader = new
	 * FileReader(new File(TempData[0])); //column name or header name sColumnName =
	 * TempData[1]; //Start Row Number to verify
	 * sRowNumber=Integer.parseInt(TempData[2]); //End Row Number to verify
	 * eRowNumber=Integer.parseInt(TempData[3]);
	 * APP_LOGS.info("Reading CSV File --> "+ TempData[0]);
	 * System.out.println("Reading CSV File --> "+ TempData[0]); CSVReader reader =
	 * new CSVReader(fileReader); //this will load content into list List<String[]>
	 * list=reader.readAll(); //get all data from first row to string array String[]
	 * str1=list.get(0); //get index of column name
	 * if(Arrays.asList(str1).contains(sColumnName)) { sHeaderIndex=
	 * Arrays.asList(str1).indexOf(sColumnName); for (
	 * k=sRowNumber;k<=eRowNumber;k++) { String[] sGetFullRow=list.get(k); //get
	 * data from desired column and row to verify
	 * sDataFromFile=sGetFullRow[sHeaderIndex]; passCount++; al1.add(sDataFromFile);
	 * } //Print data from desired column and row number for(String item : al1) {
	 * System.out.println("Data present in CSV in Column->"
	 * +TempData[1]+" between  Row Number  ->"+ TempData[2]+" and -->"
	 * +TempData[3]+" are --> "+ item );
	 * APP_LOGS.info("Data present in CSV in Column->"
	 * +TempData[1]+" between  Row Number  ->"+ TempData[2]+" and -->"
	 * +TempData[3]+" are --> "+ item); } } //Print PPT
	 * Data************************* int datacount = StringUtils.countMatches(data,
	 * "|"); // LastDownLoadFile if (data.contains("GetLastDownloadedFile")) {
	 * if(data.toLowerCase().startsWith("downloadfolder")) data = downloadPath +
	 * "\\"+getRunTimeVariable("GetLastDownloadedFile"); else
	 * if(TempData[4].toLowerCase().startsWith("uploadfolder")) data =uploadPath +
	 * "\\"+getRunTimeVariable("GetLastDownloadedFile"); } HSLFSlideShow ppt = new
	 * HSLFSlideShow(new FileInputStream(TempData[4]));
	 * APP_LOGS.info("Reading PPT File --> "+ TempData[4]);
	 * System.out.println("Reading PPT File --> "+ TempData[4]);
	 * while(intSlideNo<=6) { if (intSlideNo==Integer.parseInt(data1)) { for
	 * (HSLFSlide slide : ppt.getSlides()) { //intSlideCount++; List<HSLFShape>
	 * shapes = slide.getShapes(); for (HSLFShape shape : shapes) { String name =
	 * shape.getShapeName(); if (shape instanceof HSLFTextShape) { HSLFTextShape
	 * txShape = (HSLFTextShape) shape; for (HSLFTextParagraph xslfParagraph :
	 * txShape.getTextParagraphs()) {
	 * System.out.println(" The Shapes in PPT in slide number--> "+TempData[5]
	 * +"--> are -->"+ name);
	 * APP_LOGS.debug(" The Shapes in PPT in slid number--> "+ TempData[5]
	 * +" -->are -->"+ name ); String originalText = txShape.getRawText(); String
	 * originalTextnew = originalText.replace("%", "").trim(); ArrayList<String>
	 * al2= new ArrayList<String>(); al2.add(originalTextnew); for(String item :
	 * al2) { System.out.println("  Data in shape --> "+name+
	 * "in slide number  ---> " + TempData[5]+"  -->  is -->" +item);
	 * APP_LOGS.debug("  Data in shape --> "+name+ " in slide number--> "+
	 * TempData[5] +"  --->    is -->" +item ); }//end of for
	 * //********************************************* //Comparing csv data with ppt
	 * data //Storing the comparison output in ArrayList<String> ArrayList<String>
	 * al3= new ArrayList<String>(); for (String temp : al1) {
	 * al3.add(al2.contains(temp) ? "Pass" : "Fail"); }
	 * System.out.println("Data Comparison between Csv data -->"
	 * +al1+" and PPT data -->"+al2+" is -->"+al3);
	 * APP_LOGS.debug("Data Comparison between Csv data -->"+al1+" and PPT data-->"
	 * +al2+" is ---> "+al3); if (al3.contains("Pass")) {
	 * System.out.println("Data Comparison between csv and ppt is passed");
	 * APP_LOGS.debug("Data Comparison between csv and ppt is passed "); Result =
	 * "Pass"; } else {
	 * System.out.println("Data Comparison between csv and ppt is failed");
	 * APP_LOGS.debug("Data Comparison between csv and ppt is failed"); } }//end of
	 * para }//end of if }//end of shape }//end of slide }//end of if else {
	 * System.out.println("Navigating to slide--->"+TempData[5]); } intSlideNo++;
	 * }//end of while return true; } catch (Exception e) {
	 * keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
	 * APP_LOGS.info(keyerrormsg); return false; } }
	 */
}
/*
 * // Get the row of your desired cell. // Let's say that your desired cell is
 * at row 2. Row row = sheet1.getRow(1); // Get the column of your desired cell
 * in your selected row. // Let's say that your desired cell is at column 2.
 * Cell column = row.getCell(1); // If the cell is String type.If double or else
 * you can change it. String updatename = column.getStringCellValue(); //New
 * content for desired cell. updatename="Lala"; //Print out the updated content.
 * System.out.println(updatename); //Set the new content to your desired
 * cell(column). column.setCellValue(updatename); //Close the excel file.
 * file.close(); //Where you want to save the updated sheet. FileOutputStream
 * out = new FileOutputStream(new
 * File("(where you want to save?.Put the path here)"));
 * yourworkbook.write(out); out.close(); } catch (FileNotFoundException e) {
 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
 */
/*
 * public boolean addeditTextinExcel( String data) { try { // TQA- Created for
 * MTM Class APP_LOGS.info("In addeditTextinExcel"); // write a text to a column
 * . String[] TempData=data.split("\\|"); String[]
 * TempDescColdata=TempData[2].split("\\`"); String[]
 * searchColdata=TempData[3].split("\\`"); String[] replaceColdata =null ;
 * IXLReader srcXls=null; if(TempData.length>=5)
 * replaceColdata=TempData[4].split("\\`"); int[] TempDescColdataint = new
 * int[TempDescColdata.length] ; File f=new File(TempData[0]); if(!f.exists())
 * Xls_Write.createBlankXLSFile(TempData[0],TempData[1]);
 * if(TempData[0].endsWith(".xls")) { // XL_Reader srcXls=null; srcXls=new
 * XL_Reader(TempData[0]); }else { // Xls_Reader srcXls=null; srcXls=new
 * Xls_Reader(TempData[0]); } for(int i=0; i<TempDescColdata.length;i++) { try {
 * TempDescColdataint[i]=Integer.parseInt(TempDescColdata[i]); }catch (Exception
 * e) { boolean colExist = srcXls.checkColExist(TempDescColdata[i],
 * TempData[1],srcXls); if (!colExist) { synchronized (this) {
 * srcXls.addColumn(TempData[1], TempDescColdata[i]); } } } } int Cpass=0;
 * for(int i=0; i<TempDescColdata.length;i++) { int Jpass=0; for(int j=0;
 * j<searchColdata.length;j++) { int WRow=0; try {
 * TempDescColdataint[i]=Integer.parseInt(TempDescColdata[i]); WRow =
 * srcXls.getCellRowNum( TempData[1], TempDescColdataint[i], searchColdata[j]);
 * }catch (Exception e) { WRow = srcXls.getCellRowNum( TempData[1],
 * TempDescColdata[i], searchColdata[j]); } if (WRow != -1) { // update the if
 * data matched synchronized (this) { try {
 * TempDescColdataint[i]=Integer.parseInt(TempDescColdata[i]);
 * if(TempData.length>=5) if(j<replaceColdata.length)
 * {if(!replaceColdata[j].isEmpty()) srcXls.setCellDataRW(TempData[1],
 * TempDescColdataint[i], WRow, replaceColdata[j]); else
 * srcXls.setCellDataRW(TempData[1], TempDescColdataint[i], WRow, ""); }else
 * srcXls.setCellDataRW(TempData[1], TempDescColdataint[i], WRow, ""); Jpass++;
 * }catch(Exception e) {if(TempData.length>=5) if(j<replaceColdata.length)
 * {if(!replaceColdata[j].isEmpty()) srcXls.setCellDataRW(TempData[1],
 * TempDescColdata[i], WRow, replaceColdata[j]); else
 * srcXls.setCellDataRW(TempData[1], TempDescColdata[i], WRow, ""); }else
 * srcXls.setCellDataRW(TempData[1], TempDescColdata[i], WRow, ""); Jpass++; } }
 * } else { synchronized (this) { try {
 * TempDescColdataint[i]=Integer.parseInt(TempDescColdata[i]);
 * WRow=srcXls.getlastCellNum(TempData[1],TempDescColdataint[i]); WRow++;
 * srcXls.setCellDataRW(TempData[1], TempDescColdataint[i], WRow,
 * searchColdata[j]); Jpass++; }catch(Exception e) {
 * WRow=srcXls.getlastCellNum(TempData[1],TempDescColdata[i]); WRow++;
 * srcXls.setCellDataRW(TempData[1], TempDescColdata[i], WRow,
 * searchColdata[j]); Jpass++; } } } } if(Jpass==searchColdata.length) Cpass++;
 * } if(Cpass==TempDescColdata.length) return true; else return false; } catch
 * (Exception e) { keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
 * APP_LOGS.info(keyerrormsg); return false; } }
 */
