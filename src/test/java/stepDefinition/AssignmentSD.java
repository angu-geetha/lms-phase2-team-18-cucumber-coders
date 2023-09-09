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


public class AssignmentSD {

AssignmentPage assignmentPage = new AssignmentPage();

Map<String, String> excelDataMap;

static long startTime;

static long endTime;

static long  totalTime;

@Given("Admin is in login page")

public void admin_is_in_login_page() {

LoggerLoad.logInfo("Admin is in login page");

assignmentPage.login_page();

}

@When("Admin enter valid credentials and clicks login button")

public void admin_enter_valid_credentials_and_clicks_login_button() {

LoggerLoad.logInfo("Admin enter valid credentials and clicks login button");

excelDataMap = null;

String userName=null, password=null;

try {

excelDataMap = ExcelReader.getData("valid_login", "login");

if (null != excelDataMap && excelDataMap.size() > 0) 

{

userName = excelDataMap.get("userName") ;

password = excelDataMap.get("password") ;

}

assignmentPage.doLogin(userName, password);

} catch (Exception e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

}

@Then("Admin should land on dashboard page")

public void admin_should_land_on_dashboard_page() {

LoggerLoad.logInfo("Admin should land on dashboard page");

String Title = assignmentPage.verifyDashboardPage();

LoggerLoad.logInfo("Title of the Dashboard Page : \" " + Title + "\" ");

assertEquals(Title, ConfigReader.getProperty("dashboardTitle"), "Title do not match");

}

@Given("Admin is on dashboard page after Login")

public void admin_is_on_dashboard_page_after_login() {

LoggerLoad.logInfo("Admin is on dashboard page after Login");

assignmentPage.dashboardPage();

startTime = System.currentTimeMillis();

}

@When("Admin clicks assignment button on the navigation bar")

public void admin_clicks_assignment_button_on_the_navigation_bar() {



try {

assignmentPage.selectModuleLinks("Assignment");

LoggerLoad.logInfo("Admin clicks assignment button on the navigation bar");

} catch (Exception e) {

LoggerLoad.logError(e.getMessage());

assertFalse(false, "Failed - Admin clicks {string} button on the navigation bar");

}

}

@Then("Admin should see URL with UrlName")

public void admin_should_see_url_with_url_name() {

try {

String Title = assignmentPage.verifyManageAssignmentPage();

LoggerLoad.logInfo("Title of the Manage Assignment Page : \" " + Title + "\" ");

assertEquals(Title, ConfigReader.getProperty("manageAssignmentTitle"), "Title do not match");

} catch (Exception e) {

LoggerLoad.logError(e.getMessage());

assertFalse(false, "Failed - Admin should see URL with {string}");

}

}

@Then("Get the response time for navigation from dashboard page to manage assignment page")

public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_assignment_page() {

try {  endTime = System.currentTimeMillis();

totalTime = endTime - startTime;

ConfigReader.setProperty("responsetime", "totalTime");

System.out.println("Total Page Load Time: " + totalTime + " milliseconds");

LoggerLoad.logInfo("Get the response time for navigation from dashboard page to manage assignment page");

assertEquals(totalTime, ConfigReader.getProperty("responsetime"), "responsetime do not match");

} catch (Exception e) {

LoggerLoad.logError(e.getMessage());

assertFalse(false, "Failed - Admin should validate response time");

}

}

@Then("Admin should see header with UrlName")

public void admin_should_see_header_with_url_name() {



try {

String header = assignmentPage.verifyManageAssignmentPageHeader();

LoggerLoad.logInfo("header of the Manage Assignment Page : \" " + header + "\" ");

assertEquals(header, ConfigReader.getProperty("manageAssignmentHeader"), "header do not match");

} catch (Exception e) {

LoggerLoad.logError(e.getMessage());

assertFalse(false, "Failed - Admin should see URL with {string}");

}

}

@When("Admin clicks assignment button on the navigation bar and get all text from the portal page {string}")

public void admin_clicks_assignment_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page(String string) {



}

@Then("Admin should see correct spelling for the all the fields")

public void admin_should_see_correct_spelling_for_the_all_the_fields() {



}

@Then("Admin should see disabled delete icon below the UrlName")

public void admin_should_see_disabled_delete_icon_below_the_url_name() {

}

@Then("Admin should see search bar on the manage assignment page")

public void admin_should_see_search_bar_on_the_manage_assignment_page() {

}

@Then("Admin should see +Add New assignment button on the manage assignment page")

public void admin_should_see_add_new_assignment_button_on_the_manage_assignment_page() {

}

@Then("Admin should see data table on the manage assignment page With following column headers {string}")

public void admin_should_see_data_table_on_the_manage_assignment_page_with_following_column_headers(String string) {

}

}