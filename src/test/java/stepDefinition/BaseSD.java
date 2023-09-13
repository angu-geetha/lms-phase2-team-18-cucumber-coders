package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import dataProviders.ConfigReader;
import dataProviders.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import utilities.LoggerLoad;

public class BaseSD extends Commonclass {

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		LoggerLoad.logInfo("Admin is in login page");
		basePage.login_page();

	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		LoggerLoad.logInfo("Admin enter valid credentials and clicks login button");
		excelDataMap = null;
		String userName = null, password = null;
		try {
			excelDataMap = ExcelReader.getData("valid_login", "login");
			if (null != excelDataMap && excelDataMap.size() > 0) {
				userName = excelDataMap.get("userName");
				password = excelDataMap.get("password");
			}

			basePage.doLogin(userName, password);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Then("Admin should land on dashboard page")

	public void admin_should_land_on_dashboard_page() {

		LoggerLoad.logInfo("Admin should land on dashboard page");

		String Title = basePage.verifyDashboardPage();

		LoggerLoad.logInfo("Title of the Dashboard Page : \" " + Title + "\" ");

		assertEquals(Title, ConfigReader.getProperty("dashboardTitle"), "Title do not match");

	}

	@Given("Admin is on dashboard page after Login")

	public void admin_is_on_dashboard_page_after_login() {

		LoggerLoad.logInfo("Admin is on dashboard page after Login");

		basePage.dashboardPage();

	}

	@Then("Admin should see URL with {string}")

	public void admin_should_see_url_with_url_name(String urlName) {

		try {
			LoggerLoad.logInfo("Admin should see URL with {string}");
			String url = basePage.getCurrentPageURL();
			LoggerLoad.logInfo("URL of the Manage Assignment Page : \" " + url + "\" ");
			assertEquals(url, ConfigReader.getProperty("manageAssignmentURL"), "URL do not match");

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin should see URL with {string}");

		}

	}

	@Then("Admin should see header with {string}")

	public void admin_should_see_header_with_url_name(String urlName) {

		try {

			switch (urlName) {
			case "Assignment":
				String header = assignmentPage.verifyManageAssignmentPageHeader();

				LoggerLoad.logInfo("header of the Manage Assignment Page : \" " + header + "\" ");

				assertEquals(header, ConfigReader.getProperty(urlName), "header do not match");
				break;

			default:
				break;
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin should see URL with {string}");

		}

	}

	@Then("Admin should see disabled delete icon below the {string}")

	public void admin_should_see_disabled_delete_icon_below_the_url_name(String urlName) {
		try {
			boolean isEnabled = basePage.verifyDeleteButtonEnabled();
			LoggerLoad.logInfo("verify delete button enabled : \" " + isEnabled + "\" ");
			if (isEnabled) {
				assertFalse(false, "Delete button is enabled in " + urlName + " page");
			} else {
				assertFalse(true, "Delete button is disabled" + urlName + " page");
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin should see disabled delete icon below the UrlName " + urlName + " page");

		}
	}

	@When("Admin should click delete icon below the {string}")
	public void admin_should_click_delete_icon_below_the(String string) {
		try {
			basePage.clickDeleteButtonBelowHeader();

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin should click delete icon below the {string}");

		}
	}

	@Then("Admin should see search bar on the {string}")

	public void admin_should_see_search_bar(String urlName) {
		boolean searchbutton = basePage.verifySearchButton();
		try {
			LoggerLoad.logInfo("verify search button : \" " + searchbutton + "\" ");

			assertEquals(searchbutton, ConfigReader.getProperty("truevalue"), "search button not displayed");
		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin should see search bar on the manage assignment page");

		}

	}

	@Then("Edit Icon in each row of data table only  when entries are available for {string}")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available(String page) {
		try {
			basePage.validateEditIconForRows(page);
		} catch (Exception e) {
			assertFalse(false, "Failed - Edit Icon in each row of data table only  when entries are available");
		}

	}

	@Then("Delete Icon in each row of data table only  when entries are available for {string}")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available(String page) {
		try {
			basePage.validateDeleteIconForRows(page);
		} catch (Exception e) {
			assertFalse(false, "Failed - Delete Icon in each row of data table only  when entries are available");
		}
	}

	@Then("Admin should see check box in the all rows  of data table when entries available")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table_when_entries_available() {
		try {
			basePage.validateCheckBoxForRows();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin should see check box in the all rows  of data table when entries available");
		}
	}

	@When("Admin enters {string} into search box  from {string} and {string}")
	public void admin_enters_valid_into_search_box_from_and(String feildName, String dataKey, String sheetName) {
		try {
			excelDataMap = ExcelReader.getData(dataKey, sheetName);
			basePage.sendDataToSearchBox(excelDataMap.get("feildValue"));
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin enters valid {string} into search box  from {string} and {string}");
		}
	}

	@Then("Displays entries with that {string} from {string} and {string}")
	public void displays_entries_with_that(String feildName, String dataKey, String sheetName) {
		try {
			excelDataMap = ExcelReader.getData(dataKey, sheetName);
			List<String> searchData = basePage.getDataForSearch(feildName);
			for (Iterator iterator = searchData.iterator(); iterator.hasNext();) {
				String searchValue = (String) iterator.next();
				assertTrue(searchValue.contains(excelDataMap.get("feildValue")));
			}
		} catch (Exception e) {
			assertFalse(false, "Failed - Displays entries with that {string} from {string} and {string}");
		}

	}

	@Then("Displays empty details in the data table")
	public void displays_empty_details_in_the_data_table() {
		try {

			assertTrue(basePage.isEmptyTable(), "Table is empty");
		} catch (Exception e) {
			assertFalse(false, "Failed - Displays empty details in the data table");
		}

	}

	@Then("Admin should see a popup  with  heading {string}")
	public void admin_should_see_a_popup_with_heading(String headingTitle) {
		try {
			String heading = basePage.getPopUpPageHeadingString();
			assertEquals(heading, headingTitle);
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin should see a popup  with  heading {string}");
		}
	}

	@Then("Admin should see input fields Text  {string}")
	public void admin_should_see_input_fields_text(String page) {
		try {

			ArrayList<String> inputFields = null;

			List<WebElement> webElmts = basePage.getInputFeilds();
			switch (page) {
			case "Assignment":
				inputFields = getNewAssignmentInputFeilds();
				for (Iterator iterator = webElmts.iterator(); iterator.hasNext();) {
					WebElement webElement = (WebElement) iterator.next();

					if (inputFields.contains(webElement.getText())) {

						LoggerLoad.logInfo("Feild is present in the page");
					} else {
						assertFalse(false, "Failed - Feild is not present in the page");
					}
				}
				break;

			case "Program":
				inputFields = getNewProgramInputFields();
				for (Iterator iterator = webElmts.iterator(); iterator.hasNext();) {
					WebElement webElement = (WebElement) iterator.next();
					if (inputFields.contains(webElement.getText())) {
						LoggerLoad.logInfo("Field is present in the page");
					} else {
						assertFalse(false, "Failed - Field is not present in the page");
					}
				}
				break;

			default:
				break;
			}
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin should see input fields Text  {string}");
		}

	}

	@Then("{string} textbox should be  present in {string} details popup window")
	public void textbox_should_be_present_in_details_popup_window(String noOfTextBox, String page) {
		try {
			List<WebElement> webElmts = basePage.getTextBoxesinPage();
			assertEquals(Integer.parseInt(noOfTextBox), webElmts.size());
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin should see input fields Text  {string}");
		}

	}

	@Then("{string} radio buttons should be  present in {string} details popup window")
	public void radio_buttons_should_be_present_in_details_popup_window(String noOfRadioButtons, String page) {
		try {
			List<WebElement> webElmts = basePage.getRadioButtonsinPage();
			assertEquals(Integer.parseInt(noOfRadioButtons), webElmts.size());
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin should see correct number of radio buttons");
		}
	}

	@Then("Admin should see dropdown option for Batch Number")
	public void admin_should_see_dropdown_option_for_batch_number() {
		try {
			boolean batchdropdowndisplayed = assignmentPage.verifyDropdown();
			LoggerLoad.logInfo("verify batch Dropdown button is displayed \" " + batchdropdowndisplayed + "\" ");
			if (batchdropdowndisplayed) {
				assertFalse(true, "Dropdown button is displayed ");
			} else {
				assertFalse(false, "Dropdown button is  not displayed");
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Admin should see dropdown option for Batch Number ");

		}

	}

	@Then("Admin should see dropdown option for Program name")
	public void admin_should_see_dropdown_option_for_program_name() {
		try {
			boolean progdropdowndisplayed = assignmentPage.verifyProgramDropdown();
			LoggerLoad.logInfo("verify program Dropdown button is displayed  \" " + progdropdowndisplayed + "\" ");
			if (progdropdowndisplayed) {
				assertFalse(true, "Dropdown button is displayed ");
			} else {
				assertFalse(false, "Dropdown button is  not displayed");
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Admin should see dropdown option for Program name ");

		}

	}

	@Then("Admin should see  calendar icon for assignment due date")
	public void admin_should_see_calendar_icon_for_assignment_due_date() {
		try {
			boolean calendarvalue = basePage.verifyCalenderIcon();
			LoggerLoad.logInfo("verify calendar icon is displayed \" " + calendarvalue + "\" ");
			if (calendarvalue) {
				assertFalse(true, "calendar icon is displayed ");
			} else {
				assertFalse(false, "calendar icon is  not displayed");
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Admin should see  calendar icon for assignment due date ");

		}

	}

	@Then("Admin should see  save button in the {string} popup window")
	public void admin_should_see_save_button_in_the_popup_window(String heading) {
		try {
			boolean savebuttondisp = basePage.verifysavebutton();
			LoggerLoad.logInfo("verify save button is displayed \" " + savebuttondisp + "\" ");
			if (savebuttondisp) {
				assertFalse(true, "save button is displayed for " + heading);
			} else {
				assertFalse(false, "save button is  not displayed for" + heading);
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Admin should see  save button in the {string} popup window for " + heading);

		}

	}

	@Then("Admin should see  close button on the {string} popup window")
	public void admin_should_see_close_button_on_the_popup_window(String heading) {
		try {
			boolean closebtn = basePage.verifyclosebutton();
			LoggerLoad.logInfo("verify close button is displayed \" " + closebtn + "\" ");
			if (closebtn) {
				assertFalse(true, "close button is displayed for " + heading);
			} else {
				assertFalse(false, "close button is  not displayed for" + heading);
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Admin should see  close button on the {string} popup window for " + heading);

		}

	}

	@Then("Admin should see  cancel button in the {string} popup window")
	public void admin_should_see_cancel_button_in_the_popup_window(String heading) {
		try {
			boolean cancelbt = basePage.verifycancelbutton();
			LoggerLoad.logInfo("verify cancel button is displayed \" " + cancelbt + "\" ");
			if (cancelbt) {
				assertFalse(true, "cancel button is displayed for " + heading);
			} else {
				assertFalse(false, "cancel button is  not displayed for" + heading);
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Admin should see  cancel button in the {string} popup window for" + heading);

		}

	}

	// common method to verify the Add New button
	@Then("Admin should see {string} button on the {string} page")
	public void admin_should_see_button_on_the_page(String addBtnName, String pageName) {
		boolean addNewButtonDisplayed;
		try {

			switch (pageName) {
			case "Manage Program":
				addNewButtonDisplayed = programPage.verifyAddButtonDisplayed(addBtnName);
				LoggerLoad.logInfo("verify Add new button is displayed : ");
				if (addNewButtonDisplayed) {
					assertTrue(true, "Add button is displayed in Program page");
				} else {
					assertFalse(true, "Add button is not displayed in Program page");
				}
			case "Manage Assignment":
				addNewButtonDisplayed = assignmentPage.verifyAddButtonDisplayed(addBtnName);
				LoggerLoad.logInfo("verify Add new button is displayed : ");
				if (addNewButtonDisplayed) {
					assertTrue(true, "Add button is displayed in Assignment page");
				} else {
					assertFalse(true, "Add button is not displayed in Assignment page");
				}

			}

		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Failed - Admin should see " + addBtnName + " button on the " + pageName + " page");
		}

	}

	// Common method to verify entries along with Pagination
	@Then("Admin should see text Showing x to y of z entries along with pagination icon on {string} page")
	public void admin_should_see_text_showing_x_to_y_of_z_entries_along_with_pagination_icon_on_page(String pageName) {
		try {
			switch (pageName) {
			case "Program":
				LoggerLoad.logInfo("verify correct footer is displayed in Program page : ");
				if (programPage.verifyPaginationEntriesText("Programs")) {
					assertTrue(true, "Correct entry details are displayed in Program Page");
				} else {
					assertFalse(false, "Correct entry details are not displayed in Program Page");
				}
			case "Assignment":
				LoggerLoad.logInfo("verify correct entry details are displayed in Assignment page : ");
				if (assignmentPage.verifyPaginationEntriesText("Assignments")) {
					assertTrue(true, "Correct entry details are displayed in Assignments Page");
				} else {
					assertFalse(false, "Correct entry details are not displayed in Assignments Page");
				}

			}
		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Correct entry details are not displayed in " + pageName + " page");
		}

	}

	// Common method to verify the footer text
	@Then("Admin should see correct footer text on {string} page")
	public void admin_should_see_correct_footer_text_on_page(String pageName) {
		try {
			switch (pageName) {
			case "Program":
				LoggerLoad.logInfo("verify correct footer is displayed in Program page : ");
				if (programPage.verifyFooter("Programs")) {
					assertTrue(true, "Correct Footer displayed in Program Page");
				} else {
					assertFalse(false, "Correct Footer is not displayed in Program Page");
				}
			case "Assignment":
				LoggerLoad.logInfo("verify correct footer is displayed in Program page : ");
				if (programPage.verifyFooter("Assignments")) {
					assertTrue(true, "Correct Footer displayed in Assignments Page");
				} else {
					assertFalse(false, "Correct Footer is not displayed in Assignments Page");
				}

			}
		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Correct Footer is not displayed in " + pageName + " page");
		}

	}

	// Common method to verify the no.of rows displayed in a page is 5
	@Then("Admin should see {int} records displayed on the {string} page")
	public void admin_should_see_records_displayed_on_the_page(Integer number, String pageName) {
		try {
			switch (pageName) {
			case "Program":
				LoggerLoad.logInfo("verify correct number of records(5) are displayed in Program page : ");
				if (programPage.verifyRecordCountinPage(number)) {
					assertTrue(true, number + "records are displayed in Program Page");
				} else {
					assertFalse(false, number + "records are not displayed in Program Page");
				}
			}
		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Correct number of records are not displayed in " + pageName + " page");
		}
	}

	@When("Admin clicks Edit button in data table for {string}")
	public void admin_clicks_edit_button_in_data_table(String page) {
		try {
			rowData = basePage.clickEditIconForRows(page);
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin clicks Edit button in data table");
		}

	}

	@When("Admin clicks delete button in data table for {string}")
	public void admin_clicks_delete_button_in_data_table_for(String page) {
		try {
			rowData = basePage.clickDeleteIconForRows(page);
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin clicks Edit button in data table");
		}

	}

	@Then("Admin should see dialog box for {string}")
	public void admin_should_see_dialog_box_for(String page) {
		try {
			String confirmText = basePage.verifyPopUpforDelete(page);
			assertTrue(confirmText.contains("Are you sure you want to delele"));
		} catch (Exception e) {
			assertFalse(false, "Admin should see dialog box for {string}");
		}
	}

	@Then("Alert should have {string} button to accept")
	public void alert_should_have_button_to_accept(String buttonName) {
		try {
			basePage.verifyAlertButtons(buttonName);
		} catch (Exception e) {
			assertFalse(false, "Admin should see dialog box for {string}");
		}

	}

	@Given("Admin is in delete alert for {string}")
	public void admin_is_in_delete_alert(String page) {
		try {
			switch (page) {
			case "Assignmemt":
				rowData = assignmentPage.navigateToAssignmentDeletePage();
				break;

			default:
				break;
			}

		} catch (Exception e) {
			assertFalse(false, "Failed - Admin is in delete alert for {string}");
		}
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String buttonName) {
		try {
			basePage.clickAlertButtons(buttonName);
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin clicks {string} button");
		}

	}

	@When("Admin clicks check box in the data table for {string} for {int} checkbox")
	public void admin_clicks_check_box_in_the_data_table_for(String page, int noOfCheckBox) {
		try {
			basePage.clickCheckboxForRows(page, noOfCheckBox);
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin clicks check box in the data table for {string}");
		}
	}

	@Then("Admin should see delete icon below the header is enabled")
	public void admin_should_see_delete_icon_below_the_header_is_enabled() {
		try {
			assertTrue(basePage.verifyDeleteButtonEnabled(), "Delete button enabled");
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin clicks check box in the data table for {string}");
		}
	}

	@Then("Redirected to assignment page and selected assignment details are deleted from the data table for {string}")
	public void redirected_to_assignment_page_and_selected_assignment_details_are_deleted_from_the_data_table(
			String deleteOption) {

		try {
			assignmentPage.verifyManageAssignmentPage();
			for (int i = 0; i < rowData.size(); i++) {
				basePage.sendDataToSearchBox(rowData.get(0));
				List<String> result = basePage.getDataForSearch("name");
				if (result.size() == 0) {
					assertTrue(true, "Item Deleted");
				} else {
					assertFalse(false, "Item did not get Deleted");
				}
			}
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Redirected to assignment page and selected assignment details are deleted from the data table");
		}
	}

	@Then("Redirected to assignment page and selected assignment details are not deleted from the data table for {string}")
	public void redirected_to_assignment_page_and_selected_assignment_details_are_not_deleted_from_the_data_table(
			String deleteOption) {
		try {
			assignmentPage.verifyManageAssignmentPage();

			for (int i = 0; i < rowData.size(); i++) {
				basePage.sendDataToSearchBox(rowData.get(i));
				List<String> result = basePage.getDataForSearch("name");
				if (result.size() > 0) {
					assertTrue(true, "Item did not get Deleted");
				} else {
					assertFalse(false, "Item  Deleted");
				}
			}

		} catch (Exception e) {
			assertFalse(false,
					"Failed - Redirected to assignment page and selected assignment details are not deleted from the data table");
		}
	}

	@Then("Admin should see the pagination has Next link in {string} Page")
	public void admin_should_see_the_pagination_has_next_link_in_page(String pageName) {
		try {
			boolean isDisplayed = basePage.isNextLinkDisplayed();
			LoggerLoad.logInfo("verify Next link is displayed : \" " + isDisplayed + "\" ");
			if (isDisplayed) {
				assertTrue(true, "Next link is displayed" + pageName + " page");
			} else {
				assertFalse(false, "Next link is not displayed" + pageName + " page");
			}

		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Failed - Admin should see Next link displayed in " + pageName + " page");

		}
	}

	@Then("Admin should see next page link disabled on clicking last page record in {string} Page")
	public void admin_should_see_next_page_link_disabled_on_clicking_last_page_record_in_page(String pageName) {
		try {
			boolean isDisabled = basePage.isNextLinkDisabled();
			LoggerLoad.logInfo("verify Next link is disabled  on clicking last page record: \" " + isDisabled + "\" ");
			if (isDisabled) {
				assertTrue(true, "Next link is disabled on clicking last page record of " + pageName + " page");
			} else {
				assertFalse(false, "Next link is not disabled on clicking last page record of " + pageName + " page");
			}

		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Failed - Admin should see Next link disabled on clicking last page record of  "
					+ pageName + " page");

		}
	}

	@Then("Admin should see the pagination has Previous link in {string} Page")
	public void admin_should_see_the_pagination_has_previous_link_in_page(String pageName) {
		try {
			boolean isDisplayed = basePage.isPreviousLinkDisplayed();
			LoggerLoad.logInfo("verify Previous link is displayed : \" " + isDisplayed + "\" ");
			if (isDisplayed) {
				assertTrue(true, "Previous link is displayed" + pageName + " page");
			} else {
				assertFalse(false, "Previous link is not displayed" + pageName + " page");
			}

		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Failed - Admin should see Previous link displayed in " + pageName + " page");

		}
	}

	@Then("Admin should see previous page link disabled on clicking first page record in {string} page")
	public void admin_should_see_previous_page_link_disabled_on_clicking_first_page_record_in_page(String pageName) {
		try {
			boolean isDisabled = basePage.isFirstLinkDisabled();
			LoggerLoad.logInfo(
					"verify Previous link is disabled  on clicking first page record: \" " + isDisabled + "\" ");
			if (isDisabled) {
				assertTrue(true, "Previous link is disabled on clicking first page record of " + pageName + " page");
			} else {
				assertFalse(false,
						"Previous link is not disabled on clicking first page record of " + pageName + " page");
			}

		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Failed - Admin should Previous link disabled on clicking first page record of  "
					+ pageName + " page");

		}
	}

	@Then("Admin should get redirected to {string} page")
	public void admin_should_get_redirected_to_page(String pageName) throws Exception {
		basePage.redirectToPage(pageName);
	}

	@When("Admin clicks Edit button in data table")
	public void admin_clicks_edit_button_in_data_table() {
		try {
			basePage.clickEditIconForRows();
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin clicks Edit button in data table");
		}
	}

	@Then("Edit popup window appears with heading {string}")
	public void edit_popup_window_appears_with_heading(String headingTitle) {
		try {
			String heading = basePage.getPopUpPageHeadingString();
			assertEquals(heading, headingTitle);
		} catch (Exception e) {
			assertFalse(false, "Failed - Admin should see a popup  with  heading {string}");
		}
	}

	@Then("Admin should see if the link is broken for {string} page")
	public void admin_should_see_if_the_link_is_broken_for_page(String pageName) {
		try {
			boolean brokenFlag = basePage.isBrokenLink(pageName);
			if (!brokenFlag) {
				assertTrue(true, "Link is not broken for " + pageName + " page");
			} else {
				assertFalse(true, "Link is broken for " + pageName + " page");
			}
		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Failed - Admin should see link is not broken in " + pageName + " page");
		}
	}

	@Then("Admin should see {string}  alert message")
	public void admin_should_see_alert_message(String message) {
		String actualAlertText = basePage.getAlertForAddUpdate();
		if (actualAlertText.equals(message)) {
			assertTrue(true, "Correct Alert message" + message + "is displayed");
		} else {
			assertTrue(false, "Correct Alert message" + message + "is NOT displayed");
		}

	}

}
