package stepDefinition;

import static org.testng.Assert.assertEquals;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Login_PO;
public class login_SD {
	@Given("Admin is in home page")
	public void admin_is_in_home_page() throws InterruptedException {
		String expected="https://dsportalapp.herokuapp.com/home";
		String actual=DriverFactory.getdriver().getCurrentUrl();
			System.out.println("url chceck   "+expected+actual);
			Thread.sleep(3000);
		    assertEquals(expected,actual,"passes");
	    
	}

	@When("Admin clicks Login button")
	public void admin_clicks_login_button() {
	    lg.login_click();
	    
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	   lg.login_page();
	}

	@Then("Admin Should redirected to login Page")
	public void admin_should_redirected_to_login_page() {
	    lg.login_page();
	}

	@Then("Admin should see {string} in the title")
	public void admin_should_see_in_the_title(String string) {
	    lg.verify_title();
	    String expected="title";
		String actual=DriverFactory.getdriver().getTitle();
			System.out.println("title chceck   "+expected+actual);
		    assertEquals(expected,actual,"passes");
	    
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		lg.verify_two_text_Box();

	    
	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
	    lg.FirstTextBoxUser();
	}

	@Then("Admin should see {string} in the second text field")
	public void admin_should_see_in_the_second_text_field(String string) {
	    lg.secondTextBoxPassword();
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	    lg.allignment_input();
	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
	    lg.login_Allignment();
	}

	@Then("Admin should see forgot username or password link")
	public void admin_should_see_forgot_username_or_password_link() {
	    lg.displayForgetPwd();
	}

	@Then("Admin should see reset password link")
	public void admin_should_see_reset_password_link() {
	    lg.resetpwd_link();
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
	    lg.user_color();
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
	    lg.password_color();
	}

	
	private Login_PO lg=new Login_PO(DriverFactory.getdriver());
	@Then("Admin should see {string} symbol next to User text")
	public void admin_should_see_symbol_next_to_user_text(String string) {
     lg.verify_Aestrick_user();

	}

	@Then("Admin should see {string} symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text(String string) {
	  lg.verify_Aestrick_password();
	}


}
