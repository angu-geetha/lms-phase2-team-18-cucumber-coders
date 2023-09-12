package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	//Add New Program-Edit Existing Program pop up	
	@FindBy(xpath="//h6[@class='header']") static WebElement addProgramHeader;	
	@FindBy(xpath="//div[@class='modal-form-group']/input[@name='programname']") static WebElement txtaddNewProgramName;	
	@FindBy(xpath="//div[@class='modal-form-group']/input[@name='programdesc']") static WebElement txtaddNewProgramDescription;	
	@FindBy(xpath="//input[@type='radio'][@value='Active']") static WebElement rbaddNewProgramstatusActive;	
	@FindBy(xpath="//input[@type='radio'][@value='InActive']") static WebElement rbaddNewProgramstatusInActive;	
	@FindBy(xpath="//button[@type='Cancel']") static WebElement btnCancel;
	@FindBy(xpath="//button[@type='Save']") static WebElement btnSave;	
	@FindBy(xpath="//button[@type='Close']") static WebElement iconClose;
	
	
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
	
	
	

}