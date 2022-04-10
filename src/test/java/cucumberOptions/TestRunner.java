package cucumberOptions;

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\Features\\UserLogin.feature", 

plugin = { "json:target/cucumber-reports/cucumber.json",
    "pretty", "html:target/html-report/cucumber-html-reports.html",
    "junit:target/cucumber-reports/cucumber.xml" }, 
glue = {"stepDefination" })
public class TestRunner {


}