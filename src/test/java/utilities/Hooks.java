package utilities;




import org.openqa.selenium.WebDriver;

import dataProviders.ConfigReader;
import driverFactory.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static WebDriver driver;
	private static DriverFactory driverfactory;
	static Scenario scenario;

	@BeforeAll
	public static void beforeAll() {
	    ConfigReader.loadProperty();
	    LoggerLoad.logInfo("Loading Config file");
		
		String browser = ConfigReader.getProperty("browserType");
		
		//Initialize driver from driver factory
		driverfactory = new DriverFactory();
		driver = driverfactory.initializeDrivers(browser);
		LoggerLoad.logInfo("Initializing driver for : "+browser);
	}
	
	@Before
	public void scenario(Scenario scenario) {
		LoggerLoad.logInfo("===============================================================================================");
		LoggerLoad.logInfo(scenario.getSourceTagNames() +" : "+scenario.getName());
		LoggerLoad.logInfo("-----------------------------------------------------------------------------------------------");
		
	}
	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			LoggerLoad.logError("Steps Failed , Taking Screenshot");
			/*final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));*/
		
		}
	}

	@AfterAll
	public static void after() {
		LoggerLoad.logInfo("Closing Driver");
		driverfactory.closeallDriver();
	}
}
