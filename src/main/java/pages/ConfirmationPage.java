package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;


public class ConfirmationPage {
    @FindBy(tagName = "h1")
     private WebElement confirmationHeading;
    @FindBy(xpath = "//td[text()='Id']/following-sibling::td")
    private WebElement confirmationId;

    public ConfirmationPage(){
    PageFactory.initElements(DriverManager.getDriver(),this);

    }
    public String getConfirmationMessage(){

        return confirmationHeading.getText();
    }
    public boolean isConfirmationDisplayed(){
        return confirmationHeading.isDisplayed();

    }
    public String getConfirmationId(){
        return confirmationId.getText();

    }
}
