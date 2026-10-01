package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverManager;


public class HomePage {
    @FindBy(name = "fromPort")
    private WebElement departureCityDropdown;

    @FindBy(name = "toPort")
    private WebElement destinationCityDropdown;

    @FindBy(xpath = "//input[@value='Find Flights']")
    private WebElement findFlightsButton;

    public HomePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);

    }
    public void selectDepartureCity(String city) {
        Select departureDropdown = new Select(departureCityDropdown);
        departureDropdown.selectByVisibleText(city);
    }
    public void selectDestinationCity(String city){
        Select destinationDropdown = new Select(destinationCityDropdown);
        destinationDropdown.selectByVisibleText(city);
    }
    public void clickFindFlights(){
        findFlightsButton.click();
    }

}
