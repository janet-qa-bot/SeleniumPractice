package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "stepdefinitions",
        plugin = {"pretty","html:target/cucumber-report.html","rerun:target/rerun.txt"},
        monochrome = true,
        tags = "@Smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object [][] scenarios(){
        return super.scenarios();
    }
    }

