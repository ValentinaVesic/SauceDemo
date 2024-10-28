package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseTest {

    public ProductPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy (id="back-to-products")
    public WebElement backToProducts;

    //-------------

    public void clickOnBackToProducts(){
        backToProducts.click();
    }
}
