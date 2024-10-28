package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Login extends BaseTest {

    @Test
    public void userCanLoginWithCorrectCredentials(){
        loginPage.login("standard_user","secret_sauce");
        Assert.assertTrue(inventoryPage.burgerMenuButton.isDisplayed());
        boolean loginButtonisPresent = false;
        Assert.assertFalse(loginPage.loginButtonNotPresent(loginButtonisPresent));
    }

    @Test
    public void userCannotLoginWithIncorrectUsername(){
        loginPage.login("incorrect_username", "secret_sauce");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorButton.isDisplayed());
    }

    @Test
    public void userCannotLoginWithIncorrectPassword(){
        loginPage.login("standard_user", "incorrectPassword");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorButton.isDisplayed());
    }

    @Test
    public void userCannotLoginWithBlankUsername(){
        loginPage.login("", "incorrectPassword");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorButton.isDisplayed());
    }

    @Test
    public void userCannotLoginWithBlankPassword(){
        loginPage.login("standard_user", "");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorButton.isDisplayed());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
