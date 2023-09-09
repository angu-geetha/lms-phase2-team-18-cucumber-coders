package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;
import dataProviders.ConfigReader;

public class AssignmentPage extends BasePage{
	
	
	
	
	
	public AssignmentPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
}
