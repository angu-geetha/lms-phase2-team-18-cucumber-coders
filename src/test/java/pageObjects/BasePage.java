package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigReader;
import driverFactory.DriverFactory;

public class BasePage {
	WebDriver driver=DriverFactory.getdriver();
	String loginURL=ConfigReader.getProperty("loginPage");
	
	@FindBy (xpath="xpath for User field']")static WebElement user;
	@FindBy (xpath="xpath for Password Field']")static WebElement pwd;
	
	public BasePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login_page() {

		driver.get(loginURL);

	}
	
	public void doLogin(String username, String password) {
		try {
		user.clear();
		user.sendKeys(username);
		pwd.clear();
		pwd.sendKeys(password);
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}

	public String verifyDashboardPage() {

		String Title = driver.getTitle();
		return Title;

	}


}
