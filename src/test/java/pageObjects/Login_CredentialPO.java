package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.Enter;

public class Login_CredentialPO extends BasePage {
	private WebDriver driver;
	@FindBy(xpath=" Xpath for title ")private WebElement title;
	
	@FindBy(xpath="xpath for user text box")WebElement user;
	
	@FindBy(xpath="xpath for password textbox ")private WebElement password;
	@FindBy(xpath="xpath for Forgot Username or Password")private WebElement Forgot_Username_Password;
	@FindBy(xpath="xpath for reset password link")WebElement reset_password;
	@FindBy(css="css for aestrick next to user")WebElement Aestrick_user;
	@FindBy(css="css for aestrick next to password")WebElement Aestrick_password;
	@FindBy(xpath="xpath for login")WebElement loginbtn;
	@FindBy(xpath = "xpath for success msg")private WebElement successLogin;
String error;
String msg;
String alertmsg;
    
	public Login_CredentialPO(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
		
	}
	public void login_page() {

		driver.get(loginURL);

	}

	public String login_click()
	{
		user.sendKeys("");
		password.sendKeys(" ");
		loginbtn.click();
		error=user.getAttribute("validationMessage");
		return error;

	}

	public void login_entry(String uname, String pwd) {
		
		user.clear();
		user.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);
			
	}

	public void logBtn_click() {
		loginbtn.click();
	
		}
	public String success_login()
	{
		loginbtn.click();
		if(successLogin.isDisplayed())
		msg= "You are logged in";
		else msg="you are no logged in";
		return msg;
	}
	public void login_entry_keyboard()
	{
		Actions action = new Actions(driver);
        action.moveToElement(user).sendKeys("sdet").sendKeys(Keys.ENTER);
    	action.moveToElement(password).sendKeys("J@123").sendKeys(Keys.RETURN);
    	action.moveToElement(loginbtn).sendKeys(Keys.ENTER).perform();
        

	}
	public void login_entry_mouse()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(user).click();
		actions.sendKeys("sdet");
		actions.moveToElement(password).click();
		actions.sendKeys("J@123");
		actions.moveToElement(loginbtn).click().perform();

	
	}
	
}
