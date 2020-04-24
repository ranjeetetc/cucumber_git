package runnerFiles;		

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(
		features="src/test/java/features",
		plugin = {"pretty","html:target/cucumber-html-report",
		"json:target/cucumber-reports/CucumberTestReport.json"},
		glue={"stepDefinations"}
		)						
public class Runner_Cucumber_Junit 				
{		

}