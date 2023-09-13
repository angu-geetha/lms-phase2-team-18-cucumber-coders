package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dataProviders.ConfigReader;



public class HomePagePO extends BasePage {
	private WebDriver driver;
	// String str2;
	 WebDriverWait wait;
	 String homePageurl=ConfigReader.getProperty("homePageUrl");
	 BasePage bp=new BasePage();
	 String InvalidURL="htttp://asb.cc.com";
	  Boolean logoPresent;
	 
	
	@FindBy(xpath=" Xpath for login button ")private WebElement Login_btn;
	
	@FindBy(xpath="xpath for title")WebElement getTitle;
	
	@FindBy(xpath="xpath for error msg")private WebElement error_msg;
	@FindBy(xpath="xpath for logo image")private WebElement logo;
	
  //  WebElement logo = driver.findElement(By.id("logo")); // Assuming the logo has an id of 'logo'
    WebElement container = logo.findElement(By.xpath("..")); // Parent container of the logo
	
	
	public HomePagePO(WebDriver driver) {
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	public void Valid_Url() {
		
		bp.login_page();
		
	}
	public void invalid_url()
	{
		driver.get(InvalidURL);
	}
	  public String get_Title()
	    {    	
	    	return getTitle.getText();    			
	    }
	  public String getErr_msg()
		{
			String error=error_msg.getText();
			return error;
		}	
	 
	  public Boolean check_spell()
	  {
		return null;
		  
	  }
	  public void Verify_logo()
	  {
	  logoPresent = logo.isDisplayed();
	  Assert.assertEquals(true, logoPresent);
	  }
	  public Boolean login_visible()
	  {
		  return Login_btn.isDisplayed();
	  }
	  public void click_login() {
		  Login_btn.click();
	  }
	  
     
	 public void verify_logo_allignment()
	 {
	
		 int logo_x = logo.getLocation().getX();
	      int logo_y = logo.getLocation().getY();
		        //Define a threshold value (e.g., 10 pixels) to consider as the top-left corner
				 int  threshold = 10;

				//   Check if the logo is in the top-left corner
			if((logo_x <= threshold)&(logo_y <= threshold))
				  {
				      System.out.println("Logo is aligned in the top-left corner.");
				  }
				  else
				      System.out.println("Logo is not aligned in the top-left corner.");
		    }
	
}

