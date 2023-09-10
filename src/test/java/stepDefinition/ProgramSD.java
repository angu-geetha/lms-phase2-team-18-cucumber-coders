package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import dataProviders.ConfigReader;
import dataProviders.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProgramPage;
import utilities.LoggerLoad;

public class ProgramSD extends Commonclass {

	Map<String, String> excelDataMap;

	@When("Admin clicks program button on the navigation bar")
	public void admin_clicks_program_button_on_the_navigation_bar() {
		try {
			programPage.selectHeaderLink("Program");
			LoggerLoad.logInfo("Admin clicks program button on the navigation bar");

		} catch (Exception e) {
			LoggerLoad.logError(e.getMessage());
			assertFalse(false, "Failed - Admin clicks program button on the navigation bar");
		}
	}

	

}