package pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
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

	@FindBy(linkText = "student")
	static WebElement studentLink;
	@FindBy(linkText = "Program")
	static WebElement programLink;
	@FindBy(linkText = "Batch")
	static WebElement batchLink;
	@FindBy(linkText = "class")
	static WebElement classLink;
	@FindBy(linkText = "user")
	static WebElement userLink;
	@FindBy(linkText = "Assignment")
	static WebElement assignmentLink;
	@FindBy(linkText = "Attendance")
	static WebElement attendanceLink;
	@FindBy(linkText = "Logout")
	static WebElement logoutLink;

	// Login Page Elements
	@FindBy(xpath = "xpath for User field']")
	static WebElement user;
	@FindBy(xpath = "xpath for Password Field']")
	static WebElement pwd;

	@FindBy(xpath = "xpath for Login button]")
	static WebElement loginButtonElmt;

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

	// Pagination
	@FindBy(xpath = "")
	static WebElement firstPageicon;
	@FindBy(xpath = "")
	static WebElement lastPageicon;
	@FindBy(id = "example.previous")
	static WebElement prevlink;
	@FindBy(id = "example.next")
	static WebElement nextlink;
	@FindBy(xpath = "//span[@class='pagination'][@label,contains(text(),\"currentpage)]")
	static WebElement currentPage;

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

	@FindBy(xpath = ".//input[@type='radio'")
	static List<WebElement> inputRadioButtons;

	@FindBy(xpath = "//select")
	static WebElement batchdropdown;
	@FindBy(xpath = "//select")
	static WebElement programdropdown;

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

	// Xpath for message (successfully added, deleted and updated)
	@FindBy(xpath = "//")
	static WebElement alertMessage;

	// Delete Alert components
	String parentWindowHandler;
	String subWindowHandler;
	Alert deleteAlert;
	@FindBy(xpath = "//button[text()='Delete Alert Yes ']")
	static WebElement yes;
	@FindBy(xpath = "//button[text()='Delete Alert No ']")
	static WebElement no;

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
			loginButtonElmt.click();
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

	public boolean verifyDeleteButtonEnabled() {
		return deleteElmt.isEnabled();
	}

	public void clickDeleteButtonBelowHeader() {
		deleteElmt.click();

	}

	public boolean verifySearchButton() {
		return SearchElmt.isDisplayed() && SearchElmt.getText().contains("Search...");
	}

	public void validateEditIconForRows(String page) throws Exception {
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));

				switch (page) {
				case "Assignment": case "User":
					if (cells.size() > 0 && cells.get(5) != null) {
						cells.get(5).findElement(By.id("id of the edit button")).isDisplayed();
					} else if (cells.size() < 0) {
						throw (new Exception("exception on row edit"));
					}
					break;
				case "Program":
					if (cells.size() > 0 && cells.get(4) != null) {
						cells.get(4).findElement(By.id("id of the edit button")).isDisplayed();
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
				case "Assignment":case "User":
					if (cells.size() > 0 && cells.get(5) != null) {
						cells.get(5).findElement(By.id("id of the Delete button")).isDisplayed();
					} else if (cells.size() > 0) {
						throw (new Exception("exception on row delete"));
					}
					break;
				case "Program":
					if (cells.size() > 0 && cells.get(4) != null) {
						cells.get(4).findElement(By.id("id of the Delete button")).isDisplayed();
					} else if (cells.size() > 0) {
						throw (new Exception("exception on row delete"));
					}
					break;
				
				default:
					throw (new Exception("exception on row delete"));
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

	public void sendDataToSearchBox(String searchData) {
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

	public ArrayList<String> clickEditIconForRows(String page) throws Exception {

		ArrayList<String> rowData = new ArrayList<>();
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));

				for (Iterator iterator2 = cells.iterator(); iterator2.hasNext();) {
					WebElement webElement = (WebElement) iterator2.next();
					rowData.add(webElement.getText());
				}
				switch (page) {
				case "Assignment":
					if (cells.size() > 0 && cells.get(5) != null) {
						cells.get(5).findElement(By.id("id of the edit button")).isDisplayed();
						if (cells.get(5).findElement(By.id("id of the edit button")).isDisplayed()) {
							parentWindowHandler = driver.getWindowHandle(); // Store your parent window
							subWindowHandler = null;
							cells.get(5).findElement(By.id("id of the edit button")).click();
							Set<String> handles = driver.getWindowHandles(); // get all window handles
							Iterator<String> iterator3 = handles.iterator();
							while (iterator3.hasNext()) {
								subWindowHandler = iterator3.next();
							}
							driver.switchTo().window(subWindowHandler); // switch to popup window

							return rowData;
						} else if (cells.size() < 0) {
							throw (new Exception("exception on row edit"));
						}

					}
					break;
				case "Program":
					if (cells.size() > 0 && cells.get(4) != null) {
						cells.get(4).findElement(By.id("id of the edit button")).isDisplayed();
						if (cells.get(4).findElement(By.id("id of the edit button")).isDisplayed()) {
							parentWindowHandler = driver.getWindowHandle(); // Store your parent window
							subWindowHandler = null;
							cells.get(4).findElement(By.id("id of the edit button")).click();
							Set<String> handles = driver.getWindowHandles(); // get all window handles
							Iterator<String> iterator3 = handles.iterator();
							while (iterator3.hasNext()) {
								subWindowHandler = iterator3.next();
							}
							driver.switchTo().window(subWindowHandler); // switch to popup window

							return rowData;
						} else if (cells.size() < 0) {
							throw (new Exception("exception on row edit"));
						}

					}
					break;

				default:
					throw (new Exception("exception on row edit"));
				}

			}
		} catch (Exception e) {
			throw (new Exception("exception on edit button click "));
		}
		return rowData;
	}

	public ArrayList<String> clickDeleteIconForRows(String page) throws Exception {

		ArrayList<String> rowData = new ArrayList<>();
		try {
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));

				for (Iterator iterator2 = cells.iterator(); iterator2.hasNext();) {
					WebElement webElement = (WebElement) iterator2.next();
					rowData.add(webElement.getText());
				}
				switch (page) {
				case "Assignment":
					if (cells.size() > 0 && cells.get(5) != null) {
						cells.get(5).findElement(By.id("id of the Delete button")).isDisplayed();
						if (cells.get(5).findElement(By.id("id of the Delete button")).isDisplayed()) {
							parentWindowHandler = driver.getWindowHandle(); // Store your parent window
							subWindowHandler = null;
							cells.get(5).findElement(By.id("id of the Delete button")).click();
							Set<String> handles = driver.getWindowHandles(); // get all window handles
							Iterator<String> iterator3 = handles.iterator();
							while (iterator3.hasNext()) {
								subWindowHandler = iterator3.next();
							}
							driver.switchTo().window(subWindowHandler); // switch to popup window
							return rowData;
						} else if (cells.size() < 0) {
							throw (new Exception("exception on row Delete"));
						}

					}
					break;

				case "Program":
					if (cells.size() > 0 && cells.get(5) != null) {
						cells.get(5).findElement(By.id("id of the Delete button")).isDisplayed();
						if (cells.get(5).findElement(By.id("id of the Delete button")).isDisplayed()) {
							parentWindowHandler = driver.getWindowHandle(); // Store your parent window
							subWindowHandler = null;
							cells.get(5).findElement(By.id("id of the Delete button")).click();
							Set<String> handles = driver.getWindowHandles(); // get all window handles
							Iterator<String> iterator3 = handles.iterator();
							while (iterator3.hasNext()) {
								subWindowHandler = iterator3.next();
							}
							driver.switchTo().window(subWindowHandler); // switch to popup window
							return rowData;
						} else if (cells.size() < 0) {
							throw (new Exception("exception on row Delete"));
						}

					}
					break;

				default:
					throw (new Exception("exception on row Delete"));
				}

			}
		} catch (Exception e) {
			throw (new Exception("exception on Delete button click "));
		}
		return rowData;
	}

	public ArrayList<String> clickCheckboxForRows(String page, int noOfCheckBox) throws Exception {

		ArrayList<String> rowData = new ArrayList<>();
		try {
			int i = 1;
			for (Iterator iterator = tablerows.iterator(); iterator.hasNext();) {
				WebElement rowElement = (WebElement) iterator.next();
				List<WebElement> cells = rowElement.findElements(By.tagName("td"));

				switch (page) {
				case "Assignment":case "Program":case "User":
					if (cells.size() > 0 && cells.get(0) != null) {
						cells.get(0).findElement(By.id("id of the check box button")).isDisplayed();
						if (cells.get(0).findElement(By.id("id of the check box button")).isDisplayed()) {
							cells.get(0).findElement(By.id("id of the check box button")).click();
							rowData.add(cells.get(1).getText());
							i = i + 1;
							if (i > noOfCheckBox) {
								return rowData;
							}

						} else if (cells.size() < 0) {
							throw (new Exception("exception on row Delete"));
						}

					}
					break;
					

				default:
					throw (new Exception("exception on row Delete"));
				}

			}
		} catch (Exception e) {
			throw (new Exception("exception on Delete button click "));
		}
		return rowData;
	}

	public Boolean verifyAddButtonDisplayed(String addBtnName) {
		if (AddNewElmt.getText().contains(addBtnName)) {
			return AddNewElmt.isDisplayed();
		} else
			return false;

	}

	public boolean isNextLinkDisplayed() {
		if (!nextlink.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean isPreviousLinkDisplayed() {
		if (!prevlink.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean isNextLinkDisabled() {
		// Get Total no.of pages count
		int paginationSize = driver.findElements(By.xpath("//span/a[@class='paginate_button]")).size();

		// Click on the last page
		driver.findElement(By.xpath("//span/a[@class='paginate_button][" + paginationSize + "]")).click();

		// verify the Next link is disabled
		if (!nextlink.isEnabled())
			return true;
		else
			return false;
	}

	public boolean isFirstLinkDisabled() {
		// Click on the first page link
		driver.findElement(By.xpath("//span/a[@class='paginate_button][1]")).click();

		// verify the Next link is disabled
		if (!prevlink.isEnabled())
			return true;
		else
			return false;
	}

	public void redirectToPage(String pageName) throws Exception {
		switch (pageName) {
		case "Student":
			studentLink.click();
			break;
		case "Program":
			programLink.click();
			break;
		case "Batch":
			batchLink.click();
			break;
		case "Class":
			classLink.click();
			break;
		case "User":
			userLink.click();
			break;
		case "Attendance":
			attendanceLink.click();
			break;
		case "Assignment":
			assignmentLink.click();
			break;
		case "Logout":
			logoutLink.click();
			break;
		default:
			throw (new Exception("Unable to redirect to the specified page"));
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

	public List<WebElement> getRadioButtonsinPage() {

		return inputRadioButtons;
	}

	public boolean verifyDropdown() {
		if (batchdropdown.isDisplayed()) {
			return true;
		} else
			return false;

	}

	public boolean verifyProgramDropdown() {
		if (programdropdown.isDisplayed()) {
			return true;
		} else
			return false;
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

	public void clickClosebutton() {
		closebtn.click();
	}

	public boolean verifycancelbutton() {
		if (cancelbtn.isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickCancelbutton() {
		cancelbtn.click();
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

	// Broken Links
	public boolean isBrokenLink(String moduleName) throws Exception {
		String url = "";
		HttpURLConnection huc = null;
		int respCode;
		switch (moduleName) {
		case "Program":
			url = programLink.getAttribute("href");
			break;
		case "Student":
			url = studentLink.getAttribute("href");
			break;
		case "Batch":
			url = batchLink.getAttribute("href");
			break;
		case "Class":
			url = classLink.getAttribute("href");
			break;
		case "Attendance":
			url = attendanceLink.getAttribute("href");
			break;
		case "Assignment":
			url = assignmentLink.getAttribute("href");
			break;
		case "User":
			url = userLink.getAttribute("href");
			break;
		case "Logout":
			url = logoutLink.getAttribute("href");
			break;

		}

		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			if (respCode >= 400) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw (new Exception("exception on edit button click "));
		}

	}

	public String getAlertForAddUpdate() {
		return (driver.switchTo().alert().getText());

	}

	public String verifyPopUpforDelete(String page) {

		deleteAlert = (Alert) driver.switchTo().window(subWindowHandler);
		return deleteAlert.getText();
	}

	public boolean verifyAlertButtons(String buttonName) {
		boolean buttonDisplayed = false;
		if (buttonName.contains("yes")) {
			if (yes.isDisplayed()) {
				buttonDisplayed = true;
			}
		} else {
			if (no.isDisplayed()) {
				buttonDisplayed = true;
			}
		}
		return buttonDisplayed;
	}

	public void clickAlertButtons(String buttonName) {
		if (buttonName.contains("yes")) {
			if (yes.isDisplayed()) {
				yes.click();
			}
		} else {
			if (no.isDisplayed()) {
				no.click();
			}
		}

	}

	public void clickCloseOnDeleteAlert() {
		((JavascriptExecutor) driver).executeScript("window.close()");
	}

	public boolean getSortAsc(String columnName) {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(By.xpath("//td[contains" + columnName + "]"));
		for (WebElement e : elementList) {
			obtainedList.add(e.getText());
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		if (sortedList.equals(obtainedList)) {
			return true;
		} else
			return false;
	}
	
	public boolean getSortDesc(String columnName) {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(By.xpath("//td[contains" + columnName + "]"));
		for (WebElement e : elementList) {
			obtainedList.add(e.getText());
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		
		if (sortedList.equals(obtainedList)) {
			return true;
		} else
			return false;
	}
	
	
}
