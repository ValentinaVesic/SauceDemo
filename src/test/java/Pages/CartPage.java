package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage(){
        PageFactory.initElements(driver,this);
    }

@FindBy (className="inventory_item_name")
    public List<WebElement> listCartItems;
@FindBy(id="checkout")
    public WebElement checkOutButton;
@FindBy (id="continue-shopping")
public WebElement backToInventory;

@FindBy (css = ".btn.btn_secondary.btn_small.cart_button")
public List<WebElement> removeButton;

public void clickOnCheckOutButton(){
    checkOutButton.click();
}

public void goBackToInventory(){
    backToInventory.click();
}

public void clickOnFirstRemoveButton(){
    removeButton.get(0).click();
}

public void removeAllProductsFromCart(){
    for (int i = removeButton.size()-1; i >= 0 ; i--){
        removeButton.get(i).click();
    }
}
}
