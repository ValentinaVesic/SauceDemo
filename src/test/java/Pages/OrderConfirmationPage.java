package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseTest {

    public OrderConfirmationPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="checkout_complete_container")
    public WebElement confirmationOfCheckOutBox;

    @FindBy (className = "complete-header")
    public WebElement header;
}
