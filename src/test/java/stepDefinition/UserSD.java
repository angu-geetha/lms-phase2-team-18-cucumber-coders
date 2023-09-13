package stepDefinition;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import dataProviders.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;

public class UserSD extends Commonclass{
	
	Map<String, String> excelDataMap;

	@When("Admin clicks user button on the navigation bar")
	public void admin_clicks_user_button_on_the_navigation_bar() {
		try {
			userPage.selectHeaderLink("User");
			LoggerLoad.logInfo("Admin clicks user button on the navigation bar");

		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Failed - Admin clicks user button on the navigation bar");
		}
	}
	
	@Then("Admin should see data table on the manage user page With following column headers {string} with {string}")
	public void admin_should_see_data_table_on_the_manage_user_page_with_following_column_headers_with(String dataKey, String sheetName) {
		try {
			excelDataMap = ExcelReader.getData(dataKey, sheetName);
			assertTrue(programPage.isTableHeadersPresent());
			programPage.validateTableHeaders(excelDataMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertFalse(false,
					"Failed - Admin should see data table on the manage User page With following column headers");
		}
	}
	
	
	@Then("Admin should see {string} button on the manage User page")
	public void admin_should_see_addStaffbutton_on_the_page(String addBtnName) {
		boolean addNewStaffButtonDisplayed = userPage.verifyAddStaffButtonDisplayed(addBtnName);
		LoggerLoad.logInfo("verify Add new staff button is displayed : ");
		if (addNewStaffButtonDisplayed) {
			assertTrue(true, "Add New Staff button is displayed in User page");
		} else {
			assertFalse(true, "Add New Staff is not displayed in User page");
		}
	}
	
	@Then("Admin should land on manage user page")
	public void admin_should_land_on_manage_user_page() {
		try {
			userPage.user_page();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin is on manage user page");
		}
	}
	
	@Given("Admin is on manage user page")
	public void admin_is_on_manage_user_page() {
		try {
			userPage.user_page();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin should land on manage user page");
		}
	}
	
	@When("Admin click +Add new user button")
	public void admin_click_add_new_user_button() {
		try {
			userPage.clickAddButton();
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin cannot click on Add new user button");
		}
	}
	
	@Given("Admin is in  user details popup window")
	public void admin_is_in_user_details_popup_window()  {
		  try {
			    userPage.user_page();
				userPage.clickAddButton();
			} catch (Exception e) {
				assertFalse(false,
						"Failed - Admin clicks + add new  button on manage user page");
			}
	}
	
	@When("Admin enters data for all fields with valid values")
	public void Admin_enters_data_for_all_fields_with_valid_values() {
		userPage.addNewUserDetails();
	}
	
	@When("Admin enters data for all fields except optional with valid values")
	public void Admin_enters_data_for_all_fields_except_optional_with_valid_values() {
		userPage.addNewUserMandatoryDetails();
	}
	
	@Then("Admin should see new user details is added in the data table")
	public void Admin_should_see_new_user_details_is_added_in_the_data_table() {
		try {
			List<String> getProgramRow = userPage.getUserDataForSearch("name");
			assertTrue(getProgramRow.contains(excelDataMap.get("userName")));
		} catch (Exception e) {
			assertFalse(false,
					"Failed - Admin should see new user details is added in the data table");
		}

	}
	
	@Then("Redirected to user page and selected user details are deleted from the data table for {string}")
	public void redirected_to_user_page_and_selected_user_details_are_deleted_from_the_data_table(
			String deleteOption) {

		try {
			userPage.verifyManageUserPage();
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
					"Failed - Redirected to user page and selected user details are deleted from the data table");
		}
	}

	@Then("Redirected to user page and selected user details are not deleted from the data table for {string}")
	public void redirected_to_user_page_and_selected_user_details_are_not_deleted_from_the_data_table(
			String deleteOption) {
		try {
			userPage.verifyManageUserPage();

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
					"Failed - Redirected to user page and selected user details are not deleted from the data table");
		}
	}

	

}
