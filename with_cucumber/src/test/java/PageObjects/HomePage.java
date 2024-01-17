package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage extends AbstractPage{
    private final String HOMEPAGE_URL = " https://open.spotify.com/";

    private WebElement loginButton;
    private final By loginButtonLocator= By.xpath("//*[@data-testid='login-button']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECOND));
        webDriver.get(HOMEPAGE_URL);
        return this;
    }

    public void goToLoginPage() {
        loginButton=waitForElementLocateBy(loginButtonLocator);
        loginButton.click();
    }
}
