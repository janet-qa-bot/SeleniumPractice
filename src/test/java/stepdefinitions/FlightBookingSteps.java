package stepdefinitions;
import io. cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;
import utilities.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class FlightBookingSteps {
    private static final Logger logger = LogManager.getLogger(FlightBookingSteps.class);
    private HomePage homePage;
    private FlightsPage flightsPage;
    private PurchasePage purchasePage;
    private ConfirmationPage confirmationPage;

    @Given("the customer is on the BlazeDemo home page")
    public void customerIsOnTheBlazeDemoHomePage() {
        homePage = new HomePage();

        String pageTitle = DriverManager.getDriver().getTitle();
        Assert.assertTrue(pageTitle.contains("BlazeDemo"), "BlazeDemo home page was not displayed");


    }

    @When("the customer selects {string} as the departure city")
    public void customerSelectsDepartureCity(String city) {
        logger.info("Selecting departure city: {}",city);

        homePage.selectDepartureCity(city);

    }

    @When("the customer selects {string} as the destination city")
    public void customerSelectsDestinationCity(String city) {
        logger.info("Selecting destination city: {}",city);
        homePage.selectDestinationCity(city);

    }

    @When("the customer searches for flights")
    public void customerSearchesForFlights() {
        logger.info("Searching for available flights");
        homePage.clickFindFlights();

    }

    @Then("flights from {string} to {string} should be displayed")
    public void flightShouldBeDisplayed(String departureCity, String destinationCity) {

        flightsPage = new FlightsPage();
        String heading = flightsPage.getFlightsHeading();

        Assert.assertTrue(heading.contains(departureCity), "Departure city was not displayed");

        Assert.assertTrue(heading.contains(destinationCity), "Destination city was not displayed");
    }

    @When("the customer choose the first available flight")
    public void customerChoosesFirstAvailableFlight() {
        flightsPage.chooseFirstFlight();
    }

    @When("the customer enters valid passenger and payment information")
    public void customerEntersPassengersAndPaymentInformation() {
        purchasePage = new PurchasePage();
        purchasePage.enterPassengerAndPaymentInformation();

    }

    @When("the customer completes the purchase")
    public void customerCompletesThePurchase() {
        purchasePage.clickPurchaseFlight();
    }

    @Then("the booking confirmation should be displayed")
    public void bookingConfirmationShouldBeDisplayed() {
        confirmationPage = new ConfirmationPage();
        Assert.assertTrue(confirmationPage.isConfirmationDisplayed(), "Confirmation heading was not displayed");
        Assert.assertEquals(confirmationPage.getConfirmationMessage(),  "Thank you for your purchase today!",
                "unexpected message");
        logger.info("Booking confirmation successfully displayed");

    }
}
