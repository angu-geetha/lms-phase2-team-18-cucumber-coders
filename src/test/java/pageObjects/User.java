package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User {
	
public WebDriver driver;
	
	public User(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="header")
	@CacheLookup
	WebElement pageHeader;
	
	@FindBy(id="searchbox")
	@CacheLookup
	WebElement txtsearchbox;
	
	@FindBy(id="newUser")
	@CacheLookup
	WebElement BtnaddNewUser;
	
	@FindBy(id="deleteAllBtn")
	@CacheLookup
	WebElement BtntopDelete;
	
	@FindBy(linkText="Student")
	@CacheLookup
	WebElement StudentPageLink;
	
	@FindBy(linkText="Program")
	@CacheLookup
	WebElement ProgramPageLink;
	
	@FindBy(linkText="Batch")
	@CacheLookup
	WebElement BatchPageLink;
	
	@FindBy(linkText="Class")
	@CacheLookup
	WebElement ClassPageLink;
	
	@FindBy(linkText="User")
	@CacheLookup
	WebElement UserPageLink;
	
	@FindBy(linkText="Assignment")
	@CacheLookup
	WebElement AssignmentPageLink;
	
	@FindBy(linkText="Attendance")
	@CacheLookup
	WebElement AttendancePageLink;
	
	@FindBy(linkText="logout")
	@CacheLookup
	WebElement LogoutPageLink;
	
	@FindBy(id="checkboxall")
	@CacheLookup
	WebElement CheckBoxAll;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement SortId;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement SortName;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement SortLocation;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement sortPhoneNumber;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement Footer;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement txtNoOfEntries;
	
	//Pagination
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement firstPageicon;
	
	@FindBy(xpath="")
	@CacheLookup
	WebElement lastPageicon;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-chevron-left']")
	@CacheLookup
	WebElement moveLefticon;
	
	
	@FindBy(xpath="//i[@class='oxd-icon bi-chevron-right']")
	@CacheLookup
	WebElement moveRighticon;
	
	//Add New User-Edit Existing User pop up
	
	@FindBy(xpath="//h6[@class='header']")
	@CacheLookup
	WebElement addUserDetailsHeader;
	
	@FindBy(xpath="//input[@placeholder='FirstName']")
	@CacheLookup
	WebElement txtaddFirstName;
	
	@FindBy(xpath="//input[@placeholder='MiddleName']")
	@CacheLookup
	WebElement txtaddMiddleName;
	
	@FindBy(xpath="//input[@placeholder='LastName']")
	@CacheLookup
	WebElement txtaddLastName;
	
	@FindBy(xpath="//input[@placeholder='Location']")
	@CacheLookup
	WebElement txtaddLocation;
	
	@FindBy(xpath="//input[@placeholder='Phonenumber']")
	@CacheLookup
	WebElement txtaddPhoneNumber;
	
	@FindBy(xpath="//input[@placeholder='Linkedin']")
	@CacheLookup
	WebElement txtaddLinkedinUrl;
	
	@FindBy(xpath="//select[@id='userrole']']")
	@CacheLookup
	WebElement rbUserRole;
	
	@FindBy(xpath="//select[@id='rolestatus']']")
	@CacheLookup
	WebElement rbRoleStatus;
	
	@FindBy(xpath="//select[@id='visastatus']']")
	@CacheLookup
	WebElement rbVisaStatus;
	
	
	@FindBy(xpath="//input[@placeholder='EmailAddress']")
	@CacheLookup
	WebElement txtaddEmailAddress;
	
	@FindBy(xpath="//input[@placeholder='undergrad']")
	@CacheLookup
	WebElement txtunderGraduate;
	
	@FindBy(xpath="//input[@placeholder='postgrad']")
	@CacheLookup
	WebElement txtaddPostGraduate;
	
	@FindBy(xpath="//input[@placeholder='timezone']")
	@CacheLookup
	WebElement txtaddTimezone;
	
	@FindBy(xpath="//input[@placeholder='usercomments']")
	@CacheLookup
	WebElement txtaddUserComments;
	
	
	@FindBy(xpath="//button[@type='Cancel']")
	@CacheLookup
	WebElement btnCancel;
	
	@FindBy(xpath="//button[@type='Submit']")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath="//button[@type='Close']")
	@CacheLookup
	WebElement iconClose;

}
