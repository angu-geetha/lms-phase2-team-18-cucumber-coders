package rerun;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "pretty", 
		"html:target/LMSPhase2_Team18.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/",
		"rerun:target/failedrerun.txt" }, // reporting purpose
monochrome = false, // console output
dryRun = true, 
//tags = "todo", // tags from feature file
features = { "@target/failedrerun.txt" }, // location of feature files
glue = { "stepDefinition", "utilities" }) // location of step definition files

public class FailedRun  extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}

}
