package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class All_links_verify_PO{
	@FindBy(linkText="student") static WebElement studentLink;
	@FindBy(linkText="Program") static WebElement programLink;
	@FindBy(linkText="Batch") static WebElement batchLink;
	@FindBy(linkText="class") static WebElement classLink;
	@FindBy(linkText="user") static WebElement userLink;
	@FindBy(linkText="Assignment") static WebElement assignmentLink;
	@FindBy(linkText="Attendance") static WebElement attendanceLink;
	@FindBy(linkText="Logout") static WebElement logoutLink;
	
	WebDriver driver;
	public All_links_verify_PO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initializing WebElelements
		}

	public void redirectToPage(String pageName) throws Exception {
		switch(pageName) {
		case "Student": studentLink.click(); 
		break;
		case "Program": programLink.click();
		break;
		case "Batch": batchLink.click();
		break;
		case "Class": classLink.click();
		break;
		case "User": userLink.click();
		break;
		case "Attendance": attendanceLink.click();
		break;
		case "Assignment": assignmentLink.click();
		break;
		case "Logout": logoutLink.click();
		break;
		default:
			throw(new Exception("Unable to redirect to the specified page"));
		}
		}

}
