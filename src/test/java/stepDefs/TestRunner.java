package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome=true,		// enable console output
		plugin= {"pretty", "html:test-output/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src/test/java/features",
		// tags = "@AllTest",		// Cucumber 6 syntax
		tags = "@PositiveLogin or @NegativeLogin or @SOSingleProduct or @DTMultipleProduct or @ProductLogout or @CartLogout",
		glue = {"stepDefs"}
		
		)


public class TestRunner {
	
	
}