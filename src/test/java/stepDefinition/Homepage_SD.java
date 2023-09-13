package stepDefinition;
import static org.testng.Assert.assertEquals;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Exception;
import pageObjects.BasePage;
import pageObjects.HomePagePO;
import utilities.LoggerLoad;

public class Homepage_SD {
	String actual_PageUrl, expected_PageUrl;
	BasePage bp=new BasePage();
	private HomePagePO hp=new HomePagePO(DriverFactory.getdriver());
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		 String landingPage=DriverFactory.getdriver().getCurrentUrl();
		  String expectedLandingPage="https://lmsk.herokuapp.com/";
		  assertEquals(landingPage,expectedLandingPage);	
	}

	@When("Admin gives the Valid LMS portal URL")
	public void admin_gives_the_valid_lms_portal_url() {
		hp.Valid_Url();
		LoggerLoad.logInfo("user enter valid URl for Lms Prtal" );
	    
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() throws InterruptedException {
	String expected="https://dsportalapp.herokuapp.com/home";
	String actual=DriverFactory.getdriver().getCurrentUrl();
		System.out.println("url chceck   "+expected+actual);
		Thread.sleep(3000);
	    assertEquals(expected,actual,"passes");
	  
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
	    hp.invalid_url();
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
	    hp.getErr_msg();
	}

	@Then("HTTP response >= {int} the link is broken")
	public void http_response_the_link_is_broken(Integer response)  {
      
	            
	    }
	    
	

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
	    
	}

	@Then("Admin should see correct logo of the LMS")
	public void admin_should_see_correct_logo_of_the_lms() {
		hp.Verify_logo();
	   
	}

	@Then("Admin should see logo is properly aligned")
	public void admin_should_see_logo_is_properly_aligned() {
		hp.verify_logo_allignment();
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		hp.login_visible();
	    
	}

	@Then("Admin should able to click the Login button")
	public void admin_should_able_to_click_the_login_button() {
	    hp.click_login();
	}

}
