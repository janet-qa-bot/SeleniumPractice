package utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WaitUtils {
    private static WebDriverWait getWait(){
        int timeout = Integer.parseInt(ConfigurationReader.getProperty("explicitWait"));

        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(timeout)
        );
    }
     public static WebElement waitForVisibility(WebElement element){
        return getWait().until(
                ExpectedConditions.visibilityOf(element)
        );
     }
     public static  WebElement waitForClickable(WebElement element){
        return getWait().until(
                ExpectedConditions.elementToBeClickable(element)
        );

     }
     public static void click(WebElement element){
        waitForClickable(element).click();
     }
}
