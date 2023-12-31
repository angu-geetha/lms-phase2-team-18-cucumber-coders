package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.cucumber.java.Scenario;

import utilities.LoggerLoad;


public class DriverFactory {

	public static WebDriver driver;

	public WebDriver initializeDrivers(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			LoggerLoad.logInfo("Testing on firefox");

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			LoggerLoad.logInfo("Testing on chrome");

//			WebDriverManager.chromedriver().browserVersion("108.0.0").setup();

			//WebDriverManager.chromedriver().browserVersion("108.0.0").setup();

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("safari")) {
			LoggerLoad.logInfo("Testing on safari");

//			WebDriverManager.safaridriver().setup();

			//WebDriverManager.safaridriver().setup();

			driver = new SafariDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			LoggerLoad.logInfo("Testing on Edge");

//			WebDriverManager.edgedriver().setup();

			//WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		}
		// Set Page load timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		return driver;
	}

	public static WebDriver getdriver() {
		return driver;

	}

	public void closeallDriver() {
		driver.close();
	}

}
