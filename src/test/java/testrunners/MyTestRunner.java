package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"D:\\eclipse-workspace\\CucumberPOM\\resources\\AppFeatures"},
			glue = {"stepdefinitions", "AppHooks"},
			plugin = {"html:target/cucumber-html-report"
					
			}
								)

public class MyTestRunner {

}
