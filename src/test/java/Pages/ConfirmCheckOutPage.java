package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmCheckOutPage extends BaseTest {
    public ConfirmCheckOutPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy (id="finish")
    public WebElement finishButton;

    public void clickOnFinishButton(){
        finishButton.click();
    }
}
