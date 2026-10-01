package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigurationReader;
import utilities.DriverManager;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
    private static final Logger logger =
            LogManager.getLogger(Hooks.class);
    @Before
    public void setUp(){
        DriverManager.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        if (scenario.isFailed()){
            byte[] screenshot =
                    ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png","Failure Screenshot");


        }
        DriverManager.quitDriver();
    }
}

