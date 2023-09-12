package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/dsAlgoReport.html" }, // reporting purpose
		monochrome = false, // console output
		dryRun=true,
		tags = "todo", // tags from feature file
		features = { "src/test/resources/features" }, // location of feature files
		glue = { "stepDefinition", "utilities" }) // location of step definition files

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}
	
	/*@BeforeTest
    @Parameters({"browser"})
    public void defineBrowser(String browser) throws Throwable {
		ConfigReader.loadProperty();
		ConfigReader.setBrowserType(browser);
		System.out.println(" in runner " + browser);

}
*/
}