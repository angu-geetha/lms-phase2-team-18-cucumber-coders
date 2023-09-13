package stepDefinition;

import org.testng.asserts.SoftAssert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.*;
public class Login_Credential_SD {
	Login_CredentialPO lc=new Login_CredentialPO(DriverFactory.getdriver());

	@Given("User is on Login page")
	public void user_is_on_login_page() {
		lc.login_page();
	}

	@When("User enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String uname, String pwd) {
	    lc.login_entry(uname, pwd);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	   lc.logBtn_click();
	}

	@Then("It should navigate to the home page with a message {string}")
	public void it_should_navigate_to_the_home_page_with_a_message(String results) {
	   results= lc.success_login();
	   System.out.println("logged message should be"+results);
	}

	@When("User enters valid username as {string} and  Invalid password as {string} and gets the result {string}")
	public void user_enters_valid_username_as_and_invalid_password_as_and_gets_the_result(String string, String string2, String string3) {
	    
	}

	

	@Then("User verify the message as {string}")
	public void user_verify_the_message_as(String results) {
		
	}

	@When("Admin enter valid credentials and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
	    lc.login_entry_keyboard();
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	    lc.success_login();
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		lc.login_entry_mouse();
	    
	}




}
