package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
	   
	}

	@Then("Admin should see a popup  with  heading {string}")
	public void admin_should_see_a_popup_with_heading(String string) {
	    
	}
	
}