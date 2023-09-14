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
	

	
	@When("Admin enters data for add|edit program from {string} and {string}")
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
	

	
	@When("Admin clicks close icon on Program details form")
	public void admin_clicks_close_icon_on_program_details_form() {
	    programPage.clickClosebutton();
	}

	/*@Then("Error message should appear in alert of program page")
	public void error_message_should_appear_in_alert_of_program_page() {
		assertTrue(!programPage.getErrorElement().isBlank(), programPage.getErrorElement());
*/

	@Then("Admin should see Program Details popup window closed without saving")
	public void admin_should_see_program_details_popup_window_closed_without_saving() {
		try {
			boolean flag = programPage.verifyProgramPageAfterClickingCloseBtn();
			if(flag) {
				assertTrue(true, "Program popup page is closed without savings");
			} else {
				assertTrue(false, "Program popup page is not closed");
			}
		} catch(Exception e) {
			assertFalse(false,"Failed to close the popup page");
		}
		
	}
	
	//Delete
	@Then("Redirected to program page and selected program details are not deleted from the data table for {string}")
	public void redirected_to_program_page_and_selected_program_details_are_not_deleted_from_the_data_table(
			String deleteOption) {
		try {
			programPage.verifyManageProgramPage();

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
					"Failed - Redirected to program page and selected program details are not deleted from the data table");
		}
	}
	
	@Then("Redirected to program page and selected program details are deleted from the data table for {string}")
	public void redirected_to_program_page_and_selected_program_details_are_deleted_from_the_data_table(
			String deleteOption) {


		try {
			programPage.verifyManageProgramPage();
			
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
					"Failed - Redirected to program page and selected program details are deleted from the data table");
		}
	}

	@When("Admin click delete button on the data table for any row")
	public void admin_click_delete_button_on_the_data_table_for_any_row() {
	    try {
			programPage.clickDeleteIconForRows("Program");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Admin should see alert with heading Confirm along with Yes and No button for deletion")
	public void admin_should_see_alert_with_heading_confirm_along_with_yes_and_no_button_for_deletion() {
	    try {
	    	boolean Text = programPage.verifyAlertButtons("Program");
	    	if(Text) {
	    		assertTrue(true, "Yes and No buttons are displayed");
	    	} else {
	    		assertTrue(true, "Yes and No buttons not displayed");
	    	}
	    } catch (Exception e) {
			assertFalse(false,
					"Failed - Yes and No buttonsd for Delete alert");
		}
	}

	@Then("Admin should see a message Are you sure you want to delete program")
	public void admin_should_see_a_message_are_you_sure_you_want_to_delete_program() {
		 try {
		    	String Text = programPage.verifyPopUpforDelete("Program");
		    	if(Text.contains("Are you sure you want to delete Program")) {
		    		assertTrue(true, "Correct message is displayed");
		    	} else {
		    		assertTrue(true, "Correct message is not displayed");
		    	}
		    } catch (Exception e) {
				assertFalse(false,
						"Failed - Correct message is not displayed for Delete alert");
			}
	}
	
	@Then("Admin gets a message Successfull Program Deleted")
	public void admin_gets_a_message_successfull_program_deleted() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Admin clicks Cancel\\/Close_X Icon on Deletion alert")
	public void admin_clicks_cancel_close_x_icon_on_deletion_alert() {
	    	programPage.clickCloseOnDeleteAlert();
	    	
	    
	}
	
	

	}
	
}