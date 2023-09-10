package pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigReader;
import driverFactory.DriverFactory;

public class BasePage {
	WebDriver driver = DriverFactory.getdriver();
	String loginURL = ConfigReader.getProperty("loginPageUrl");
	String dashboardUrl = ConfigReader.getProperty("dashboardUrl");

	@FindBy(xpath = "xpath for User field']")
	static WebElement user;
	@FindBy(xpath = "xpath for Password Field']")
	static WebElement pwd;

	@FindBy(xpath = "xpath for retreving all the header elements']")
	static List<WebElement> headerLinks;
	@FindBy(xpath = "xpath for  delete button']")
	static WebElement deleteElmt;
	@FindBy(xpath = "xpath for  search button']")
	static WebElement SearchElmt;
	
	@FindBy(xpath = "xpath for  Add new button']")
	static WebElement AddNewElmt;
	
	@FindBy(xpath="") static WebElement Footer;	
	@FindBy(xpath="") static WebElement txtNoOfEntries;
	
	@FindBy(xpath = ".//*[@id=\"id of the table\"]/table/thead/tr/th") static List<WebElement> tableHeaders;
	@FindBy(xpath = ".//*[@id=\"id of the table\"]/table/thead/tr") static List<WebElement> tablerows;
    
	@FindBy(xpath = "xpath for title heading in the current Page']")
	static WebElement headingElmt;

	static String totalRowsAllPages;
	static int totalRowsinpage;
	static int count=0;
	
	//Pagination	
		@FindBy(xpath="")	static WebElement firstPageicon;	
		@FindBy(xpath="") static WebElement lastPageicon;	
		@FindBy(id="example.previous") static WebElement forwardlink;		
		@FindBy(id="example.next") static WebElement nextlink;	
		@FindBy(xpath="//span[@class='pagination'][@label,contains(text(),\"currentpage)]") static WebElement currentPage;
		
		static String nextButtonClass = nextlink.getAttribute("class");
		static String currentPageNumber = currentPage.getText();

	public BasePage() {
		PageFactory.initElements(driver, this);
	}

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

	public String verifyDashboardPage() {

		String Title = driver.getTitle();
		return Title;

	}

	public void dashboardPage() {
		driver.get(dashboardUrl);

	}

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

		return SearchElmt.isDisplayed();
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
				if(cells.size() > 0) {
					String dataValue = null;
					switch (feildName) {
					case "name":
						if(cells.get(1)!= null) {
							dataValue = cells.get(1).findElement(By.id("id of the Assignment Name class")).getText();
						} else if(cells.size() > 0) {
							throw(new Exception("exception on retrving search"));
						}
						break;
					case "desc":
						if(cells.get(2)!= null) {
							dataValue = cells.get(2).findElement(By.id("id of the Assignment Desc class")).getText();
						} else if(cells.size() > 0) {
							throw(new Exception("exception on retrving search"));
						}
						break;
					case "dueDate":
						if(cells.get(3)!= null) {
							dataValue = cells.get(3).findElement(By.id("id of the Assignment dueDate class")).getText();
						} else if(cells.size() > 0) {
							throw(new Exception("exception on retrving search"));
						}
						break;
					case "grade":
						if(cells.get(4) != null) {
							dataValue = cells.get(4).findElement(By.id("id of the Assignment grade class")).getText();
						} else if(cells.size() > 0) {
							throw(new Exception("exception on retrving search"));
						}
						break;

					default:
						throw(new Exception("exception on retrving search"));
						
					}
					if(!dataValue.isEmpty()) {
						dataList.add(dataValue);
					}
				}
				

			}
			
		}catch (Exception e) {
			throw(new Exception("exception on row checkbox"));
		}
		return dataList;
	}
	
	public Boolean verifyAddButtonDisplayed(String addBtnName) {
		if(AddNewElmt.getText().contains(addBtnName)) {
			return AddNewElmt.isDisplayed();
		} else
			return false;
		
	}
	
	public int getRowCountinPage() {
		totalRowsinpage = tablerows.size();
		return totalRowsinpage;				
	}
	
	public String extractTotalRowCountFromFooter() {
		totalRowsAllPages =  (Footer.getText()).replaceAll("[^0-9]", "");		
		return totalRowsAllPages;
	}
	
	public int findTotalRecordCount() throws InterruptedException {
		while(!nextButtonClass.contains("disabled")) {
			nextlink.click();
			Thread.sleep(1000);
			count += tablerows.size();		
		}
		return count;		
	}
	
	public boolean verifyFooter(String moduleName) {
		String actualFooterText = Footer.getText();
		String expectedFooterText = "In total there are "+ totalRowsAllPages +" "+ moduleName +" ";
		
		if(actualFooterText.equals(expectedFooterText)) return true;
		else return false;
	}
	
	public boolean verifyPaginationEntriesText(String moduleName) {
		String actualEntriesText = txtNoOfEntries.getText();
		String expectedEntriesText = "Showing "+ currentPageNumber+ " to 5 of "+totalRowsAllPages+" entries";
	
		if(actualEntriesText.equals(expectedEntriesText)) return true;
		else return false;
	}
	
	public boolean verifyRecordCountinPage(Integer x) {
		if((count>x && totalRowsinpage==x) || (count<x && totalRowsinpage==count)) 
		{
			return true;
		} else 
			return false;
	}	
	

	public String getPopUpPageHeadingString () {
		return headingElmt.getText();
		
	}
	
	public Boolean verifyAddButtonDisplayed(String addBtnName) {
		if(AddNewElmt.getText().contains(addBtnName)) {
			return AddNewElmt.isDisplayed();
		} else
			return false;
		
	}
	
	public int getRowCountinPage() {
		totalRowsinpage = tablerows.size();
		return totalRowsinpage;				
	}
	
	public String extractTotalRowCountFromFooter() {
		totalRowsAllPages =  (Footer.getText()).replaceAll("[^0-9]", "");		
		return totalRowsAllPages;
	}
	
	public int findTotalRecordCount() throws InterruptedException {
		while(!nextButtonClass.contains("disabled")) {
			nextlink.click();
			Thread.sleep(1000);
			count += tablerows.size();		
		}
		return count;		
	}
	
	public boolean verifyFooter(String moduleName) {
		String actualFooterText = Footer.getText();
		String expectedFooterText = "In total there are "+ totalRowsAllPages +" "+ moduleName +" ";
		
		if(actualFooterText.equals(expectedFooterText)) return true;
		else return false;
	}
	
	public boolean verifyPaginationEntriesText(String moduleName) {
		String actualEntriesText = txtNoOfEntries.getText();
		String expectedEntriesText = "Showing "+ currentPageNumber+ " to 5 of "+totalRowsAllPages+" entries";
	
		if(actualEntriesText.equals(expectedEntriesText)) return true;
		else return false;
	}
	
	public boolean verifyRecordCountinPage(Integer x) {
		if((count>x && totalRowsinpage==x) || (count<x && totalRowsinpage==count)) 
		{
			return true;
		} else 
			return false;
	}	
	

}
