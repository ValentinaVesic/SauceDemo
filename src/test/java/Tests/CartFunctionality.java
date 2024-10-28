package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CartFunctionality extends BaseTest {

    @Test
    public void userCanGoBackToProductPage(){
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickOnCartIcon();
        String cartUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(driver.getCurrentUrl(),cartUrl);
        cartPage.goBackToInventory();
        String inventoryUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertTrue(inventoryPage.productSortButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),inventoryUrl);
    }

    @Test
    public void userCanRemoveProductsFromCartFromCartPage(){
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.listCartItems.size(), 0);
        cartPage.goBackToInventory();
        String addedItem = inventoryPage.AddToCartAndGetName();
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(addedItem, cartPage.listCartItems.get(0).getText());
        Assert.assertEquals(cartPage.listCartItems.size(), 1);
        cartPage.clickOnFirstRemoveButton();
        Assert.assertEquals(cartPage.listCartItems.size(), 0);

    }

    @Test
    public void itemsRemainInCartWhenUserGoesBackToShopping(){
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.listCartItems.size(), 0);
        cartPage.goBackToInventory();
        String addedItem = inventoryPage.AddToCartAndGetName();
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(addedItem, cartPage.listCartItems.get(0).getText());
        Assert.assertEquals(cartPage.listCartItems.size(), 1);
        cartPage.clickOnFirstRemoveButton();
        Assert.assertEquals(cartPage.listCartItems.size(), 0);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
