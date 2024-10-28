package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

public LoginPage(){
    PageFactory.initElements(driver,this);
}

@FindBy(id="user-name")
    public WebElement usernameField;

@FindBy(id="password")
    public WebElement passwordField;

@FindBy(id="login-button")
    public WebElement loginButton;

@FindBy(className="error-button")
public WebElement errorButton;

public void login(String username, String password){
    usernameField.clear();
    usernameField.sendKeys(username);
    passwordField.clear();
    passwordField.sendKeys(password);
    loginButton.click();
}

public boolean loginButtonNotPresent(boolean isPresent){
    isPresent = false;
    try {
        isPresent = loginButton.isDisplayed();
    } catch (Exception e) {
    }
    return isPresent;
}

}
