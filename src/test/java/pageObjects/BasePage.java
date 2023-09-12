package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigReader;
import driverFactory.DriverFactory;

public class BasePage {

	WebDriver driver = DriverFactory.getdriver();

	// Get URLS from Config
	String loginURL = ConfigReader.getProperty("loginPageUrl");
	String dashboardUrl = ConfigReader.getProperty("dashboardUrl");
	
	@FindBy(linkText="student") static WebElement studentLink;
	@FindBy(linkText="Program") static WebElement programLink;
	@FindBy(linkText="Batch") static WebElement batchLink;
	@FindBy(linkText="class") static WebElement classLink;
	@FindBy(linkText="user") static WebElement userLink;
	@FindBy(linkText="Assignment") static WebElement assignmentLink;
	@FindBy(linkText="Attendance") static WebElement attendanceLink;
	@FindBy(linkText="Logout") static WebElement logoutLink;


	// Login Page Elements
	@FindBy(xpath = "xpath for User field']")
	static WebElement user;
	@FindBy(xpath = "xpath for Password Field']")
	static WebElement pwd;

	// Navigation Bar Elmt - has all the links of Navigation Bar
	@FindBy(xpath = "xpath for retreving all the header elements']")
	static List<WebElement> headerLinks;

	// Delete Button for Multi Select Delete - common for all pages
	@FindBy(xpath = "xpath for  delete button']")
	static WebElement deleteElmt;

	// Search Button - common for all pages
	@FindBy(xpath = "xpath for  search button']")
	static WebElement SearchElmt;

	// Need to check
	@FindBy(xpath = "xpath for  Add new button']")
	static WebElement AddNewElmt;

	// Footer Elmt - Common for all pages
	@FindBy(xpath = "")
	static WebElement Footer;
	@FindBy(xpath = "")
	static WebElement txtNoOfEntries;

	// Pagination Related Elmts - Common for all pages
	static String totalRowsAllPages;
	static int totalRowsinpage;

	
	//Pagination	
		@FindBy(xpath="")	static WebElement firstPageicon;	
		@FindBy(xpath="") static WebElement lastPageicon;	
		@FindBy(id="example.previous") static WebElement prevlink;		
		@FindBy(id="example.next") static WebElement nextlink;	
		@FindBy(xpath="//span[@class='pagination'][@label,contains(text(),\"currentpage)]") static WebElement currentPage;
		
		static String nextButtonClass = nextlink.getAttribute("class");
		static String currentPageNumber = currentPage.getText();

	static int count = 0;


	// Data Table Elmts - Common for all pages
	@FindBy(xpath = ".//*[@id=\"id of the table\"]/table/thead/tr/th")
	static List<WebElement> tableHeaders;
	@FindBy(xpath = ".//*[@id=\"id of the table\"]/table/thead/tr")
	static List<WebElement> tablerows;

	// Page Heading - Title - Common for all pages
	@FindBy(xpath = "xpath for title heading in the current Page']")
	static WebElement headingElmt;

	// String nextButtonClass = nextlink.getAttribute("class");
	// String currentPageNumber = currentPage.getText();

	// Elmts to find No of input fields - common for all pages
	@FindBy(xpath = ".//input")
	static List<WebElement> inputFeilds;

	// Elmts to find no of input text boxes - common for all pages
	@FindBy(xpath = ".//input[@type='text'")
	static List<WebElement> inputTextBoxes;

	// Elmts for Calendar -Date Picker
	@FindBy(xpath = "//td//img[contains(@id, 'cntMainContent_imgStartDate') and contains(@src, 'Images/calendar.gif')]\")))")
	static WebElement calenderelement;

	// Elmts for Save Cancel and CLose - common for all pages
	@FindBy(xpath = "//button[@title='Save']")
	static WebElement savebtn;

	@FindBy(xpath = "//div[@class='closebutton']")
	static WebElement closebtn;

	@FindBy(xpath = "//button[text()='Cancel']")
	static WebElement cancelbtn;

	public BasePage() {
		PageFactory.initElements(driver, this);
	}

