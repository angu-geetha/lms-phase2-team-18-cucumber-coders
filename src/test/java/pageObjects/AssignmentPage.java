package pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
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



	@FindBy(xpath = ".//*[@id=\"id of the table\"]/table/thead/tr/th") static List<WebElement> tableHeaders;
	@FindBy(xpath = ".//*[@id=\"id of the table\"]/table/thead/tr") static List<WebElement> tablerows;


	static WebElement checkboxElmt;
	static WebElement asignmtName;
	static WebElement asignmtDesc;
	static WebElement asignmtDueDate;
	static WebElement asignmtGrade;
	static WebElement asignmtEditDelete;




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

	public boolean isTableHeadersPresent() {
		try {
			if(tableHeaders.size()>0)
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;

	}
	public String verifyTableHeaders(String headerlink) {
		String textname = null;



		return textname;
	}




	public Boolean verifyAddAssignmenthButton() {
		return addassignmentElmt.isDisplayed();
	}




	public void validateTableHeaders(Map<String, String> excelDataMap) {

		if(!tableHeaders.isEmpty() && tableHeaders.size() >0) {
			checkboxElmt = tableHeaders.get(0);
			asignmtName = tableHeaders.get(1);
			asignmtDesc = tableHeaders.get(2);
			asignmtDueDate = tableHeaders.get(3);
			asignmtGrade = tableHeaders.get(4);
			asignmtEditDelete = tableHeaders.get(5);

			if(checkboxElmt.isDisplayed() && checkboxElmt.getText().contains(excelDataMap.get("checkBox"))
					&&	asignmtName.isDisplayed() && asignmtName.getText().contains(excelDataMap.get("assignmentName"))
					&&	asignmtDesc.isDisplayed() && asignmtDesc.getText().contains(excelDataMap.get("assignmentDesc"))
					&&	asignmtDueDate.isDisplayed() && asignmtDueDate.getText().contains(excelDataMap.get("assignmentDueDate"))
					&&	asignmtGrade.isDisplayed() && asignmtGrade.getText().contains(excelDataMap.get("assignmentGrade"))
					&&	asignmtEditDelete.isDisplayed() && asignmtEditDelete.getText().contains(excelDataMap.get("editOrDelete"))
					) {
				assertTrue(true, "table has all headers");
			}
			else {
				assertTrue(false, "table has mismatch headers");
			}

		} else {
			assertTrue(false, "table has mismatch headers");
		}

	}

	public void validateEditIconForRows() throws Exception {
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));
				if(cells.size() > 0 && cells.get(5)!= null) {
					cells.get(5).findElement(By.id("id of the edit button")).isDisplayed();
				} else if(cells.size() > 0) {
					throw(new Exception("exception on row edit"));
				}

			}
		}catch (Exception e) {
			throw(new Exception("exception on row edit"));
		}


	}

	public void validateDeleteIconForRows() throws Exception {
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));
				if(cells.size() > 0 && cells.get(5)!= null) {
					cells.get(5).findElement(By.id("id of the Delete button")).isDisplayed();
				} else if(cells.size() > 0) {
					throw(new Exception("exception on row delete"));
				}

			}
		}catch (Exception e) {
			throw(new Exception("exception on row delete"));
		}
		
	}

	public void validateCheckBoxForRows() throws Exception {
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));
				if(cells.size() > 0 && cells.get(0)!= null) {
					cells.get(0).findElement(By.id("id of the Checkbox button")).isDisplayed();
					
				} else if(cells.size() > 0) {
					throw(new Exception("exception on row checkbox"));
				}

			}
		}catch (Exception e) {
			throw(new Exception("exception on row checkbox"));
		}
		
	}

	public void validateSortElmtForHeaders() {
		if(!tableHeaders.isEmpty() && tableHeaders.size() >0) {
			checkboxElmt = tableHeaders.get(0);
			asignmtName = tableHeaders.get(1);
			asignmtDesc = tableHeaders.get(2);
			asignmtDueDate = tableHeaders.get(3);
			asignmtGrade = tableHeaders.get(4);
			asignmtEditDelete = tableHeaders.get(5);

			if(asignmtName.findElement(By.id("sort element id")).isDisplayed()
					&& asignmtDesc.findElement(By.id("sort element id")).isDisplayed()
					&& asignmtDueDate.findElement(By.id("sort element id")).isDisplayed()
					&& asignmtGrade.findElement(By.id("sort element id")).isDisplayed()
					) {
				assertTrue(true, "table has sort icon in headers");
			}
			else {
				assertTrue(false, "table does not has sort icon in headers");
			}

		} else {
			assertTrue(false, "table does not has sort icon in headers");
		}
		
	}
	
	

}





