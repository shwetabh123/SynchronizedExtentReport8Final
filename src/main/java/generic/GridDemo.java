
	package generic;

	import java.net.MalformedURLException;
	import java.net.URL;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;

	public class GridDemo implements IAutoConst{

		public static void main(String[] args) throws MalformedURLException {
			
			URL sys=new URL("http://127.0.0.1:4444/wd/hub");
			DesiredCapabilities bro=new DesiredCapabilities();
			bro.setBrowserName("chrome");
			WebDriver driver=new RemoteWebDriver(sys,bro);
			
			driver.get("http://www.google.com");
			driver.close();
		}

	}













