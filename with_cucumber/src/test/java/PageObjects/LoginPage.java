package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class LoginPage extends AbstractPage {

    private WebElement inputUserName;
    private final By inputUserNameLocator = By.id("login-username");

    private WebElement inputPassword;
    private final By inputPasswordLocator = By.id("login-password");

    private WebElement buttonLogin;
    private final By buttonLoginLocator = By.id("login-button");

    private WebElement labelUserName;
    private final By labelUserNameLocator = By.id("username-error");

    private WebElement labelPassword;
    private final By labelPasswordLocator = By.id("password-error");

    private WebElement bannerError;
    private final By bannerErrorLocator = By.xpath("//*[@class='sc-iveFHk kstyxm']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please, don't open page again");
    }

    public void login(String test, String username, String password) {
        inputUserName = waitForElementLocateBy(inputUserNameLocator);
        inputPassword = waitForElementLocateBy(inputPasswordLocator);
        inputUserName.sendKeys(username);
        inputPassword.sendKeys(password);
        if (test.equals("empty")) {
            Actions action = new Actions(webDriver);
            action.moveToElement(inputUserName).doubleClick().sendKeys(Keys.DELETE).perform();
            action.moveToElement(inputPassword).doubleClick().sendKeys(Keys.DELETE).perform();
            return;
        }
        buttonLogin = waitForElementLocateBy(buttonLoginLocator);
        buttonLogin.click();
    }

    public ArrayList getResult(String test) {
        ArrayList<String> result = new ArrayList<>();
        switch (test) {
            case "empty":
                labelUserName = waitForElementLocateBy(labelUserNameLocator);
                result.add(labelUserName.getText());
                labelPassword = waitForElementLocateBy(labelPasswordLocator);
                result.add(labelPassword.getText());
                return result;
            case "incorrect":
                bannerError = waitForElementLocateBy(bannerErrorLocator);
                result.add(bannerError.getText());
                return result;
            case "correct":
                MainPage mainPage = new MainPage(webDriver);
                result.add(mainPage.checkUserName());
                return result;
        }
        return result;
    }
}
