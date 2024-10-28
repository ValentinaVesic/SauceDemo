package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ProductPage extends BaseTest {

    @Test
    public void everyProductHasATitle() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.addToCartButtonsList.size(),
                inventoryPage.itemTitlesList.size());
    }

    @Test
    public void PriceCanBeSortedLowToHigh() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.sortLowToHigh();
        Assert.assertTrue(inventoryPage.lowToHighTrue());
    }

    @Test
    public void PriceCanBeSortedHighToLow() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.sortHighToLow();
        Assert.assertTrue(inventoryPage.highToLowTrue());
    }

    @Test
    public void UserIsRedirectedToAnItemPageFromProductPage() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickOnAnyProduct();
        Assert.assertTrue(productPage.backToProducts.isDisplayed());
    }

    @Test
    public void AnyProductCanBeAddedToCartFromProductPage() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.listCartItems.size(), 0);
        cartPage.goBackToInventory();
        String addedItem = inventoryPage.AddToCartAndGetName();
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(addedItem, cartPage.listCartItems.get(0).getText());
        Assert.assertEquals(cartPage.listCartItems.size(), 1);
    }

    @Test
    public void AnyProductCanBeRemovedFromCartFromProductPage() {
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.listCartItems.size(), 0);
        cartPage.goBackToInventory();
        String addedItem = inventoryPage.AddToCartAndGetName();
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(addedItem, cartPage.listCartItems.get(0).getText());
        Assert.assertEquals(cartPage.listCartItems.size(), 1);
        cartPage.goBackToInventory();
        inventoryPage.clickOnRemoveButton();
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.listCartItems.size(), 0);
    }

    @Test
    public void AllItemsCanBeAddedToCartFromProductPage() {
        loginPage.login("standard_user", "secret_sauce");
        int expectedItemNumberInCart = inventoryPage.addToCartButtonsList.size();
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.listCartItems.size(), 0);
        cartPage.goBackToInventory();
        inventoryPage.addAllItemsToCart();
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.listCartItems.size(), expectedItemNumberInCart);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
