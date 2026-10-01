package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features =  "@target/rerun.txt",
        glue = "stepdefinitions",
        plugin = {"pretty","html:target/failed-cucumber-report.html"},
        monochrome = true
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {

}
