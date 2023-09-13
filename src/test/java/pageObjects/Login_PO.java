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
	
	@FindBy(xpath="xpath for password textbox ")private WebElement password;
	@FindBy(xpath="xpath for Forgot Username or Password")private WebElement Forgot_Username_Password;
	@FindBy(xpath="xpath for reset password link")WebElement reset_password;
	@FindBy(css="css for aestrick next to user")WebElement Aestrick_user;
	@FindBy(css="css for aestrick next to password")WebElement Aestrick_password;
	
//	# Locate the asterisk element next to the user textbox (you may need to inspect the HTML to find the correct selector)
    
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
	
	
	

}
