package Base;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

public static WebDriver driver;
public LoginPage loginPage;
public InventoryPage inventoryPage;
public CartPage cartPage;
public CheckOutFormPage checkOutFormPage;
public ConfirmCheckOutPage confirmCheckOutPage;
public OrderConfirmationPage orderConfirmationPage;
public ProductPage productPage;

    @BeforeMethod
    public void PageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");


        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkOutFormPage = new CheckOutFormPage();
        confirmCheckOutPage = new ConfirmCheckOutPage();
        orderConfirmationPage = new OrderConfirmationPage();
        productPage = new ProductPage();
    }
}
