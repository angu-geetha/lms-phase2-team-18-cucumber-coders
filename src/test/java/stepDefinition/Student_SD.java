package stepDefinition;
import pageObjects.*;
import dataProviders.*;
import org.apache.logging.log4j.core.appender.rolling.action.Duration;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.StudentPage;


public class Student_SD {
	private static WebDriver driver;
	StudentPage stPg = new StudentPage(driver);
	DashboardPage dashboardPage = new DashboardPage(driver);

	@Given("Admin is on the dashboard page after login")
	public void admin_is_on_the_dashboard_page_after_login() throws InterruptedException {
	// open dashboard url
	dashboardPage.visit_LMS_url();
	// click login
	dashboardPage.clickMainPageLogin_btn();
	// enter u/pswd
	//prop.getProperty("username");
	dashboardPage.enterUsername(ConfigReader.getProperty("username"));
	dashboardPage.enterPassword(ConfigReader.getProperty("password"));
	// click login
	dashboardPage.clickLogin();
	// click student link
	Assert.assertEquals("Dashboard Page", dashboardPage.getCurrentPageTitle());
	}

	@When("Admin clicks Student on the navigation bar")
	public void admin_clicks_student_on_the_navigation_bar() {
	dashboardPage.clickStudentLink();
	Assert.assertEquals("Student Details Page", stPg.getCurrentPageTitle());
	}

	@Then("Admin should see the Student details Page Title")
	public void admin_should_see_the_student_details_page_title() {
	Assert.assertEquals("Student Details Page", stPg.getCurrentPageTitle());
	}

	@Then("Admin should see Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void admin_should_see_maximum_navigation_time_in_milliseconds_defaults_to_seconds(int seconds) {
	try {
	// This is just a generic wait condition for the sake of this example.
	// You'll need to replace this with the actual condition you're waiting for.
	// For instance, this waits for the dashboard URL to be loaded.
	WebDriverWait wait = new WebDriverWait(driver, null, null);
	wait.until(ExpectedConditions.urlContains("Student"));

	// If it gets past the wait without exception, it means the page loaded within
	// the expected time frame
	} catch (TimeoutException e) {
	Assert.fail("Navigation took longer than " + seconds + " seconds");
	}
	}

	@Then("Admin should see LMS-Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
	Assert.assertEquals("LMS-Learning management system", stPg.getlmsTitleText());
	}

	@Then("Admin should see Student Detail title in the center of the page")
	public void admin_should_see_student_detail_title_in_the_center_of_the_page() {
	Assert.assertTrue("Student Detail title is not centered at the top of the page.",
	stPg.isStudentDetailTitleCenteredAtTop());

	}

	@Then("Admin should see Two dropdowns on the page")
	public void admin_should_see_two_dropdowns_on_the_page() {

	Assert.assertTrue(stPg.isDropdownVisible("Student Name"));
	Assert.assertTrue(stPg.isDropdownVisible("Batch Id"));
	}

	@Then("Admin should see a search box inside the Student name dropdown")
	public void admin_should_see_a_search_box_inside_the_student_name_dropdown() {
	Assert.assertTrue(stPg.isSearchBoxVisible("Student Name"));

	}

	@Then("Admin should see a search box inside the batch ID dropdown")
	public void admin_should_see_a_search_box_inside_the_batch_id_dropdown() {
	Assert.assertTrue(stPg.isSearchBoxVisible("Batch Id"));
	}

	@Then("Admin should see correct spelling for {string}")
	public void admin_should_see_correct_spelling_for(String string) {
	Assert.assertTrue(stPg.isDropDownSpellingCorrect(string));
	}

	@Then("Admin should see select student name in gray color and the correct spelling")
	public void admin_should_see_select_student_name_in_gray_color_and_the_correct_spelling() {
	// Write code here that turns the phrase above into concrete actions
	throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see select batch ID in gray color and only numbers")
	public void admin_should_see_select_batch_id_in_gray_color_and_only_numbers() {
	// Write code here that turns the phrase above into concrete actions
	throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see {string} in first dropdown")
	public void adminShouldSeeLabelInFirstDropdown(String expectedLabel) {
	Assert.assertEquals(expectedLabel, stPg.firstDropDownTitle(expectedLabel));
	}

	@Then("Admin should see {string} in second dropdown")
	public void adminShouldSeeLabelInSecondDropdown(String expectedLabel) {
	Assert.assertEquals(expectedLabel, stPg.secondDropDownTitle(expectedLabel));
	}

	@When("Admin selects student name from the student name dropdown")
	public void admin_selects_student_name_from_the_student_name_dropdown() {
	stPg.clickStudentDropDown();
	}

	@Then("Admin should be able to scroll down to select the name")
	public void admin_should_be_able_to_scroll_down_to_select_the_name() {
	Assert.assertEquals(stPg.selectNameFromStudentDropdown(), "Steve");
	}

	@Then("Admin should be able to scroll down to select the batch ID")
	public void admin_should_be_able_to_scroll_down_to_select_the_batch_id() {
	Assert.assertEquals(stPg.selectBatchIdFromBatchDropdown(), "8428");
	}

	@When("Admin selects batch ID from the batch ID dropdown")
	public void admin_selects_batch_id_from_the_batch_id_dropdown() {
	stPg.clickBatchIdDropDown();

	}

	@Then("Admin should not see {string} text")
	public void admin_should_not_see_text(String string) {
	Assert.assertNotEquals(stPg.selectNameFromStudentDropdown(), string);
	}

	@When("Admin selects {string} alphabet in the search box from the student name dropdown")
	public void admin_selects_alphabet_in_the_search_box_from_the_student_name_dropdown(String string) {
	stPg.findStudentNameByAlphabet("Student Name", string);
	}

	@Then("Admin should see student names starting with {string} listed below")
	public void admin_should_see_student_names_starting_with_listed_below(String string) {
	String dropDownValue = stPg.selectStudentNameByAlphabet("Student Name");
	Assert.assertTrue(dropDownValue.startsWith(string));
	}

	@When("Admin selects {string} number in the search box from the batch ID dropdown")
	public void admin_selects_x_number_in_the_search_box_from_the_batch_id_dropdown(String string) {
	stPg.findStudentNameByAlphabet("Batch Id", string);
	}

	@Then("Admin should see batch IDs starting with {string} listed below")
	public void admin_should_see_batch_i_ds_starting_with_listed_below(String string) {
	String dropDownValue = stPg.selectStudentNameByAlphabet("Batch Id");
	Assert.assertTrue(dropDownValue.startsWith(string));
	}

	@When("Admin selects both a student name and batch ID from their respective dropdowns")
	public void admin_selects_both_a_student_name_and_batch_id_from_their_respective_dropdowns() {
	stPg.clickStudentDropDown();
	stPg.selectNameFromStudentDropdown();
	stPg.clickBatchIdDropDown();
	stPg.selectBatchIdFromBatchDropdown();
	}

	@Then("The selected student information should be displayed")
	public void the_selected_student_information_should_be_displayed() {
	Assert.assertTrue(stPg.isStudentResultDisplayed());
	}
	

}
