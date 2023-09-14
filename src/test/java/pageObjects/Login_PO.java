package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Login_PO extends BasePage {
	
	private WebDriver driver;
	@FindBy(xpath=" Xpath for title ")private WebElement title;
	
	@FindBy(xpath="xpath for user text box")WebElement user;
	@FindBy(xpath="xpath for login")WebElement login;
	@FindBy(xpath="xpath for password textbox ")private WebElement password;
	@FindBy(xpath="xpath for Forgot Username or Password")private WebElement Forgot_Username_Password;
	@FindBy(xpath="xpath for reset password link")WebElement reset_password;
	@FindBy(css="css for aestrick next to user")WebElement Aestrick_user;
	@FindBy(css="css for aestrick next to password")WebElement Aestrick_password;
	
//	# Locate the asterisk element next to the user textbox (you may need to inspect the HTML to find the correct selector)
	public void user_color()
	{
		String user_color_display=user.getCssValue("color");
		String expected_grey_color = "rgba(128, 128, 128, 1)" ;    //assume grey color css value
		if( user_color_display == expected_grey_color)
		{
			System.out.println("user is grey in color");
		}
		else
		{
			System.out.println("user is not grey");
		}
	
	}
	public void password_color()
	{
		String pwd_color_display=user.getCssValue("color");
		String expected_grey_color = "rgba(128, 128, 128, 1)" ;    //assume grey color css value
		if( pwd_color_display == expected_grey_color)
		{
			System.out.println("password is grey in color");
		}
		else
		{
			System.out.println("password is not grey");
		}
	
	}
	
	public Login_PO(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
		
	}
	public void verify_Aestrick_user()
	{
		if(Aestrick_user.isDisplayed())
		{
			System.out.println("Asterisk sign is displayed next to the user textbox");
		}
		else
		{
			System.out.println("Asterisk sign is not displayed next to the user textbox");
		}
	}
	public void verify_Aestrick_password()
	{
		if(Aestrick_password.isDisplayed())
		{
			System.out.println("Asterisk sign is displayed next to the password textbox");
		}
		else
		{
			System.out.println("Asterisk sign is not displayed next to the password textbox");
		}
	}
	public Boolean resetpwd_link() {
		reset_password.isDisplayed();
		return true;
		
	}
	public Boolean displayForgetPwd() {
		Forgot_Username_Password.isDisplayed();
		return true;
		
	}
	public void login_Allignment() 
		{
		
			int send_button_x = login.getLocation().getX();
			int send_button_y = login.getLocation().getY();

			
		int window_width = driver.manage().window().getSize().getWidth();
		int	window_height =driver.manage().window().getSize().getHeight() ;

			
		int	center_x = window_width/2;
		int	center_y = window_height/2;

		//	# Check if the "Send" link button is in the center of the page
			if (send_button_x == center_x&send_button_y == center_y)
			{
			    System.out.println("login  button is in the center of the page.");
			}
			else
			    System.out.println("login link button is not in the center of the page.");

		}
	public void login_click() {
		login.click();
		
	}
	public void verify_two_text_Box()
	{
			//# Check if both text boxes are present on the page
			if (user.isDisplayed() &password.isDisplayed())
			{
				 System.out.println("Both text boxes are present on the page.");
			}
			else
			{
				 System.out.println("One or both text boxes are not present on the page.");
	          }
	}
	public void FirstTextBoxUser() {
		int user_text_box_order = user.getLocation().getY();
		
			int	password_text_box_order = password.getLocation().getY();
			if (user_text_box_order < password_text_box_order)
				System.out.println("The 'User' text box appears first on the login page.");
			else
				System.out.println("The 'User' text box does not appear first on the login page.");
		
	}
	public void secondTextBoxPassword() {
		int user_text_box_order = user.getLocation().getY();
		
		int	password_text_box_order = password.getLocation().getY();
		if (user_text_box_order > password_text_box_order)
			System.out.println("The 'User' text box appears first on the login page.");
		else
			System.out.println("The 'User' text box does not appear first on the login page.");
	
		
	}
	public void verify_title()
	{
		
		title.isDisplayed();
	}
	public void allignment_input()
	{
		//code 
	}
}
	
	
	


