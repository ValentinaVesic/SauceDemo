package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutFormPage extends BaseTest {

    public CheckOutFormPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="checkout_info_container")
    public WebElement checkOutForm;

    @FindBy(id="first-name")
    public WebElement firstNameField;

    @FindBy(id="last-name")
    public WebElement lastNameField;

    @FindBy(id="postal-code")
    public WebElement postalCodeField;

    @FindBy(id="continue")
    public WebElement continueButton;

    public void inputFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode){
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }
}
