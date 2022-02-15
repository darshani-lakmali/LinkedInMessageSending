package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/com/features/HomePage.feature",
				//Path of feature file
				glue = {"stepDefinitions","appHooks"},//Path of Step Definition file
				plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"
						,"rerun:target/failedrerun.txt"
						},
				dryRun= false, //to check the mapping is proper between feature file and step definition file
				monochrome = true, //display the console output in a proper readable format
				strict = true //strictly follows all the rules between feature and step definition file
		)
public class TestRunner {

}