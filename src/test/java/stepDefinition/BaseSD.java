package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Map;

import dataProviders.ConfigReader;
import dataProviders.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import utilities.LoggerLoad;

public class BaseSD extends Commonclass {

	public BaseSD() {

	}

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

			if (null != excelDataMap && excelDataMap.size() > 0)

			{

				userName = excelDataMap.get("userName");

				password = excelDataMap.get("password");

			}

			basePage.doLogin(userName, password);

		} catch (Exception e) {

// TODO Auto-generated catch block

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

		startTime = System.currentTimeMillis();

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

			String header = assignmentPage.verifyManageAssignmentPageHeader();

			LoggerLoad.logInfo("header of the Manage Assignment Page : \" " + header + "\" ");

			assertEquals(header, ConfigReader.getProperty(urlName), "header do not match");

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
				assertFalse(true, "Delete button is enabled in "+urlName+ " page");
			} else {
				assertFalse(false, "Delete button is disabled"+urlName+ " page");
			}

		} catch (Exception e) {

			LoggerLoad.logError(e.getMessage());

			assertFalse(false, "Failed - Admin should see disabled delete icon below the UrlName "+urlName+ " page");

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

}
