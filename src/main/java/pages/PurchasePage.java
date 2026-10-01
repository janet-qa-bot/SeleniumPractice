package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverManager;


public class PurchasePage {
    @FindBy(id = "inputName")
    private WebElement nameInput;
    @FindBy(id = "address")
    private WebElement addressInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "state")
    private WebElement stateInput;
    @FindBy(id = "zipCode")
    private WebElement zipCodeInput;
    @FindBy(id = "cardType")
    private WebElement cardTypeDropdown;
    @FindBy(id = "creditCardNumber")
    private WebElement creditCardNumberInput;
    @FindBy(id = "creditCardMonth")
    private WebElement cardMonthInput;
    @FindBy(id = "creditCardYear")
    private WebElement cardYearInput;
    @FindBy(id = "nameOnCard")
    private WebElement nameOnCardInput;
    @FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement purchaseFlightButton;

    public PurchasePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);

    }
    public void enterPassengerAndPaymentInformation(){
        nameInput.sendKeys("Test Customer");
        addressInput.sendKeys("123 Main Street");
        cityInput.sendKeys("Plano");
        stateInput.sendKeys("Texas");
        zipCodeInput.sendKeys("75023");
        Select cardType = new Select(cardTypeDropdown);
        cardType.selectByVisibleText("Visa");
        creditCardNumberInput.sendKeys("411111111111");
        cardMonthInput.clear();
        cardMonthInput.sendKeys("12");
        cardYearInput.clear();
        cardYearInput.sendKeys("2028");
        nameOnCardInput.sendKeys("Test Customer");

    }
    public void clickPurchaseFlight(){
        purchaseFlightButton.click();
    }
}
