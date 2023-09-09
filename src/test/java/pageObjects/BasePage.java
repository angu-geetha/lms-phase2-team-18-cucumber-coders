package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigReader;
import driverFactory.DriverFactory;

public class BasePage {
	WebDriver driver=DriverFactory.getdriver();
	String loginURL=ConfigReader.getProperty("loginPageUrl");
	String dashboardUrl=ConfigReader.getProperty("dashboardUrl");
	
	
	@FindBy (xpath="xpath for User field']")static WebElement user;
	@FindBy (xpath="xpath for Password Field']")static WebElement pwd;
	
	@FindBys ( {
		
		@FindBy (xpath="xpath for student link']"),
		@FindBy (xpath="xpath for program link']"),
		@FindBy (xpath="xpath for Batchlink']"),
		@FindBy (xpath="xpath for Classlink']"),
		@FindBy (xpath="xpath for Userlink']"),
		@FindBy (xpath="xpath for Assignmentlink']"),
		@FindBy (xpath="xpath for Attendancelink']")
		
		
	})static List< WebElement> headerLinks;  
		
	
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
	
	public void dashboardPage() {
		driver.get(dashboardUrl);
		

	}

	
	
	public void selectModuleLinks(String headerlink) {

		try {
			for (Iterator iterator = headerLinks.iterator(); iterator.hasNext();) {
				WebElement webElement = (WebElement) iterator.next();
				if (webElement.getText().contains(headerlink)) {
					webElement.click();
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
		
	
	
	
	
}
