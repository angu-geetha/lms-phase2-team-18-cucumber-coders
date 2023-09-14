package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			plugin = {"pretty", "html:target/Cucumber.html",
					"json:target/cucumber.json",
					"junit:target/cucumber-reports/Cucumber.xml",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
					}, //reporting purpose
			monochrome=false,  //console output color
			features = {"src/test/resources/features/",
					}, //location of feature files
					
			

			glue = { "stepDefinition", "utilities" } //location of step definition files
		)
public class TestRunner {
	
}