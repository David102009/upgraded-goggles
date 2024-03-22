package Utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// singleton class -A singleton class is a class that can have only one object
	// at a time

	private static WebDriver driver; // this is an instance, here webdriver is our object the driver is null
										// we only want one

	public static WebDriver getDriver() {

		if (driver == null) {
			switch (BaseClass.getProperty("browser")) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break; // without break it will fall through and try to run fire fox

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "edge":

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			}

			driver.get(BaseClass.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constants.implicit_wait_time, TimeUnit.SECONDS);
			PageInitializer.initialize();

		}

		return driver;

	}

	public static void teardDown() {

		BaseClass.getDriver().quit();

	}

	private static Properties configFile;

	static {

		try {

			String filePath = Constants.configProperty_filePath;

			FileInputStream inputStream = new FileInputStream(filePath);

			configFile = new Properties();

			configFile.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);

	}

}
