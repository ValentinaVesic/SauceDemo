package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class E2e extends BaseTest {

    @Test
    public void UserCanLoginWithValidCredentials() {
        loginPage.login("standard_user","secret_sauce");
        Assert.assertTrue(inventoryPage.burgerMenuButton.isDisplayed());
        boolean loginButtonisPresent = false;
        Assert.assertFalse(loginPage.loginButtonNotPresent(loginButtonisPresent));
    }

    @Test
    public void UserCanAddAnItemToCart(){
        loginPage.login("standard_user","secret_sauce");
        String addedItem = inventoryPage.AddToCartAndGetName();
        inventoryPage.clickOnCartIcon();
        Assert.assertEquals(addedItem,cartPage.listCartItems.get(0).getText());
        Assert.assertEquals(cartPage.listCartItems.size(),1);
      /*  cartPage.clickOnCheckOutButton();
        Assert.assertTrue(checkOutFormPage.checkOutForm.isDisplayed());*/

    }

    @Test
    public void UserCanProceedToCheckOutForm(){
        loginPage.login("standard_user","secret_sauce");

        inventoryPage.AddAnyItemToCart();
        inventoryPage.clickOnCartIcon();
        cartPage.clickOnCheckOutButton();
        Assert.assertTrue(checkOutFormPage.checkOutForm.isDisplayed());
    }

    @Test
    public void UserCanPlaceAnOrder(){
        loginPage.login("standard_user","secret_sauce");
        inventoryPage.AddAnyItemToCart();
        inventoryPage.clickOnCartIcon();
        cartPage.clickOnCheckOutButton();
        checkOutFormPage.inputFirstName("Valentina");
        checkOutFormPage.inputLastName("Vesic");
        checkOutFormPage.inputPostalCode("11000");
        checkOutFormPage.clickOnContinueButton();
       confirmCheckOutPage.clickOnFinishButton();
       Assert.assertTrue(orderConfirmationPage.confirmationOfCheckOutBox.isDisplayed());
       Assert.assertEquals(orderConfirmationPage.header.getText(),"Thank you for your order!");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
