package generic;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;
import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest implements IAutoConst {
	protected static WebDriver driver = null;
	public static int REPEAT_MINUS = 100;
	Logger APP_LOGS = Logger.getLogger("BaseTest");
	public static String scrshotFolderLoc;
//	public static String path ="D:\\ShwetabhWorkspace\\SynchronizedExtentReport3\\data\\preCondInput.xlsx";
	final static String workingDir = System.getProperty("user.dir");
	// final static String filePath = "./test-output/MyReport.html";
	final static String filePath = "\\test-output\\MyReport.html";
	public static String path = workingDir + filePath;
	static int testRunId = 000000;
	public static String logfiletimestamp;
	public static String downloadPath = null;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	private static ExtentHtmlReporter htmlReporter = null;

	public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> childTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> childTestnew = new ThreadLocal<ExtentTest>();

	public static Excel eLib = new Excel();

	@BeforeSuite
	public void beforeSuite() {
		// extent = ExtentManager.getExtentReport();
		htmlReporter = new ExtentHtmlReporter(workingDir + filePath);
		htmlReporter.config().setReportName("My Test Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setTheme(Theme.DARK);
		// htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");
		extent = new ExtentReports();
		extent.setSystemInfo("Platform", "Windows");
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public synchronized void beforeTest(XmlTest method) {
		ExtentTest tests = extent.createTest(method.getName());
		parentTest.set(tests);

	}

	@BeforeClass
	public synchronized void beforeClass(ITestContext result) {
		ExtentTest testclass = parentTest.get().createNode(getClass().getSimpleName());
		childTest.set(testclass);
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public synchronized void beforeMethod(Method method, String browser) throws Exception {

		ExtentTest testmethod = childTest.get().createNode(method.getName());
		childTestnew.set(testmethod);
		driver = getDriver(browser);
		driver.manage().window().maximize();
	}

	public static RemoteWebDriver getDriver(String browser) throws Exception {
		String fileName = null;
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MMMMM.yyyy.hh.mm");
		logfiletimestamp = "AutomationLog_TestRunId_" + format.format(d);
		System.setProperty("autologname", logfiletimestamp);
		PropertyConfigurator.configure("Log4j.properties");
		String browserType = eLib.getCellValue(path, "PreCon", 1, 1);
		return new RemoteWebDriver(new URL("http://192.168.2.4:4444/wd/hub"), getBrowserCapabilities(browser));

	}

	/**
	 * @param browser
	 * @return
	 * @throws Exception
	 */
	public static DesiredCapabilities getBrowserCapabilities(String browser) throws Exception {
		// DesiredCapabilities capability = null;

		switch (browser) {
		case "firefox":
			System.out.println("Opening firefox driver");

			/*
			 * // System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe"); String
			 * pathToBinary = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
			 * ProfilesIni profile = new ProfilesIni(); FirefoxProfile testProfile = new
			 * FirefoxProfile(); testProfile.setAcceptUntrustedCertificates(true);
			 * testProfile.setAssumeUntrustedCertificateIssuer(true); DesiredCapabilities
			 * dc= DesiredCapabilities.firefox();
			 * dc.setCapability("webdriver.gecko.driver","C:\\geckodriver.exe");
			 * dc.setCapability(FirefoxDriver.PROFILE, testProfile);
			 * dc.setCapability(FirefoxDriver.BINARY, pathToBinary); driver = new
			 * FirefoxDriver(dc); return DesiredCapabilities.firefox();
			 */

			// System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");

			DesiredCapabilities capability = new DesiredCapabilities().firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			// capability.setVersion("72");

			capability.setCapability("marionette", false);
			capability.setCapability("binary", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

			// capability.setCapability("job-name", "Fancy Firefox profile");
			/*
			 * FirefoxProfile profile = new FirefoxProfile();
			 * profile.setPreference("network.http.phishy-userpass-length", 255);
			 * capability.setCapability(FirefoxDriver.PROFILE, profile); FirefoxOptions
			 * firefox = new FirefoxOptions(); firefox.setCapability("marionette", false);
			 */

			return DesiredCapabilities.firefox();

		/*
		 * System.setProperty("webdriver.firefox.bin",
		 * "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); String
		 * Firefoxdriverpath = "C:\\geckodriver.exe";
		 * System.setProperty("webdriver.gecko.driver", Firefoxdriverpath);
		 * DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		 * capabilities.setCapability("marionette", true); driver = new
		 * FirefoxDriver(capabilities);
		 */

		/*
		 * FirefoxOptions firefox = new FirefoxOptions();
		 * firefox.setCapability("marionette", false); DesiredCapabilities capability =
		 * DesiredCapabilities.firefox(); capability.setBrowserName("firefox");
		 * capability.setPlatform(Platform.WINDOWS); capability.setVersion("72"); return
		 * DesiredCapabilities.firefox();
		 */

		case "chrome":
			System.out.println("Opening chrome driver");
			DesiredCapabilities capability1 = DesiredCapabilities.chrome();
			capability1.setBrowserName("chrome");
			capability1.setPlatform(Platform.ANY);
			ChromeOptions options1 = new ChromeOptions();
			// options.addArguments("--start-maximized");
			return DesiredCapabilities.chrome();

		case "internet explorer":
			System.out.println("Opening IE driver");
			DesiredCapabilities capability2 = new DesiredCapabilities().internetExplorer();

			capability2.setBrowserName("internet explorer");
			capability2.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			// capability2.setVersion("11");
			// capability2.setCapability("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			capability2.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capability2.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capability2.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capability2.setCapability("ignoreProtectedModeSettings", true);
			capability2.setCapability("nativeEvents", false);
			capability2.setCapability("acceptInsecureCerts", true);
			capability2.setCapability("acceptSslCerts", true);
			capability2.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capability2.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);

			return DesiredCapabilities.internetExplorer();

		default:
			System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
			return DesiredCapabilities.firefox();
		}

	}

	public static String getScreenshot(RemoteWebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			childTestnew.get().fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {

			childTestnew.get().skip(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			childTestnew.get().pass("Test Passed");
		}

		extent.flush();
		driver.close();

	}

	@AfterSuite
	public void testDown() {

	}

	@AfterClass
	public void afterClass() {

		extent.flush();
		// driver.close();

	}
}