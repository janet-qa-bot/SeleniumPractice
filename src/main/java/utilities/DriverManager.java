package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverPool =
            new ThreadLocal<>();

    private DriverManager() {
        // Prevent creating DriverManager objects
    }

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            String browser =
                    ConfigurationReader.getProperty("browser");

            boolean headless = Boolean.parseBoolean(
                    ConfigurationReader.getProperty("headless")
            );

            WebDriver driver;

            if (browser.equalsIgnoreCase("firefox")) {


                FirefoxOptions options = new FirefoxOptions();

                if (headless) {
                    options.addArguments("-headless");
                }

                driver = new FirefoxDriver(options);

            } else {


                ChromeOptions options = new ChromeOptions();

                if (headless) {
                    options.addArguments("--headless=new");
                }

                driver = new ChromeDriver(options);
            }

            driver.manage().timeouts().implicitlyWait(
                    Duration.ofSeconds(
                            Long.parseLong(
                                    ConfigurationReader.getProperty(
                                            "implicitWait"
                                    )
                            )
                    )
            );

            driver.manage().window().maximize();
            driverPool.set(driver);
        }

        return driverPool.get();
    }

    public static void quitDriver() {

        WebDriver driver = driverPool.get();

        if (driver != null) {
            driver.quit();
            driverPool.remove();
        }
    }
}