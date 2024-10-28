package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Random;

public class InventoryPage extends BaseTest {

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    Random rand = new Random();

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuButton;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> addToCartButtonsList;

    @FindBy(css =".btn.btn_secondary.btn_small.btn_inventory" )
    public List<WebElement> removeFromCartButton;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemTitlesList;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartIcon;

    @FindBy(className = "product_sort_container")
    public WebElement productSortButton;

    @FindBy(css = "option[value='lohi']")
    public WebElement lowToHigh;

    @FindBy(css = "option[value='hilo']")
    public WebElement highToLow;

    @FindBy(css = "option[value='az']")
    public WebElement aToZ;

    @FindBy(css = "option[value='za']")
    public WebElement zToA;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> listOfPrices;

    //--------------------------------------




    public String AddToCartAndGetName() {
        int i = rand.nextInt(addToCartButtonsList.size());
        addToCartButtonsList.get(i).click();
        String name = "";
        return name = itemTitlesList.get(i).getText();
    }

    public void clickOnAnyProduct(){
        int i = rand.nextInt(itemTitlesList.size());
        itemTitlesList.get(i).click();
    }

    public void AddAnyItemToCart() {
        int i = rand.nextInt(addToCartButtonsList.size());
        addToCartButtonsList.get(i).click();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void sortLowToHigh() {
        productSortButton.click();
        lowToHigh.click();
    }


    public boolean lowToHighTrue() {
        boolean lowToHighIsTrue = true;
        int lowestPrice;
        String s = listOfPrices.get(0).getText();
        lowestPrice = Integer.parseInt(s.replaceAll("[\\D]", ""));
        for (int i = 1; i < listOfPrices.size(); i++) {
            String s1 = listOfPrices.get(i).getText();
            int price = Integer.parseInt(s.replaceAll("[\\D]", ""));
            if (lowestPrice > price) {
                lowToHighIsTrue = false;
                return lowToHighIsTrue;

            }
        }
        return lowToHighIsTrue;
    }

    public void sortHighToLow() {
        productSortButton.click();
        highToLow.click();
    }

    public boolean highToLowTrue(){
        boolean highToLowIsTrue = true;
        int highestPrice;
        String s = listOfPrices.get(0).getText();
        highestPrice = Integer.parseInt(s.replaceAll("[\\D]", ""));
        for (int i = 1; i < listOfPrices.size(); i++) {
            String s1 = listOfPrices.get(i).getText();
            int price = Integer.parseInt(s.replaceAll("[\\D]", ""));
            if (highestPrice < price) {
                highToLowIsTrue = false;
                return highToLowIsTrue;

            }
        }
        return highToLowIsTrue;
    }

    public void sortAToZ() {
        productSortButton.click();
        aToZ.click();
    }

    public void clickOnRemoveButton(){
        removeFromCartButton.get(0).click();
    }

    public void addAllItemsToCart(){
        for (int i = addToCartButtonsList.size()-1; i >= 0; i--){
            addToCartButtonsList.get(i).click();
        }
    }


}
