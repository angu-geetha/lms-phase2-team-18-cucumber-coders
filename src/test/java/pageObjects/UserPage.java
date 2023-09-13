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

//import com.github.javafaker.Faker;

import dataProviders.ConfigReader;

public class UserPage extends BasePage{
	
public WebDriver driver;
	
	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="title")      static WebElement userpageTitle;	
	@FindBy(id="header")      static WebElement userpageHeader;	
	@FindBy (xpath="xpath for manage LMS Header']") static WebElement    lmsheaderElmt;
	@FindBy(id="header") static WebElement pageHeader;
	@FindBy(id="searchbox") static WebElement txtsearchbox;
	@FindBy(id="newUser") static WebElement BtnaddNewUser;
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
	@FindBy(xpath="") static WebElement SortId;
	@FindBy(xpath="") static WebElement SortName;
	@FindBy(xpath="") static WebElement SortLocation;
	@FindBy(xpath="") static WebElement sortPhoneNumber;
	@FindBy(xpath="") static WebElement Footer;
	@FindBy(xpath="") static WebElement txtNoOfEntries;
	
	//Pagination
	
	@FindBy(xpath="")	 static WebElement firstPageicon;
	@FindBy(xpath="")WebElement lastPageicon;
	@FindBy(xpath="//i[@class='oxd-icon bi-chevron-left']") static WebElement moveLefticon;
	@FindBy(xpath="//i[@class='oxd-icon bi-chevron-right']") static WebElement moveRighticon;
	
	
	
	//Add New User-Edit Existing User pop up
	
	@FindBy(xpath="//h6[@class='header']")static WebElement addUserDetailsHeader;	
	@FindBy(xpath="//input[@placeholder='FirstName']") static WebElement txtaddFirstName;	
	@FindBy(xpath="//input[@placeholder='MiddleName']") static WebElement txtaddMiddleName;	
	@FindBy(xpath="//input[@placeholder='LastName']") static WebElement txtaddLastName;	
	@FindBy(xpath="//input[@placeholder='Location']") static WebElement txtaddLocation;	
	@FindBy(xpath="//input[@placeholder='Phonenumber']") static WebElement txtaddPhoneNumber;	
	@FindBy(xpath="//input[@placeholder='Linkedin']") static WebElement txtaddLinkedinUrl;	
	
	@FindBy (xpath="xpath for userrole Options")  static List<WebElement> allUserRoleOptions;
	@FindBy (xpath="xpath for role status Options")  static List<WebElement> allRoleStatusOptions;
	@FindBy (xpath="xpath for  programOptions")  static List<WebElement> allVisaStatusOptions;
	
	@FindBy(xpath="//select[@id='userrole']']") static WebElement rbUserRole;	
	@FindBy(xpath="//select[@id='rolestatus']']") static WebElement rbRoleStatus;	
	@FindBy(xpath="//select[@id='visastatus']']")WebElement rbVisaStatus;		
	@FindBy(xpath="//input[@placeholder='EmailAddress']") static WebElement txtaddEmailAddress;	
	@FindBy(xpath="//input[@placeholder='undergrad']") static WebElement txtunderGraduate;	
	@FindBy(xpath="//input[@placeholder='postgrad']") static WebElement txtaddPostGraduate;	
	@FindBy(xpath="//input[@placeholder='timezone']") static WebElement txtaddTimezone;	
	@FindBy(xpath="//input[@placeholder='usercomments']") static WebElement txtaddUserComments;		
	@FindBy(xpath="//button[@type='Cancel']") static WebElement btnCancel;	
	@FindBy(xpath="//button[@type='Submit']") static WebElement btnSubmit;	
	@FindBy(xpath="//button[@type='Close']") static WebElement iconClose;
	
	@FindBy(xpath = "//div[@class='alert alert-primary']") WebElement errorElement;
	
	static WebElement checkboxElmt;
	static WebElement userIdHeader;
	static WebElement userNameHeader;
	static WebElement userLocationHeader;
	static WebElement userPhoneNumberHeader;
	static WebElement asignmtEditDelete;
	
	String userPageUrl = ConfigReader.getProperty("UserPageUrl");
	public static String ipFirstName="";
	public static String ipMiddleName="";
	public static String ipLastName="";
	public static String ipLocation="";
	public static String ipPhoneNumber="";
	public static String ipLinkedinUrl="";
	public static String ipEmailAddress="";
	public static String ipUnderGrad="";
	public static String ipPostGrad="";
	public static String ipTimeZone="";
	public static String ipUserComments="";

	
	
	/*Faker faker = new Faker();
	
	public void generateData() {
		ipFirstName = faker.name().firstName();
		ipMiddleName = faker.name().lastName();
		ipLastName = faker.name().lastName();
		
	}*/
	
	
	  public void user_page() {
			driver.get(userPageUrl);
		}
		
		public String verifyManageProgramPage() {
			return  userpageTitle.getText();
		}

		public String verifyManageProgramPageHeader() {
			return  userpageHeader.getText();
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
		
		public void userRoleDropdownOptions(String userRole) {
			 for (int i = 0; i < allUserRoleOptions.size(); i++) {
				 if (allUserRoleOptions.get(i).getText().contains(userRole)) {
					 allUserRoleOptions.get(i).click();
				 break;
				 }
			 }			 
		  }
		
		public void roleStatusDropdownOptions(String roleStatus) {
			 for (int i = 0; i < allRoleStatusOptions.size(); i++) {
				 if (allRoleStatusOptions.get(i).getText().contains(roleStatus)) {
					 allRoleStatusOptions.get(i).click();
				 break;
				 }
			 }			 
		  }
		
		public void visaStatusDropdownOptions(String visaStatus) {
			 for (int i = 0; i < allVisaStatusOptions.size(); i++) {
				 if (allVisaStatusOptions.get(i).getText().contains(visaStatus)) {
					 allVisaStatusOptions.get(i).click();
				 break;
				 }
			 }			 
		  }
		
		
		
		public void validateTableHeaders(Map<String, String> excelDataMap) {

			if(!tableHeaders.isEmpty() && tableHeaders.size() >0) {
				checkboxElmt = tableHeaders.get(0);
				userIdHeader = tableHeaders.get(1);
				userNameHeader = tableHeaders.get(2);
				userLocationHeader = tableHeaders.get(3);
				userPhoneNumberHeader = tableHeaders.get(4);
				asignmtEditDelete = tableHeaders.get(5);

				if(checkboxElmt.isDisplayed() && checkboxElmt.getText().contains(excelDataMap.get("checkBox"))
						&&	userIdHeader.isDisplayed() && userIdHeader.getText().contains(excelDataMap.get("userId"))
						&&	userNameHeader.isDisplayed() && userNameHeader.getText().contains(excelDataMap.get("userName"))
						&&	userLocationHeader.isDisplayed() && userLocationHeader.getText().contains(excelDataMap.get("userLocation"))
						&&	userPhoneNumberHeader.isDisplayed() && userPhoneNumberHeader.getText().contains(excelDataMap.get("userPhoneNumber"))
						&&	asignmtEditDelete.isDisplayed() && asignmtEditDelete.getText().contains(excelDataMap.get("editOrDelete"))
						) {
					assertTrue(true, "User table has all headers");
				}
				else {
					assertTrue(false, "User table has mismatch headers");
				}

			} else {
				assertTrue(false, "User table has mismatch headers");
			}

		}
		
		public void clickAddButton() {
			BtnaddNewUser.click();
		}
		
		////code to select from drop down
			
		
	 public void addNewEditExistProgramDetails(Map<String, String> excelDataMap) {
		 
		 	String popUpWindowHandle = driver.getWindowHandle();
		 	driver.switchTo().window(popUpWindowHandle);
			
			if(!excelDataMap.get("firstName").isEmpty()) {
				txtaddFirstName.clear();
				txtaddFirstName.sendKeys(excelDataMap.get("firstName"));
			}
			
			
			btnSubmit.click();
			driver.switchTo().defaultContent();
					
		}
	 

	 
	 
	 public String getErrorElement() {

			return (errorElement).getText();

		}
	 
	 public List<String> getUserDataForSearch(String fieldName) throws Exception {
			List<String> dataList = new ArrayList<>();
			try {

				for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
					WebElement rowElement = (WebElement) iterator.next();
					List<WebElement> cells = rowElement.findElements(By.tagName("td"));
					if (cells.size() > 0) {
						String dataValue = null;
						switch (fieldName) {
						case "id":
							if (cells.get(1) != null) {
								dataValue = cells.get(1).findElement(By.id("id of the user id")).getText();
							} else if (cells.size() > 0) {
								throw (new Exception("exception on retrieving search"));
							}
							break;
						case "username":
							if (cells.get(2) != null) {
								dataValue = cells.get(2).findElement(By.id("id of the username")).getText();
							} else if (cells.size() > 0) {
								throw (new Exception("exception on retrieving search"));
							}
							break;
						case "userlocation":
							if (cells.get(3) != null) {
								dataValue = cells.get(3).findElement(By.id("id of the userlocation")).getText();
							} else if (cells.size() > 0) {
								throw (new Exception("exception on retrieving search"));
							}
							break;
							
						case "phonenumber":
							if (cells.get(4) != null) {
								dataValue = cells.get(4).findElement(By.id("id of the phonenumber class")).getText();
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
