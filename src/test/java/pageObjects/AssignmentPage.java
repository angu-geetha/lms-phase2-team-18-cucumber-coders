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
	@FindBy (xpath="xpath for maanage LMS Header']")static WebElement    lmsheaderElmt;
	
	
	@FindBy (xpath="xpath for  addassignment button']")static WebElement    addassignmentElmt;
	@FindBy (xpath="xpath for  datatable ']")  static WebElement  datatableElement;
	
	
	@FindBy (xpath="xpath for  checkbox button']")static WebElement    checkboxElement;	
	
	
	
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
	
	
	
	
	public Boolean verifyAddAssignmenthButton() {
		boolean addassigbutton;
		return addassigbutton =addassignmentElmt.isDisplayed();
	}
	


public Boolean verifyDataTable() {
	boolean datatable;
	
	//return datatable =datatableElement.isd
	return true;
}
public String verifyColumnHeaders(String columnheaders) {
	String textname = null;
	/*	try {
	for (Iterator iterator = datatableElement.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			if (webElement.getText().contains(columnheaders)) {
				 textname=webElement.getText();
				break;
			}

		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	*/
		return "";
}


}
