package stepDefinition;
import pageObjects.*;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Login_CredentialPO;

public class Login_Forget_SD {
	String color;
	Login_CredentialPO lc=new Login_CredentialPO(DriverFactory.getdriver());
	Login_ForgetPO lf=new Login_ForgetPO(DriverFactory.getdriver());
	
	

	@When("Admin clicks forgot username or password link")
	public void admin_clicks_forgot_username_or_password_link() {
	   lf.click_forget_password();
	}

	@Then("Admin should land on forgot username or password page")
	public void admin_should_land_on_forgot_username_or_password_page() {
	    lf.Forget_Password_Page();
	}

	@Then("Admin should see Email text in gray color")
	public void admin_should_see_email_text_in_gray_color() {
		lf.Email_txt_box();
	}

	@Then("Admin should see Email in text field")
	public void admin_should_see_email_in_text_field() {
	    lf.Email_box_display();
	}

	@Then("Admin should see send Link  button")
	public void admin_should_see_send_link_button() {
		lf.Send_link_button();
	    
	}

	@Then("Admin should see asterik symbol near Email")
	public void admin_should_see_asterik_symbol_near_email() {
	    lf.verify_Aestrick_Email();
	}

	@Then("Admin should see send link button in center of the page")
	public void admin_should_see_send_link_button_in_center_of_the_page() {
		lf.Allignment_SEndLinkbtn();
	    
	}

	@When("Admin Enter Valid Email Id")
	public void admin_enter_valid_email_id() {
	    lf.Enter_Email();
	}

	@When("Admin click on Send Link")
	public void admin_click_on_send_link() {
	    lf.Click_SendLink();
	}

	@Then("Admin should receive link in email for reset username\\/password")
	public void admin_should_receive_link_in_email_for_reset_username_password() {
		lf.SuccessMsg_Email();
	    
	}

	@When("Admin Enter inValid Email Id")
	public void admin_enter_in_valid_email_id() {
		
	    lf.Enter_invalid_Email();
	}

	@Then("Admin should not receive link in email for reset username\\/password")
	public void admin_should_not_receive_link_in_email_for_reset_username_password() {
		lf.Error_Msg_Email();
	   
	}


}
