package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reset_Password_PO extends BasePage {
	@FindBy(xpath="xpath for reset password link")WebElement reset_password;
	@FindBy(xpath="xpath for submit btn")WebElement Submitbtn;
	@FindBy(css="css for aestrick next to password")WebElement new_password;
	@FindBy(css="css for aestrick next to password")WebElement retype_password;
	@FindBy(xpath="reset password page title")WebElement title;
	private WebDriver driver;

	
	public Reset_Password_PO(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
		
	}
	public void ResetLinkClick()
	{
		reset_password.click();
	}
	public void verifyTitle()
	{
		String Expected;
		String Actual;
		title.getText();
//assertion
	}
	
	public Boolean SubmitDisplay()
	{
		Submitbtn.isDisplayed();
		return true;
	}
	public void submitClick()
	{
		Submitbtn.click();
	}
	
	
	
	
	
	
	
	
}
