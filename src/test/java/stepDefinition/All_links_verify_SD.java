package stepDefinition;
import pageObjects.*;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class All_links_verify_SD {
	private HomePagePO hp=new HomePagePO(DriverFactory.getdriver());
	private StudentPage sp=new StudentPage(DriverFactory.getdriver());
	private All_links_verify_PO av=new All_links_verify_PO(DriverFactory.getdriver());
	@Given("Admin is logged into the LMS portal")
	public void admin_is_logged_into_the_lms_portal() {
	    hp.login_page();
	}

	@Given("Admin is in the student details page")
	public void admin_is_in_the_student_details_page() {
	    sp.student_page();
	}

	@When("Admin clicks student link on the navigation bar and get all text from the portal page {string}")
	public void admin_clicks_student_link_on_the_navigation_bar_and_get_all_text_from_the_portal_page(String str) throws Exception {
	    av.redirectToPage(str);
	}

	

}
