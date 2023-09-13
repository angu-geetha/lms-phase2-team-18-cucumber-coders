package pageObjects;
import pageObjects.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_ForgetPO extends BasePage {
	private WebDriver driver;
	String URL_Forget_password= "url link for forget password ";
	@FindBy(xpath="xpath for Forgot Username or Password")private WebElement Forgot_Username_Password;
	@FindBy(xpath="xpath for email")private WebElement Email;
	@FindBy(xpath="xpath for send link")private WebElement Send_Link;
	@FindBy(css="css for aestrick next to Email")private WebElement Aestrick_Email;
	@FindBy(xpath="success msg for email")private WebElement Success_msg;
	@FindBy(xpath="error msg for invalid email")private WebElement error_msg;
	public Login_ForgetPO(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
		
	}
	
	public void click_forget_password()
	{
		Forgot_Username_Password.click();
	}
	public void Forget_Password_Page()
	{
		driver.get(URL_Forget_password);
	}
	public boolean Email_box_display()
	{
		return Email.isDisplayed();
	}
	public void Email_txt_box()
	{
		String Email_color=Email.getCssValue("color");
		String expected_grey_color = "rgba(128, 128, 128, 1)" ;    //assume grey color css value
		if( Email_color == expected_grey_color)
		{
			System.out.println("Email is grey in color");
		}
		else
		{
			System.out.println("Email is not grey");
		}
	
	}
	public boolean Send_link_button()
	{
		System.out.println("Send link is displayed");
		return Send_Link.isDisplayed();
		
	}
	public void verify_Aestrick_Email()
	{
		if(Aestrick_Email.isDisplayed())
		{
			System.out.println("Asterisk sign is displayed next to the password textbox");
		}
		else
		{
			System.out.println("Asterisk sign is not displayed next to the password textbox");
		}
	
	}
	public void Enter_Email()
	{
		Email.clear();
		Email.sendKeys("Jass@gmail.com");
	}
	public String SuccessMsg_Email()
	{
		Email.sendKeys("Jass@gmail.com");
		Send_Link.click();
		String msg=Success_msg.getAttribute("validationMessage");
		return msg;
	}
	public String Error_Msg_Email()
	{
		Email.sendKeys("Jass.com");
		Send_Link.click();
		String Errmsg=error_msg.getAttribute("validationMessage");
		return Errmsg;
	}
	public void Click_SendLink()
	{
		Send_Link.click();
	}
	public void Enter_invalid_Email()
	{
		Email.clear();
		Email.sendKeys("Jass@com");
	}
	public void Allignment_SEndLinkbtn()
	{
	
		int send_button_x = Send_Link.getLocation().getX();
		int send_button_y = Send_Link.getLocation().getY();

		
	int window_width = driver.manage().window().getSize().getWidth();
	int	window_height =driver.manage().window().getSize().getHeight() ;

		
	int	center_x = window_width/2;
	int	center_y = window_height/2;

	//	# Check if the "Send" link button is in the center of the page
		if (send_button_x == center_x&send_button_y == center_y)
		{
		    System.out.println("Send link button is in the center of the page.");
		}
		else
		    System.out.println("Send link button is not in the center of the page.");

	}

}
