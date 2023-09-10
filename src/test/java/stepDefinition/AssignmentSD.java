package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

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
		boolean addassigbutton = assignmentPage.verifyAddAssignmenthButton();
		try {
			LoggerLoad.logInfo("verify search button : \" " + addassigbutton + "\" ");

			assertEquals(addassigbutton, ConfigReader.getProperty("truevalue"), "addassigbutton button not displayed");
		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin should see +Add New assignment button on the manage assignment page");

		}

	}

	@Then("Admin should see data table on the manage assignment page With following column headers {string}")

	public void admin_should_see_data_table_on_the_manage_assignment_page_with_following_column_headers(String string) {

	}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}