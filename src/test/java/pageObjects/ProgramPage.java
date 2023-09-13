package pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigReader;

public class ProgramPage extends BasePage {
	
	public WebDriver driver;
	
	public ProgramPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//Program Page fields
	@FindBy(id="title")      static WebElement programpageTitle;	
	@FindBy(id="header")      static WebElement programpageHeader;	
	@FindBy (xpath="xpath for maanage LMS Header']") static WebElement    lmsheaderElmt;
	@FindBy(id="searchbox")   static WebElement txtsearchbox;	
	@FindBy(id="newProgram")  static WebElement BtnaddNewProgram;	
	@FindBy(id="deleteAllBtn") static WebElement BtntopDelete;	
	@FindBy(linkText="Student") static WebElement StudentPageLink;	
	@FindBy(linkText="Program") static WebElement ProgramPageLink;	
	@FindBy(linkText="Batch") static WebElement BatchPageLink;	
	@FindBy(linkText="Class") static WebElement ClassPageLink;	
	@FindBy(linkText="User") static WebElement UserPageLink;	
	@FindBy(linkText="Assignment") static WebElement AssignmentPageLink;	
	@FindBy(linkText="Attendance") static WebElement AttendancePageLink;	
	@FindBy(linkText="logout") static WebElement LogoutPageLink;	
	@FindBy(id="checkboxall") static WebElement CheckBoxAll;	
	@FindBy(xpath="") static WebElement SortProgramNameHeader;	
	@FindBy(xpath="")static WebElement SortDescriptionNameHeader;	
	@FindBy(xpath="") static WebElement SortProgramStatusHeader;	
	@FindBy(xpath="") static WebElement Footer;	
	@FindBy(xpath="") static WebElement txtNoOfEntries;
	
	@FindBy(xpath = ".//*[@id=\"id of the table\"]/table/thead/tr/th") static List<WebElement> tableHeaders;
	@FindBy(xpath = ".//*[@id=\"id of the table\"]/table/thead/tr") static List<WebElement> tablerows;

	
	//Pagination	
	@FindBy(xpath="")	static WebElement firstPageicon;	
	@FindBy(xpath="") static WebElement lastPageicon;	
	@FindBy(xpath="//i[@class='oxd-icon bi-chevron-left']") static WebElement moveLefticon;		
	@FindBy(xpath="//i[@class='oxd-icon bi-chevron-right']") static WebElement moveRighticon;
	
	//Add New Program-Edit Existing Program pop up	ur
	@FindBy(xpath="//h6[@class='header']") static WebElement addProgramHeader;	
	@FindBy(xpath="//div[@class='modal-form-group']/input[@name='programname']") static WebElement txtaddNewProgramName;	
	@FindBy(xpath="//div[@class='modal-form-group']/input[@name='programdesc']") static WebElement txtaddNewProgramDescription;	
	@FindBy(xpath="//input[@type='radio'][@value='Active']") static WebElement rbaddNewProgramstatusActive;	
	@FindBy(xpath="//input[@type='radio'][@value='InActive']") static WebElement rbaddNewProgramstatusInActive;	
	@FindBy(xpath="//button[@type='Cancel']") static WebElement btnCancel;
	@FindBy(xpath="//button[@type='Save']") static WebElement btnSave;	
	@FindBy(xpath="//button[@type='Close']") static WebElement iconClose;
	
	@FindBy(xpath = "//div[@class='alert alert-primary']") WebElement errorElement;

	static WebElement checkboxElmt;
	static WebElement programName;
	static WebElement programDesc;
	static WebElement programStatus;
	static WebElement asignmtEditDelete;
    String programPageUrl = ConfigReader.getProperty("programPageUrl");
	
    
    public void program_page() {
		driver.get(programPageUrl);
	}
	
	public String verifyManageProgramPage() {
		return  programpageTitle.getText();
	}

	public String verifyManageProgramPageHeader() {
		return  programpageHeader.getText();
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
	
	public void validateTableHeaders(Map<String, String> excelDataMap) {

		if(!tableHeaders.isEmpty() && tableHeaders.size() >0) {
			checkboxElmt = tableHeaders.get(0);
			programName = tableHeaders.get(1);
			programDesc = tableHeaders.get(2);
			programStatus = tableHeaders.get(3);
			asignmtEditDelete = tableHeaders.get(4);

			if(checkboxElmt.isDisplayed() && checkboxElmt.getText().contains(excelDataMap.get("checkBox"))
					&&	programName.isDisplayed() && programName.getText().contains(excelDataMap.get("programName"))
					&&	programDesc.isDisplayed() && programDesc.getText().contains(excelDataMap.get("programDesc"))
					&&	programStatus.isDisplayed() && programStatus.getText().contains(excelDataMap.get("programDueDate"))
					&&	asignmtEditDelete.isDisplayed() && asignmtEditDelete.getText().contains(excelDataMap.get("editOrDelete"))
					) {
				assertTrue(true, "Program table has all headers");
			}
			else {
				assertTrue(false, "Program table has mismatch headers");
			}

		} else {
			assertTrue(false, "Program table has mismatch headers");
		}

	}
	
	public void clickAddButton() {
		BtnaddNewProgram.click();
	}
	
	public void getProgramStatus(String programStatus) {
		if(programStatus.equals("Active")) {
			rbaddNewProgramstatusActive.click();
		} else if (programStatus.equals("InActive")){
			rbaddNewProgramstatusInActive.click();
		}	
		
	}
		
	
 public void addNewEditExistProgramDetails(Map<String, String> excelDataMap) {
	 
	 	String popUpWindowHandle = driver.getWindowHandle();
	 	driver.switchTo().window(popUpWindowHandle);
		
		if(!excelDataMap.get("programName").isEmpty()) {
			txtaddNewProgramName.clear();
			txtaddNewProgramName.sendKeys(excelDataMap.get("programName"));
		}
		if(!excelDataMap.get("programDescription").isEmpty()) {
			txtaddNewProgramDescription.clear();
			txtaddNewProgramDescription.sendKeys(excelDataMap.get("programDescription"));
		}
		if(!excelDataMap.get("programStatus").isEmpty()) {
			getProgramStatus(excelDataMap.get("programStatus"));
		}
		
		btnSave.click();
		driver.switchTo().defaultContent();
				
	}
 

 
 
 public String getErrorElement() {

		return (errorElement).getText();

	}
 
 public List<String> getProgramDataForSearch(String fieldName) throws Exception {
		List<String> dataList = new ArrayList<>();
		try {

			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));
				if (cells.size() > 0) {
					String dataValue = null;
					switch (fieldName) {
					case "name":
						if (cells.get(1) != null) {
							dataValue = cells.get(1).findElement(By.id("id of the Program Name class")).getText();
						} else if (cells.size() > 0) {
							throw (new Exception("exception on retrieving search"));
						}
						break;
					case "desc":
						if (cells.get(2) != null) {
							dataValue = cells.get(2).findElement(By.id("id of the Program Desc class")).getText();
						} else if (cells.size() > 0) {
							throw (new Exception("exception on retrieving search"));
						}
						break;
					case "status":
						if (cells.get(3) != null) {
							dataValue = cells.get(3).findElement(By.id("id of the Assignment status class")).getText();
						} else if (cells.size() > 0) {
							throw (new Exception("exception on retrieving search"));
						}
						break;
					
					default:
						throw (new Exception("exception on retrving search"));

					}
					if (!dataValue.isEmpty()) {
						dataList.add(dataValue);
					}
				}

			}

		} catch (Exception e) {
			throw (new Exception("exception on row checkbox"));
		}
		return dataList;
	}

}
