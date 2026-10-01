package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import utilities.DriverManager;
import utilities.WaitUtils;


public class FlightsPage {
    @FindBy(tagName = "h3")
    private WebElement flightsHeading;

    @FindBy(xpath = "(//input[@value='Choose This Flight'])[1]")
    private WebElement firstChooseFlightButton;

    public FlightsPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public String getFlightsHeading(){
        return WaitUtils.waitForVisibility(flightsHeading).getText();

    }
    public void chooseFirstFlight(){
      WaitUtils.click(firstChooseFlightButton);

    }
}
