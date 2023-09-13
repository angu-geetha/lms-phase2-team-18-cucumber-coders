package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import dataProviders.ConfigReader;
import dataProviders.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProgramPage;
import utilities.LoggerLoad;

public class ProgramSD extends Commonclass {

	Map<String, String> excelDataMap;

	@When("Admin clicks program button on the navigation bar")
	public void admin_clicks_program_button_on_the_navigation_bar() {
		try {
			programPage.selectHeaderLink("Program");
			LoggerLoad.logInfo("Admin clicks program button on the navigation bar");

		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Failed - Admin clicks program button on the navigation bar");
		}
	}

	
	@Then("Admin should see data table on the manage program page With following column headers {string} with {string}")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_with(String dataKey, String sheetName) {
		try {
			excelDataMap = ExcelReader.getData(dataKey, sheetName);
			assertTrue(programPage.isTableHeadersPresent());
			programPage.validateTableHeaders(excelDataMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertFalse(false,
					"Failed - Admin should see data table on the manage Program page With following column headers");
		}
	}
	
	@Given("Admin is on manage program page")
	public void admin_is_on_manage_program_page() {
		try {
			programPage.program_page();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin should land on manage program page");
		}
	}

	@Then("Admin should land on manage program page")
	public void admin_should_land_on_manage_program_page() {
		try {
			programPage.program_page();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin is on manage program page");
		}
	}
	
	@When("Admin click +Add new program button")
	public void admin_click_add_new_program_button() {
		try {
			programPage.clickAddButton();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin cannot click on Add new Program button");
		}
	}

	@Then("Admin should see a popup  with  heading {string}")
	public void admin_should_see_a_popup_with_heading(String string) {
	    
	}
	
	@When("Admin clicks + add new  button on manage program page")
	public void admin_clicks_add_new_button_on_manage_program_page() {
	    try {
			programPage.clickAddButton();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin clicks + add new  button on manage program page");
		}
	}
	
	@Given("Admin is in  program details popup window")
	public void admin_is_in_program_details_popup_window()  {
		  try {
			    programPage.program_page();
				programPage.clickAddButton();
			} catch (Exception e) {
				assertFalse(false,
						"Failed - Admin clicks + add new  button on manage program page");
			}
	}
	

	
	@When("Admin enters data for add program from {string} and {string}")
	public void admin_enters_data_for_add_program_from_and(String dataKey, String sheetName) {
		try {
			excelDataMap = ExcelReader.getData(dataKey, sheetName);
			programPage.addNewEditExistProgramDetails(excelDataMap);
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin enters data for add program from {string} and {string}");
		}	
	}
	
	
	@Then("Admin should see new program details is added in the data table from {string} and {string}")
	public void admin_should_see_new_program_details_is_added_in_the_data_table_from_and(String dataKey, String sheetName) {
		try {
			excelDataMap = ExcelReader.getData(dataKey, sheetName);
			List<String> getProgramRow = programPage.getProgramDataForSearch("name");
			assertTrue(getProgramRow.contains(excelDataMap.get("programName")));
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin should see new program details is added in the data table from {string} and {string}");
		}

	}
	
	@Then("Error message should appear in alert of program page")
	public void error_message_should_appear_in_alert_of_program_page() {
		assertTrue(!programPage.getErrorElement().isBlank(), programPage.getErrorElement());

	}
	
	
	@Then("Error message with {string} should be displayed from {string} and {string}")
	public void error_message_with_should_be_displayed_from_and(String dataKey, String sheetName, String message) {
		   assertEquals(programPage.getErrorElement(), message);

	}
	
}