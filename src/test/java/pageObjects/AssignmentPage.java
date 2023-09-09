package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;
import dataProviders.ConfigReader;

public class AssignmentPage extends BasePage{
	
	@FindBy (xpath="xpath for maanage assignment Title']")static WebElement manageAssignmentTitleElmt;
	@FindBy (xpath="xpath for maanage assignment Header']")static WebElement manageAssignmentheaderElmt;
	@FindBy (xpath="xpath for maanage assignment Header']")static WebElement    lmsheaderElmt;
@FindBys ( {
		
		@FindBy (xpath="xpath for student link']"),
		@FindBy (xpath="xpath for program link']"),
		@FindBy (xpath="xpath for Batchlink']"),
		@FindBy (xpath="xpath for Classlink']"),
		@FindBy (xpath="xpath for Userlink']"),
		@FindBy (xpath="xpath for Assignmentlink']"),
		@FindBy (xpath="xpath for Attendancelink']")
		
		
	})static List< WebElement> headerLinks;  
	
	
	public AssignmentPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public String verifyManageAssignmentPage() {
		return  manageAssignmentTitleElmt.getText();
	}

	public String verifyManageAssignmentPageHeader() {
		return  manageAssignmentheaderElmt.getText();
	}
	public String verifyLMSPageHeader() {
		return  lmsheaderElmt.getText();
	}
	public String textModuleLinks(String headerlink) {
		String textname = null;
		try {
			for (Iterator iterator = headerLinks.iterator(); iterator.hasNext();) {
				WebElement webElement = (WebElement) iterator.next();
				if (webElement.getText().contains(headerlink)) {
					 textname=webElement.getText();
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return textname;
	}
	
}
