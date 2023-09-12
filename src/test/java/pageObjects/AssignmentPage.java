package pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
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

	@FindBy (xpath="xpath for  asignmtNameTxtBox")  static WebElement  asignmtNameTxtBox;
	@FindBy (xpath="xpath for  asignmtDescTxtBox")  static WebElement  asignmtDescTxtBox;
	@FindBy (xpath="xpath for  gradeByTxtBox")  static WebElement  gradeByTxtBox;
	@FindBy (xpath="xpath for  asignmtDueDateTxtBox")  static WebElement  asignmtDueDateTxtBox;
	@FindBy (xpath="xpath for  asignmtFile1TxtBox")  static WebElement  asignmtFile1TxtBox;
	@FindBy (xpath="xpath for  asignmtFile2TxtBox")  static WebElement  asignmtFile2TxtBox;
	@FindBy (xpath="xpath for  asignmtFile3TxtBox")  static WebElement  asignmtFile3TxtBox;
	@FindBy (xpath="xpath for  asignmtFile4TxtBox")  static WebElement  asignmtFile4TxtBox;
	@FindBy (xpath="xpath for  asignmtFile5TxtBox")  static WebElement  asignmtFile5TxtBox;
	@FindBy (xpath="xpath for  programOptions")  static List<WebElement> allProgramOptions;
	@FindBy (xpath="xpath for  programOptions")  static List<WebElement> allBatchOptions;

	@FindBy(xpath = "//div[@class='alert alert-primary']") WebElement errorElement;
	

	static WebElement checkboxElmt;
	static WebElement asignmtName;
	static WebElement asignmtDesc;
	static WebElement asignmtDueDate;
	static WebElement asignmtGrade;
	static WebElement asignmtEditDelete;
    String assignmentPageUrl = ConfigReader.getProperty("assignmentPageUrl");




	public AssignmentPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void assignment_page() {

		driver.get(assignmentPageUrl);

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


	public void clickAddNewButton() {
		addassignmentElmt.click();
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
  public void programDropdownOptions(String programName) {
	 for (int i = 0; i < allProgramOptions.size(); i++) {
		 if (allProgramOptions.get(i).getText().contains(programName)) {
		 allProgramOptions.get(i).click();
		 break;
		 }
	 }
	 
  }
  public void batchDropdownOptions(String batchName) {
		 for (int i = 0; i < allBatchOptions.size(); i++) {
			 if (allBatchOptions.get(i).getText().contains(batchName)) {
				 allBatchOptions.get(i).click();
			 break;
			 }
		 }
		 
	  }
	public void addNewAssignmentDetails(Map<String, String> excelDataMap) {
		
		if(!excelDataMap.get("programName").isEmpty()) {
			programDropdownOptions(excelDataMap.get("programName"));
		}
		if(!excelDataMap.get("BatchNumber").isEmpty()) {
			batchDropdownOptions(excelDataMap.get("BatchNumber"));
		}
		
		if(!excelDataMap.get("assigName").isEmpty()) {
			asignmtNameTxtBox.clear();
			asignmtNameTxtBox.sendKeys(excelDataMap.get("assigName"));
		}
		if(!excelDataMap.get("assigDesc").isEmpty()) {
			asignmtDescTxtBox.clear();
			asignmtDescTxtBox.sendKeys(excelDataMap.get("assigDesc"));
		}
		if(!excelDataMap.get("assgDueDate").isEmpty()) {
			asignmtDueDateTxtBox.clear();
			asignmtDueDateTxtBox.sendKeys(excelDataMap.get("assgDueDate"));
		}
		if(!excelDataMap.get("gradeBy").isEmpty()) {
			gradeByTxtBox.clear();
			gradeByTxtBox.sendKeys(excelDataMap.get("gradeBy"));
		}
		if(!excelDataMap.get("assigFile1").isEmpty()) {
			asignmtFile1TxtBox.clear();
			asignmtFile1TxtBox.sendKeys(excelDataMap.get("assigFile1"));
		}
		if(!excelDataMap.get("assigFile2").isEmpty()) {
			asignmtFile2TxtBox.clear();
			asignmtFile2TxtBox.sendKeys(excelDataMap.get("assigFile2"));
		}
		if(!excelDataMap.get("assigFile3").isEmpty()) {
			asignmtFile3TxtBox.clear();
			asignmtFile3TxtBox.sendKeys(excelDataMap.get("assigFile3"));
		}
		if(!excelDataMap.get("assigFile4").isEmpty()) {
			asignmtFile4TxtBox.clear();
			asignmtFile4TxtBox.sendKeys(excelDataMap.get("assigFile4"));
		}
		if(!excelDataMap.get("assigFile5").isEmpty()) {
			asignmtFile5TxtBox.clear();
			asignmtFile5TxtBox.sendKeys(excelDataMap.get("assigFile5"));
		}
		savebtn.click();
		
	}

	
	public String getErrorElementg() {

		return (errorElement).getText();

	}
	
	
	

}





