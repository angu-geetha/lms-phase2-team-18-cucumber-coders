package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dataProviders.ConfigReader;
import dataProviders.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AssignmentPage;
import utilities.LoggerLoad;

public class AssignmentSD extends Commonclass {

	Map<String, String> excelDataMap;

	@When("Admin clicks assignment button on the navigation bar")

	public void admin_clicks_assignment_button_on_the_navigation_bar() {

		try {

			assignmentPage.selectHeaderLink("Assignment");

			LoggerLoad.logInfo("Admin clicks assignment button on the navigation bar");

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin clicks assignment button on the navigation bar");

		}

	}

	@Then("Get the response time for navigation from dashboard page to manage assignment page")

	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_assignment_page() {
		LoggerLoad.logInfo("Get the response time for navigation from dashboard page to manage assignment page");
		try {
			endTime = System.currentTimeMillis();

			totalTime = endTime - startTime;

			LoggerLoad.logInfo(
					" response time for navigation from dashboard page to manage assignment page ::" + totalTime);

			if (totalTime > Integer.parseInt(ConfigReader.getProperty("MaxResponsetime"))) {
				assertFalse(true, "responsetime exceeded");
			} else {
				assertFalse(false, "responsetime exceeded");
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin should validate response time");

		}

	}

	@When("Admin clicks assignment button on the navigation bar and get all text from the portal page {string}")

	public void admin_clicks_assignment_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page(
			String headerlinks) {
		try {

			/*
			 * assignmentPage.selectModuleLinks("Assignment");
			 * 
			 * LoggerLoad.logInfo("Admin clicks assignment button on the navigation bar");
			 * 
			 * textname = assignmentPage.textModuleLinks(headerlinks);
			 */

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin clicks {string} button on the navigation bar");

		}

	}

	@Then("Admin should see correct spelling for the all the fields")

	public void admin_should_see_correct_spelling_for_the_all_the_fields() {

		/*
		 * String Title = assignmentPage.verifyManageAssignmentPage();
		 * 
		 * LoggerLoad.logInfo("Title of the Manage Assignment Page : \" " + Title +
		 * "\" ");
		 * 
		 * assertEquals(Title, ConfigReader.getProperty("manageAssignmentTitle"),
		 * "Title do not match");
		 * 
		 * String header = assignmentPage.verifyManageAssignmentPageHeader();
		 * 
		 * LoggerLoad.logInfo("header of the Manage Assignment Page : \" " + header +
		 * "\" ");
		 * 
		 * assertEquals(header, ConfigReader.getProperty("manageAssignmentHeader"),
		 * "header do not match");
		 * 
		 * String LMSheader = assignmentPage.verifyLMSPageHeader();
		 * 
		 * LoggerLoad.logInfo("header of the Learning Management System Page : \" " +
		 * LMSheader + "\" ");
		 * 
		 * assertEquals(header, ConfigReader.getProperty("LMSHeader"),
		 * "header do not match");
		 * 
		 * switch (textname) { case "Student": assertEquals(textname,
		 * ConfigReader.getProperty("Studentext"), "header do not match"); break; case
		 * "Program": assertEquals(textname, ConfigReader.getProperty("Programtext"),
		 * "header do not match"); break;
		 * 
		 * case "Batch": assertEquals(textname, ConfigReader.getProperty("Batchtext"),
		 * "header do not match"); break;
		 * 
		 * case "Class": assertEquals(textname, ConfigReader.getProperty("Classtext"),
		 * "header do not match"); break;
		 * 
		 * case "User": assertEquals(textname, ConfigReader.getProperty("Usertext"),
		 * "header do not match"); break;
		 * 
		 * case "Assignment": assertEquals(textname,
		 * ConfigReader.getProperty("Assignmenttext"), "header do not match"); break;
		 * case "Attendance": assertEquals(textname,
		 * ConfigReader.getProperty("Attendancetext"), "header do not match"); break;
		 * default: break; }
		 */

	}

	@Then("Admin should see +Add New assignment button on the manage assignment page")

	public void admin_should_see_add_new_assignment_button_on_the_manage_assignment_page() {
		try {
			boolean addAssignmentButtonDisplayed = assignmentPage.verifyAddAssignmenthButton();
			LoggerLoad.logInfo("verify delete button enabled : ");
			if (addAssignmentButtonDisplayed) {
				assertFalse(false, "Add button is enabled in Assignment page");
			} else {
				assertFalse(true, "Add button is disabled in Assignment page");
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin should see +Add New assignment button on the manage assignment page");

		}

	}

	@Then("Admin should see data table on the manage assignment page With following column headers {string} with {string}")

	public void admin_should_see_data_table_on_the_manage_assignment_page_with_following_column_headers(String dataKey,
			String sheetName) {
		try {
			excelDataMap = ExcelReader.getData(dataKey, sheetName);
			assertTrue(assignmentPage.isTableHeadersPresent());
			assignmentPage.validateTableHeaders(excelDataMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertFalse(false,
					"Failed - Admin should see data table on the manage assignment page With following column headers");
		}

	}

	
	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
		try {
			assignmentPage.validateSortElmtForHeaders();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin should see check box in the all rows  of data table when entries available");
		}
	}

	@Then("Admin should land on manage assignment page")
	public void admin_should_land_on_manage_assignment_page() {
		try {
			assignmentPage.verifyManageAssignmentPage();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin should land on manage assignment page");
		}
	}

	@Given("Admin is on manage assignment page")
	public void admin_is_on_manage_assignment_page() {
		try {
			assignmentPage.assignment_page();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin is on manage assignment page");
		}
	}

	@When("Admin click +Add new assignment button")
	public void admin_click_add_new_assignment_button() {
	   
	}



	

}