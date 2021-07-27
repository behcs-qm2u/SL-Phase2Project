package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome=true,		// enable console output
		//plugin= {"pretty", "html:target/cucumber-html", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent/report.html"},
		// plugin= {"pretty", "html:target/cucumber-html"},
		// plugin= {"pretty", "html:target/cucumber-html", "json:target/cucumber.json",
		plugin= {"pretty", "html:test-output/cucumber.html", "json:target/cucumber.json",
		//plugin= {"pretty",  "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src/test/java/features",
		// tags = {"@NegativeLogin, @PositiveLogin" },   // Logical AND
		// tags = {"~@NegativeLogin", "@Sanity" },   // Logical OR
		
		// tags = {"@LoginFeature"},			// Cucumber 4 syntax
		// tags = "@LoginFeature and @PositiveLogin",		// Cucumber 6 syntax
		// tags = "@LoginFeature or @ProductsFeature",
		// tags = "@LogoutFeature",
		// tags = "@ProductsFeature and @SOSingleProduct",
		
		// tags = "@LoginFeature",		
		// tags = {"@ProductsFeature"},
		
		tags = "@AllTest",
		glue = {"stepDefs"}
		
		)



public class TestRunner {

	
	
	
	
}