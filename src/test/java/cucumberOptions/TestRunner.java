package cucumberOptions;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\Features\\UserLogin.feature", 

plugin = { "json:target/cucumber-reports/cucumber.json",
    "pretty", "html:target/html-report/cucumber-html-reports.html",
    "junit:target/cucumber-reports/cucumber.xml" }, 
glue = {"stepDefination" })
public class TestRunner extends AbstractTestNGCucumberTests
{
	
}