	// Login related common methods
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

	// Dashboard related common methods
	public String verifyDashboardPage() {

		String Title = driver.getTitle();
		return Title;

	}

	public void dashboardPage() {
		driver.get(dashboardUrl);

	}

	// Navigation Bar common methods
	public void selectHeaderLink(String headerlink) {

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

	public String getCurrentPageURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public Boolean verifyDeleteButtonEnabled() {
		return deleteElmt.isEnabled();
	}

	public Boolean verifySearchButton() {
		return SearchElmt.isDisplayed() && SearchElmt.getText().contains("Search...");
	}

	public void validateEditIconForRows(String page) throws Exception {
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));

				switch (page) {
				case "Assignment":
					if (cells.size() > 0 && cells.get(5) != null) {
						cells.get(5).findElement(By.id("id of the edit button")).isDisplayed();
					} else if (cells.size() < 0) {
						throw (new Exception("exception on row edit"));
					}
					break;

				default:
					throw (new Exception("exception on row edit"));
				}

			}
		} catch (Exception e) {
			throw (new Exception("exception on row edit"));
		}

	}

	public void validateDeleteIconForRows(String page) throws Exception {
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));
				switch (page) {
				case "Assignment":
					if (cells.size() > 0 && cells.get(5) != null) {
						cells.get(5).findElement(By.id("id of the Delete button")).isDisplayed();
					} else if (cells.size() > 0) {
						throw (new Exception("exception on row delete"));
					}
					break;

				default:
					throw (new Exception("exception on row edit"));
				}

			}
		} catch (Exception e) {
			throw (new Exception("exception on row delete"));
		}

	}

	public void validateCheckBoxForRows() throws Exception {
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));
				if (cells.size() > 0 && cells.get(0) != null) {
					cells.get(0).findElement(By.id("id of the Checkbox button")).isDisplayed();

				} else if (cells.size() > 0) {
					throw (new Exception("exception on row checkbox"));
				}

			}
		} catch (Exception e) {
			throw (new Exception("exception on row checkbox"));
		}

	}

	public void sendDataToSearchString(String searchData) {
		SearchElmt.clear();
		SearchElmt.sendKeys(searchData);
		// need to see if you need js action to pop out or keyboard enter
	}

	public boolean isEmptyTable() {
		if (tablerows.size() == 0)
			return true;
		else
			return false;

	}

	public List<String> getDataForSearch(String feildName) throws Exception {
		List<String> dataList = new ArrayList<>();
		try {

			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));
				if (cells.size() > 0) {
					String dataValue = null;
					switch (feildName) {
					case "name":
						if (cells.get(1) != null) {
							dataValue = cells.get(1).findElement(By.id("id of the Assignment Name class")).getText();
						} else if (cells.size() > 0) {
							throw (new Exception("exception on retrving search"));
						}
						break;
					case "desc":
						if (cells.get(2) != null) {
							dataValue = cells.get(2).findElement(By.id("id of the Assignment Desc class")).getText();
						} else if (cells.size() > 0) {
							throw (new Exception("exception on retrving search"));
						}
						break;
					case "dueDate":
						if (cells.get(3) != null) {
							dataValue = cells.get(3).findElement(By.id("id of the Assignment dueDate class")).getText();
						} else if (cells.size() > 0) {
							throw (new Exception("exception on retrving search"));
						}
						break;
					case "grade":
						if (cells.get(4) != null) {
							dataValue = cells.get(4).findElement(By.id("id of the Assignment grade class")).getText();
						} else if (cells.size() > 0) {
							throw (new Exception("exception on retrving search"));
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

	public Boolean verifyAddButtonDisplayed(String addBtnName) {
		if (AddNewElmt.getText().contains(addBtnName)) {
			return AddNewElmt.isDisplayed();
		} else
			return false;

	}

	
	
	public boolean isNextLinkDisplayed() {
		if(!nextlink.isDisplayed()) return true;
		else return false;
	}
	
	public boolean isPreviousLinkDisplayed() {
		if(!prevlink.isDisplayed()) return true;
		else return false;
	}
	
	public boolean isNextLinkDisabled() {
		//Get Total no.of pages count
		int paginationSize = driver.findElements(By.xpath("//span/a[@class='paginate_button]")).size();

		//Click on the last page
		driver.findElement(By.xpath("//span/a[@class='paginate_button]["+paginationSize+"]")).click();
		
		//verify the Next link is disabled
		if(!nextlink.isEnabled()) return true;
		else return false;
	}
	
	public boolean isFirstLinkDisabled() {
		//Click on the first page link
		driver.findElement(By.xpath("//span/a[@class='paginate_button][1]")).click();
		
		//verify the Next link is disabled
		if(!prevlink.isEnabled()) return true;
		else return false;
	}

	public void redirectToPage(String pageName) throws Exception {
		switch(pageName) {
		case "Student": studentLink.click(); break;
		case "Program": programLink.click();break;
		case "Batch": batchLink.click();break;
		case "Class": classLink.click();break;
		case "User": userLink.click();break;
		case "Attendance": attendanceLink.click();break;
		case "Assignment": assignmentLink.click();break;
		case "Logout": logoutLink.click();break;
		default:
			throw(new Exception("Unable to redirect to the specified page"));
		}
		}

	public int getRowCountinPage() {
		totalRowsinpage = tablerows.size();
		return totalRowsinpage;
	}

	public String extractTotalRowCountFromFooter() {
		totalRowsAllPages = (Footer.getText()).replaceAll("[^0-9]", "");
		return totalRowsAllPages;
	}

	public int findTotalRecordCount() throws InterruptedException {
		/*
		 * while (!nextButtonClass.contains("disabled")) { nextlink.click();
		 * Thread.sleep(1000); count += tablerows.size(); }
		 */
		return count;
	}

	public boolean verifyFooter(String moduleName) {
		String actualFooterText = Footer.getText();
		String expectedFooterText = "In total there are " + totalRowsAllPages + " " + moduleName + " ";

		if (actualFooterText.equals(expectedFooterText))
			return true;
		else
			return false;
	}

	public boolean verifyPaginationEntriesText(String moduleName) {
		String actualEntriesText = txtNoOfEntries.getText();
		String expectedEntriesText = "Showing ";// + currentPageNumber + " to 5 of " + totalRowsAllPages + " entries";

		if (actualEntriesText.equals(expectedEntriesText))
			return true;
		else
			return false;
	}

	public boolean verifyRecordCountinPage(Integer x) {
		if ((count > x && totalRowsinpage == x) || (count < x && totalRowsinpage == count)) {
			return true;
		} else
			return false;
	}

	public String getPopUpPageHeadingString() {
		return headingElmt.getText();

	}

	public List<WebElement> getInputFeilds() {

		return inputFeilds;
	}

	public List<WebElement> getTextBoxesinPage() {

		return inputTextBoxes;
	}

	

	public boolean verifyCalenderIcon() {
		if (calenderelement.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean verifysavebutton() {
		if (savebtn.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean verifyclosebutton() {
		if (closebtn.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean verifycancelbutton() {
		if (cancelbtn.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public ArrayList<String> clickEditIconForRows() throws Exception {

		ArrayList<String> rowData = new ArrayList<>();
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));

				for (Iterator iterator2 = cells.iterator(); iterator2.hasNext();) {
					WebElement webElement = (WebElement) iterator2.next();
					rowData.add(webElement.getText());
				}
				if (cells.size() > 0 && cells.get(5) != null) {
					cells.get(5).findElement(By.id("id of the edit button")).isDisplayed();
					if (cells.get(5).findElement(By.id("id of the edit button")).isDisplayed()) {
						cells.get(5).findElement(By.id("id of the edit button")).click();
						return rowData;
					} else if (cells.size() < 0) {
						throw (new Exception("exception on row edit"));
					}

				}

			}
		} catch (Exception e) {
			throw (new Exception("exception on edit button click "));
		}
		return rowData;
	}

}
