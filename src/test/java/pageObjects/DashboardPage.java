package pageObjects;

import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initializing WebElelements
		}
	//Login button
	@FindBy(xpath = "//button[@class='btn']")
	WebElement mainPageLoginBtn;

	@FindBy(name = "username")
	WebElement usernameTextBox;

	@FindBy(name = "password")
	WebElement passwordTextBox;

	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	WebElement loginButton;

	//This is where Dashboard Page Web Elements begins

	@FindBy(tagName = "h1") // Assuming the header is an h1 element
	WebElement headerElement;

	@FindBy(className ="lms-title")
	WebElement lmsTitle; // Assuming LMS title has a class "lms-title"

	@FindBy(className="navbar")
	WebElement navBar;  // Assuming navigation bar has a class "navbar"

	@FindBy(className ="navbar-text")
	WebElement navbarText; // Assuming LMS title has a class "navbar-text"

	@FindBy(className ="navbar-text-container")
	WebElement navbarTextContainer; // Assuming LMS title has a class "navbar-text-container"

	@FindBy(className ="menu-item")
	List<WebElement> menuItems; // Assuming LMS title has a class "navbar-text-container"

	public void clickStudentLink() {

			 menuItems.get(0).click();

		 }

	 

		 

		 //Visit LMS Home Page

		 public void visit_LMS_url() {
    String URL="Url";
			 driver.get(URL);

		 }



		 

		 public void clickMainPageLogin_btn() {

			 mainPageLoginBtn.click();



		 }



		 public String getCurrentPageTitle() {

		  return driver.getTitle().trim();

		 }

		 

		 public void enterUsername(String username) {



			 usernameTextBox.sendKeys(username);



		 }

		 

		 public void clearUsername() {



			 usernameTextBox.clear();



		 }

		 

		 public void enterPassword(String password) {



			 passwordTextBox.sendKeys(password);



		 }

		 

		 public void clearPassword() {



			 passwordTextBox.clear();



		 }

		 

		 public Point getlmsTitleLocation() {

			 return	lmsTitle.getLocation();	 

		 }

		 

		 public String getlmsTitleText() {

			 return	lmsTitle.getText();	 

		 }

		 

		 public String getNavBarText() {

			 return navBar.getText();

			 

		 }

		 

		 public Point getNavBarContainerLocation() {

				return navbarTextContainer.getLocation();

		 }

		 

		 public int getNavBarContainerWidth() {

		 return navbarTextContainer.getSize().getWidth();

	}

		 

		 public void clickLogin() throws InterruptedException {

			 Thread.sleep(3000);

			 loginButton.click();

		 }



		 

		 public String getHeaderElementText() {

			 return headerElement.getText();

		 }

		 

		 public boolean verifyMenuItemOrder(String menuItem, int expectedIndex) {

			return menuItems.get(expectedIndex).getText().equals(menuItem);

		 }





		public boolean isOnDashboard() {

			// TODO Auto-generated method stub

			return false;

		}

	 

	}



